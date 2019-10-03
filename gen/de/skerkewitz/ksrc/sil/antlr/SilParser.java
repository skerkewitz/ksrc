// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/java/de/skerkewitz/ksrc/sil/antlr\Sil.g4 by ANTLR 4.7.2
package de.skerkewitz.ksrc.sil.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SilParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		LINE_COMMENT=18, SIL_VALUE_NAME=19, WS=20, TYPE_SIGIL=21, POINTER_SIGIL=22, 
		LOCAL_SIGIL=23, FUNCTION_SIGIL=24, STRING=25, NAME=26, DECIMAL_INTEGER=27;
	public static final int
		RULE_translation_unit = 0, RULE_sil_type = 1, RULE_sil_types = 2, RULE_sil_function_type = 3, 
		RULE_sil_function_type_arguments = 4, RULE_sil_basic_type = 5, RULE_sil_identifier = 6, 
		RULE_sil_value = 7, RULE_sil_operand = 8, RULE_sil_function = 9, RULE_sil_function_name = 10, 
		RULE_sil_basic_block = 11, RULE_sil_label_target = 12, RULE_sil_label = 13, 
		RULE_sil_instruction_result = 14, RULE_sil_instruction_def = 15, RULE_sil_terminator = 16, 
		RULE_sil_terminator_return = 17, RULE_sil_terminator_br = 18, RULE_sil_terminator_cond_br = 19, 
		RULE_sil_instruction = 20, RULE_sil_instruction_integer_literal = 21, 
		RULE_sil_instruction_buildin = 22, RULE_sil_instruction_function_ref = 23, 
		RULE_sil_instruction_apply = 24, RULE_integer = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"translation_unit", "sil_type", "sil_types", "sil_function_type", "sil_function_type_arguments", 
			"sil_basic_type", "sil_identifier", "sil_value", "sil_operand", "sil_function", 
			"sil_function_name", "sil_basic_block", "sil_label_target", "sil_label", 
			"sil_instruction_result", "sil_instruction_def", "sil_terminator", "sil_terminator_return", 
			"sil_terminator_br", "sil_terminator_cond_br", "sil_instruction", "sil_instruction_integer_literal", 
			"sil_instruction_buildin", "sil_instruction_function_ref", "sil_instruction_apply", 
			"integer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'->'", "','", "':'", "'sil'", "'{'", "'}'", "'='", 
			"'return'", "'br'", "'cond_br'", "'alloc_stack'", "'integer_literal'", 
			"'builtin'", "'function_ref'", "'apply'", null, null, null, "'$'", "'*'", 
			"'%'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "LINE_COMMENT", "SIL_VALUE_NAME", 
			"WS", "TYPE_SIGIL", "POINTER_SIGIL", "LOCAL_SIGIL", "FUNCTION_SIGIL", 
			"STRING", "NAME", "DECIMAL_INTEGER"
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
	public String getGrammarFileName() { return "Sil.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SilParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Translation_unitContext extends ParserRuleContext {
		public Sil_functionContext sil_function() {
			return getRuleContext(Sil_functionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SilParser.EOF, 0); }
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterTranslation_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitTranslation_unit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitTranslation_unit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translation_unit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			sil_function();
			setState(53);
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

	public static class Sil_typeContext extends ParserRuleContext {
		public TerminalNode TYPE_SIGIL() { return getToken(SilParser.TYPE_SIGIL, 0); }
		public Sil_typesContext sil_types() {
			return getRuleContext(Sil_typesContext.class,0);
		}
		public Sil_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_typeContext sil_type() throws RecognitionException {
		Sil_typeContext _localctx = new Sil_typeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sil_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(TYPE_SIGIL);
			setState(56);
			sil_types();
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

	public static class Sil_typesContext extends ParserRuleContext {
		public Sil_basic_typeContext sil_basic_type() {
			return getRuleContext(Sil_basic_typeContext.class,0);
		}
		public Sil_function_typeContext sil_function_type() {
			return getRuleContext(Sil_function_typeContext.class,0);
		}
		public Sil_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_types(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_types(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_types(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_typesContext sil_types() throws RecognitionException {
		Sil_typesContext _localctx = new Sil_typesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sil_types);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POINTER_SIGIL:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				sil_basic_type();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				sil_function_type();
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

	public static class Sil_function_typeContext extends ParserRuleContext {
		public Sil_typesContext returnType;
		public Sil_function_type_argumentsContext sil_function_type_arguments() {
			return getRuleContext(Sil_function_type_argumentsContext.class,0);
		}
		public Sil_typesContext sil_types() {
			return getRuleContext(Sil_typesContext.class,0);
		}
		public Sil_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_function_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_function_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_function_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_function_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_function_typeContext sil_function_type() throws RecognitionException {
		Sil_function_typeContext _localctx = new Sil_function_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sil_function_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__0);
			setState(63);
			sil_function_type_arguments();
			setState(64);
			match(T__1);
			setState(65);
			match(T__2);
			setState(66);
			((Sil_function_typeContext)_localctx).returnType = sil_types();
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

	public static class Sil_function_type_argumentsContext extends ParserRuleContext {
		public List<Sil_typesContext> sil_types() {
			return getRuleContexts(Sil_typesContext.class);
		}
		public Sil_typesContext sil_types(int i) {
			return getRuleContext(Sil_typesContext.class,i);
		}
		public Sil_function_type_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_function_type_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_function_type_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_function_type_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_function_type_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_function_type_argumentsContext sil_function_type_arguments() throws RecognitionException {
		Sil_function_type_argumentsContext _localctx = new Sil_function_type_argumentsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sil_function_type_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			sil_types();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(69);
				match(T__3);
				setState(70);
				sil_types();
				}
				}
				setState(75);
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

	public static class Sil_basic_typeContext extends ParserRuleContext {
		public Sil_basic_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_basic_type; }
	 
		public Sil_basic_typeContext() { }
		public void copyFrom(Sil_basic_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PointerContext extends Sil_basic_typeContext {
		public TerminalNode POINTER_SIGIL() { return getToken(SilParser.POINTER_SIGIL, 0); }
		public Sil_identifierContext sil_identifier() {
			return getRuleContext(Sil_identifierContext.class,0);
		}
		public PointerContext(Sil_basic_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimpleContext extends Sil_basic_typeContext {
		public Sil_identifierContext sil_identifier() {
			return getRuleContext(Sil_identifierContext.class,0);
		}
		public SimpleContext(Sil_basic_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_basic_typeContext sil_basic_type() throws RecognitionException {
		Sil_basic_typeContext _localctx = new Sil_basic_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sil_basic_type);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				sil_identifier();
				}
				break;
			case POINTER_SIGIL:
				_localctx = new PointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(POINTER_SIGIL);
				setState(78);
				sil_identifier();
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

	public static class Sil_identifierContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SilParser.NAME, 0); }
		public Sil_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_identifierContext sil_identifier() throws RecognitionException {
		Sil_identifierContext _localctx = new Sil_identifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sil_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
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

	public static class Sil_valueContext extends ParserRuleContext {
		public TerminalNode SIL_VALUE_NAME() { return getToken(SilParser.SIL_VALUE_NAME, 0); }
		public Sil_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_valueContext sil_value() throws RecognitionException {
		Sil_valueContext _localctx = new Sil_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sil_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(SIL_VALUE_NAME);
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

	public static class Sil_operandContext extends ParserRuleContext {
		public Sil_valueContext sil_value() {
			return getRuleContext(Sil_valueContext.class,0);
		}
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public Sil_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_operand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_operand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_operandContext sil_operand() throws RecognitionException {
		Sil_operandContext _localctx = new Sil_operandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sil_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			sil_value();
			setState(86);
			match(T__4);
			setState(87);
			sil_type();
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

	public static class Sil_functionContext extends ParserRuleContext {
		public Sil_function_nameContext sil_function_name() {
			return getRuleContext(Sil_function_nameContext.class,0);
		}
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public List<Sil_basic_blockContext> sil_basic_block() {
			return getRuleContexts(Sil_basic_blockContext.class);
		}
		public Sil_basic_blockContext sil_basic_block(int i) {
			return getRuleContext(Sil_basic_blockContext.class,i);
		}
		public Sil_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_functionContext sil_function() throws RecognitionException {
		Sil_functionContext _localctx = new Sil_functionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sil_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__5);
			setState(90);
			sil_function_name();
			setState(91);
			match(T__4);
			setState(92);
			sil_type();
			setState(93);
			match(T__6);
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				sil_basic_block();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			setState(99);
			match(T__7);
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

	public static class Sil_function_nameContext extends ParserRuleContext {
		public TerminalNode FUNCTION_SIGIL() { return getToken(SilParser.FUNCTION_SIGIL, 0); }
		public TerminalNode NAME() { return getToken(SilParser.NAME, 0); }
		public Sil_function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_function_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_function_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_function_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_function_nameContext sil_function_name() throws RecognitionException {
		Sil_function_nameContext _localctx = new Sil_function_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sil_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(FUNCTION_SIGIL);
			setState(102);
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

	public static class Sil_basic_blockContext extends ParserRuleContext {
		public Sil_labelContext sil_label() {
			return getRuleContext(Sil_labelContext.class,0);
		}
		public Sil_terminatorContext sil_terminator() {
			return getRuleContext(Sil_terminatorContext.class,0);
		}
		public List<Sil_instruction_defContext> sil_instruction_def() {
			return getRuleContexts(Sil_instruction_defContext.class);
		}
		public Sil_instruction_defContext sil_instruction_def(int i) {
			return getRuleContext(Sil_instruction_defContext.class,i);
		}
		public Sil_basic_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_basic_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_basic_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_basic_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_basic_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_basic_blockContext sil_basic_block() throws RecognitionException {
		Sil_basic_blockContext _localctx = new Sil_basic_blockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sil_basic_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			sil_label();
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << SIL_VALUE_NAME))) != 0)) {
				{
				{
				setState(105);
				sil_instruction_def();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			sil_terminator();
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

	public static class Sil_label_targetContext extends ParserRuleContext {
		public Sil_identifierContext sil_identifier() {
			return getRuleContext(Sil_identifierContext.class,0);
		}
		public List<Sil_operandContext> sil_operand() {
			return getRuleContexts(Sil_operandContext.class);
		}
		public Sil_operandContext sil_operand(int i) {
			return getRuleContext(Sil_operandContext.class,i);
		}
		public Sil_label_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_label_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_label_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_label_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_label_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_label_targetContext sil_label_target() throws RecognitionException {
		Sil_label_targetContext _localctx = new Sil_label_targetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sil_label_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			sil_identifier();
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(114);
				match(T__0);
				setState(115);
				sil_operand();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(116);
					match(T__3);
					setState(117);
					sil_operand();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(T__1);
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

	public static class Sil_labelContext extends ParserRuleContext {
		public Sil_identifierContext sil_identifier() {
			return getRuleContext(Sil_identifierContext.class,0);
		}
		public List<Sil_operandContext> sil_operand() {
			return getRuleContexts(Sil_operandContext.class);
		}
		public Sil_operandContext sil_operand(int i) {
			return getRuleContext(Sil_operandContext.class,i);
		}
		public Sil_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_label(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_label(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_labelContext sil_label() throws RecognitionException {
		Sil_labelContext _localctx = new Sil_labelContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sil_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			sil_identifier();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(128);
				match(T__0);
				setState(129);
				sil_operand();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(130);
					match(T__3);
					setState(131);
					sil_operand();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(137);
				match(T__1);
				}
			}

			setState(141);
			match(T__4);
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

	public static class Sil_instruction_resultContext extends ParserRuleContext {
		public TerminalNode SIL_VALUE_NAME() { return getToken(SilParser.SIL_VALUE_NAME, 0); }
		public Sil_instruction_resultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_result(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_result(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_result(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_resultContext sil_instruction_result() throws RecognitionException {
		Sil_instruction_resultContext _localctx = new Sil_instruction_resultContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sil_instruction_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(SIL_VALUE_NAME);
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

	public static class Sil_instruction_defContext extends ParserRuleContext {
		public Sil_instructionContext sil_instruction() {
			return getRuleContext(Sil_instructionContext.class,0);
		}
		public Sil_instruction_resultContext sil_instruction_result() {
			return getRuleContext(Sil_instruction_resultContext.class,0);
		}
		public Sil_instruction_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_defContext sil_instruction_def() throws RecognitionException {
		Sil_instruction_defContext _localctx = new Sil_instruction_defContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sil_instruction_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIL_VALUE_NAME) {
				{
				setState(145);
				sil_instruction_result();
				setState(146);
				match(T__8);
				}
			}

			setState(150);
			sil_instruction();
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

	public static class Sil_terminatorContext extends ParserRuleContext {
		public Sil_terminator_brContext sil_terminator_br() {
			return getRuleContext(Sil_terminator_brContext.class,0);
		}
		public Sil_terminator_cond_brContext sil_terminator_cond_br() {
			return getRuleContext(Sil_terminator_cond_brContext.class,0);
		}
		public Sil_terminator_returnContext sil_terminator_return() {
			return getRuleContext(Sil_terminator_returnContext.class,0);
		}
		public Sil_terminatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_terminator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_terminator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_terminator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_terminator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_terminatorContext sil_terminator() throws RecognitionException {
		Sil_terminatorContext _localctx = new Sil_terminatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sil_terminator);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				sil_terminator_br();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				sil_terminator_cond_br();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				sil_terminator_return();
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

	public static class Sil_terminator_returnContext extends ParserRuleContext {
		public Sil_operandContext sil_operand() {
			return getRuleContext(Sil_operandContext.class,0);
		}
		public Sil_terminator_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_terminator_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_terminator_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_terminator_return(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_terminator_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_terminator_returnContext sil_terminator_return() throws RecognitionException {
		Sil_terminator_returnContext _localctx = new Sil_terminator_returnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sil_terminator_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__9);
			setState(158);
			sil_operand();
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

	public static class Sil_terminator_brContext extends ParserRuleContext {
		public Sil_label_targetContext sil_label_target() {
			return getRuleContext(Sil_label_targetContext.class,0);
		}
		public Sil_terminator_brContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_terminator_br; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_terminator_br(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_terminator_br(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_terminator_br(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_terminator_brContext sil_terminator_br() throws RecognitionException {
		Sil_terminator_brContext _localctx = new Sil_terminator_brContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sil_terminator_br);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__10);
			setState(161);
			sil_label_target();
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

	public static class Sil_terminator_cond_brContext extends ParserRuleContext {
		public Sil_operandContext condition;
		public Sil_label_targetContext thenLabel;
		public Sil_label_targetContext elseLabel;
		public Sil_operandContext sil_operand() {
			return getRuleContext(Sil_operandContext.class,0);
		}
		public List<Sil_label_targetContext> sil_label_target() {
			return getRuleContexts(Sil_label_targetContext.class);
		}
		public Sil_label_targetContext sil_label_target(int i) {
			return getRuleContext(Sil_label_targetContext.class,i);
		}
		public Sil_terminator_cond_brContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_terminator_cond_br; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_terminator_cond_br(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_terminator_cond_br(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_terminator_cond_br(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_terminator_cond_brContext sil_terminator_cond_br() throws RecognitionException {
		Sil_terminator_cond_brContext _localctx = new Sil_terminator_cond_brContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sil_terminator_cond_br);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__11);
			setState(164);
			((Sil_terminator_cond_brContext)_localctx).condition = sil_operand();
			setState(165);
			match(T__3);
			setState(166);
			((Sil_terminator_cond_brContext)_localctx).thenLabel = sil_label_target();
			setState(167);
			match(T__3);
			setState(168);
			((Sil_terminator_cond_brContext)_localctx).elseLabel = sil_label_target();
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

	public static class Sil_instructionContext extends ParserRuleContext {
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public Sil_instruction_integer_literalContext sil_instruction_integer_literal() {
			return getRuleContext(Sil_instruction_integer_literalContext.class,0);
		}
		public Sil_instruction_buildinContext sil_instruction_buildin() {
			return getRuleContext(Sil_instruction_buildinContext.class,0);
		}
		public Sil_instruction_function_refContext sil_instruction_function_ref() {
			return getRuleContext(Sil_instruction_function_refContext.class,0);
		}
		public Sil_instruction_applyContext sil_instruction_apply() {
			return getRuleContext(Sil_instruction_applyContext.class,0);
		}
		public Sil_instructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instructionContext sil_instruction() throws RecognitionException {
		Sil_instructionContext _localctx = new Sil_instructionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sil_instruction);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(T__12);
				setState(171);
				sil_type();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				sil_instruction_integer_literal();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				sil_instruction_buildin();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				sil_instruction_function_ref();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				sil_instruction_apply();
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

	public static class Sil_instruction_integer_literalContext extends ParserRuleContext {
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public Sil_instruction_integer_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_integer_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_integer_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_integer_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_integer_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_integer_literalContext sil_instruction_integer_literal() throws RecognitionException {
		Sil_instruction_integer_literalContext _localctx = new Sil_instruction_integer_literalContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_sil_instruction_integer_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__13);
			setState(179);
			sil_type();
			setState(180);
			match(T__3);
			setState(181);
			integer();
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

	public static class Sil_instruction_buildinContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SilParser.STRING, 0); }
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public List<Sil_operandContext> sil_operand() {
			return getRuleContexts(Sil_operandContext.class);
		}
		public Sil_operandContext sil_operand(int i) {
			return getRuleContext(Sil_operandContext.class,i);
		}
		public Sil_instruction_buildinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_buildin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_buildin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_buildin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_buildin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_buildinContext sil_instruction_buildin() throws RecognitionException {
		Sil_instruction_buildinContext _localctx = new Sil_instruction_buildinContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sil_instruction_buildin);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__14);
			setState(184);
			match(STRING);
			setState(185);
			match(T__0);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIL_VALUE_NAME) {
				{
				setState(186);
				sil_operand();
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(187);
					match(T__3);
					setState(188);
					sil_operand();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(196);
			match(T__1);
			setState(197);
			match(T__4);
			setState(198);
			sil_type();
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

	public static class Sil_instruction_function_refContext extends ParserRuleContext {
		public Sil_function_nameContext sil_function_name() {
			return getRuleContext(Sil_function_nameContext.class,0);
		}
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public Sil_instruction_function_refContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_function_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_function_ref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_function_ref(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_function_ref(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_function_refContext sil_instruction_function_ref() throws RecognitionException {
		Sil_instruction_function_refContext _localctx = new Sil_instruction_function_refContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sil_instruction_function_ref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__15);
			setState(201);
			sil_function_name();
			setState(202);
			match(T__4);
			setState(203);
			sil_type();
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

	public static class Sil_instruction_applyContext extends ParserRuleContext {
		public Sil_valueContext function;
		public Sil_typeContext returnType;
		public List<Sil_valueContext> sil_value() {
			return getRuleContexts(Sil_valueContext.class);
		}
		public Sil_valueContext sil_value(int i) {
			return getRuleContext(Sil_valueContext.class,i);
		}
		public Sil_typeContext sil_type() {
			return getRuleContext(Sil_typeContext.class,0);
		}
		public Sil_instruction_applyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_instruction_apply; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_instruction_apply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_instruction_apply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_instruction_apply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_instruction_applyContext sil_instruction_apply() throws RecognitionException {
		Sil_instruction_applyContext _localctx = new Sil_instruction_applyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sil_instruction_apply);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__16);
			setState(206);
			((Sil_instruction_applyContext)_localctx).function = sil_value();
			setState(207);
			match(T__0);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIL_VALUE_NAME) {
				{
				setState(208);
				sil_value();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(209);
					match(T__3);
					setState(210);
					sil_value();
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(218);
			match(T__1);
			setState(219);
			match(T__4);
			setState(220);
			((Sil_instruction_applyContext)_localctx).returnType = sil_type();
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL_INTEGER() { return getToken(SilParser.DECIMAL_INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(DECIMAL_INTEGER);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00e3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\5\4?\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\7\3\7\3\7\5\7R"+
		"\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\6\13"+
		"b\n\13\r\13\16\13c\3\13\3\13\3\f\3\f\3\f\3\r\3\r\7\rm\n\r\f\r\16\rp\13"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16y\n\16\f\16\16\16|\13\16\3\16"+
		"\3\16\5\16\u0080\n\16\3\17\3\17\3\17\3\17\3\17\7\17\u0087\n\17\f\17\16"+
		"\17\u008a\13\17\3\17\3\17\5\17\u008e\n\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\21\5\21\u0097\n\21\3\21\3\21\3\22\3\22\3\22\5\22\u009e\n\22\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u00b3\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u00c0\n\30\f\30\16\30\u00c3\13\30\5\30\u00c5"+
		"\n\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\7\32\u00d6\n\32\f\32\16\32\u00d9\13\32\5\32\u00db\n\32\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\2\2\u00dc\2\66\3\2\2\2\49\3\2\2\2\6>\3\2\2"+
		"\2\b@\3\2\2\2\nF\3\2\2\2\fQ\3\2\2\2\16S\3\2\2\2\20U\3\2\2\2\22W\3\2\2"+
		"\2\24[\3\2\2\2\26g\3\2\2\2\30j\3\2\2\2\32s\3\2\2\2\34\u0081\3\2\2\2\36"+
		"\u0091\3\2\2\2 \u0096\3\2\2\2\"\u009d\3\2\2\2$\u009f\3\2\2\2&\u00a2\3"+
		"\2\2\2(\u00a5\3\2\2\2*\u00b2\3\2\2\2,\u00b4\3\2\2\2.\u00b9\3\2\2\2\60"+
		"\u00ca\3\2\2\2\62\u00cf\3\2\2\2\64\u00e0\3\2\2\2\66\67\5\24\13\2\678\7"+
		"\2\2\38\3\3\2\2\29:\7\27\2\2:;\5\6\4\2;\5\3\2\2\2<?\5\f\7\2=?\5\b\5\2"+
		"><\3\2\2\2>=\3\2\2\2?\7\3\2\2\2@A\7\3\2\2AB\5\n\6\2BC\7\4\2\2CD\7\5\2"+
		"\2DE\5\6\4\2E\t\3\2\2\2FK\5\6\4\2GH\7\6\2\2HJ\5\6\4\2IG\3\2\2\2JM\3\2"+
		"\2\2KI\3\2\2\2KL\3\2\2\2L\13\3\2\2\2MK\3\2\2\2NR\5\16\b\2OP\7\30\2\2P"+
		"R\5\16\b\2QN\3\2\2\2QO\3\2\2\2R\r\3\2\2\2ST\7\34\2\2T\17\3\2\2\2UV\7\25"+
		"\2\2V\21\3\2\2\2WX\5\20\t\2XY\7\7\2\2YZ\5\4\3\2Z\23\3\2\2\2[\\\7\b\2\2"+
		"\\]\5\26\f\2]^\7\7\2\2^_\5\4\3\2_a\7\t\2\2`b\5\30\r\2a`\3\2\2\2bc\3\2"+
		"\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\n\2\2f\25\3\2\2\2gh\7\32\2\2hi"+
		"\7\34\2\2i\27\3\2\2\2jn\5\34\17\2km\5 \21\2lk\3\2\2\2mp\3\2\2\2nl\3\2"+
		"\2\2no\3\2\2\2oq\3\2\2\2pn\3\2\2\2qr\5\"\22\2r\31\3\2\2\2s\177\5\16\b"+
		"\2tu\7\3\2\2uz\5\22\n\2vw\7\6\2\2wy\5\22\n\2xv\3\2\2\2y|\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\4\2\2~\u0080\3\2\2\2\177t\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080\33\3\2\2\2\u0081\u008d\5\16\b\2\u0082\u0083"+
		"\7\3\2\2\u0083\u0088\5\22\n\2\u0084\u0085\7\6\2\2\u0085\u0087\5\22\n\2"+
		"\u0086\u0084\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008c\7\4\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u0082\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0090\7\7\2\2\u0090\35\3\2\2\2\u0091\u0092\7\25\2\2\u0092\37"+
		"\3\2\2\2\u0093\u0094\5\36\20\2\u0094\u0095\7\13\2\2\u0095\u0097\3\2\2"+
		"\2\u0096\u0093\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099"+
		"\5*\26\2\u0099!\3\2\2\2\u009a\u009e\5&\24\2\u009b\u009e\5(\25\2\u009c"+
		"\u009e\5$\23\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2"+
		"\2\2\u009e#\3\2\2\2\u009f\u00a0\7\f\2\2\u00a0\u00a1\5\22\n\2\u00a1%\3"+
		"\2\2\2\u00a2\u00a3\7\r\2\2\u00a3\u00a4\5\32\16\2\u00a4\'\3\2\2\2\u00a5"+
		"\u00a6\7\16\2\2\u00a6\u00a7\5\22\n\2\u00a7\u00a8\7\6\2\2\u00a8\u00a9\5"+
		"\32\16\2\u00a9\u00aa\7\6\2\2\u00aa\u00ab\5\32\16\2\u00ab)\3\2\2\2\u00ac"+
		"\u00ad\7\17\2\2\u00ad\u00b3\5\4\3\2\u00ae\u00b3\5,\27\2\u00af\u00b3\5"+
		".\30\2\u00b0\u00b3\5\60\31\2\u00b1\u00b3\5\62\32\2\u00b2\u00ac\3\2\2\2"+
		"\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3+\3\2\2\2\u00b4\u00b5\7\20\2\2\u00b5\u00b6\5\4\3\2\u00b6"+
		"\u00b7\7\6\2\2\u00b7\u00b8\5\64\33\2\u00b8-\3\2\2\2\u00b9\u00ba\7\21\2"+
		"\2\u00ba\u00bb\7\33\2\2\u00bb\u00c4\7\3\2\2\u00bc\u00c1\5\22\n\2\u00bd"+
		"\u00be\7\6\2\2\u00be\u00c0\5\22\n\2\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3"+
		"\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c7\7\4\2\2\u00c7\u00c8\7\7\2\2\u00c8\u00c9\5\4\3\2\u00c9"+
		"/\3\2\2\2\u00ca\u00cb\7\22\2\2\u00cb\u00cc\5\26\f\2\u00cc\u00cd\7\7\2"+
		"\2\u00cd\u00ce\5\4\3\2\u00ce\61\3\2\2\2\u00cf\u00d0\7\23\2\2\u00d0\u00d1"+
		"\5\20\t\2\u00d1\u00da\7\3\2\2\u00d2\u00d7\5\20\t\2\u00d3\u00d4\7\6\2\2"+
		"\u00d4\u00d6\5\20\t\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da"+
		"\u00d2\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\4"+
		"\2\2\u00dd\u00de\7\7\2\2\u00de\u00df\5\4\3\2\u00df\63\3\2\2\2\u00e0\u00e1"+
		"\7\35\2\2\u00e1\65\3\2\2\2\22>KQcnz\177\u0088\u008d\u0096\u009d\u00b2"+
		"\u00c1\u00c4\u00d7\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}