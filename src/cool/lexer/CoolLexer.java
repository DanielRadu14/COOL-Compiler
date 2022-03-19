// Generated from C:/Users/danie/Desktop/Tema1/src/cool/lexer\CoolLexer.g4 by ANTLR 4.8

    package cool.lexer;	

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, IF=2, THEN=3, ELSE=4, FI=5, WHILE=6, LOOP=7, POOL=8, LET=9, IN=10, 
		CASE=11, OF=12, ESAC=13, VERIFY_CASE=14, CLASS=15, INHERITS=16, TYPE=17, 
		INT=18, BOOL=19, NOT=20, ISVOID=21, NEW=22, DISPATCH=23, ID=24, NEG=25, 
		DOT=26, SEMI=27, COLON=28, COMMA=29, ASSIGN=30, LPAREN=31, RPAREN=32, 
		LBRACE=33, RBRACE=34, PLUS=35, MINUS=36, MULT=37, DIV=38, EQUAL=39, LT=40, 
		LE=41, STRING=42, LINE_COMMENT=43, BLOCK_COMMENT=44, UNMATCHED_COMMENT=45, 
		WS=46, INVALID_CHAR=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "LET", "IN", "CASE", 
			"OF", "ESAC", "VERIFY_CASE", "CLASS", "INHERITS", "TYPE", "INT", "BOOL", 
			"NOT", "ISVOID", "NEW", "DISPATCH", "DIGIT", "LETTER", "CAPITAL", "CLASS_NAME", 
			"ID", "NEG", "DOT", "SEMI", "COLON", "COMMA", "ASSIGN", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "PLUS", "MINUS", "MULT", "DIV", "EQUAL", "LT", "LE", 
			"STRING", "ESCAPED_NEW_LINE", "NEW_LINE", "LINE_COMMENT", "BLOCK_COMMENT", 
			"UNMATCHED_COMMENT", "WS", "INVALID_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'if'", "'then'", "'else'", "'fi'", "'while'", "'loop'", 
			"'pool'", "'let'", "'in'", "'case'", "'of'", "'esac'", "'=>'", "'class'", 
			"'inherits'", null, null, null, "'not'", "'isvoid'", "'new'", "'@'", 
			null, "'~'", "'.'", "';'", "':'", "','", "'<-'", "'('", "')'", "'{'", 
			"'}'", "'+'", "'-'", "'*'", "'/'", "'='", "'<'", "'<='", null, null, 
			null, "'*)'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ERROR", "IF", "THEN", "ELSE", "FI", "WHILE", "LOOP", "POOL", "LET", 
			"IN", "CASE", "OF", "ESAC", "VERIFY_CASE", "CLASS", "INHERITS", "TYPE", 
			"INT", "BOOL", "NOT", "ISVOID", "NEW", "DISPATCH", "ID", "NEG", "DOT", 
			"SEMI", "COLON", "COMMA", "ASSIGN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"PLUS", "MINUS", "MULT", "DIV", "EQUAL", "LT", "LE", "STRING", "LINE_COMMENT", 
			"BLOCK_COMMENT", "UNMATCHED_COMMENT", "WS", "INVALID_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	    
	    private void raiseError(String msg) {
	        setText(msg);
	        setType(ERROR);
	    }


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 44:
			STRING_action((RuleContext)_localctx, actionIndex);
			break;
		case 48:
			BLOCK_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 49:
			UNMATCHED_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 51:
			INVALID_CHAR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 raiseError("EOF in string constant"); 
			break;
		case 1:
			 raiseError("Unterminated string constant"); 
			break;
		case 2:
			   String s = getText();
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
			        
			break;
		}
	}
	private void BLOCK_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 skip(); 
			break;
		case 4:
			 raiseError("EOF in comment"); 
			break;
		}
	}
	private void UNMATCHED_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 raiseError("Unmatched *)");
			break;
		}
	}
	private void INVALID_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			   String s = getText();
			                    String result  = "Invalid character: ";

			                    result = result.concat(s);
			                    raiseError(result); 
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u017d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00cf\n\21\3\22\6\22"+
		"\u00d2\n\22\r\22\16\22\u00d3\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\5\23\u00df\n\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\7\33\u00fc\n\33\f\33\16\33\u00ff\13\33\3\34\3\34\5\34"+
		"\u0103\n\34\3\34\3\34\3\34\7\34\u0108\n\34\f\34\16\34\u010b\13\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\7.\u0134"+
		"\n.\f.\16.\u0137\13.\3.\3.\3.\3.\3.\3.\5.\u013f\n.\3.\3.\3/\3/\5/\u0145"+
		"\n/\3/\3/\3\60\5\60\u014a\n\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0152"+
		"\n\61\f\61\16\61\u0155\13\61\3\61\3\61\5\61\u0159\n\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\7\62\u0162\n\62\f\62\16\62\u0165\13\62\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\5\62\u016d\n\62\3\63\3\63\3\63\3\63\3\63\3\64\6\64"+
		"\u0175\n\64\r\64\16\64\u0176\3\64\3\64\3\65\3\65\3\65\5\u0135\u0153\u0163"+
		"\2\66\3\4\5\5\7\6\t\7\13\b\r\t\17\n\21\13\23\f\25\r\27\16\31\17\33\20"+
		"\35\21\37\22!\23#\24%\25\'\26)\27+\30-\31/\2\61\2\63\2\65\2\67\329\33"+
		";\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]\2_\2a-c.e/g\60i\61\3\2\6"+
		"\3\2\62;\4\2C\\c|\3\2C\\\5\2\13\f\16\17\"\"\2\u0190\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5n\3\2\2\2\7s\3\2\2\2\tx\3\2\2"+
		"\2\13{\3\2\2\2\r\u0081\3\2\2\2\17\u0086\3\2\2\2\21\u008b\3\2\2\2\23\u008f"+
		"\3\2\2\2\25\u0092\3\2\2\2\27\u0097\3\2\2\2\31\u009a\3\2\2\2\33\u009f\3"+
		"\2\2\2\35\u00a2\3\2\2\2\37\u00a8\3\2\2\2!\u00ce\3\2\2\2#\u00d1\3\2\2\2"+
		"%\u00de\3\2\2\2\'\u00e0\3\2\2\2)\u00e4\3\2\2\2+\u00eb\3\2\2\2-\u00ef\3"+
		"\2\2\2/\u00f1\3\2\2\2\61\u00f3\3\2\2\2\63\u00f5\3\2\2\2\65\u00f7\3\2\2"+
		"\2\67\u0102\3\2\2\29\u010c\3\2\2\2;\u010e\3\2\2\2=\u0110\3\2\2\2?\u0112"+
		"\3\2\2\2A\u0114\3\2\2\2C\u0116\3\2\2\2E\u0119\3\2\2\2G\u011b\3\2\2\2I"+
		"\u011d\3\2\2\2K\u011f\3\2\2\2M\u0121\3\2\2\2O\u0123\3\2\2\2Q\u0125\3\2"+
		"\2\2S\u0127\3\2\2\2U\u0129\3\2\2\2W\u012b\3\2\2\2Y\u012d\3\2\2\2[\u0130"+
		"\3\2\2\2]\u0142\3\2\2\2_\u0149\3\2\2\2a\u014d\3\2\2\2c\u015c\3\2\2\2e"+
		"\u016e\3\2\2\2g\u0174\3\2\2\2i\u017a\3\2\2\2kl\7k\2\2lm\7h\2\2m\4\3\2"+
		"\2\2no\7v\2\2op\7j\2\2pq\7g\2\2qr\7p\2\2r\6\3\2\2\2st\7g\2\2tu\7n\2\2"+
		"uv\7u\2\2vw\7g\2\2w\b\3\2\2\2xy\7h\2\2yz\7k\2\2z\n\3\2\2\2{|\7y\2\2|}"+
		"\7j\2\2}~\7k\2\2~\177\7n\2\2\177\u0080\7g\2\2\u0080\f\3\2\2\2\u0081\u0082"+
		"\7n\2\2\u0082\u0083\7q\2\2\u0083\u0084\7q\2\2\u0084\u0085\7r\2\2\u0085"+
		"\16\3\2\2\2\u0086\u0087\7r\2\2\u0087\u0088\7q\2\2\u0088\u0089\7q\2\2\u0089"+
		"\u008a\7n\2\2\u008a\20\3\2\2\2\u008b\u008c\7n\2\2\u008c\u008d\7g\2\2\u008d"+
		"\u008e\7v\2\2\u008e\22\3\2\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091"+
		"\24\3\2\2\2\u0092\u0093\7e\2\2\u0093\u0094\7c\2\2\u0094\u0095\7u\2\2\u0095"+
		"\u0096\7g\2\2\u0096\26\3\2\2\2\u0097\u0098\7q\2\2\u0098\u0099\7h\2\2\u0099"+
		"\30\3\2\2\2\u009a\u009b\7g\2\2\u009b\u009c\7u\2\2\u009c\u009d\7c\2\2\u009d"+
		"\u009e\7e\2\2\u009e\32\3\2\2\2\u009f\u00a0\7?\2\2\u00a0\u00a1\7@\2\2\u00a1"+
		"\34\3\2\2\2\u00a2\u00a3\7e\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7c\2\2\u00a5"+
		"\u00a6\7u\2\2\u00a6\u00a7\7u\2\2\u00a7\36\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9"+
		"\u00aa\7p\2\2\u00aa\u00ab\7j\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7t\2\2"+
		"\u00ad\u00ae\7k\2\2\u00ae\u00af\7v\2\2\u00af\u00b0\7u\2\2\u00b0 \3\2\2"+
		"\2\u00b1\u00b2\7K\2\2\u00b2\u00b3\7p\2\2\u00b3\u00cf\7v\2\2\u00b4\u00b5"+
		"\7U\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7t\2\2\u00b7\u00b8\7k\2\2\u00b8"+
		"\u00b9\7p\2\2\u00b9\u00cf\7i\2\2\u00ba\u00bb\7D\2\2\u00bb\u00bc\7q\2\2"+
		"\u00bc\u00bd\7q\2\2\u00bd\u00cf\7n\2\2\u00be\u00bf\7U\2\2\u00bf\u00c0"+
		"\7G\2\2\u00c0\u00c1\7N\2\2\u00c1\u00c2\7H\2\2\u00c2\u00c3\7a\2\2\u00c3"+
		"\u00c4\7V\2\2\u00c4\u00c5\7[\2\2\u00c5\u00c6\7R\2\2\u00c6\u00cf\7G\2\2"+
		"\u00c7\u00c8\7Q\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca\7l\2\2\u00ca\u00cb"+
		"\7g\2\2\u00cb\u00cc\7e\2\2\u00cc\u00cf\7v\2\2\u00cd\u00cf\5\65\33\2\u00ce"+
		"\u00b1\3\2\2\2\u00ce\u00b4\3\2\2\2\u00ce\u00ba\3\2\2\2\u00ce\u00be\3\2"+
		"\2\2\u00ce\u00c7\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\"\3\2\2\2\u00d0\u00d2"+
		"\5/\30\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4$\3\2\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7t\2\2\u00d7"+
		"\u00d8\7w\2\2\u00d8\u00df\7g\2\2\u00d9\u00da\7h\2\2\u00da\u00db\7c\2\2"+
		"\u00db\u00dc\7n\2\2\u00dc\u00dd\7u\2\2\u00dd\u00df\7g\2\2\u00de\u00d5"+
		"\3\2\2\2\u00de\u00d9\3\2\2\2\u00df&\3\2\2\2\u00e0\u00e1\7p\2\2\u00e1\u00e2"+
		"\7q\2\2\u00e2\u00e3\7v\2\2\u00e3(\3\2\2\2\u00e4\u00e5\7k\2\2\u00e5\u00e6"+
		"\7u\2\2\u00e6\u00e7\7x\2\2\u00e7\u00e8\7q\2\2\u00e8\u00e9\7k\2\2\u00e9"+
		"\u00ea\7f\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7g\2\2\u00ed"+
		"\u00ee\7y\2\2\u00ee,\3\2\2\2\u00ef\u00f0\7B\2\2\u00f0.\3\2\2\2\u00f1\u00f2"+
		"\t\2\2\2\u00f2\60\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4\62\3\2\2\2\u00f5\u00f6"+
		"\t\4\2\2\u00f6\64\3\2\2\2\u00f7\u00fd\5\63\32\2\u00f8\u00fc\5\61\31\2"+
		"\u00f9\u00fc\7a\2\2\u00fa\u00fc\5/\30\2\u00fb\u00f8\3\2\2\2\u00fb\u00f9"+
		"\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\66\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0103\5\61\31"+
		"\2\u0101\u0103\7a\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0109"+
		"\3\2\2\2\u0104\u0108\5\61\31\2\u0105\u0108\7a\2\2\u0106\u0108\5/\30\2"+
		"\u0107\u0104\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108\u010b"+
		"\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a8\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u010d\7\u0080\2\2\u010d:\3\2\2\2\u010e\u010f\7\60"+
		"\2\2\u010f<\3\2\2\2\u0110\u0111\7=\2\2\u0111>\3\2\2\2\u0112\u0113\7<\2"+
		"\2\u0113@\3\2\2\2\u0114\u0115\7.\2\2\u0115B\3\2\2\2\u0116\u0117\7>\2\2"+
		"\u0117\u0118\7/\2\2\u0118D\3\2\2\2\u0119\u011a\7*\2\2\u011aF\3\2\2\2\u011b"+
		"\u011c\7+\2\2\u011cH\3\2\2\2\u011d\u011e\7}\2\2\u011eJ\3\2\2\2\u011f\u0120"+
		"\7\177\2\2\u0120L\3\2\2\2\u0121\u0122\7-\2\2\u0122N\3\2\2\2\u0123\u0124"+
		"\7/\2\2\u0124P\3\2\2\2\u0125\u0126\7,\2\2\u0126R\3\2\2\2\u0127\u0128\7"+
		"\61\2\2\u0128T\3\2\2\2\u0129\u012a\7?\2\2\u012aV\3\2\2\2\u012b\u012c\7"+
		">\2\2\u012cX\3\2\2\2\u012d\u012e\7>\2\2\u012e\u012f\7?\2\2\u012fZ\3\2"+
		"\2\2\u0130\u0135\7$\2\2\u0131\u0134\5]/\2\u0132\u0134\13\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0132\3\2\2\2\u0134\u0137\3\2\2\2\u0135\u0136\3\2\2\2\u0135"+
		"\u0133\3\2\2\2\u0136\u013e\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013f\7$"+
		"\2\2\u0139\u013a\7\2\2\3\u013a\u013f\b.\2\2\u013b\u013c\5_\60\2\u013c"+
		"\u013d\b.\3\2\u013d\u013f\3\2\2\2\u013e\u0138\3\2\2\2\u013e\u0139\3\2"+
		"\2\2\u013e\u013b\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\b.\4\2\u0141"+
		"\\\3\2\2\2\u0142\u0144\7^\2\2\u0143\u0145\7\17\2\2\u0144\u0143\3\2\2\2"+
		"\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\7\f\2\2\u0147^\3"+
		"\2\2\2\u0148\u014a\7\17\2\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\7\f\2\2\u014c`\3\2\2\2\u014d\u014e\7/\2\2\u014e"+
		"\u014f\7/\2\2\u014f\u0153\3\2\2\2\u0150\u0152\13\2\2\2\u0151\u0150\3\2"+
		"\2\2\u0152\u0155\3\2\2\2\u0153\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0158\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0159\5_\60\2\u0157\u0159\7\2"+
		"\2\3\u0158\u0156\3\2\2\2\u0158\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a"+
		"\u015b\b\61\5\2\u015bb\3\2\2\2\u015c\u015d\7*\2\2\u015d\u015e\7,\2\2\u015e"+
		"\u0163\3\2\2\2\u015f\u0162\5c\62\2\u0160\u0162\13\2\2\2\u0161\u015f\3"+
		"\2\2\2\u0161\u0160\3\2\2\2\u0162\u0165\3\2\2\2\u0163\u0164\3\2\2\2\u0163"+
		"\u0161\3\2\2\2\u0164\u016c\3\2\2\2\u0165\u0163\3\2\2\2\u0166\u0167\7,"+
		"\2\2\u0167\u0168\7+\2\2\u0168\u0169\3\2\2\2\u0169\u016d\b\62\6\2\u016a"+
		"\u016b\7\2\2\3\u016b\u016d\b\62\7\2\u016c\u0166\3\2\2\2\u016c\u016a\3"+
		"\2\2\2\u016dd\3\2\2\2\u016e\u016f\7,\2\2\u016f\u0170\7+\2\2\u0170\u0171"+
		"\3\2\2\2\u0171\u0172\b\63\b\2\u0172f\3\2\2\2\u0173\u0175\t\5\2\2\u0174"+
		"\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0178\3\2\2\2\u0178\u0179\b\64\5\2\u0179h\3\2\2\2\u017a\u017b"+
		"\13\2\2\2\u017b\u017c\b\65\t\2\u017cj\3\2\2\2\26\2\u00ce\u00d3\u00de\u00fb"+
		"\u00fd\u0102\u0107\u0109\u0133\u0135\u013e\u0144\u0149\u0153\u0158\u0161"+
		"\u0163\u016c\u0176\n\3.\2\3.\3\3.\4\b\2\2\3\62\5\3\62\6\3\63\7\3\65\b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}