package cool.compiler;
import cool.parser.CoolParser;
import cool.structures.*;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class DefinitionPassVisitor implements ASTVisitor<Void> {
    static Scope basicClassesScope = null;
    static Scope currentScope = null;
    static Scope functionScope = null;
    static Map<String, String> clase = new LinkedHashMap<>();
    String class_name = null;
    String method_name = null;
    int letCase = 0;

    public Scope getFunctionScope()
    {
        return functionScope;
    }

    @Override
    public Void visit(Prog prog) {
        basicClassesScope = SymbolTable.globals;
        currentScope = new DefaultScope(basicClassesScope);
        functionScope = new DefaultScope(null);

        clase = new LinkedHashMap<>();
        clase.put("Int", "Object");
        clase.put("String", "Object");
        clase.put("Bool", "Object");

        class_name = null;
        method_name = null;
        letCase = 0;

        for (var stmt: prog.definitii_clase)
            stmt.accept(this);

        return null;
    }

    @Override
    public Void visit(ClassDef classDef) {

        var name = classDef.name;
        var inherits_name = classDef.inherits_name;

        if (!clase.containsKey(name.getText()))
        {
            if(inherits_name != null)
            {
                clase.put(name.getText(), inherits_name.getText());
            }
            else
                clase.put(name.getText(), "Object");
        }

        var symbol = new Symbol(name.getText());

        if(name.getText().equals("SELF_TYPE"))
        {
            SymbolTable.error(classDef.ctx, classDef.ctx.name, "Class has illegal name " + name.getText());
        }

        if(inherits_name != null && (inherits_name.getText().equals("SELF_TYPE") || inherits_name.getText().equals("Bool") ||
                inherits_name.getText().equals("Int") || inherits_name.getText().equals("String")))
        {
            SymbolTable.error(classDef.ctx, classDef.ctx.inherits_name, "Class " + name.getText() + " has illegal parent " + inherits_name.getText());
        }

        if (!currentScope.add(symbol) || basicClassesScope.lookup(name.getText()) != null)
        {
            SymbolTable.error(classDef.ctx, classDef.ctx.name, "Class " + name.getText() + " is redefined");
        }



        class_name = name.getText();

        for (var stmt: classDef.definitii)
        {
            if(classDef.inherits_name == null)
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

        if(id.getText().equals("self"))
        {
            SymbolTable.error(varDef.ctx, varDef.ctx.name, "Class " + class_name + " has attribute with illegal name self");
        }

        if (!currentScope.add(symbol))
        {
            SymbolTable.error(varDef.ctx, varDef.ctx.name, "Class " + class_name + " redefines attribute " + id.getText());
        }
        return null;
    }

    @Override
    public Void visit(FuncDef funcDef) {

        var id = funcDef.id;
        var type = funcDef.type;

        var symbol = new FuncSymbol(id.getText());
        symbol.setType(type.getText());
        symbol.setClasa(class_name);

        if (!functionScope.add(symbol))
        {
            SymbolTable.error(funcDef.ctx, funcDef.ctx.name, "Class " + class_name + " redefines method " + id.getText());
        }

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
        letCase = 1;
        for (var local: let.locals)
        {
            local.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Case aCase) {

        letCase = 2;
        for (var local: aCase.cases)
        {
            local.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(LetDefinition letDefinition) {
        var name = letDefinition.name;
        var type = letDefinition.type;

        if(name.getText().equals("self"))
        {
            if(letCase == 1)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.name, "Let variable has illegal name self");
            else if(letCase == 2)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.name, "Case variable has illegal name self");
        }

        if(type.getText().equals("SELF_TYPE"))
        {
            if(letCase == 1)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.type, "Let variable " + name.getText() + " has illegal type SELF_TYPE");
            else if(letCase == 2)
                SymbolTable.error(letDefinition.ctx, letDefinition.ctx.type, "Case variable " + name.getText() + " has illegal type SELF_TYPE");
        }

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