// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/java/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, LET=8, VAR=9, 
		FUNC=10, IF=11, RETURN=12, BREAK=13, WHILE=14, CLASS=15, ASSIGN=16, ELSE=17, 
		END=18, LPARENS=19, RPARENS=20, SEMICOLON=21, LINE_COMMENT=22, BLOCK_COMMENT=23, 
		POW=24, MINUS=25, NOT=26, MULT=27, DIV=28, MOD=29, PLUS=30, LTEQ=31, GTEQ=32, 
		LT=33, GT=34, EQ=35, IDEQ=36, NEQ=37, AND=38, OR=39, WS=40, DECIMAL_INTEGER=41, 
		FLOAT_LITERAL=42, STRING=43, NAME=44;
	public static final int
		RULE_translation_unit = 0, RULE_statements = 1, RULE_statement = 2, RULE_if_statement = 3, 
		RULE_loop_statement = 4, RULE_while_statement = 5, RULE_condition = 6, 
		RULE_return_statement = 7, RULE_break_statement = 8, RULE_assign_statement = 9, 
		RULE_declaration = 10, RULE_constant_declaration = 11, RULE_variable_declaration = 12, 
		RULE_class_declaration = 13, RULE_function_declaration = 14, RULE_field_declaration = 15, 
		RULE_type_annotation = 16, RULE_initializer = 17, RULE_expression = 18, 
		RULE_postfix_expression = 19, RULE_primary_expression = 20, RULE_literal_expression = 21, 
		RULE_function_call_argument_clause = 22, RULE_function_call_argument_list = 23, 
		RULE_type_literal = 24, RULE_identifier = 25, RULE_function_signature = 26, 
		RULE_function_result = 27, RULE_function_parameters = 28, RULE_function_parameter = 29, 
		RULE_statements_list = 30, RULE_code_block = 31, RULE_numeric_literal = 32, 
		RULE_string_literal = 33, RULE_boolean_literal = 34, RULE_nil_literal = 35;
	public static final String[] ruleNames = {
		"translation_unit", "statements", "statement", "if_statement", "loop_statement", 
		"while_statement", "condition", "return_statement", "break_statement", 
		"assign_statement", "declaration", "constant_declaration", "variable_declaration", 
		"class_declaration", "function_declaration", "field_declaration", "type_annotation", 
		"initializer", "expression", "postfix_expression", "primary_expression", 
		"literal_expression", "function_call_argument_clause", "function_call_argument_list", 
		"type_literal", "identifier", "function_signature", "function_result", 
		"function_parameters", "function_parameter", "statements_list", "code_block", 
		"numeric_literal", "string_literal", "boolean_literal", "nil_literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "'.'", "','", "'->'", "'true'", "'false'", "'nil'", "'let'", 
		"'var'", "'fn'", "'if'", "'return'", "'break'", "'while'", "'class'", 
		"'='", "'else:'", "'end'", "'('", "')'", "';'", null, null, "'^'", "'-'", 
		"'!'", "'*'", "'/'", "'%'", "'+'", "'=<'", "'>='", "'<'", "'>'", "'=='", 
		"'==='", "'!='", "'and'", "'or'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "LET", "VAR", "FUNC", 
		"IF", "RETURN", "BREAK", "WHILE", "CLASS", "ASSIGN", "ELSE", "END", "LPARENS", 
		"RPARENS", "SEMICOLON", "LINE_COMMENT", "BLOCK_COMMENT", "POW", "MINUS", 
		"NOT", "MULT", "DIV", "MOD", "PLUS", "LTEQ", "GTEQ", "LT", "GT", "EQ", 
		"IDEQ", "NEQ", "AND", "OR", "WS", "DECIMAL_INTEGER", "FLOAT_LITERAL", 
		"STRING", "NAME"
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
	public static class Translation_unitContext extends ParserRuleContext {
		public Statements_listContext statements_list() {
			return getRuleContext(Statements_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KSrcParser.EOF, 0); }
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterTranslation_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitTranslation_unit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitTranslation_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translation_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			statements_list();
			setState(73);
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

	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(KSrcParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(KSrcParser.SEMICOLON, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			statement();
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(76);
				match(SEMICOLON);
				setState(77);
				statement();
				}
				}
				setState(82);
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

	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Break_statementContext break_statement() {
			return getRuleContext(Break_statementContext.class,0);
		}
		public TerminalNode LINE_COMMENT() { return getToken(KSrcParser.LINE_COMMENT, 0); }
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assign_statementContext assign_statement() {
			return getRuleContext(Assign_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				return_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				break_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(LINE_COMMENT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				if_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
				loop_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(89);
				expression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(90);
				assign_statement();
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

	public static class If_statementContext extends ParserRuleContext {
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	 
		public If_statementContext() { }
		public void copyFrom(If_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementContext extends If_statementContext {
		public Statements_listContext thenBlock;
		public Statements_listContext elseBlock;
		public TerminalNode IF() { return getToken(KSrcParser.IF, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode END() { return getToken(KSrcParser.END, 0); }
		public List<Statements_listContext> statements_list() {
			return getRuleContexts(Statements_listContext.class);
		}
		public Statements_listContext statements_list(int i) {
			return getRuleContext(Statements_listContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(KSrcParser.ELSE, 0); }
		public IfStatementContext(If_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_statement);
		int _la;
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(IF);
			setState(94);
			condition();
			setState(95);
			match(T__0);
			setState(96);
			((IfStatementContext)_localctx).thenBlock = statements_list();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(97);
				match(ELSE);
				setState(98);
				((IfStatementContext)_localctx).elseBlock = statements_list();
				}
			}

			setState(101);
			match(END);
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

	public static class Loop_statementContext extends ParserRuleContext {
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterLoop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitLoop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitLoop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_loop_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			while_statement();
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

	public static class While_statementContext extends ParserRuleContext {
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	 
		public While_statementContext() { }
		public void copyFrom(While_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementWhileContext extends While_statementContext {
		public TerminalNode WHILE() { return getToken(KSrcParser.WHILE, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public StatementWhileContext(While_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStatementWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStatementWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStatementWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_statement);
		try {
			_localctx = new StatementWhileContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(WHILE);
			setState(106);
			condition();
			setState(107);
			code_block();
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

	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			expression(0);
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

	public static class Return_statementContext extends ParserRuleContext {
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	 
		public Return_statementContext() { }
		public void copyFrom(Return_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnStatementContext extends Return_statementContext {
		public TerminalNode RETURN() { return getToken(KSrcParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(Return_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return_statement);
		try {
			_localctx = new ReturnStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(RETURN);
			setState(112);
			expression(0);
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

	public static class Break_statementContext extends ParserRuleContext {
		public Break_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_break_statement; }
	 
		public Break_statementContext() { }
		public void copyFrom(Break_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BreakStatementContext extends Break_statementContext {
		public TerminalNode BREAK() { return getToken(KSrcParser.BREAK, 0); }
		public BreakStatementContext(Break_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Break_statementContext break_statement() throws RecognitionException {
		Break_statementContext _localctx = new Break_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_break_statement);
		try {
			_localctx = new BreakStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(BREAK);
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

	public static class Assign_statementContext extends ParserRuleContext {
		public Assign_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_statement; }
	 
		public Assign_statementContext() { }
		public void copyFrom(Assign_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementAssignContext extends Assign_statementContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(KSrcParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementAssignContext(Assign_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStatementAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStatementAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStatementAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_statementContext assign_statement() throws RecognitionException {
		Assign_statementContext _localctx = new Assign_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign_statement);
		try {
			_localctx = new StatementAssignContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			postfix_expression(0);
			setState(117);
			match(ASSIGN);
			setState(118);
			expression(0);
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

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationClassContext extends DeclarationContext {
		public Class_declarationContext class_declaration() {
			return getRuleContext(Class_declarationContext.class,0);
		}
		public DeclarationClassContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationClass(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationVariableContext extends DeclarationContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public DeclarationVariableContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationConstantContext extends DeclarationContext {
		public Constant_declarationContext constant_declaration() {
			return getRuleContext(Constant_declarationContext.class,0);
		}
		public DeclarationConstantContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationFunctionContext extends DeclarationContext {
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public DeclarationFunctionContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_declaration);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				_localctx = new DeclarationConstantContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				constant_declaration();
				}
				break;
			case VAR:
				_localctx = new DeclarationVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				variable_declaration();
				}
				break;
			case FUNC:
				_localctx = new DeclarationFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				function_declaration();
				}
				break;
			case CLASS:
				_localctx = new DeclarationClassContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				class_declaration();
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

	public static class Constant_declarationContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(KSrcParser.LET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Type_annotationContext type_annotation() {
			return getRuleContext(Type_annotationContext.class,0);
		}
		public Constant_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterConstant_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitConstant_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitConstant_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constant_declarationContext constant_declaration() throws RecognitionException {
		Constant_declarationContext _localctx = new Constant_declarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(LET);
			setState(127);
			identifier();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(128);
				type_annotation();
				}
			}

			setState(131);
			initializer();
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

	public static class Variable_declarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(KSrcParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Type_annotationContext type_annotation() {
			return getRuleContext(Type_annotationContext.class,0);
		}
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitVariable_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(VAR);
			setState(134);
			identifier();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(135);
				type_annotation();
				}
			}

			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(138);
				initializer();
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

	public static class Class_declarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(KSrcParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode END() { return getToken(KSrcParser.END, 0); }
		public List<Field_declarationContext> field_declaration() {
			return getRuleContexts(Field_declarationContext.class);
		}
		public Field_declarationContext field_declaration(int i) {
			return getRuleContext(Field_declarationContext.class,i);
		}
		public List<Function_declarationContext> function_declaration() {
			return getRuleContexts(Function_declarationContext.class);
		}
		public Function_declarationContext function_declaration(int i) {
			return getRuleContext(Function_declarationContext.class,i);
		}
		public Class_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterClass_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitClass_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitClass_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declarationContext class_declaration() throws RecognitionException {
		Class_declarationContext _localctx = new Class_declarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_class_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(CLASS);
			setState(142);
			identifier();
			setState(143);
			match(T__0);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LET) | (1L << VAR) | (1L << FUNC))) != 0)) {
				{
				setState(146);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LET:
				case VAR:
					{
					setState(144);
					field_declaration();
					}
					break;
				case FUNC:
					{
					setState(145);
					function_declaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(END);
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

	public static class Function_declarationContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(KSrcParser.FUNC, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Function_signatureContext function_signature() {
			return getRuleContext(Function_signatureContext.class,0);
		}
		public Code_blockContext code_block() {
			return getRuleContext(Code_blockContext.class,0);
		}
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunction_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunction_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunction_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_function_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(FUNC);
			setState(154);
			identifier();
			setState(155);
			function_signature();
			setState(156);
			code_block();
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

	public static class Field_declarationContext extends ParserRuleContext {
		public Field_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_declaration; }
	 
		public Field_declarationContext() { }
		public void copyFrom(Field_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationFieldConstantContext extends Field_declarationContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public DeclarationFieldConstantContext(Field_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationFieldConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationFieldConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationFieldConstant(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationFieldVariableContext extends Field_declarationContext {
		public Constant_declarationContext constant_declaration() {
			return getRuleContext(Constant_declarationContext.class,0);
		}
		public DeclarationFieldVariableContext(Field_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterDeclarationFieldVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitDeclarationFieldVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitDeclarationFieldVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declarationContext field_declaration() throws RecognitionException {
		Field_declarationContext _localctx = new Field_declarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_field_declaration);
		try {
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LET:
				_localctx = new DeclarationFieldVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				constant_declaration();
				}
				break;
			case VAR:
				_localctx = new DeclarationFieldConstantContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				variable_declaration();
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

	public static class Type_annotationContext extends ParserRuleContext {
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public Type_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterType_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitType_annotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitType_annotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_annotationContext type_annotation() throws RecognitionException {
		Type_annotationContext _localctx = new Type_annotationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162);
			match(T__0);
			setState(163);
			type_literal();
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

	public static class InitializerContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(KSrcParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_initializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(165);
			match(ASSIGN);
			setState(166);
			expression(0);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprIdEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IDEQ() { return getToken(KSrcParser.IDEQ, 0); }
		public ExprIdEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprIdEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprIdEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprIdEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPowContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode POW() { return getToken(KSrcParser.POW, 0); }
		public ExprPowContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprPow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParensContext extends ExpressionContext {
		public TerminalNode LPARENS() { return getToken(KSrcParser.LPARENS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPARENS() { return getToken(KSrcParser.RPARENS, 0); }
		public ExprParensContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultiplicationContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(KSrcParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(KSrcParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(KSrcParser.MOD, 0); }
		public ExprMultiplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprMultiplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprMultiplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprMultiplication(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprUnaryMinusContext extends ExpressionContext {
		public TerminalNode MINUS() { return getToken(KSrcParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprUnaryMinusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprUnaryMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprUnaryMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(KSrcParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprNotContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLogicalOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(KSrcParser.OR, 0); }
		public ExprLogicalOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprLogicalOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprLogicalOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprLogicalOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprRelationalContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LTEQ() { return getToken(KSrcParser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(KSrcParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(KSrcParser.LT, 0); }
		public TerminalNode GT() { return getToken(KSrcParser.GT, 0); }
		public ExprRelationalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEqualityContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(KSrcParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(KSrcParser.NEQ, 0); }
		public ExprEqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPostFixContext extends ExpressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public ExprPostFixContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprPostFix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprPostFix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprPostFix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAdditiveContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(KSrcParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(KSrcParser.MINUS, 0); }
		public ExprAdditiveContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprAdditive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprAdditive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLogicalAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(KSrcParser.AND, 0); }
		public ExprLogicalAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprLogicalAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprLogicalAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprLogicalAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				{
				_localctx = new ExprUnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(169);
				match(MINUS);
				setState(170);
				expression(11);
				}
				break;
			case NOT:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(NOT);
				setState(172);
				expression(10);
				}
				break;
			case LPARENS:
				{
				_localctx = new ExprParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(LPARENS);
				setState(174);
				expression(0);
				setState(175);
				match(RPARENS);
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case DECIMAL_INTEGER:
			case FLOAT_LITERAL:
			case STRING:
			case NAME:
				{
				_localctx = new ExprPostFixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				postfix_expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(204);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprPowContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(181);
						match(POW);
						setState(182);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExprMultiplicationContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(184);
						((ExprMultiplicationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIV) | (1L << MOD))) != 0)) ) {
							((ExprMultiplicationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExprAdditiveContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(187);
						((ExprAdditiveContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MINUS || _la==PLUS) ) {
							((ExprAdditiveContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(188);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExprRelationalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(190);
						((ExprRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LTEQ) | (1L << GTEQ) | (1L << LT) | (1L << GT))) != 0)) ) {
							((ExprRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(191);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExprEqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(192);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(193);
						((ExprEqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((ExprEqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(194);
						expression(6);
						}
						break;
					case 6:
						{
						_localctx = new ExprLogicalAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(195);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(196);
						match(AND);
						setState(197);
						expression(5);
						}
						break;
					case 7:
						{
						_localctx = new ExprLogicalOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(199);
						match(OR);
						setState(200);
						expression(4);
						}
						break;
					case 8:
						{
						_localctx = new ExprIdEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(202);
						match(IDEQ);
						setState(203);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class Postfix_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
	 
		public Postfix_expressionContext() { }
		public void copyFrom(Postfix_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprPrimaryContext extends Postfix_expressionContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public ExprPrimaryContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprPrimary(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCallContext extends Postfix_expressionContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Function_call_argument_clauseContext function_call_argument_clause() {
			return getRuleContext(Function_call_argument_clauseContext.class,0);
		}
		public ExprCallContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
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
	public static class ExprExplicitMemberAccessContext extends Postfix_expressionContext {
		public Postfix_expressionContext lhs;
		public Postfix_expressionContext rhs;
		public List<Postfix_expressionContext> postfix_expression() {
			return getRuleContexts(Postfix_expressionContext.class);
		}
		public Postfix_expressionContext postfix_expression(int i) {
			return getRuleContext(Postfix_expressionContext.class,i);
		}
		public ExprExplicitMemberAccessContext(Postfix_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterExprExplicitMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitExprExplicitMemberAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitExprExplicitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		return postfix_expression(0);
	}

	private Postfix_expressionContext postfix_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, _parentState);
		Postfix_expressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_postfix_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprPrimaryContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(210);
			primary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(219);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(217);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprExplicitMemberAccessContext(new Postfix_expressionContext(_parentctx, _parentState));
						((ExprExplicitMemberAccessContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(212);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(213);
						match(T__1);
						setState(214);
						((ExprExplicitMemberAccessContext)_localctx).rhs = postfix_expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprCallContext(new Postfix_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(215);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(216);
						function_call_argument_clause();
						}
						break;
					}
					} 
				}
				setState(221);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Primary_expressionContext extends ParserRuleContext {
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
	 
		public Primary_expressionContext() { }
		public void copyFrom(Primary_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprValueContext extends Primary_expressionContext {
		public Literal_expressionContext literal_expression() {
			return getRuleContext(Literal_expressionContext.class,0);
		}
		public ExprValueContext(Primary_expressionContext ctx) { copyFrom(ctx); }
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
	public static class ExprIdentContext extends Primary_expressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExprIdentContext(Primary_expressionContext ctx) { copyFrom(ctx); }
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

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primary_expression);
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case T__6:
			case DECIMAL_INTEGER:
			case FLOAT_LITERAL:
			case STRING:
				_localctx = new ExprValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				literal_expression();
				}
				break;
			case NAME:
				_localctx = new ExprIdentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				identifier();
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

	public static class Literal_expressionContext extends ParserRuleContext {
		public Numeric_literalContext numeric_literal() {
			return getRuleContext(Numeric_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Boolean_literalContext boolean_literal() {
			return getRuleContext(Boolean_literalContext.class,0);
		}
		public Nil_literalContext nil_literal() {
			return getRuleContext(Nil_literalContext.class,0);
		}
		public Literal_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterLiteral_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitLiteral_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitLiteral_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_expressionContext literal_expression() throws RecognitionException {
		Literal_expressionContext _localctx = new Literal_expressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal_expression);
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				numeric_literal();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				string_literal();
				}
				break;
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				boolean_literal();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				nil_literal();
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

	public static class Function_call_argument_clauseContext extends ParserRuleContext {
		public Function_call_argument_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_argument_clause; }
	 
		public Function_call_argument_clauseContext() { }
		public void copyFrom(Function_call_argument_clauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionCallArgumentClauseContext extends Function_call_argument_clauseContext {
		public Function_call_argument_listContext function_call_argument_list() {
			return getRuleContext(Function_call_argument_listContext.class,0);
		}
		public FunctionCallArgumentClauseContext(Function_call_argument_clauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunctionCallArgumentClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunctionCallArgumentClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunctionCallArgumentClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_call_argument_clauseContext function_call_argument_clause() throws RecognitionException {
		Function_call_argument_clauseContext _localctx = new Function_call_argument_clauseContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_function_call_argument_clause);
		try {
			_localctx = new FunctionCallArgumentClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(LPARENS);
			setState(233);
			function_call_argument_list();
			setState(234);
			match(RPARENS);
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

	public static class Function_call_argument_listContext extends ParserRuleContext {
		public Function_call_argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_argument_list; }
	 
		public Function_call_argument_listContext() { }
		public void copyFrom(Function_call_argument_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionCallArgumentListContext extends Function_call_argument_listContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallArgumentListContext(Function_call_argument_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunctionCallArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunctionCallArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunctionCallArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_call_argument_listContext function_call_argument_list() throws RecognitionException {
		Function_call_argument_listContext _localctx = new Function_call_argument_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_function_call_argument_list);
		int _la;
		try {
			_localctx = new FunctionCallArgumentListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << LPARENS) | (1L << MINUS) | (1L << NOT) | (1L << DECIMAL_INTEGER) | (1L << FLOAT_LITERAL) | (1L << STRING) | (1L << NAME))) != 0)) {
				{
				setState(236);
				expression(0);
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(237);
					match(T__2);
					setState(238);
					expression(0);
					}
					}
					setState(243);
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

	public static class Type_literalContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(KSrcParser.NAME, 0); }
		public Type_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterType_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitType_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitType_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_literalContext type_literal() throws RecognitionException {
		Type_literalContext _localctx = new Type_literalContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(KSrcParser.NAME, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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

	public static class Function_signatureContext extends ParserRuleContext {
		public Function_signatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_signature; }
	 
		public Function_signatureContext() { }
		public void copyFrom(Function_signatureContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionSignatureContext extends Function_signatureContext {
		public TerminalNode LPARENS() { return getToken(KSrcParser.LPARENS, 0); }
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public TerminalNode RPARENS() { return getToken(KSrcParser.RPARENS, 0); }
		public Function_resultContext function_result() {
			return getRuleContext(Function_resultContext.class,0);
		}
		public FunctionSignatureContext(Function_signatureContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunctionSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunctionSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunctionSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_signatureContext function_signature() throws RecognitionException {
		Function_signatureContext _localctx = new Function_signatureContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_function_signature);
		int _la;
		try {
			_localctx = new FunctionSignatureContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPARENS) {
				{
				setState(250);
				match(LPARENS);
				setState(251);
				function_parameters();
				setState(252);
				match(RPARENS);
				}
			}

			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(256);
				match(T__3);
				setState(257);
				function_result();
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

	public static class Function_resultContext extends ParserRuleContext {
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public Function_resultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunction_result(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunction_result(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunction_result(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_resultContext function_result() throws RecognitionException {
		Function_resultContext _localctx = new Function_resultContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_function_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			type_literal();
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

	public static class Function_parametersContext extends ParserRuleContext {
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
	 
		public Function_parametersContext() { }
		public void copyFrom(Function_parametersContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionParametersContext extends Function_parametersContext {
		public List<Function_parameterContext> function_parameter() {
			return getRuleContexts(Function_parameterContext.class);
		}
		public Function_parameterContext function_parameter(int i) {
			return getRuleContext(Function_parameterContext.class,i);
		}
		public FunctionParametersContext(Function_parametersContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunctionParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunctionParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunctionParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_function_parameters);
		int _la;
		try {
			_localctx = new FunctionParametersContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(262);
				function_parameter();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(263);
					match(T__2);
					setState(264);
					function_parameter();
					}
					}
					setState(269);
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

	public static class Function_parameterContext extends ParserRuleContext {
		public Function_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameter; }
	 
		public Function_parameterContext() { }
		public void copyFrom(Function_parameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionParameterContext extends Function_parameterContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Type_literalContext type_literal() {
			return getRuleContext(Type_literalContext.class,0);
		}
		public FunctionParameterContext(Function_parameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterFunctionParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitFunctionParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitFunctionParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parameterContext function_parameter() throws RecognitionException {
		Function_parameterContext _localctx = new Function_parameterContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_function_parameter);
		try {
			_localctx = new FunctionParameterContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			identifier();
			setState(273);
			match(T__0);
			setState(274);
			type_literal();
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

	public static class Statements_listContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public Statements_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterStatements_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitStatements_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitStatements_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statements_listContext statements_list() throws RecognitionException {
		Statements_listContext _localctx = new Statements_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statements_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << LET) | (1L << VAR) | (1L << FUNC) | (1L << IF) | (1L << RETURN) | (1L << BREAK) | (1L << WHILE) | (1L << CLASS) | (1L << LPARENS) | (1L << LINE_COMMENT) | (1L << MINUS) | (1L << NOT) | (1L << DECIMAL_INTEGER) | (1L << FLOAT_LITERAL) | (1L << STRING) | (1L << NAME))) != 0)) {
				{
				{
				setState(276);
				statements();
				}
				}
				setState(281);
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

	public static class Code_blockContext extends ParserRuleContext {
		public Code_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_block; }
	 
		public Code_blockContext() { }
		public void copyFrom(Code_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CodeBlockContext extends Code_blockContext {
		public Statements_listContext statements_list() {
			return getRuleContext(Statements_listContext.class,0);
		}
		public CodeBlockContext(Code_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_blockContext code_block() throws RecognitionException {
		Code_blockContext _localctx = new Code_blockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_code_block);
		try {
			_localctx = new CodeBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__0);
			setState(283);
			statements_list();
			setState(284);
			match(END);
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

	public static class Numeric_literalContext extends ParserRuleContext {
		public Numeric_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric_literal; }
	 
		public Numeric_literalContext() { }
		public void copyFrom(Numeric_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralIntegerContext extends Numeric_literalContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(KSrcParser.DECIMAL_INTEGER, 0); }
		public LiteralIntegerContext(Numeric_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterLiteralInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitLiteralInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitLiteralInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralFloatContext extends Numeric_literalContext {
		public TerminalNode FLOAT_LITERAL() { return getToken(KSrcParser.FLOAT_LITERAL, 0); }
		public LiteralFloatContext(Numeric_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterLiteralFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitLiteralFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitLiteralFloat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numeric_literalContext numeric_literal() throws RecognitionException {
		Numeric_literalContext _localctx = new Numeric_literalContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_numeric_literal);
		try {
			setState(288);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_INTEGER:
				_localctx = new LiteralIntegerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(DECIMAL_INTEGER);
				}
				break;
			case FLOAT_LITERAL:
				_localctx = new LiteralFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(FLOAT_LITERAL);
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

	public static class String_literalContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(KSrcParser.STRING, 0); }
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitString_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitString_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_string_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(STRING);
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

	public static class Boolean_literalContext extends ParserRuleContext {
		public Boolean_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterBoolean_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitBoolean_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitBoolean_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_literalContext boolean_literal() throws RecognitionException {
		Boolean_literalContext _localctx = new Boolean_literalContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_boolean_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_la = _input.LA(1);
			if ( !(_la==T__4 || _la==T__5) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Nil_literalContext extends ParserRuleContext {
		public Nil_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nil_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).enterNil_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KSrcListener ) ((KSrcListener)listener).exitNil_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof KSrcVisitor ) return ((KSrcVisitor<? extends T>)visitor).visitNil_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nil_literalContext nil_literal() throws RecognitionException {
		Nil_literalContext _localctx = new Nil_literalContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_nil_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__6);
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
		case 18:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 19:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\3\3\3\3\3\7\3Q\n\3\f\3\16"+
		"\3T\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4^\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\5\5f\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\177\n\f\3\r\3\r\3\r\5\r\u0084"+
		"\n\r\3\r\3\r\3\16\3\16\3\16\5\16\u008b\n\16\3\16\5\16\u008e\n\16\3\17"+
		"\3\17\3\17\3\17\3\17\7\17\u0095\n\17\f\17\16\17\u0098\13\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\5\21\u00a3\n\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00b5"+
		"\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00cf\n\24"+
		"\f\24\16\24\u00d2\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00dc"+
		"\n\25\f\25\16\25\u00df\13\25\3\26\3\26\5\26\u00e3\n\26\3\27\3\27\3\27"+
		"\3\27\5\27\u00e9\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\7\31\u00f2\n"+
		"\31\f\31\16\31\u00f5\13\31\5\31\u00f7\n\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\5\34\u0101\n\34\3\34\3\34\5\34\u0105\n\34\3\35\3\35\3\36"+
		"\3\36\3\36\7\36\u010c\n\36\f\36\16\36\u010f\13\36\5\36\u0111\n\36\3\37"+
		"\3\37\3\37\3\37\3 \7 \u0118\n \f \16 \u011b\13 \3!\3!\3!\3!\3\"\3\"\5"+
		"\"\u0123\n\"\3#\3#\3$\3$\3%\3%\3%\2\4&(&\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\7\3\2\35\37\4\2\33\33  \3\2"+
		"!$\4\2%%\'\'\3\2\7\b\2\u0131\2J\3\2\2\2\4M\3\2\2\2\6]\3\2\2\2\b_\3\2\2"+
		"\2\ni\3\2\2\2\fk\3\2\2\2\16o\3\2\2\2\20q\3\2\2\2\22t\3\2\2\2\24v\3\2\2"+
		"\2\26~\3\2\2\2\30\u0080\3\2\2\2\32\u0087\3\2\2\2\34\u008f\3\2\2\2\36\u009b"+
		"\3\2\2\2 \u00a2\3\2\2\2\"\u00a4\3\2\2\2$\u00a7\3\2\2\2&\u00b4\3\2\2\2"+
		"(\u00d3\3\2\2\2*\u00e2\3\2\2\2,\u00e8\3\2\2\2.\u00ea\3\2\2\2\60\u00f6"+
		"\3\2\2\2\62\u00f8\3\2\2\2\64\u00fa\3\2\2\2\66\u0100\3\2\2\28\u0106\3\2"+
		"\2\2:\u0110\3\2\2\2<\u0112\3\2\2\2>\u0119\3\2\2\2@\u011c\3\2\2\2B\u0122"+
		"\3\2\2\2D\u0124\3\2\2\2F\u0126\3\2\2\2H\u0128\3\2\2\2JK\5> \2KL\7\2\2"+
		"\3L\3\3\2\2\2MR\5\6\4\2NO\7\27\2\2OQ\5\6\4\2PN\3\2\2\2QT\3\2\2\2RP\3\2"+
		"\2\2RS\3\2\2\2S\5\3\2\2\2TR\3\2\2\2U^\5\26\f\2V^\5\20\t\2W^\5\22\n\2X"+
		"^\7\30\2\2Y^\5\b\5\2Z^\5\n\6\2[^\5&\24\2\\^\5\24\13\2]U\3\2\2\2]V\3\2"+
		"\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^\7\3"+
		"\2\2\2_`\7\r\2\2`a\5\16\b\2ab\7\3\2\2be\5> \2cd\7\23\2\2df\5> \2ec\3\2"+
		"\2\2ef\3\2\2\2fg\3\2\2\2gh\7\24\2\2h\t\3\2\2\2ij\5\f\7\2j\13\3\2\2\2k"+
		"l\7\20\2\2lm\5\16\b\2mn\5@!\2n\r\3\2\2\2op\5&\24\2p\17\3\2\2\2qr\7\16"+
		"\2\2rs\5&\24\2s\21\3\2\2\2tu\7\17\2\2u\23\3\2\2\2vw\5(\25\2wx\7\22\2\2"+
		"xy\5&\24\2y\25\3\2\2\2z\177\5\30\r\2{\177\5\32\16\2|\177\5\36\20\2}\177"+
		"\5\34\17\2~z\3\2\2\2~{\3\2\2\2~|\3\2\2\2~}\3\2\2\2\177\27\3\2\2\2\u0080"+
		"\u0081\7\n\2\2\u0081\u0083\5\64\33\2\u0082\u0084\5\"\22\2\u0083\u0082"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\5$\23\2\u0086"+
		"\31\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u008a\5\64\33\2\u0089\u008b\5\""+
		"\22\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c"+
		"\u008e\5$\23\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\33\3\2\2"+
		"\2\u008f\u0090\7\21\2\2\u0090\u0091\5\64\33\2\u0091\u0096\7\3\2\2\u0092"+
		"\u0095\5 \21\2\u0093\u0095\5\36\20\2\u0094\u0092\3\2\2\2\u0094\u0093\3"+
		"\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7\24\2\2\u009a\35\3\2\2"+
		"\2\u009b\u009c\7\f\2\2\u009c\u009d\5\64\33\2\u009d\u009e\5\66\34\2\u009e"+
		"\u009f\5@!\2\u009f\37\3\2\2\2\u00a0\u00a3\5\30\r\2\u00a1\u00a3\5\32\16"+
		"\2\u00a2\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3!\3\2\2\2\u00a4\u00a5"+
		"\7\3\2\2\u00a5\u00a6\5\62\32\2\u00a6#\3\2\2\2\u00a7\u00a8\7\22\2\2\u00a8"+
		"\u00a9\5&\24\2\u00a9%\3\2\2\2\u00aa\u00ab\b\24\1\2\u00ab\u00ac\7\33\2"+
		"\2\u00ac\u00b5\5&\24\r\u00ad\u00ae\7\34\2\2\u00ae\u00b5\5&\24\f\u00af"+
		"\u00b0\7\25\2\2\u00b0\u00b1\5&\24\2\u00b1\u00b2\7\26\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b5\5(\25\2\u00b4\u00aa\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4"+
		"\u00af\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\u00d0\3\2\2\2\u00b6\u00b7\f\16"+
		"\2\2\u00b7\u00b8\7\32\2\2\u00b8\u00cf\5&\24\17\u00b9\u00ba\f\n\2\2\u00ba"+
		"\u00bb\t\2\2\2\u00bb\u00cf\5&\24\13\u00bc\u00bd\f\t\2\2\u00bd\u00be\t"+
		"\3\2\2\u00be\u00cf\5&\24\n\u00bf\u00c0\f\b\2\2\u00c0\u00c1\t\4\2\2\u00c1"+
		"\u00cf\5&\24\t\u00c2\u00c3\f\7\2\2\u00c3\u00c4\t\5\2\2\u00c4\u00cf\5&"+
		"\24\b\u00c5\u00c6\f\6\2\2\u00c6\u00c7\7(\2\2\u00c7\u00cf\5&\24\7\u00c8"+
		"\u00c9\f\5\2\2\u00c9\u00ca\7)\2\2\u00ca\u00cf\5&\24\6\u00cb\u00cc\f\4"+
		"\2\2\u00cc\u00cd\7&\2\2\u00cd\u00cf\5&\24\5\u00ce\u00b6\3\2\2\2\u00ce"+
		"\u00b9\3\2\2\2\u00ce\u00bc\3\2\2\2\u00ce\u00bf\3\2\2\2\u00ce\u00c2\3\2"+
		"\2\2\u00ce\u00c5\3\2\2\2\u00ce\u00c8\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cf"+
		"\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\'\3\2\2\2"+
		"\u00d2\u00d0\3\2\2\2\u00d3\u00d4\b\25\1\2\u00d4\u00d5\5*\26\2\u00d5\u00dd"+
		"\3\2\2\2\u00d6\u00d7\f\4\2\2\u00d7\u00d8\7\4\2\2\u00d8\u00dc\5(\25\5\u00d9"+
		"\u00da\f\3\2\2\u00da\u00dc\5.\30\2\u00db\u00d6\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		")\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\5,\27\2\u00e1\u00e3\5\64\33"+
		"\2\u00e2\u00e0\3\2\2\2\u00e2\u00e1\3\2\2\2\u00e3+\3\2\2\2\u00e4\u00e9"+
		"\5B\"\2\u00e5\u00e9\5D#\2\u00e6\u00e9\5F$\2\u00e7\u00e9\5H%\2\u00e8\u00e4"+
		"\3\2\2\2\u00e8\u00e5\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7\3\2\2\2\u00e9"+
		"-\3\2\2\2\u00ea\u00eb\7\25\2\2\u00eb\u00ec\5\60\31\2\u00ec\u00ed\7\26"+
		"\2\2\u00ed/\3\2\2\2\u00ee\u00f3\5&\24\2\u00ef\u00f0\7\5\2\2\u00f0\u00f2"+
		"\5&\24\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u00ee\3\2"+
		"\2\2\u00f6\u00f7\3\2\2\2\u00f7\61\3\2\2\2\u00f8\u00f9\7.\2\2\u00f9\63"+
		"\3\2\2\2\u00fa\u00fb\7.\2\2\u00fb\65\3\2\2\2\u00fc\u00fd\7\25\2\2\u00fd"+
		"\u00fe\5:\36\2\u00fe\u00ff\7\26\2\2\u00ff\u0101\3\2\2\2\u0100\u00fc\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0103\7\6\2\2\u0103"+
		"\u0105\58\35\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\67\3\2\2"+
		"\2\u0106\u0107\5\62\32\2\u01079\3\2\2\2\u0108\u010d\5<\37\2\u0109\u010a"+
		"\7\5\2\2\u010a\u010c\5<\37\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2"+
		"\2\2\u0110\u0108\3\2\2\2\u0110\u0111\3\2\2\2\u0111;\3\2\2\2\u0112\u0113"+
		"\5\64\33\2\u0113\u0114\7\3\2\2\u0114\u0115\5\62\32\2\u0115=\3\2\2\2\u0116"+
		"\u0118\5\4\3\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2"+
		"\2\2\u0119\u011a\3\2\2\2\u011a?\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d"+
		"\7\3\2\2\u011d\u011e\5> \2\u011e\u011f\7\24\2\2\u011fA\3\2\2\2\u0120\u0123"+
		"\7+\2\2\u0121\u0123\7,\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123"+
		"C\3\2\2\2\u0124\u0125\7-\2\2\u0125E\3\2\2\2\u0126\u0127\t\6\2\2\u0127"+
		"G\3\2\2\2\u0128\u0129\7\t\2\2\u0129I\3\2\2\2\33R]e~\u0083\u008a\u008d"+
		"\u0094\u0096\u00a2\u00b4\u00ce\u00d0\u00db\u00dd\u00e2\u00e8\u00f3\u00f6"+
		"\u0100\u0104\u010d\u0110\u0119\u0122";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}