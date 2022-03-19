package cool.compiler;
import cool.structures.*;

import java.util.LinkedList;

public class ThirdPassVisitor implements ASTVisitor<String> {

    String class_name = null;
    String inherits = null;
    String method_name = null;
    int letCase = 0;
    boolean letBody = false;
    LinkedList<String> varLocaleLet = new LinkedList<>();
    LinkedList<String> tipuriLocaleLet = new LinkedList<>();
    int varLocalaLet = -1;
    String tipVarLocalaLet = null;


    @Override
    public String visit(Prog prog) {

        class_name = null;
        method_name = null;
        inherits = null;
        letCase = 0;
        varLocaleLet = new LinkedList<>();
        tipuriLocaleLet = new LinkedList<>();
        varLocalaLet = -1;
        tipVarLocalaLet = null;

        for (var stmt: prog.definitii_clase)
            stmt.accept(this);

        return null;
    }

    @Override
    public String visit(ClassDef classDef) {

        var name = classDef.name;
        var inherits_name = classDef.inherits_name;

        if(inherits_name != null)
        {
            inherits = inherits_name.getText();
        }

        class_name = name.getText();

        for (var stmt: classDef.definitii)
        {
            stmt.accept(this);
        }

        return null;
    }

    @Override
    public String visit(VarDef varDef) {

        var id = varDef.id;
        var type = varDef.type;

        var symbol = (IdSymbol)DefinitionPassVisitor.currentScope.lookup(id.getText());
        String tip = symbol.getType();

        if (DefinitionPassVisitor.currentScope.lookup(type.getText()) == null && type.getText().equals(tip))
        {
            SymbolTable.error(varDef.ctx, varDef.ctx.type, "Class " + class_name + " has attribute " + id.getText() + " with undefined type " + type.getText());
        }

        if(varDef.assign != null) {
            var assignType = varDef.assign.accept(this);
            if(assignType != null && !assignType.equals(type.getText()) && !verifyInheritance(type.getText(), assignType))
            {
                SymbolTable.error(varDef.ctx, varDef.ctx.assign.start, "Type " + assignType + " of initialization expression of attribute " +
                        id.getText() + " is incompatible with declared type " + type.getText());
            }
        }

        return tip;
    }

    @Override
    public String visit(FuncDef funcDef) {

        var id = funcDef.id;
        var type = funcDef.type;

        FuncSymbol sym = (FuncSymbol) DefinitionPassVisitor.functionScope.lookup(id.getText());
        if(sym != null && verifyInheritance(sym.getClasa(), class_name))
        {
            LinkedList<String> formali = ((FuncSymbol)sym).getFormali();
            LinkedList<String> tipuri = ((FuncSymbol)sym).getTipuri();

            if(formali.size() != funcDef.formali.size() && inherits != null)
            {
                SymbolTable.error(funcDef.ctx, funcDef.ctx.name, "Class " + class_name + " overrides method " + id.getText()
                        + " with different number of formal parameters");
            }

            int i = 0;
            for (var formal: funcDef.formali)
            {
                String nume_formal = ((Formal)formal).name.getText();
                String tip_formal = ((Formal)formal).type.getText();
                if(!tipuri.get(i).equals(tip_formal))
                {
                    SymbolTable.error(funcDef.ctx, ((Formal)formal).ctx.type, "Class " + class_name + " overrides method " + id.getText()
                            + " but changes type of formal parameter " + nume_formal + " from " + tipuri.get(i) + " to " + tip_formal);
                    break;
                }
                i++;
            }
            if(!((FuncSymbol) sym).getType().equals(type.getText()))
            {
                SymbolTable.error(funcDef.ctx, funcDef.ctx.type, "Class " + class_name + " overrides method " + id.getText()
                        + " but changes return type from " + ((FuncSymbol) sym).getType() + " to " + type.getText());
            }
        }

        method_name = id.getText();
        for (var formal: funcDef.formali)
        {
            formal.accept(this);
        }

        var bodyType = funcDef.body.accept(this);
        if(bodyType != null && !bodyType.equals(type.getText()) && !verifyInheritance(type.getText(), bodyType) && !bodyType.equals("Object"))
        {
            SymbolTable.error(funcDef.ctx, funcDef.ctx.body.start, "Type " + bodyType + " of the body of method " +
                    id.getText() + " is incompatible with declared return type " + type.getText());
        }

        return bodyType;
    }

    @Override
    public String visit(Formal formal) {

        var name = formal.name;
        var type = formal.type;

        if (DefinitionPassVisitor.currentScope.lookup(type.getText()) == null && !type.getText().equals("SELF_TYPE"))
        {
            SymbolTable.error(formal.ctx, formal.ctx.type, "Method " + method_name + " of class " + class_name +
                    " has formal parameter " + name.getText() + " with undefined type " + type.getText());
        }

        return null;
    }

    @Override
    public String visit(Let let) {

        letCase = 1;
        for (var local: let.locals)
        {
            var type = local.accept(this);
            if(type != null && tipVarLocalaLet != null)
            {
                tipVarLocalaLet = null;
            }
        }
        letBody = true;
        var bodyType = let.body.accept(this);
        letBody = false;

        letCase = 0;
        varLocaleLet = new LinkedList<>();
        tipuriLocaleLet = new LinkedList<>();
        varLocalaLet = -1;

        return bodyType;
    }

    @Override
    public String visit(Case aCase) {

        LinkedList<String> tipuri = new LinkedList<>();
        letCase = 2;
        for (var local: aCase.cases)
        {
            var type = local.accept(this);
            if(type != null)
            {
                tipuri.add(type);
            }
        }

        letCase = 0;

        if(tipuri.size() > 1)
        {
            return commonParentClass(tipuri.get(0), tipuri.get(1));
        }
        else
            if(tipuri.size() == 1)
                return tipuri.get(0);
            else return null;
    }

    @Override
    public String visit(LetDefinition letDefinition) {

        var name = letDefinition.name;
        var type = letDefinition.type;

        if (DefinitionPassVisitor.currentScope.lookup(type.getText()) == null && !type.getText().equals("SELF_TYPE"))
        {
            if(letCase == 1)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.type, "Let variable " + name.getText() + " has undefined type " + type.getText());
            else if(letCase == 2)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.type, "Case variable " + name.getText() + " has undefined type " + type.getText());
            return null;
        }

        if(letCase == 1) {
            varLocaleLet.add(name.getText());
            tipuriLocaleLet.add(type.getText());
            varLocalaLet++;
            tipVarLocalaLet = type.getText();
        }

        return null;
    }

    @Override
    public String visit(Id id) {
        var name = id.token;

        IdSymbol sym_id = (IdSymbol) DefinitionPassVisitor.currentScope.lookup(name.getText());

        LinkedList<String> formali = new LinkedList<>();
        Symbol sym = DefinitionPassVisitor.functionScope.lookup(method_name);
        if(sym != null)
        {
            formali = ((FuncSymbol) sym).getFormali();
            if(formali.contains(name.getText()))
            {
                LinkedList<String> tipuri = ((FuncSymbol)sym).getTipuri();
                return tipuri.get(formali.indexOf(name.getText()));
            }
        }

        boolean undefinedIdentifier = false;

        if((varLocaleLet.contains(name.getText()) && varLocaleLet.indexOf(name.getText()) == varLocalaLet) || !varLocaleLet.contains(name.getText()))
        {
            undefinedIdentifier = true;
        }

        if(letBody && varLocaleLet.contains(name.getText()))
        {
            return tipuriLocaleLet.get(varLocaleLet.indexOf(name.getText()));
        }

        if (undefinedIdentifier && DefinitionPassVisitor.currentScope.lookup(name.getText()) == null && !name.getText().equals("self") && !formali.contains(name.getText()))
        {
            SymbolTable.error(id.ctx, id.ctx.name, "Undefined identifier " + name.getText());
        }

        if((varLocaleLet.contains(name.getText()) && varLocaleLet.indexOf(name.getText()) < varLocalaLet))
        {
            return tipuriLocaleLet.get(varLocaleLet.indexOf(name.getText()));
        }

        if(sym_id != null)
            return sym_id.getType();
        else
        {
            if (sym != null)
            {
                int index = formali.indexOf(name.getText());
                LinkedList<String> tipuri = ((FuncSymbol) sym).getTipuri();
                if (index >= 0)
                    return tipuri.get(index);
            }
        }
        return null;
    }

    @Override
    public String visit(Paren paren) {
        return paren.e.accept(this);
    }

    @Override
    public String visit(Plus plus) {
        var exprType_left = plus.left.accept(this);
        var exprType_right = plus.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(plus.ctx, plus.ctx.left.start, "Operand of + has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(plus.ctx, plus.ctx.right.start, "Operand of + has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            if(letCase == 1 && tipVarLocalaLet != null)
            {
                if(!exprType_right.equals(tipVarLocalaLet))
                {
                    SymbolTable.error(plus.ctx, plus.ctx.left.start, "Type " + exprType_right + " of initialization expression of identifier "
                            + varLocaleLet.getLast() + " is incompatible with declared type " + tipVarLocalaLet);
                }
                tipVarLocalaLet = null;
            }
            return exprType_right;
        }
        return null;
    }

    @Override
    public String visit(Minus minus) {
        var exprType_left = minus.left.accept(this);
        var exprType_right = minus.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(minus.ctx, minus.ctx.left.start, "Operand of - has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(minus.ctx, minus.ctx.right.start, "Operand of - has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            return exprType_right;
        }
        return null;
    }

    @Override
    public String visit(Mult mult) {
        var exprType_left = mult.left.accept(this);
        var exprType_right = mult.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(mult.ctx, mult.ctx.left.start, "Operand of * has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(mult.ctx, mult.ctx.right.start, "Operand of * has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            return exprType_right;
        }
        return null;
    }

    @Override
    public String visit(Div div) {
        var exprType_left = div.left.accept(this);
        var exprType_right = div.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(div.ctx, div.ctx.left.start, "Operand of / has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(div.ctx, div.ctx.right.start, "Operand of / has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            return exprType_right;
        }
        return null;
    }

    @Override
    public String visit(Negation negation) {
        var exprType = negation.e.accept(this);

        if(exprType != null && !exprType.equals("Int"))
        {
            SymbolTable.error(negation.ctx, negation.ctx.e.start, "Operand of ~ has type " + exprType + " instead of Int");
            return null;
        }
        return exprType;
    }

    @Override
    public String visit(Le le) {
        var exprType_left = le.left.accept(this);
        var exprType_right = le.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(le.ctx, le.ctx.left.start, "Operand of <= has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(le.ctx, le.ctx.right.start, "Operand of <= has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            return "Bool";
        }
        return null;
    }

    @Override
    public String visit(Lt lt) {
        var exprType_left = lt.left.accept(this);
        var exprType_right = lt.right.accept(this);

        if(exprType_left != null && !exprType_left.equals("Int"))
        {
            SymbolTable.error(lt.ctx, lt.ctx.left.start, "Operand of < has type " + exprType_left + " instead of Int");
            return null;
        }
        else if(exprType_right != null && !exprType_right.equals("Int"))
        {
            SymbolTable.error(lt.ctx, lt.ctx.right.start, "Operand of < has type " + exprType_right + " instead of Int");
            return null;
        }
        else if(exprType_right != null && exprType_right.equals(exprType_left))
        {
            return "Bool";
        }
        return null;
    }

    @Override
    public String visit(Equal equal) {
        var exprType_left = equal.left.accept(this);
        var exprType_right = equal.right.accept(this);

        if(exprType_left != null && !exprType_left.equals(exprType_right)
                && DefinitionPassVisitor.basicClassesScope.lookup(exprType_left) != null
                && DefinitionPassVisitor.basicClassesScope.lookup(exprType_right) != null)
        {
            SymbolTable.error(equal.ctx, equal.ctx.op, "Cannot compare " + exprType_left + " with " + exprType_right);
            return null;
        }
        else
        {
            return "Bool";
        }
    }

    @Override
    public String visit(Not not) {
        var exprType = not.e.accept(this);

        if(exprType != null && !exprType.equals("Bool"))
        {
            SymbolTable.error(not.ctx, not.ctx.e.start, "Operand of not has type " + exprType + " instead of Bool");
            return null;
        }
        return exprType;
    }

    public Boolean verifyInheritance(String varType, String exprType)
    {
        String inherits = DefinitionPassVisitor.clase.get(exprType);
        while(inherits != null)
        {
            if(inherits.equals(varType))
            {
                return true;
            }

            inherits = DefinitionPassVisitor.clase.get(inherits);
        }
        return false;
    }

    @Override
    public String visit(Assign assign) {
        var varName = assign.name.getText();
        var symbol = (IdSymbol)DefinitionPassVisitor.currentScope.lookup(varName);
        var varType = "null";

        if(symbol != null)
        {
            varType = symbol.getType();
        }
        else
        {
            Symbol sym = DefinitionPassVisitor.functionScope.lookup(method_name);
            if(sym != null)
            {
                LinkedList<String> formali = ((FuncSymbol) sym).getFormali();
                int index = formali.indexOf(varName);
                LinkedList<String> tipuri = ((FuncSymbol) sym).getTipuri();
                if(index >=0)
                    varType = tipuri.get(index);
            }
        }
        var exprType = assign.e.accept(this);

        if(assign.name.getText().equals("self"))
        {
            SymbolTable.error(assign.ctx, assign.ctx.name, "Cannot assign to self");
            return null;
        }

        if(exprType != null && exprType.equals("Object"))
        {
            SymbolTable.error(assign.ctx, assign.ctx.e.start, "Type " + exprType + " of assigned expression is " +
                    "incompatible with declared type " + varType + " of identifier " + assign.name.getText());
            return null;
        }
        else if(!varType.equals(exprType) && !varType.equals("null") && !verifyInheritance(varType, exprType) && exprType != null && !exprType.equals("null"))
        {
            SymbolTable.error(assign.ctx, assign.ctx.e.start, "Type " + exprType + " of assigned expression is " +
                    "incompatible with declared type " + varType + " of identifier " + assign.name.getText());
            return null;
        }
        return exprType;
    }

    @Override
    public String visit(New aNew) {
        var type = aNew.name.getText();

        if(letCase == 1 && tipVarLocalaLet != null)
        {
            if(!type.equals(tipVarLocalaLet) && !verifyInheritance(tipVarLocalaLet, type))
            {
                SymbolTable.error(aNew.ctx, aNew.ctx.start, "Type " + type + " of initialization expression of identifier "
                        + varLocaleLet.getLast() + " is incompatible with declared type " + tipVarLocalaLet);
            }
            tipVarLocalaLet = null;
        }

        if (DefinitionPassVisitor.currentScope.lookup(type) == null)
        {
            SymbolTable.error(aNew.ctx, aNew.ctx.name, "new is used with undefined type " + type);
            return null;
        }
        return type;
    }

    @Override
    public String visit(While aWhile) {
        var condType = aWhile.cond.accept(this);

        if(condType != null && !condType.equals("Bool"))
        {
            SymbolTable.error(aWhile.ctx, aWhile.ctx.cond.start, "While condition has type " + condType +" instead of Bool");
        }
        return "Object";
    }

    public String commonParentClass(String firstClassType, String secondClassType)
    {
        String inheritsFirst = DefinitionPassVisitor.clase.get(firstClassType);
        String inheritsSecond = DefinitionPassVisitor.clase.get(secondClassType);
        if(verifyInheritance(firstClassType, secondClassType))
            return firstClassType;
        else
        {
            String inherits = DefinitionPassVisitor.clase.get(firstClassType);
            while(inherits != null)
            {
                if(inherits.equals("Object"))
                {
                    break;
                }
                inherits = DefinitionPassVisitor.clase.get(inherits);
            }

            if(verifyInheritance(inherits, secondClassType))
            {
                return inherits;
            }
        }
        return null;
    }

    @Override
    public String visit(If anIf) {
        var condType = anIf.cond.accept(this);
        var thenType = anIf.thenBranch.accept(this);
        var elseType = anIf.elseBranch.accept(this);

        if(condType != null && !condType.equals("Bool"))
        {
            SymbolTable.error(anIf.ctx, anIf.ctx.cond.start, "If condition has type " + condType + " instead of Bool");
        }

        if(thenType != null && thenType.equals(elseType))
        {
            return thenType;
        }
        else
        {
            return commonParentClass(thenType, elseType);
        }
    }

    @Override
    public String visit(Block block) {
        var type = "Object";
        for (var local: block.exprs)
        {
            type = local.accept(this);
        }
        return type;
    }

    @Override
    public String visit(ExplicitDispatch explicitDispatch) {




        return null;
    }

    @Override
    public String visit(Bool bool) {
        if(letCase == 1 && tipVarLocalaLet != null)
        {
            if(!"Bool".equals(tipVarLocalaLet))
            {
                SymbolTable.error(bool.ctx, bool.ctx.start, "Type " + "Bool" + " of initialization expression of identifier "
                        + varLocaleLet.getLast() + " is incompatible with declared type " + tipVarLocalaLet);
            }
            tipVarLocalaLet = null;
        }
        return "Bool";
    }

    @Override
    public String visit(Int anInt) {
        return "Int";
    }

    @Override
    public String visit(Text text) {
        return "String";
    }

    @Override
    public String visit(IsVoid isVoid) {
        return null;
    }

    @Override
    public String visit(ImplicitDispatch implicitDispatch) {
        return null;
    }
}