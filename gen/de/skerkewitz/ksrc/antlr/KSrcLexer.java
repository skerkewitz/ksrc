// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/main/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
package de.skerkewitz.ksrc.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KSrcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, LET=11, FUNC=12, ASSIGN=13, WS=14, NUMBER=15, INTEGER=16, DECIMAL_INTEGER=17, 
		FLOAT_NUMBER=18, STRING=19, NAME=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "LET", "FUNC", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", 
		"FLOAT_NUMBER", "STRING", "NAME", "ID_START", "ID_CONTINUE", "NON_ZERO_DIGIT", 
		"DIGIT", "POINT_FLOAT", "INT_PART", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "','", "'{'", "'}'", 
		"'let'", "'fn'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "LET", 
		"FUNC", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", 
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


	public KSrcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KSrc.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\6\17X\n\17\r\17\16\17Y\3\17\3\17\3\20\3\20\5\20"+
		"`\n\20\3\21\3\21\3\22\3\22\7\22f\n\22\f\22\16\22i\13\22\3\22\6\22l\n\22"+
		"\r\22\16\22m\5\22p\n\22\3\23\3\23\3\24\3\24\7\24v\n\24\f\24\16\24y\13"+
		"\24\3\24\3\24\3\25\3\25\7\25\177\n\25\f\25\16\25\u0082\13\25\3\26\5\26"+
		"\u0085\n\26\3\27\3\27\5\27\u0089\n\27\3\30\3\30\3\31\3\31\3\32\5\32\u0090"+
		"\n\32\3\32\3\32\3\32\3\32\5\32\u0096\n\32\3\33\6\33\u0099\n\33\r\33\16"+
		"\33\u009a\3\34\3\34\6\34\u009f\n\34\r\34\16\34\u00a0\2\2\35\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\2-\2/\2\61\2\63\2\65\2\67\2\3\2\7\5\2\13\f\17\17\""+
		"\"\3\2$$\5\2C\\aac|\3\2\62;\3\2\63;\2\u00a6\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3\2\2\2\13A\3\2\2\2"+
		"\rC\3\2\2\2\17E\3\2\2\2\21G\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2\2"+
		"\2\31Q\3\2\2\2\33T\3\2\2\2\35W\3\2\2\2\37_\3\2\2\2!a\3\2\2\2#o\3\2\2\2"+
		"%q\3\2\2\2\'s\3\2\2\2)|\3\2\2\2+\u0084\3\2\2\2-\u0088\3\2\2\2/\u008a\3"+
		"\2\2\2\61\u008c\3\2\2\2\63\u0095\3\2\2\2\65\u0098\3\2\2\2\67\u009c\3\2"+
		"\2\29:\7=\2\2:\4\3\2\2\2;<\7,\2\2<\6\3\2\2\2=>\7\61\2\2>\b\3\2\2\2?@\7"+
		"-\2\2@\n\3\2\2\2AB\7/\2\2B\f\3\2\2\2CD\7*\2\2D\16\3\2\2\2EF\7+\2\2F\20"+
		"\3\2\2\2GH\7.\2\2H\22\3\2\2\2IJ\7}\2\2J\24\3\2\2\2KL\7\177\2\2L\26\3\2"+
		"\2\2MN\7n\2\2NO\7g\2\2OP\7v\2\2P\30\3\2\2\2QR\7h\2\2RS\7p\2\2S\32\3\2"+
		"\2\2TU\7?\2\2U\34\3\2\2\2VX\t\2\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3"+
		"\2\2\2Z[\3\2\2\2[\\\b\17\2\2\\\36\3\2\2\2]`\5!\21\2^`\5%\23\2_]\3\2\2"+
		"\2_^\3\2\2\2` \3\2\2\2ab\5#\22\2b\"\3\2\2\2cg\5/\30\2df\5\61\31\2ed\3"+
		"\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hp\3\2\2\2ig\3\2\2\2jl\7\62\2\2kj"+
		"\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2oc\3\2\2\2ok\3\2\2\2p"+
		"$\3\2\2\2qr\5\63\32\2r&\3\2\2\2sw\7$\2\2tv\n\3\2\2ut\3\2\2\2vy\3\2\2\2"+
		"wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7$\2\2{(\3\2\2\2|\u0080\5+"+
		"\26\2}\177\5-\27\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081*\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\t\4\2\2\u0084"+
		"\u0083\3\2\2\2\u0085,\3\2\2\2\u0086\u0089\5+\26\2\u0087\u0089\t\5\2\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089.\3\2\2\2\u008a\u008b\t"+
		"\6\2\2\u008b\60\3\2\2\2\u008c\u008d\t\5\2\2\u008d\62\3\2\2\2\u008e\u0090"+
		"\5\65\33\2\u008f\u008e\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2"+
		"\u0091\u0096\5\67\34\2\u0092\u0093\5\65\33\2\u0093\u0094\7\60\2\2\u0094"+
		"\u0096\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0092\3\2\2\2\u0096\64\3\2\2"+
		"\2\u0097\u0099\5\61\31\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\66\3\2\2\2\u009c\u009e\7\60\2"+
		"\2\u009d\u009f\5\61\31\2\u009e\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a18\3\2\2\2\20\2Y_gmow\u0080\u0084"+
		"\u0088\u008f\u0095\u009a\u00a0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}