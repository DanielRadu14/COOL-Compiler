parser grammar CoolParser;

options {
    tokenVocab = CoolLexer;
}

@header{
    package cool.parser;
}

program
    :   (class_def SEMI)* EOF
    ;

class_def : CLASS name=TYPE (INHERITS inherits_name=TYPE)? LBRACE (feature SEMI)* RBRACE    #classDef
          ;

feature : name=ID COLON type=TYPE (ASSIGN assign=expr)?                                                                         #varDef
        | name=ID LPAREN (formals += formal (COMMA formals += formal)*)? RPAREN COLON type=TYPE LBRACE body=expr RBRACE         #funcDef
        ;

formal : name=ID COLON type=TYPE;

expr : dispatch=expr (DISPATCH dispatch_type=TYPE)? DOT name=ID LPAREN (exprs += expr (COMMA exprs += expr)*)? RPAREN       #explicitdispatch
     | name=ID LPAREN (exprs += expr (COMMA exprs += expr)*)? RPAREN                            #implicitdispatch
     | IF cond=expr THEN thenBranch=expr ELSE elseBranch=expr FI                                #ifelse
     | WHILE cond=expr LOOP body=expr POOL                                                      #while
     | LBRACE (exprs+=expr SEMI)* RBRACE                                                        #block
     | LET exprs+=expr (ASSIGN exprs+=expr)? (COMMA exprs+=expr (ASSIGN exprs+=expr)?)* IN body=expr                        #let
     | name=ID COLON type=TYPE                                                                  #letdefinition
     | CASE cond=expr OF (exprs+=expr VERIFY_CASE exprs+=expr SEMI)* ESAC                       #case
     | NEW name=TYPE                                                                            #new
     | ISVOID e=expr                                                                            #isvoid
     | NEG e=expr                                                                               #negation
     | left=expr op=MULT right=expr                                                             #mult
     | left=expr op=DIV right=expr                                                              #div
     | left=expr op=MINUS right=expr                                                            #minus
     | left=expr op=PLUS right=expr                                                             #plus
     | left=expr op=LT right=expr                                                               #lt
     | left=expr op=LE right=expr                                                               #le
     | left=expr op=EQUAL right=expr                                                            #equal
     | NOT e=expr                                                                               #not
     | name=ID ASSIGN e=expr                                                                    #assign
     | LPAREN e=expr RPAREN                                                                     #paren
     | name=ID                                                                                  #id
     | INT                                                                                      #int
     | STRING                                                                                   #text
     | BOOL                                                                                     #bool
     ;