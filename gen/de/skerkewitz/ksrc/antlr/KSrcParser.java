// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
package de.skerkewitz.ksrc.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KSrcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LET=11, FUNC=12, ASSIGN=13, WS=14, NUMBER=15, INTEGER=16, DECIMAL_INTEGER=17, 
		FLOAT_NUMBER=18, NAME=19, NEWLINE=20;
	public static final int
		RULE_file_input = 0, RULE_stmt_list = 1, RULE_stmt = 2, RULE_expr = 3, 
		RULE_arguments = 4, RULE_ident = 5, RULE_value = 6, RULE_func_decl = 7, 
		RULE_func_body = 8;
	public static final String[] ruleNames = {
		"file_input", "stmt_list", "stmt", "expr", "arguments", "ident", "value", 
		"func_decl", "func_body"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "','", "'{'", "'}'", 
		"'let'", "'fn'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "LET", 
		"FUNC", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", 
		"NAME", "NEWLINE"
	};
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
	public String getGrammarFileName() { return "KSrc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KSrcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class File_inputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(KSrcParser.EOF, 0); }
		public List<Stmt_listContext> stmt_list() {
			return getRuleContexts(Stmt_listContext.class);
		}
		public Stmt_listContext stmt_list(int i) {
			return getRuleContext(Stmt_listContext.class,i);
		}
		public List<Func_declContext> func_decl() {
			return getRuleContexts(Func_declContext.class);
		}
		public Func_declContext func_decl(int i) {
			return getRuleContext(Func_declContext.class,i);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFile_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFile_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFile_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LET) | (1L << FUNC) | (1L << NUMBER) | (1L << NAME))) != 0)) {
				{
				setState(20);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LET:
				case NUMBER:
				case NAME:
					{
					setState(18);
					stmt_list();
					}
					break;
				case FUNC:
					{
					setState(19);
					func_decl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
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

	public static class Stmt_listContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			stmt();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(28);
				match(T__0);
				setState(29);
				stmt();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclLetContext extends StmtContext {
		public TerminalNode LET() { return getToken(KSrcParser.LET, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(KSrcParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DeclLetContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclLet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stmt);
		try {
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				_localctx = new DeclLetContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(35);
				match(LET);
				setState(36);
				ident();
				setState(37);
				match(ASSIGN);
				setState(38);
				expr(0);
				}
				break;
			case NUMBER:
			case NAME:
				_localctx = new ExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				expr(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class ExprCallContext extends ExprContext {
		public TerminalNode NAME() { return getToken(KSrcParser.NAME, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExprCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprValueContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMulContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprMul(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprMul(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIdentContext extends ExprContext {
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public ExprIdentContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAddContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprAdd(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new ExprIdentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(44);
				ident();
				}
				break;
			case 2:
				{
				_localctx = new ExprValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				value();
				}
				break;
			case 3:
				{
				_localctx = new ExprCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(NAME);
				setState(47);
				match(T__5);
				setState(48);
				arguments();
				setState(49);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(53);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(54);
						match(T__1);
						setState(55);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(56);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(57);
						match(T__2);
						setState(58);
						expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(60);
						match(T__3);
						setState(61);
						expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ExprSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(63);
						match(T__4);
						setState(64);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	 
		public ArgumentsContext() { }
		public void copyFrom(ArgumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncArgumentsContext extends ArgumentsContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncArgumentsContext(ArgumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFuncArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFuncArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFuncArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arguments);
		int _la;
		try {
			_localctx = new FuncArgumentsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NUMBER || _la==NAME) {
				{
				setState(70);
				expr(0);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(71);
					match(T__7);
					setState(72);
					expr(0);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

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

	public static class IdentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(KSrcParser.NAME, 0); }
		public IdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentContext ident() throws RecognitionException {
		IdentContext _localctx = new IdentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ident);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(NAME);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(KSrcParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(NUMBER);
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

	public static class Func_declContext extends ParserRuleContext {
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
	 
		public Func_declContext() { }
		public void copyFrom(Func_declContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclFuncContext extends Func_declContext {
		public TerminalNode FUNC() { return getToken(KSrcParser.FUNC, 0); }
		public IdentContext ident() {
			return getRuleContext(IdentContext.class,0);
		}
		public Func_bodyContext func_body() {
			return getRuleContext(Func_bodyContext.class,0);
		}
		public DeclFuncContext(Func_declContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_func_decl);
		try {
			_localctx = new DeclFuncContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(FUNC);
			setState(85);
			ident();
			setState(86);
			func_body();
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

	public static class Func_bodyContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(KSrcParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(KSrcParser.NEWLINE, i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Func_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunc_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunc_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunc_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_bodyContext func_body() throws RecognitionException {
		Func_bodyContext _localctx = new Func_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__8);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LET) | (1L << NUMBER) | (1L << NAME) | (1L << NEWLINE))) != 0)) {
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWLINE:
					{
					setState(89);
					match(NEWLINE);
					}
					break;
				case LET:
				case NUMBER:
				case NAME:
					{
					setState(90);
					stmt();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			match(T__9);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26e\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\7\2"+
		"\27\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\7\3!\n\3\f\3\16\3$\13\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4,\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\66"+
		"\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5D\n\5\f\5\16\5"+
		"G\13\5\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\5\6Q\n\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n^\n\n\f\n\16\na\13\n\3\n\3\n\3\n\2\3\b\13"+
		"\2\4\6\b\n\f\16\20\22\2\2\2i\2\30\3\2\2\2\4\35\3\2\2\2\6+\3\2\2\2\b\65"+
		"\3\2\2\2\nP\3\2\2\2\fR\3\2\2\2\16T\3\2\2\2\20V\3\2\2\2\22Z\3\2\2\2\24"+
		"\27\5\4\3\2\25\27\5\20\t\2\26\24\3\2\2\2\26\25\3\2\2\2\27\32\3\2\2\2\30"+
		"\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3\2\2\2\33\34\7\2\2\3\34"+
		"\3\3\2\2\2\35\"\5\6\4\2\36\37\7\3\2\2\37!\5\6\4\2 \36\3\2\2\2!$\3\2\2"+
		"\2\" \3\2\2\2\"#\3\2\2\2#\5\3\2\2\2$\"\3\2\2\2%&\7\r\2\2&\'\5\f\7\2\'"+
		"(\7\17\2\2()\5\b\5\2),\3\2\2\2*,\5\b\5\2+%\3\2\2\2+*\3\2\2\2,\7\3\2\2"+
		"\2-.\b\5\1\2.\66\5\f\7\2/\66\5\16\b\2\60\61\7\25\2\2\61\62\7\b\2\2\62"+
		"\63\5\n\6\2\63\64\7\t\2\2\64\66\3\2\2\2\65-\3\2\2\2\65/\3\2\2\2\65\60"+
		"\3\2\2\2\66E\3\2\2\2\678\f\7\2\289\7\4\2\29D\5\b\5\b:;\f\6\2\2;<\7\5\2"+
		"\2<D\5\b\5\7=>\f\5\2\2>?\7\6\2\2?D\5\b\5\6@A\f\4\2\2AB\7\7\2\2BD\5\b\5"+
		"\5C\67\3\2\2\2C:\3\2\2\2C=\3\2\2\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2"+
		"\2\2F\t\3\2\2\2GE\3\2\2\2HM\5\b\5\2IJ\7\n\2\2JL\5\b\5\2KI\3\2\2\2LO\3"+
		"\2\2\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OM\3\2\2\2PH\3\2\2\2PQ\3\2\2\2Q\13"+
		"\3\2\2\2RS\7\25\2\2S\r\3\2\2\2TU\7\21\2\2U\17\3\2\2\2VW\7\16\2\2WX\5\f"+
		"\7\2XY\5\22\n\2Y\21\3\2\2\2Z_\7\13\2\2[^\7\26\2\2\\^\5\6\4\2][\3\2\2\2"+
		"]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\7\f\2"+
		"\2c\23\3\2\2\2\r\26\30\"+\65CEMP]_";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}