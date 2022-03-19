package cool.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import cool.lexer.*;
import cool.parser.*;
import cool.structures.SymbolTable;

import java.io.*;
import java.util.LinkedList;


public class Compiler {
    // Annotates class nodes with the names of files where they are defined.
    public static ParseTreeProperty<String> fileNames = new ParseTreeProperty<>();

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("No file(s) given");
            return;
        }
        
        CoolLexer lexer = null;
        CommonTokenStream tokenStream = null;
        CoolParser parser = null;
        ParserRuleContext globalTree = null;
        
        // True if any lexical or syntax errors occur.
        boolean lexicalSyntaxErrors = false;
        
        // Parse each input file and build one big parse tree out of
        // individual parse trees.
        for (var fileName : args) {
            var input = CharStreams.fromFileName(fileName);
            
            // Lexer
            if (lexer == null)
                lexer = new CoolLexer(input);
            else
                lexer.setInputStream(input);

            // Token stream
            if (tokenStream == null)
                tokenStream = new CommonTokenStream(lexer);
            else
                tokenStream.setTokenSource(lexer);
                
            /*
            // Test lexer only.
            tokenStream.fill();
            List<Token> tokens = tokenStream.getTokens();
            tokens.stream().forEach(token -> {
                var text = token.getText();
                var name = CoolLexer.VOCABULARY.getSymbolicName(token.getType());
                
                System.out.println(text + " : " + name);
                //System.out.println(token);
            });
            */
            
            // Parser
            if (parser == null)
                parser = new CoolParser(tokenStream);
            else
                parser.setTokenStream(tokenStream);
            
            // Customized error listener, for including file names in error
            // messages.
            var errorListener = new BaseErrorListener() {
                public boolean errors = false;
                
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer,
                                        Object offendingSymbol,
                                        int line, int charPositionInLine,
                                        String msg,
                                        RecognitionException e) {
                    String newMsg = "\"" + new File(fileName).getName() + "\", line " +
                                        line + ":" + (charPositionInLine + 1) + ", ";
                    
                    Token token = (Token)offendingSymbol;
                    if (token.getType() == CoolLexer.ERROR)
                        newMsg += "Lexical error: " + token.getText();
                    else
                        newMsg += "Syntax error: " + msg;
                    
                    System.err.println(newMsg);
                    errors = true;
                }
            };
            
            parser.removeErrorListeners();
            parser.addErrorListener(errorListener);
            
            // Actual parsing
            var tree = parser.program();
            if (globalTree == null)
                globalTree = tree;
            else
                // Add the current parse tree's children to the global tree.
                for (int i = 0; i < tree.getChildCount(); i++)
                    globalTree.addAnyChild(tree.getChild(i));
                    
            // Annotate class nodes with file names, to be used later
            // in semantic error messages.
            for (int i = 0; i < tree.getChildCount(); i++) {
                var child = tree.getChild(i);
                // The only ParserRuleContext children of the program node
                // are class nodes.
                if (child instanceof ParserRuleContext)
                    fileNames.put(child, fileName);
            }

            var astConstructionVisitor = new CoolParserBaseVisitor<ASTNode>() {
                @Override
                public ASTNode visitProgram(CoolParser.ProgramContext ctx) {
                    LinkedList<ASTNode> definitii = new LinkedList<>();
                    for (var arg : ctx.class_def()) {
                        definitii.add(visit(arg));
                    }
                    return new Prog(definitii, ctx.start, ctx);
                }

                @Override
                public ASTNode visitClassDef(CoolParser.ClassDefContext ctx) {
                    LinkedList<ASTNode> definitii = new LinkedList<>();
                    for (var arg : ctx.feature()) {
                        definitii.add(visit(arg));
                    }
                    return new ClassDef(ctx.name, ctx.inherits_name, definitii, ctx.start, ctx);
                }

                @Override
                public ASTNode visitVarDef(CoolParser.VarDefContext ctx) {
                    if (ctx.assign != null)
                        return new VarDef(ctx.name, ctx.type, (Expression) visit(ctx.assign), ctx.start, ctx);
                    else
                        return new VarDef(ctx.name, ctx.type, null, ctx.start, ctx);

                }

                @Override
                public ASTNode visitFuncDef(CoolParser.FuncDefContext ctx) {
                    LinkedList<ASTNode> formali = new LinkedList<>();
                    for (var arg : ctx.formals) {
                        formali.add(visit(arg));
                    }

                    return new FuncDef(ctx.name,
                            formali,
                            ctx.type,
                            (Expression) visit(ctx.body),
                            ctx.start, ctx);
                }

                @Override
                public ASTNode visitImplicitdispatch(CoolParser.ImplicitdispatchContext ctx) {
                    LinkedList<ASTNode> expresii = new LinkedList<>();
                    for (var arg : ctx.exprs) {
                        expresii.add(visit(arg));
                    }
                    return new ImplicitDispatch(ctx.name, expresii, ctx.start);
                }

                @Override
                public ASTNode visitExplicitdispatch(CoolParser.ExplicitdispatchContext ctx) {
                    LinkedList<ASTNode> expresii = new LinkedList<>();
                    for (var arg : ctx.exprs) {
                        expresii.add(visit(arg));
                    }
                    return new ExplicitDispatch((Expression) visit(ctx.dispatch), ctx.dispatch_type, ctx.name, expresii, ctx.start);
                }

                @Override
                public ASTNode visitLet(CoolParser.LetContext ctx) {

                    LinkedList<ASTNode> locals = new LinkedList<>();
                    for (int i = 0; i < ctx.exprs.size(); i++) {
                        locals.add(visit(ctx.exprs.get(i)));
                    }

                    return new Let(locals, (Expression) visit(ctx.body), ctx.start, ctx);
                }

                @Override
                public ASTNode visitBlock(CoolParser.BlockContext ctx) {
                    LinkedList<ASTNode> exprs = new LinkedList<>();
                    for (int i = 0; i < ctx.exprs.size(); i++) {
                        exprs.add(visit(ctx.exprs.get(i)));
                    }
                    return new Block(exprs, ctx.start);
                }

                @Override
                public ASTNode visitCase(CoolParser.CaseContext ctx) {
                    LinkedList<ASTNode> cases = new LinkedList<>();
                    for (int i = 0; i < ctx.exprs.size(); i++) {
                        cases.add(visit(ctx.exprs.get(i)));
                    }

                    return new Case((Expression) visit(ctx.cond), cases, ctx.start);
                }

                @Override
                public ASTNode visitFormal(CoolParser.FormalContext ctx) {
                    return new Formal(ctx.name,
                            ctx.type,
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitLetdefinition(CoolParser.LetdefinitionContext ctx) {
                    return new LetDefinition(ctx.name,
                            ctx.type,
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitDiv(CoolParser.DivContext ctx) {
                    return new Div((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitMult(CoolParser.MultContext ctx) {
                    return new Mult((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start, ctx);
                }

                @Override
                public ASTNode visitPlus(CoolParser.PlusContext ctx) {
                    return new Plus((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitMinus(CoolParser.MinusContext ctx) {
                    return new Minus((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitParen(CoolParser.ParenContext ctx) {
                    return new Paren(
                            (Expression) visit(ctx.e),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitNegation(CoolParser.NegationContext ctx) {
                    return new Negation((Expression) visit(ctx.e),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitNot(CoolParser.NotContext ctx) {
                    return new Not((Expression) visit(ctx.e),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitIsvoid(CoolParser.IsvoidContext ctx) {
                    return new IsVoid((Expression) visit(ctx.e),
                            ctx.start);
                }

                @Override
                public ASTNode visitAssign(CoolParser.AssignContext ctx) {
                    return new Assign(ctx.name,
                            (Expression) visit(ctx.e),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitNew(CoolParser.NewContext ctx) {
                    return new New(ctx.name,
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitInt(CoolParser.IntContext ctx) {

                    return new Int(ctx.INT().getSymbol());
                }

                @Override
                public ASTNode visitBool(CoolParser.BoolContext ctx) {
                    return new Bool(ctx.BOOL().getSymbol(), ctx);
                }

                @Override
                public ASTNode visitText(CoolParser.TextContext ctx) {
                    return new Text(ctx.STRING().getSymbol());
                }

                @Override
                public ASTNode visitId(CoolParser.IdContext ctx) {
                    return new Id(ctx.ID().getSymbol(), ctx);
                }

                @Override
                public ASTNode visitLe(CoolParser.LeContext ctx) {
                    return new Le((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitLt(CoolParser.LtContext ctx) {
                    return new Lt((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,
                            ctx);
                }


                @Override
                public ASTNode visitEqual(CoolParser.EqualContext ctx) {
                    return new Equal((Expression) visit(ctx.left),
                            (Expression) visit(ctx.right),
                            ctx.start,ctx);
                }

                @Override
                public ASTNode visitIfelse(CoolParser.IfelseContext ctx) {
                    return new If((Expression) visit(ctx.cond),
                            (Expression) visit(ctx.thenBranch),
                            (Expression) visit(ctx.elseBranch),
                            ctx.start,
                            ctx);
                }

                @Override
                public ASTNode visitWhile(CoolParser.WhileContext ctx) {
                    return new While((Expression) visit(ctx.cond),
                            (Expression) visit(ctx.body),
                            ctx.start,
                            ctx);
                }
            };


            var ast = astConstructionVisitor.visit(globalTree);
            var printVisitor = new ASTVisitor<Void>() {
                int indent = 1;
                boolean inLet = false;
                boolean inCase = false;

                @Override
                public Void visit(Prog prog) {
                    for (var arg : prog.definitii_clase) {
                        arg.accept(this);
                    }
                    return null;
                }

                @Override
                public Void visit(ClassDef classDef) {
                    printIndent("class");
                    indent++;
                    printIndent(classDef.name.getText());
                    if (classDef.inherits_name != null) printIndent(classDef.inherits_name.getText());
                    for (var arg : classDef.definitii) {
                        arg.accept(this);
                    }
                    indent--;
                    return null;
                }

                @Override
                public Void visit(ImplicitDispatch implicitDispatch) {
                    printIndent("implicit dispatch");
                    indent++;
                    printIndent(implicitDispatch.name.getText());
                    for (var arg : implicitDispatch.expresii) {
                        arg.accept(this);
                    }
                    indent--;
                    return null;
                }

                @Override
                public Void visit(ExplicitDispatch explicitDispatch) {
                    printIndent(".");
                    indent++;
                    explicitDispatch.dispatch.accept(this);
                    if (explicitDispatch.dispatch_type != null)
                        printIndent(explicitDispatch.dispatch_type.getText());

                    printIndent(explicitDispatch.name.getText());
                    for (var arg : explicitDispatch.expresii) {
                        arg.accept(this);
                    }
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Block block) {
                    printIndent("block");
                    indent++;
                    for (var arg : block.exprs) {
                        arg.accept(this);
                    }
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Let let) {
                    printIndent("let");
                    indent++;
                    inLet = true;
                    for (int i = 0; i < let.locals.size(); i++) {
                        indent++;
                        if (let.locals.get(i) != null) let.locals.get(i).accept(this);
                        indent--;
                    }
                    inLet = false;
                    let.body.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Case aCase) {
                    printIndent("case");
                    indent++;
                    inCase = true;
                    aCase.cond.accept(this);
                    for (int i = 0; i < aCase.cases.size(); i++) {
                        if (i % 2 == 0) printIndent("case branch");
                        indent++;
                        if (aCase.cases.get(i) != null) aCase.cases.get(i).accept(this);
                        indent--;
                    }
                    indent--;
                    inCase = false;
                    return null;
                }

                @Override
                public Void visit(LetDefinition letDefinition) {
                    if (inLet && !inCase) {
                        indent--;
                        printIndent("local");
                        indent++;
                    }
                    printIndent(letDefinition.type.getText());
                    printIndent(letDefinition.name.getText());
                    return null;
                }

                @Override
                public Void visit(If anIf) {
                    printIndent("if");
                    indent++;
                    anIf.cond.accept(this);
                    anIf.thenBranch.accept(this);
                    anIf.elseBranch.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(While aWhile) {
                    printIndent("while");
                    indent++;
                    aWhile.cond.accept(this);
                    aWhile.body.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(VarDef varDef) {
                    printIndent("attribute");
                    indent++;
                    printIndent(varDef.id.getText());
                    printIndent(varDef.type.getText());
                    if (varDef.assign != null) varDef.assign.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(FuncDef funcDef) {
                    printIndent("method");
                    indent++;
                    printIndent(funcDef.id.getText());
                    for (var arg : funcDef.formali) {
                        arg.accept(this);
                    }
                    printIndent(funcDef.type.getText());
                    funcDef.body.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Formal formal) {
                    printIndent("formal");
                    indent++;
                    printIndent(formal.type.getText());
                    printIndent(formal.name.getText());
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Div div) {
                    printIndent("/");
                    indent++;
                    div.left.accept(this);
                    div.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Mult mult) {
                    printIndent("*");
                    indent++;
                    mult.left.accept(this);
                    mult.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Plus plus) {
                    printIndent("+");
                    indent++;
                    plus.left.accept(this);
                    plus.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Minus minus) {
                    printIndent("-");
                    indent++;
                    minus.left.accept(this);
                    minus.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Paren paren) {
                    paren.e.accept(this);
                    return null;
                }

                @Override
                public Void visit(Negation negation) {
                    printIndent("~");
                    indent++;
                    negation.e.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Not not) {
                    printIndent("not");
                    indent++;
                    not.e.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(New aNew) {
                    printIndent("new");
                    indent++;
                    printIndent(aNew.name.getText());
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Int intt) {
                    printIndent(intt.token.getText());
                    return null;
                }

                @Override
                public Void visit(Bool bool) {
                    printIndent(bool.token.getText());
                    return null;
                }

                @Override
                public Void visit(Text text) {
                    printIndent(text.token.getText());
                    return null;
                }

                @Override
                public Void visit(Id id) {
                    printIndent(id.token.getText());
                    return null;
                }

                @Override
                public Void visit(Le le) {
                    printIndent("<=");
                    indent++;
                    le.left.accept(this);
                    le.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Lt lt) {
                    printIndent("<");
                    indent++;
                    lt.left.accept(this);
                    lt.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Equal equal) {
                    printIndent("=");
                    indent++;
                    equal.left.accept(this);
                    equal.right.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(Assign assign) {
                    printIndent("<-");
                    indent++;
                    printIndent(assign.name.getText());
                    assign.e.accept(this);
                    indent--;
                    return null;
                }

                @Override
                public Void visit(IsVoid isVoid) {
                    printIndent("isvoid");
                    indent++;
                    isVoid.e.accept(this);
                    indent--;
                    return null;
                }

                void printIndent(String str) {
                    for (int i = 0; i < indent; i++)
                        System.out.print("  ");
                    System.out.println(str);
                }
            };

            // Record any lexical or syntax errors.
            lexicalSyntaxErrors |= errorListener.errors;
            if (!lexicalSyntaxErrors) {
                //System.out.println("program");
                //ast.accept(printVisitor);
            }

            // Stop before semantic analysis phase, in case errors occurred.
            if (lexicalSyntaxErrors) {
                System.err.println("Compilation halted");
                return;
            }

            // Populate global scope.
            SymbolTable.defineBasicClasses();

            // TODO Semantic analysis
            var definitionPassVisitor = new DefinitionPassVisitor();
            var resolutionPassVisitor = new ResolutionPassVisitor();
            var thirdPassVisitor = new ThirdPassVisitor();
            ast.accept(definitionPassVisitor);
            ast.accept(resolutionPassVisitor);
            ast.accept(thirdPassVisitor);

            if (SymbolTable.hasSemanticErrors()) {
                System.err.println("Compilation halted");
                return;
            }
        }
    }
}
