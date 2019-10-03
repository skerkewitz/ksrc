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
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, TYPE_SIGIL=15, POINTER_SIGIL=16, 
		LOCAL_SIGIL=17, FUNCTION_SIGIL=18, STRING=19, VALUENAME=20, NAME=21;
	public static final int
		RULE_translation_unit = 0, RULE_sil_type = 1, RULE_sil_types = 2, RULE_sil_function_type = 3, 
		RULE_sil_function_type_arguments = 4, RULE_sil_basic_type = 5, RULE_sil_identifier = 6, 
		RULE_sil_value_name = 7, RULE_sil_value = 8, RULE_sil_operand = 9, RULE_sil_function = 10, 
		RULE_sil_function_name = 11, RULE_sil_name = 12, RULE_sil_basic_block = 13, 
		RULE_sil_label_target = 14, RULE_sil_label = 15, RULE_sil_instruction_result = 16, 
		RULE_sil_instruction_def = 17, RULE_sil_terminator = 18, RULE_sil_terminator_return = 19, 
		RULE_sil_terminator_br = 20, RULE_sil_terminator_cond_br = 21, RULE_sil_instruction = 22, 
		RULE_valuename = 23, RULE_functioname = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"translation_unit", "sil_type", "sil_types", "sil_function_type", "sil_function_type_arguments", 
			"sil_basic_type", "sil_identifier", "sil_value_name", "sil_value", "sil_operand", 
			"sil_function", "sil_function_name", "sil_name", "sil_basic_block", "sil_label_target", 
			"sil_label", "sil_instruction_result", "sil_instruction_def", "sil_terminator", 
			"sil_terminator_return", "sil_terminator_br", "sil_terminator_cond_br", 
			"sil_instruction", "valuename", "functioname"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'->'", "','", "':'", "'sil'", "'{'", "'}'", "'='", 
			"'return'", "'br'", "'cond_br'", "'alloc_stack'", null, "'$'", "'*'", 
			"'%'", "'@'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "TYPE_SIGIL", "POINTER_SIGIL", "LOCAL_SIGIL", "FUNCTION_SIGIL", 
			"STRING", "VALUENAME", "NAME"
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
			setState(50);
			sil_function();
			setState(51);
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
			setState(53);
			match(TYPE_SIGIL);
			setState(54);
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
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case POINTER_SIGIL:
			case VALUENAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				sil_basic_type();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
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
			setState(60);
			match(T__0);
			setState(61);
			sil_function_type_arguments();
			setState(62);
			match(T__1);
			setState(63);
			match(T__2);
			setState(64);
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
			setState(66);
			sil_types();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(67);
				match(T__3);
				setState(68);
				sil_types();
				}
				}
				setState(73);
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VALUENAME:
				_localctx = new SimpleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				sil_identifier();
				}
				break;
			case POINTER_SIGIL:
				_localctx = new PointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(POINTER_SIGIL);
				setState(76);
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
		public ValuenameContext valuename() {
			return getRuleContext(ValuenameContext.class,0);
		}
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
			setState(79);
			valuename();
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

	public static class Sil_value_nameContext extends ParserRuleContext {
		public TerminalNode LOCAL_SIGIL() { return getToken(SilParser.LOCAL_SIGIL, 0); }
		public ValuenameContext valuename() {
			return getRuleContext(ValuenameContext.class,0);
		}
		public Sil_value_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_value_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_value_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_value_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_value_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_value_nameContext sil_value_name() throws RecognitionException {
		Sil_value_nameContext _localctx = new Sil_value_nameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sil_value_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LOCAL_SIGIL);
			setState(82);
			valuename();
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
		public Sil_value_nameContext sil_value_name() {
			return getRuleContext(Sil_value_nameContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_sil_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			sil_value_name();
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
		enterRule(_localctx, 18, RULE_sil_operand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			sil_value();
			setState(87);
			match(T__4);
			setState(88);
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
		enterRule(_localctx, 20, RULE_sil_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__5);
			setState(91);
			sil_function_name();
			setState(92);
			match(T__4);
			setState(93);
			sil_type();
			setState(94);
			match(T__6);
			setState(96); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(95);
				sil_basic_block();
				}
				}
				setState(98); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VALUENAME );
			setState(100);
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
		public FunctionameContext functioname() {
			return getRuleContext(FunctionameContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_sil_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(FUNCTION_SIGIL);
			setState(103);
			functioname();
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

	public static class Sil_nameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SilParser.NAME, 0); }
		public Sil_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sil_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterSil_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitSil_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitSil_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sil_nameContext sil_name() throws RecognitionException {
		Sil_nameContext _localctx = new Sil_nameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sil_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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
		enterRule(_localctx, 26, RULE_sil_basic_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			sil_label();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==LOCAL_SIGIL) {
				{
				{
				setState(108);
				sil_instruction_def();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
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
		enterRule(_localctx, 28, RULE_sil_label_target);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			sil_identifier();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(117);
				match(T__0);
				setState(118);
				sil_operand();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(119);
					match(T__3);
					setState(120);
					sil_operand();
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(126);
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
		enterRule(_localctx, 30, RULE_sil_label);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			sil_identifier();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(131);
				match(T__0);
				setState(132);
				sil_operand();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(133);
					match(T__3);
					setState(134);
					sil_operand();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140);
				match(T__1);
				}
			}

			setState(144);
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
		public Sil_value_nameContext sil_value_name() {
			return getRuleContext(Sil_value_nameContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_sil_instruction_result);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			sil_value_name();
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
		enterRule(_localctx, 34, RULE_sil_instruction_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LOCAL_SIGIL) {
				{
				setState(148);
				sil_instruction_result();
				setState(149);
				match(T__8);
				}
			}

			setState(153);
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
		enterRule(_localctx, 36, RULE_sil_terminator);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				sil_terminator_br();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				sil_terminator_cond_br();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
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
		enterRule(_localctx, 38, RULE_sil_terminator_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__9);
			setState(161);
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
		enterRule(_localctx, 40, RULE_sil_terminator_br);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(T__10);
			setState(164);
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
		enterRule(_localctx, 42, RULE_sil_terminator_cond_br);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__11);
			setState(167);
			((Sil_terminator_cond_brContext)_localctx).condition = sil_operand();
			setState(168);
			match(T__3);
			setState(169);
			((Sil_terminator_cond_brContext)_localctx).thenLabel = sil_label_target();
			setState(170);
			match(T__3);
			setState(171);
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
		enterRule(_localctx, 44, RULE_sil_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__12);
			setState(174);
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

	public static class ValuenameContext extends ParserRuleContext {
		public TerminalNode VALUENAME() { return getToken(SilParser.VALUENAME, 0); }
		public ValuenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valuename; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterValuename(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitValuename(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitValuename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuenameContext valuename() throws RecognitionException {
		ValuenameContext _localctx = new ValuenameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_valuename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(VALUENAME);
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

	public static class FunctionameContext extends ParserRuleContext {
		public TerminalNode VALUENAME() { return getToken(SilParser.VALUENAME, 0); }
		public FunctionameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functioname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).enterFunctioname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SilListener ) ((SilListener)listener).exitFunctioname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SilVisitor ) return ((SilVisitor<? extends T>)visitor).visitFunctioname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionameContext functioname() throws RecognitionException {
		FunctionameContext _localctx = new FunctionameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functioname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(VALUENAME);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u00b7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\5\4=\n\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\7\3\7\3\7\5\7P\n\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\6\f"+
		"c\n\f\r\f\16\fd\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\7\17p\n\17\f\17"+
		"\16\17s\13\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20|\n\20\f\20\16\20"+
		"\177\13\20\3\20\3\20\5\20\u0083\n\20\3\21\3\21\3\21\3\21\3\21\7\21\u008a"+
		"\n\21\f\21\16\21\u008d\13\21\3\21\3\21\5\21\u0091\n\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\23\5\23\u009a\n\23\3\23\3\23\3\24\3\24\3\24\5\24\u00a1"+
		"\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\2\2\2\u00a9\2\64\3\2\2\2\4\67\3\2\2\2\6"+
		"<\3\2\2\2\b>\3\2\2\2\nD\3\2\2\2\fO\3\2\2\2\16Q\3\2\2\2\20S\3\2\2\2\22"+
		"V\3\2\2\2\24X\3\2\2\2\26\\\3\2\2\2\30h\3\2\2\2\32k\3\2\2\2\34m\3\2\2\2"+
		"\36v\3\2\2\2 \u0084\3\2\2\2\"\u0094\3\2\2\2$\u0099\3\2\2\2&\u00a0\3\2"+
		"\2\2(\u00a2\3\2\2\2*\u00a5\3\2\2\2,\u00a8\3\2\2\2.\u00af\3\2\2\2\60\u00b2"+
		"\3\2\2\2\62\u00b4\3\2\2\2\64\65\5\26\f\2\65\66\7\2\2\3\66\3\3\2\2\2\67"+
		"8\7\21\2\289\5\6\4\29\5\3\2\2\2:=\5\f\7\2;=\5\b\5\2<:\3\2\2\2<;\3\2\2"+
		"\2=\7\3\2\2\2>?\7\3\2\2?@\5\n\6\2@A\7\4\2\2AB\7\5\2\2BC\5\6\4\2C\t\3\2"+
		"\2\2DI\5\6\4\2EF\7\6\2\2FH\5\6\4\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2J\13\3\2\2\2KI\3\2\2\2LP\5\16\b\2MN\7\22\2\2NP\5\16\b\2OL\3\2\2\2"+
		"OM\3\2\2\2P\r\3\2\2\2QR\5\60\31\2R\17\3\2\2\2ST\7\23\2\2TU\5\60\31\2U"+
		"\21\3\2\2\2VW\5\20\t\2W\23\3\2\2\2XY\5\22\n\2YZ\7\7\2\2Z[\5\4\3\2[\25"+
		"\3\2\2\2\\]\7\b\2\2]^\5\30\r\2^_\7\7\2\2_`\5\4\3\2`b\7\t\2\2ac\5\34\17"+
		"\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2ef\3\2\2\2fg\7\n\2\2g\27\3\2"+
		"\2\2hi\7\24\2\2ij\5\62\32\2j\31\3\2\2\2kl\7\27\2\2l\33\3\2\2\2mq\5 \21"+
		"\2np\5$\23\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2"+
		"\2tu\5&\24\2u\35\3\2\2\2v\u0082\5\16\b\2wx\7\3\2\2x}\5\24\13\2yz\7\6\2"+
		"\2z|\5\24\13\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2"+
		"\2\177}\3\2\2\2\u0080\u0081\7\4\2\2\u0081\u0083\3\2\2\2\u0082w\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\37\3\2\2\2\u0084\u0090\5\16\b\2\u0085\u0086"+
		"\7\3\2\2\u0086\u008b\5\24\13\2\u0087\u0088\7\6\2\2\u0088\u008a\5\24\13"+
		"\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u008f\7\4\2\2\u008f"+
		"\u0091\3\2\2\2\u0090\u0085\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\7\7\2\2\u0093!\3\2\2\2\u0094\u0095\5\20\t\2\u0095#\3"+
		"\2\2\2\u0096\u0097\5\"\22\2\u0097\u0098\7\13\2\2\u0098\u009a\3\2\2\2\u0099"+
		"\u0096\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\5."+
		"\30\2\u009c%\3\2\2\2\u009d\u00a1\5*\26\2\u009e\u00a1\5,\27\2\u009f\u00a1"+
		"\5(\25\2\u00a0\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\'\3\2\2\2\u00a2\u00a3\7\f\2\2\u00a3\u00a4\5\24\13\2\u00a4)\3\2\2\2\u00a5"+
		"\u00a6\7\r\2\2\u00a6\u00a7\5\36\20\2\u00a7+\3\2\2\2\u00a8\u00a9\7\16\2"+
		"\2\u00a9\u00aa\5\24\13\2\u00aa\u00ab\7\6\2\2\u00ab\u00ac\5\36\20\2\u00ac"+
		"\u00ad\7\6\2\2\u00ad\u00ae\5\36\20\2\u00ae-\3\2\2\2\u00af\u00b0\7\17\2"+
		"\2\u00b0\u00b1\5\4\3\2\u00b1/\3\2\2\2\u00b2\u00b3\7\26\2\2\u00b3\61\3"+
		"\2\2\2\u00b4\u00b5\7\26\2\2\u00b5\63\3\2\2\2\r<IOdq}\u0082\u008b\u0090"+
		"\u0099\u00a0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}