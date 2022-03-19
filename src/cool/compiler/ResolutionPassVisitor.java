package cool.compiler;
import cool.structures.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.LinkedList;

public class ResolutionPassVisitor implements ASTVisitor<Void> {

    String class_name = null;
    String method_name = null;

    @Override
    public Void visit(Prog prog) {

        class_name = null;
        method_name = null;

        for (var stmt: prog.definitii_clase)
            stmt.accept(this);

        return null;
    }

    @Override
    public Void visit(ClassDef classDef) {

        var name = classDef.name;
        var inherits_name = classDef.inherits_name;

        String inherits = DefinitionPassVisitor.clase.get(name.getText());
        while(inherits != null)
        {
            if(inherits.equals(name.getText()))
            {
                SymbolTable.error(classDef.ctx, classDef.ctx.name, "Inheritance cycle for class " + name.getText());
                break;
            }

            inherits = DefinitionPassVisitor.clase.get(inherits);
        }

        if (inherits_name != null && DefinitionPassVisitor.currentScope.lookup(inherits_name.getText()) == null)
        {
            SymbolTable.error(classDef.ctx, classDef.ctx.inherits_name, "Class " + name.getText() + " has undefined parent " + inherits_name.getText());
        }

        class_name = name.getText();
        for (var stmt: classDef.definitii)
        {
            if(classDef.inherits_name != null)
            {
                stmt.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(VarDef varDef) {

        var id = varDef.id;
        var type = varDef.type;

        var symbol = new IdSymbol(id.getText());
        symbol.setType(type.getText());

        if (!DefinitionPassVisitor.currentScope.add(symbol)) {
            SymbolTable.error(varDef.ctx, varDef.ctx.name, "Class " + class_name + " redefines inherited attribute " + id.getText());
        }
        return null;
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
    public Void visit(FuncDef funcDef) {

        var id = funcDef.id;
        var type = funcDef.type;

        var sym = (FuncSymbol)DefinitionPassVisitor.functionScope.lookup(id.getText());

        var symbol = new FuncSymbol(id.getText());
        symbol.setType(type.getText());
        symbol.setClasa(class_name);

        if(sym != null && verifyInheritance(class_name, sym.getClasa()) && !sym.getClasa().equals(class_name))
        {
            SymbolTable.error(funcDef.ctx, funcDef.ctx.name, "Class " + class_name + " redefines method " + id.getText());
        }
        else
            DefinitionPassVisitor.functionScope.add(symbol);

        method_name = id.getText();
        for (var formal: funcDef.formali)
        {
            String nume_formal = ((Formal)formal).name.getText();
            String tip_formal = ((Formal)formal).type.getText();
            if(!symbol.existsFormal(nume_formal))
            {
                symbol.addFormal(nume_formal, tip_formal);
            }
            else
                SymbolTable.error(funcDef.ctx, ((Formal)formal).ctx.name, "Method " + method_name + " of class " + class_name + " redefines formal parameter " + nume_formal);
        }

        for (var formal: funcDef.formali)
        {
            formal.accept(this);
        }

        funcDef.body.accept(this);

        return null;
    }

    @Override
    public Void visit(Formal formal) {

        var name = formal.name;
        var type = formal.type;

        if(name.getText().equals("self"))
        {
            SymbolTable.error(formal.ctx, formal.ctx.name, "Method " + method_name + " of class " + class_name +
                    " has formal parameter with illegal name self");
        }

        if(type.getText().equals("SELF_TYPE"))
        {
            SymbolTable.error(formal.ctx, formal.ctx.type, "Method " + method_name + " of class " + class_name +
                    " has formal parameter " + name.getText() + " with illegal type SELF_TYPE");
        }

        return null;
    }

    @Override
    public Void visit(Let let) {
        return null;
    }

    @Override
    public Void visit(Case aCase) {
        return null;
    }

    @Override
    public Void visit(LetDefinition letDefinition) {
        return null;
    }

    @Override
    public Void visit(Id id) {
        return null;
    }

    @Override
    public Void visit(Le le) {
        return null;
    }

    @Override
    public Void visit(Lt lt) {
        return null;
    }

    @Override
    public Void visit(Div div) {
        return null;
    }

    @Override
    public Void visit(If anIf) {
        return null;
    }

    @Override
    public Void visit(Not not) {
        return null;
    }

    @Override
    public Void visit(New aNew) {
        return null;
    }

    @Override
    public Void visit(Bool bool) {
        return null;
    }

    @Override
    public Void visit(Int anInt) {
        return null;
    }

    @Override
    public Void visit(Mult mult) {
        return null;
    }

    @Override
    public Void visit(Plus plus) {
        return null;
    }

    @Override
    public Void visit(Text text) {
        return null;
    }

    @Override
    public Void visit(Block block) {
        return null;
    }

    @Override
    public Void visit(Equal equal) {
        return null;
    }

    @Override
    public Void visit(Minus minus) {
        return null;
    }

    @Override
    public Void visit(Paren paren) {
        return null;
    }

    @Override
    public Void visit(While aWhile) {
        return null;
    }

    @Override
    public Void visit(Assign assign) {
        return null;
    }

    @Override
    public Void visit(IsVoid isVoid) {
        return null;
    }

    @Override
    public Void visit(Negation negation) {
        return null;
    }

    @Override
    public Void visit(ExplicitDispatch explicitDispatch) {
        return null;
    }

    @Override
    public Void visit(ImplicitDispatch implicitDispatch) {
        return null;
    }
}