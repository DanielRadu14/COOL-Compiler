lexer grammar CoolLexer;

tokens { ERROR } 

@header{
    package cool.lexer;	
}

@members{    
    private void raiseError(String msg) {
        setText(msg);
        setType(ERROR);
    }
}

IF : 'if';
THEN : 'then';
ELSE : 'else';
FI: 'fi';

WHILE : 'while';
LOOP : 'loop';
POOL : 'pool';

LET : 'let';
IN : 'in';

CASE : 'case';
OF : 'of';
ESAC : 'esac';
VERIFY_CASE : '=>';

CLASS : 'class';

INHERITS : 'inherits';

TYPE : 'Int' | 'String' | 'Bool' | 'SELF_TYPE' | 'Object' | CLASS_NAME;

INT : DIGIT+;
BOOL : 'true' | 'false';

NOT : 'not';

ISVOID : 'isvoid';

NEW : 'new';

DISPATCH : '@';

fragment DIGIT : [0-9];
fragment LETTER : [a-zA-Z];
fragment CAPITAL : [A-Z];
fragment CLASS_NAME : CAPITAL(LETTER | '_' | DIGIT)*;
ID : (LETTER | '_')(LETTER | '_' | DIGIT)*;

NEG : '~';

DOT : '.';

SEMI : ';';

COLON : ':';

COMMA : ',';

ASSIGN : '<-';

LPAREN : '(';

RPAREN : ')';

LBRACE : '{';

RBRACE : '}';

PLUS : '+';

MINUS : '-';

MULT : '*';

DIV : '/';

EQUAL : '=';

LT : '<';

LE : '<=';

STRING : '"' (ESCAPED_NEW_LINE | .)*?
       ('"'
       | EOF { raiseError("EOF in string constant"); }
       | NEW_LINE { raiseError("Unterminated string constant"); })
        {   String s = getText();
            String result = "";
            boolean containsNull = false;

            int i = 0;
            while(i < s.length())
            {
                if(s.charAt(i) == '\u0000')
                {
                    containsNull = true;
                }

                if(s.charAt(i) == '\\' && s.charAt(i+1) == 'n')
                {
                    result = result + '\n';
                    i++;
                }
                else if(s.charAt(i) == '\\' && s.charAt(i+1) == 't')
                {
                    result = result + '\t';
                    i++;
                }
                else if(s.charAt(i) == '\\' && s.charAt(i+1) == 'f')
                {
                    result = result + '\f';
                    i++;
                }
                else if(s.charAt(i) == '\\' && s.charAt(i+1) == 'b')
                {
                    result = result + '\b';
                    i++;
                }
                else if(s.charAt(i) == '\\')
                {
                    result = result + s.charAt(i+1);
                    i++;
                }
                else if(s.charAt(i) == '"'){}
                else
                {
                    result = result + s.charAt(i);
                }
                i++;

            }
            if(s.length() > 1024)
            {
                raiseError("String constant too long");
            }
            else if(containsNull)
            {
                raiseError("String contains null character");
            }
            else setText(result);
        };

fragment ESCAPED_NEW_LINE : '\\' '\r'? '\n';
fragment NEW_LINE : '\r'? '\n';

LINE_COMMENT
    : '--' .*? (NEW_LINE | EOF) -> skip
    ;

BLOCK_COMMENT
    : '(*'
      (BLOCK_COMMENT | .)*?
      ('*)' { skip(); }| EOF { raiseError("EOF in comment"); })
    ;

UNMATCHED_COMMENT : '*)' { raiseError("Unmatched *)");};

WS
    :   [ \n\f\r\t]+ -> skip
    ;

INVALID_CHAR : .{   String s = getText();
                    String result  = "Invalid character: ";

                    result = result.concat(s);
                    raiseError(result); };