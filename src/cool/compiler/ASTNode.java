package cool.compiler;
import cool.parser.CoolParser;
import cool.structures.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import java.util.*;


public abstract class ASTNode {
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }
}

abstract class Program extends ASTNode {
    Token token;
    ParserRuleContext ctx;

    Program(Token token, ParserRuleContext ctx) {
        this.token = token;
        this.ctx = ctx;
    }
}

class Prog extends Program {
    LinkedList<ASTNode> definitii_clase;

    Prog(LinkedList<ASTNode> definitii_clase,Token token,ParserRuleContext ctx)
    {
        super(token, ctx);
        this.definitii_clase = definitii_clase;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class ClassDefinition extends ASTNode {
    Token token;
    CoolParser.ClassDefContext ctx;

    ClassDefinition(Token token, CoolParser.ClassDefContext ctx) {
        this.token = token;
        this.ctx = ctx;
    }
}

class ClassDef extends ClassDefinition {

    Token name;
    Token inherits_name;
    LinkedList<ASTNode> definitii;

    ClassDef(Token name, Token inherits_name, LinkedList<ASTNode> definitii,
             Token start, CoolParser.ClassDefContext ctx) {
        super(start, ctx);
        this.name = name;
        this.inherits_name = inherits_name;
        this.definitii = definitii;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class FeatureDefinition extends ASTNode {
    Token token;

    FeatureDefinition(Token token) {
        this.token = token;
    }
}

class VarDef extends FeatureDefinition {
    Token id;
    Token type;
    Expression assign;
    CoolParser.VarDefContext ctx;

    VarDef(Token id, Token type, Expression assign, Token start, CoolParser.VarDefContext ctx) {
        super(start);
        this.id = id;
        this.type = type;
        this.assign = assign;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class FuncDef extends FeatureDefinition {
    Token id;
    LinkedList<ASTNode> formali;
    Token type;
    Expression body;
    CoolParser.FuncDefContext ctx;

    FuncDef(Token id, LinkedList<ASTNode> formali, Token type, Expression body, Token start, CoolParser.FuncDefContext ctx) {
        super(start);
        this.id = id;
        this.formali = formali;
        this.type = type;
        this.body = body;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class Formals extends ASTNode {
    Token token;

    Formals(Token token) {
        this.token = token;
    }
}

class Formal extends Formals {
    Token type;
    Token name;
    CoolParser.FormalContext ctx;

    Formal(Token name, Token type, Token start, CoolParser.FormalContext ctx) {
        super(start);
        this.type = type;
        this.name = name;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class Expression extends ASTNode {
    Token token;

    Expression(Token token) {
        this.token = token;
    }
}

class Int extends Expression {
    Int(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}


class Bool extends Expression {
    CoolParser.BoolContext ctx;

    Bool(Token token, CoolParser.BoolContext ctx) {
        super(token);
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Text extends Expression {
    Text(Token token) {
        super(token);
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Id extends Expression {

    CoolParser.IdContext ctx;

    Id(Token start, CoolParser.IdContext ctx) {
        super(start);
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Mult extends Expression {
    Expression left;
    Expression right;
    CoolParser.MultContext ctx;

    Mult(Expression left,
         Expression right,
         Token start,CoolParser.MultContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Div extends Expression {
    Expression left;
    Expression right;
    CoolParser.DivContext ctx;

    Div(Expression left,
        Expression right,
        Token start,
        CoolParser.DivContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Minus extends Expression {
    Expression left;
    Expression right;
    CoolParser.MinusContext ctx;

    Minus(Expression left,
          Expression right,
          Token start,
          CoolParser.MinusContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Plus extends Expression {
    Expression left;
    Expression right;
    CoolParser.PlusContext ctx;

    Plus(Expression left,
         Expression right,
         Token start,
         CoolParser.PlusContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Paren extends Expression {
    Expression e;
    CoolParser.ParenContext ctx;

    Paren(Expression e,
          Token start,
          CoolParser.ParenContext ctx) {
        super(start);
        this.e = e;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Negation extends Expression {
    Expression e;
    CoolParser.NegationContext ctx;

    Negation(Expression e,
               Token start,
             CoolParser.NegationContext ctx) {
        super(start);
        this.e = e;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Not extends Expression {
    Expression e;
    CoolParser.NotContext ctx;

    Not(Expression e,
        Token start,
        CoolParser.NotContext ctx) {
        super(start);
        this.e = e;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class New extends Expression {
    Token name;
    CoolParser.NewContext ctx;

    New(Token name,
        Token start,
        CoolParser.NewContext ctx) {
        super(start);
        this.name = name;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Lt extends Expression {
    Expression left;
    Expression right;
    CoolParser.LtContext ctx;

    Lt(Expression left,
       Expression right,
       Token start,
       CoolParser.LtContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Le extends Expression {
    Expression left;
    Expression right;
    CoolParser.LeContext ctx;

    Le(Expression left,
       Expression right,
       Token start,
       CoolParser.LeContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Equal extends Expression {
    Expression left;
    Expression right;
    CoolParser.EqualContext ctx;

    Equal(Expression left,
          Expression right,
          Token start,
          CoolParser.EqualContext ctx) {
        super(start);
        this.left = left;
        this.right = right;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class IsVoid extends Expression {
    Expression e;

    IsVoid(Expression e,
           Token start) {
        super(start);
        this.e = e;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Assign extends Expression {
    Token name;
    Expression e;
    CoolParser.AssignContext ctx;

    Assign(Token name,
           Expression e,
           Token start,
           CoolParser.AssignContext ctx) {
        super(start);
        this.name = name;
        this.e = e;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class ImplicitDispatch extends Expression {
    Token name;
    LinkedList<ASTNode> expresii;

    ImplicitDispatch(Token name,
                     LinkedList<ASTNode> expresii,
                     Token start) {
        super(start);
        this.name = name;
        this.expresii = expresii;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class ExplicitDispatch extends Expression {
    Expression dispatch;
    Token dispatch_type;
    Token name;
    LinkedList<ASTNode> expresii;

    ExplicitDispatch(Expression dispatch,
                     Token dispatch_type,
                     Token name,
                     LinkedList<ASTNode> expresii,
                     Token start) {
        super(start);
        this.dispatch = dispatch;
        this.dispatch_type = dispatch_type;
        this.name = name;
        this.expresii = expresii;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class If extends Expression {
    // Sunt necesare trei câmpuri pentru cele trei componente ale expresiei.
    Expression cond;
    Expression thenBranch;
    Expression elseBranch;
    CoolParser.IfelseContext ctx;

    If(Expression cond,
       Expression thenBranch,
       Expression elseBranch,
       Token start,
       CoolParser.IfelseContext ctx) {
        super(start);
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class While extends Expression {
    // Sunt necesare trei câmpuri pentru cele trei componente ale expresiei.
    Expression cond;
    Expression body;
    CoolParser.WhileContext ctx;

    While(Expression cond,
          Expression body,
          Token start,
          CoolParser.WhileContext ctx) {
        super(start);
        this.cond = cond;
        this.body = body;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Let extends Expression {
    LinkedList<ASTNode> locals;
    Expression body;
    CoolParser.LetContext ctx;

    Let(LinkedList<ASTNode> locals,
        Expression body,
        Token start,
        CoolParser.LetContext ctx) {
        super(start);
        this.locals = locals;
        this.body = body;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class LetDefinition extends Expression {
    Token type;
    Token name;
    CoolParser.LetdefinitionContext ctx;

    LetDefinition(Token name, Token type, Token start, CoolParser.LetdefinitionContext ctx) {
        super(start);
        this.type = type;
        this.name = name;
        this.ctx = ctx;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Case extends Expression {
    Expression cond;
    LinkedList<ASTNode> cases;

    Case(Expression cond,
        LinkedList<ASTNode> cases,
        Token start) {
        super(start);
        this.cases = cases;
        this.cond = cond;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Block extends Expression {
    LinkedList<ASTNode> exprs;

    Block(LinkedList<ASTNode> exprs,
         Token start) {
        super(start);
        this.exprs = exprs;
    }

    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}