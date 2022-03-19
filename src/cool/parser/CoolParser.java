// Generated from C:/Users/danie/Desktop/Tema2/src/cool/parser\CoolParser.g4 by ANTLR 4.8

    package cool.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_class_def = 1, RULE_feature = 2, RULE_formal = 3, 
		RULE_expr = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class_def", "feature", "formal", "expr"
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

	@Override
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public List<Class_defContext> class_def() {
			return getRuleContexts(Class_defContext.class);
		}
		public Class_defContext class_def(int i) {
			return getRuleContext(Class_defContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(10);
				class_def();
				setState(11);
				match(SEMI);
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(18);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_defContext extends ParserRuleContext {
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
	 
		public Class_defContext() { }
		public void copyFrom(Class_defContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassDefContext extends Class_defContext {
		public Token name;
		public Token inherits_name;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> TYPE() { return getTokens(CoolParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(CoolParser.TYPE, i);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public ClassDefContext(Class_defContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_def);
		int _la;
		try {
			_localctx = new ClassDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(CLASS);
			setState(21);
			((ClassDefContext)_localctx).name = match(TYPE);
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(22);
				match(INHERITS);
				setState(23);
				((ClassDefContext)_localctx).inherits_name = match(TYPE);
				}
			}

			setState(26);
			match(LBRACE);
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(27);
				feature();
				setState(28);
				match(SEMI);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
	 
		public FeatureContext() { }
		public void copyFrom(FeatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarDefContext extends FeatureContext {
		public Token name;
		public Token type;
		public ExprContext assign;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncDefContext extends FeatureContext {
		public Token name;
		public FormalContext formal;
		public List<FormalContext> formals = new ArrayList<FormalContext>();
		public Token type;
		public ExprContext body;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public FuncDefContext(FeatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_feature);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new VarDefContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				((VarDefContext)_localctx).name = match(ID);
				setState(38);
				match(COLON);
				setState(39);
				((VarDefContext)_localctx).type = match(TYPE);
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(40);
					match(ASSIGN);
					setState(41);
					((VarDefContext)_localctx).assign = expr(0);
					}
				}

				}
				break;
			case 2:
				_localctx = new FuncDefContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				((FuncDefContext)_localctx).name = match(ID);
				setState(45);
				match(LPAREN);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(46);
					((FuncDefContext)_localctx).formal = formal();
					((FuncDefContext)_localctx).formals.add(((FuncDefContext)_localctx).formal);
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(47);
						match(COMMA);
						setState(48);
						((FuncDefContext)_localctx).formal = formal();
						((FuncDefContext)_localctx).formals.add(((FuncDefContext)_localctx).formal);
						}
						}
						setState(53);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(56);
				match(RPAREN);
				setState(57);
				match(COLON);
				setState(58);
				((FuncDefContext)_localctx).type = match(TYPE);
				setState(59);
				match(LBRACE);
				setState(60);
				((FuncDefContext)_localctx).body = expr(0);
				setState(61);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormalContext extends ParserRuleContext {
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitFormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((FormalContext)_localctx).name = match(ID);
			setState(66);
			match(COLON);
			setState(67);
			((FormalContext)_localctx).type = match(TYPE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MinusContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public MinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationContext extends ExprContext {
		public ExprContext e;
		public TerminalNode NEG() { return getToken(CoolParser.NEG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(CoolParser.MULT, 0); }
		public MultContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(CoolParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IsvoidContext extends ExprContext {
		public ExprContext e;
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IsvoidContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIsvoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIsvoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIsvoid(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LtContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public LtContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileContext extends ExprContext {
		public ExprContext cond;
		public ExprContext body;
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WhileContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DIV() { return getToken(CoolParser.DIV, 0); }
		public DivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public ExprContext e;
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenContext extends ExprContext {
		public ExprContext e;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BlockContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetContext extends ExprContext {
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public ExprContext body;
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(CoolParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(CoolParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public LetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public Token name;
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TextContext extends ExprContext {
		public TerminalNode STRING() { return getToken(CoolParser.STRING, 0); }
		public TextContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitText(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CaseContext extends ExprContext {
		public ExprContext cond;
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> VERIFY_CASE() { return getTokens(CoolParser.VERIFY_CASE); }
		public TerminalNode VERIFY_CASE(int i) {
			return getToken(CoolParser.VERIFY_CASE, i);
		}
		public List<TerminalNode> SEMI() { return getTokens(CoolParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(CoolParser.SEMI, i);
		}
		public CaseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewContext extends ExprContext {
		public Token name;
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public NewContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterNew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitNew(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitNew(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplicitdispatchContext extends ExprContext {
		public Token name;
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ImplicitdispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterImplicitdispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitImplicitdispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitImplicitdispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LetdefinitionContext extends ExprContext {
		public Token name;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public LetdefinitionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLetdefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLetdefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLetdefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(CoolParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PlusContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public PlusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitPlus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfelseContext extends ExprContext {
		public ExprContext cond;
		public ExprContext thenBranch;
		public ExprContext elseBranch;
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public IfelseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitIfelse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitIfelse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CoolParser.EQUAL, 0); }
		public EqualContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitdispatchContext extends ExprContext {
		public ExprContext dispatch;
		public Token dispatch_type;
		public Token name;
		public ExprContext expr;
		public List<ExprContext> exprs = new ArrayList<ExprContext>();
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public TerminalNode DISPATCH() { return getToken(CoolParser.DISPATCH, 0); }
		public TerminalNode TYPE() { return getToken(CoolParser.TYPE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public ExplicitdispatchContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterExplicitdispatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitExplicitdispatch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExplicitdispatch(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public LeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterLe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitLe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLe(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends ExprContext {
		public Token name;
		public ExprContext e;
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public TerminalNode ID() { return getToken(CoolParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CoolParserListener ) ((CoolParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new ImplicitdispatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(70);
				((ImplicitdispatchContext)_localctx).name = match(ID);
				setState(71);
				match(LPAREN);
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << LET) | (1L << CASE) | (1L << INT) | (1L << BOOL) | (1L << NOT) | (1L << ISVOID) | (1L << NEW) | (1L << ID) | (1L << NEG) | (1L << LPAREN) | (1L << LBRACE) | (1L << STRING))) != 0)) {
					{
					setState(72);
					((ImplicitdispatchContext)_localctx).expr = expr(0);
					((ImplicitdispatchContext)_localctx).exprs.add(((ImplicitdispatchContext)_localctx).expr);
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(73);
						match(COMMA);
						setState(74);
						((ImplicitdispatchContext)_localctx).expr = expr(0);
						((ImplicitdispatchContext)_localctx).exprs.add(((ImplicitdispatchContext)_localctx).expr);
						}
						}
						setState(79);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(82);
				match(RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new IfelseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(IF);
				setState(84);
				((IfelseContext)_localctx).cond = expr(0);
				setState(85);
				match(THEN);
				setState(86);
				((IfelseContext)_localctx).thenBranch = expr(0);
				setState(87);
				match(ELSE);
				setState(88);
				((IfelseContext)_localctx).elseBranch = expr(0);
				setState(89);
				match(FI);
				}
				break;
			case 3:
				{
				_localctx = new WhileContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(WHILE);
				setState(92);
				((WhileContext)_localctx).cond = expr(0);
				setState(93);
				match(LOOP);
				setState(94);
				((WhileContext)_localctx).body = expr(0);
				setState(95);
				match(POOL);
				}
				break;
			case 4:
				{
				_localctx = new BlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(LBRACE);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << LET) | (1L << CASE) | (1L << INT) | (1L << BOOL) | (1L << NOT) | (1L << ISVOID) | (1L << NEW) | (1L << ID) | (1L << NEG) | (1L << LPAREN) | (1L << LBRACE) | (1L << STRING))) != 0)) {
					{
					{
					setState(98);
					((BlockContext)_localctx).expr = expr(0);
					((BlockContext)_localctx).exprs.add(((BlockContext)_localctx).expr);
					setState(99);
					match(SEMI);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(106);
				match(RBRACE);
				}
				break;
			case 5:
				{
				_localctx = new LetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(LET);
				setState(108);
				((LetContext)_localctx).expr = expr(0);
				((LetContext)_localctx).exprs.add(((LetContext)_localctx).expr);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(109);
					match(ASSIGN);
					setState(110);
					((LetContext)_localctx).expr = expr(0);
					((LetContext)_localctx).exprs.add(((LetContext)_localctx).expr);
					}
				}

				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(113);
					match(COMMA);
					setState(114);
					((LetContext)_localctx).expr = expr(0);
					((LetContext)_localctx).exprs.add(((LetContext)_localctx).expr);
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ASSIGN) {
						{
						setState(115);
						match(ASSIGN);
						setState(116);
						((LetContext)_localctx).expr = expr(0);
						((LetContext)_localctx).exprs.add(((LetContext)_localctx).expr);
						}
					}

					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(IN);
				setState(125);
				((LetContext)_localctx).body = expr(20);
				}
				break;
			case 6:
				{
				_localctx = new LetdefinitionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				((LetdefinitionContext)_localctx).name = match(ID);
				setState(128);
				match(COLON);
				setState(129);
				((LetdefinitionContext)_localctx).type = match(TYPE);
				}
				break;
			case 7:
				{
				_localctx = new CaseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				match(CASE);
				setState(131);
				((CaseContext)_localctx).cond = expr(0);
				setState(132);
				match(OF);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << LET) | (1L << CASE) | (1L << INT) | (1L << BOOL) | (1L << NOT) | (1L << ISVOID) | (1L << NEW) | (1L << ID) | (1L << NEG) | (1L << LPAREN) | (1L << LBRACE) | (1L << STRING))) != 0)) {
					{
					{
					setState(133);
					((CaseContext)_localctx).expr = expr(0);
					((CaseContext)_localctx).exprs.add(((CaseContext)_localctx).expr);
					setState(134);
					match(VERIFY_CASE);
					setState(135);
					((CaseContext)_localctx).expr = expr(0);
					((CaseContext)_localctx).exprs.add(((CaseContext)_localctx).expr);
					setState(136);
					match(SEMI);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(143);
				match(ESAC);
				}
				break;
			case 8:
				{
				_localctx = new NewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(145);
				match(NEW);
				setState(146);
				((NewContext)_localctx).name = match(TYPE);
				}
				break;
			case 9:
				{
				_localctx = new IsvoidContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(147);
				match(ISVOID);
				setState(148);
				((IsvoidContext)_localctx).e = expr(16);
				}
				break;
			case 10:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(149);
				match(NEG);
				setState(150);
				((NegationContext)_localctx).e = expr(15);
				}
				break;
			case 11:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(151);
				match(NOT);
				setState(152);
				((NotContext)_localctx).e = expr(7);
				}
				break;
			case 12:
				{
				_localctx = new AssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(153);
				((AssignContext)_localctx).name = match(ID);
				setState(154);
				match(ASSIGN);
				setState(155);
				((AssignContext)_localctx).e = expr(6);
				}
				break;
			case 13:
				{
				_localctx = new ParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156);
				match(LPAREN);
				setState(157);
				((ParenContext)_localctx).e = expr(0);
				setState(158);
				match(RPAREN);
				}
				break;
			case 14:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160);
				((IdContext)_localctx).name = match(ID);
				}
				break;
			case 15:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(INT);
				}
				break;
			case 16:
				{
				_localctx = new TextContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(STRING);
				}
				break;
			case 17:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(BOOL);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new MultContext(new ExprContext(_parentctx, _parentState));
						((MultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(167);
						((MultContext)_localctx).op = match(MULT);
						setState(168);
						((MultContext)_localctx).right = expr(15);
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new ExprContext(_parentctx, _parentState));
						((DivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(170);
						((DivContext)_localctx).op = match(DIV);
						setState(171);
						((DivContext)_localctx).right = expr(14);
						}
						break;
					case 3:
						{
						_localctx = new MinusContext(new ExprContext(_parentctx, _parentState));
						((MinusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(173);
						((MinusContext)_localctx).op = match(MINUS);
						setState(174);
						((MinusContext)_localctx).right = expr(13);
						}
						break;
					case 4:
						{
						_localctx = new PlusContext(new ExprContext(_parentctx, _parentState));
						((PlusContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(175);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(176);
						((PlusContext)_localctx).op = match(PLUS);
						setState(177);
						((PlusContext)_localctx).right = expr(12);
						}
						break;
					case 5:
						{
						_localctx = new LtContext(new ExprContext(_parentctx, _parentState));
						((LtContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(179);
						((LtContext)_localctx).op = match(LT);
						setState(180);
						((LtContext)_localctx).right = expr(11);
						}
						break;
					case 6:
						{
						_localctx = new LeContext(new ExprContext(_parentctx, _parentState));
						((LeContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(182);
						((LeContext)_localctx).op = match(LE);
						setState(183);
						((LeContext)_localctx).right = expr(10);
						}
						break;
					case 7:
						{
						_localctx = new EqualContext(new ExprContext(_parentctx, _parentState));
						((EqualContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(185);
						((EqualContext)_localctx).op = match(EQUAL);
						setState(186);
						((EqualContext)_localctx).right = expr(9);
						}
						break;
					case 8:
						{
						_localctx = new ExplicitdispatchContext(new ExprContext(_parentctx, _parentState));
						((ExplicitdispatchContext)_localctx).dispatch = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(190);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==DISPATCH) {
							{
							setState(188);
							match(DISPATCH);
							setState(189);
							((ExplicitdispatchContext)_localctx).dispatch_type = match(TYPE);
							}
						}

						setState(192);
						match(DOT);
						setState(193);
						((ExplicitdispatchContext)_localctx).name = match(ID);
						setState(194);
						match(LPAREN);
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << LET) | (1L << CASE) | (1L << INT) | (1L << BOOL) | (1L << NOT) | (1L << ISVOID) | (1L << NEW) | (1L << ID) | (1L << NEG) | (1L << LPAREN) | (1L << LBRACE) | (1L << STRING))) != 0)) {
							{
							setState(195);
							((ExplicitdispatchContext)_localctx).expr = expr(0);
							((ExplicitdispatchContext)_localctx).exprs.add(((ExplicitdispatchContext)_localctx).expr);
							setState(200);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(196);
								match(COMMA);
								setState(197);
								((ExplicitdispatchContext)_localctx).expr = expr(0);
								((ExplicitdispatchContext)_localctx).exprs.add(((ExplicitdispatchContext)_localctx).expr);
								}
								}
								setState(202);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(205);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 25);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u00d6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\7\2\20\n\2\f\2\16\2\23\13"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\33\n\3\3\3\3\3\3\3\3\3\7\3!\n\3\f\3\16"+
		"\3$\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\4\3\4\3\4\7\4"+
		"\64\n\4\f\4\16\4\67\13\4\5\49\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6N\n\6\f\6\16\6Q\13\6\5\6S"+
		"\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\3\6\3\6\3\6\3\6\5\6r\n\6\3\6\3"+
		"\6\3\6\3\6\5\6x\n\6\7\6z\n\6\f\6\16\6}\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6\u00a7\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c1\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\u00c9\n\6\f\6\16\6\u00cc\13\6\5\6\u00ce\n\6\3\6\7"+
		"\6\u00d1\n\6\f\6\16\6\u00d4\13\6\3\6\2\3\n\7\2\4\6\b\n\2\2\2\u00f9\2\21"+
		"\3\2\2\2\4\26\3\2\2\2\6A\3\2\2\2\bC\3\2\2\2\n\u00a6\3\2\2\2\f\r\5\4\3"+
		"\2\r\16\7\35\2\2\16\20\3\2\2\2\17\f\3\2\2\2\20\23\3\2\2\2\21\17\3\2\2"+
		"\2\21\22\3\2\2\2\22\24\3\2\2\2\23\21\3\2\2\2\24\25\7\2\2\3\25\3\3\2\2"+
		"\2\26\27\7\21\2\2\27\32\7\23\2\2\30\31\7\22\2\2\31\33\7\23\2\2\32\30\3"+
		"\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\"\7#\2\2\35\36\5\6\4\2\36\37\7\35"+
		"\2\2\37!\3\2\2\2 \35\3\2\2\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2"+
		"$\"\3\2\2\2%&\7$\2\2&\5\3\2\2\2\'(\7\32\2\2()\7\36\2\2),\7\23\2\2*+\7"+
		" \2\2+-\5\n\6\2,*\3\2\2\2,-\3\2\2\2-B\3\2\2\2./\7\32\2\2/8\7!\2\2\60\65"+
		"\5\b\5\2\61\62\7\37\2\2\62\64\5\b\5\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63"+
		"\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2\28\60\3\2\2\289\3\2\2\2"+
		"9:\3\2\2\2:;\7\"\2\2;<\7\36\2\2<=\7\23\2\2=>\7#\2\2>?\5\n\6\2?@\7$\2\2"+
		"@B\3\2\2\2A\'\3\2\2\2A.\3\2\2\2B\7\3\2\2\2CD\7\32\2\2DE\7\36\2\2EF\7\23"+
		"\2\2F\t\3\2\2\2GH\b\6\1\2HI\7\32\2\2IR\7!\2\2JO\5\n\6\2KL\7\37\2\2LN\5"+
		"\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RJ\3"+
		"\2\2\2RS\3\2\2\2ST\3\2\2\2T\u00a7\7\"\2\2UV\7\4\2\2VW\5\n\6\2WX\7\5\2"+
		"\2XY\5\n\6\2YZ\7\6\2\2Z[\5\n\6\2[\\\7\7\2\2\\\u00a7\3\2\2\2]^\7\b\2\2"+
		"^_\5\n\6\2_`\7\t\2\2`a\5\n\6\2ab\7\n\2\2b\u00a7\3\2\2\2ci\7#\2\2de\5\n"+
		"\6\2ef\7\35\2\2fh\3\2\2\2gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jl\3"+
		"\2\2\2ki\3\2\2\2l\u00a7\7$\2\2mn\7\13\2\2nq\5\n\6\2op\7 \2\2pr\5\n\6\2"+
		"qo\3\2\2\2qr\3\2\2\2r{\3\2\2\2st\7\37\2\2tw\5\n\6\2uv\7 \2\2vx\5\n\6\2"+
		"wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2ys\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2"+
		"|~\3\2\2\2}{\3\2\2\2~\177\7\f\2\2\177\u0080\5\n\6\26\u0080\u00a7\3\2\2"+
		"\2\u0081\u0082\7\32\2\2\u0082\u0083\7\36\2\2\u0083\u00a7\7\23\2\2\u0084"+
		"\u0085\7\r\2\2\u0085\u0086\5\n\6\2\u0086\u008e\7\16\2\2\u0087\u0088\5"+
		"\n\6\2\u0088\u0089\7\20\2\2\u0089\u008a\5\n\6\2\u008a\u008b\7\35\2\2\u008b"+
		"\u008d\3\2\2\2\u008c\u0087\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0092\7\17\2\2\u0092\u00a7\3\2\2\2\u0093\u0094\7\30\2\2\u0094\u00a7\7"+
		"\23\2\2\u0095\u0096\7\27\2\2\u0096\u00a7\5\n\6\22\u0097\u0098\7\33\2\2"+
		"\u0098\u00a7\5\n\6\21\u0099\u009a\7\26\2\2\u009a\u00a7\5\n\6\t\u009b\u009c"+
		"\7\32\2\2\u009c\u009d\7 \2\2\u009d\u00a7\5\n\6\b\u009e\u009f\7!\2\2\u009f"+
		"\u00a0\5\n\6\2\u00a0\u00a1\7\"\2\2\u00a1\u00a7\3\2\2\2\u00a2\u00a7\7\32"+
		"\2\2\u00a3\u00a7\7\24\2\2\u00a4\u00a7\7,\2\2\u00a5\u00a7\7\25\2\2\u00a6"+
		"G\3\2\2\2\u00a6U\3\2\2\2\u00a6]\3\2\2\2\u00a6c\3\2\2\2\u00a6m\3\2\2\2"+
		"\u00a6\u0081\3\2\2\2\u00a6\u0084\3\2\2\2\u00a6\u0093\3\2\2\2\u00a6\u0095"+
		"\3\2\2\2\u00a6\u0097\3\2\2\2\u00a6\u0099\3\2\2\2\u00a6\u009b\3\2\2\2\u00a6"+
		"\u009e\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00d2\3\2\2\2\u00a8\u00a9\f\20\2\2\u00a9"+
		"\u00aa\7\'\2\2\u00aa\u00d1\5\n\6\21\u00ab\u00ac\f\17\2\2\u00ac\u00ad\7"+
		"(\2\2\u00ad\u00d1\5\n\6\20\u00ae\u00af\f\16\2\2\u00af\u00b0\7&\2\2\u00b0"+
		"\u00d1\5\n\6\17\u00b1\u00b2\f\r\2\2\u00b2\u00b3\7%\2\2\u00b3\u00d1\5\n"+
		"\6\16\u00b4\u00b5\f\f\2\2\u00b5\u00b6\7*\2\2\u00b6\u00d1\5\n\6\r\u00b7"+
		"\u00b8\f\13\2\2\u00b8\u00b9\7+\2\2\u00b9\u00d1\5\n\6\f\u00ba\u00bb\f\n"+
		"\2\2\u00bb\u00bc\7)\2\2\u00bc\u00d1\5\n\6\13\u00bd\u00c0\f\33\2\2\u00be"+
		"\u00bf\7\31\2\2\u00bf\u00c1\7\23\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3"+
		"\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\7\34\2\2\u00c3\u00c4\7\32\2\2\u00c4"+
		"\u00cd\7!\2\2\u00c5\u00ca\5\n\6\2\u00c6\u00c7\7\37\2\2\u00c7\u00c9\5\n"+
		"\6\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00c5\3\2"+
		"\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\7\"\2\2\u00d0"+
		"\u00a8\3\2\2\2\u00d0\u00ab\3\2\2\2\u00d0\u00ae\3\2\2\2\u00d0\u00b1\3\2"+
		"\2\2\u00d0\u00b4\3\2\2\2\u00d0\u00b7\3\2\2\2\u00d0\u00ba\3\2\2\2\u00d0"+
		"\u00bd\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\13\3\2\2\2\u00d4\u00d2\3\2\2\2\26\21\32\",\658AORiqw{\u008e"+
		"\u00a6\u00c0\u00ca\u00cd\u00d0\u00d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}