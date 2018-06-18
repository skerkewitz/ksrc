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
		T__9=10, T__10=11, T__11=12, LET=13, FUNC=14, IF=15, RETURN=16, ASSIGN=17, 
		LINE_COMMENT=18, WS=19, NUMBER=20, INTEGER=21, DECIMAL_INTEGER=22, FLOAT_NUMBER=23, 
		STRING=24, NAME=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "LET", "FUNC", "IF", "RETURN", "ASSIGN", "LINE_COMMENT", 
		"WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", "STRING", 
		"NAME", "ID_START", "ID_CONTINUE", "NON_ZERO_DIGIT", "DIGIT", "POINT_FLOAT", 
		"INT_PART", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'=='", "'('", "')'", "','", 
		"':'", "'{'", "'}'", "'let'", "'fn'", "'if'", "'return'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "LET", "FUNC", "IF", "RETURN", "ASSIGN", "LINE_COMMENT", "WS", "NUMBER", 
		"INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", "STRING", "NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00c4\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\7\23r\n\23\f\23\16\23u\13\23\3\23\3\23\3\24\6\24z\n\24\r\24\16\24"+
		"{\3\24\3\24\3\25\3\25\5\25\u0082\n\25\3\26\3\26\3\27\3\27\7\27\u0088\n"+
		"\27\f\27\16\27\u008b\13\27\3\27\6\27\u008e\n\27\r\27\16\27\u008f\5\27"+
		"\u0092\n\27\3\30\3\30\3\31\3\31\7\31\u0098\n\31\f\31\16\31\u009b\13\31"+
		"\3\31\3\31\3\32\3\32\7\32\u00a1\n\32\f\32\16\32\u00a4\13\32\3\33\5\33"+
		"\u00a7\n\33\3\34\3\34\5\34\u00ab\n\34\3\35\3\35\3\36\3\36\3\37\5\37\u00b2"+
		"\n\37\3\37\3\37\3\37\3\37\5\37\u00b8\n\37\3 \6 \u00bb\n \r \16 \u00bc"+
		"\3!\3!\6!\u00c1\n!\r!\16!\u00c2\2\2\"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\2\67\29\2;\2=\2?\2A\2\3\2\b\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\3\2$$\5\2C\\aac|\3\2\62;\3\2\63;\2\u00c9\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\3C\3\2\2\2\5E\3\2\2\2\7G\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3"+
		"\2\2\2\17P\3\2\2\2\21R\3\2\2\2\23T\3\2\2\2\25V\3\2\2\2\27X\3\2\2\2\31"+
		"Z\3\2\2\2\33\\\3\2\2\2\35`\3\2\2\2\37c\3\2\2\2!f\3\2\2\2#m\3\2\2\2%o\3"+
		"\2\2\2\'y\3\2\2\2)\u0081\3\2\2\2+\u0083\3\2\2\2-\u0091\3\2\2\2/\u0093"+
		"\3\2\2\2\61\u0095\3\2\2\2\63\u009e\3\2\2\2\65\u00a6\3\2\2\2\67\u00aa\3"+
		"\2\2\29\u00ac\3\2\2\2;\u00ae\3\2\2\2=\u00b7\3\2\2\2?\u00ba\3\2\2\2A\u00be"+
		"\3\2\2\2CD\7=\2\2D\4\3\2\2\2EF\7,\2\2F\6\3\2\2\2GH\7\61\2\2H\b\3\2\2\2"+
		"IJ\7-\2\2J\n\3\2\2\2KL\7/\2\2L\f\3\2\2\2MN\7?\2\2NO\7?\2\2O\16\3\2\2\2"+
		"PQ\7*\2\2Q\20\3\2\2\2RS\7+\2\2S\22\3\2\2\2TU\7.\2\2U\24\3\2\2\2VW\7<\2"+
		"\2W\26\3\2\2\2XY\7}\2\2Y\30\3\2\2\2Z[\7\177\2\2[\32\3\2\2\2\\]\7n\2\2"+
		"]^\7g\2\2^_\7v\2\2_\34\3\2\2\2`a\7h\2\2ab\7p\2\2b\36\3\2\2\2cd\7k\2\2"+
		"de\7h\2\2e \3\2\2\2fg\7t\2\2gh\7g\2\2hi\7v\2\2ij\7w\2\2jk\7t\2\2kl\7p"+
		"\2\2l\"\3\2\2\2mn\7?\2\2n$\3\2\2\2os\7%\2\2pr\n\2\2\2qp\3\2\2\2ru\3\2"+
		"\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\b\23\2\2w&\3\2\2\2xz\t"+
		"\3\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|}\3\2\2\2}~\b\24\2\2~("+
		"\3\2\2\2\177\u0082\5+\26\2\u0080\u0082\5/\30\2\u0081\177\3\2\2\2\u0081"+
		"\u0080\3\2\2\2\u0082*\3\2\2\2\u0083\u0084\5-\27\2\u0084,\3\2\2\2\u0085"+
		"\u0089\59\35\2\u0086\u0088\5;\36\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0092\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008c\u008e\7\62\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3"+
		"\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u0085\3\2\2\2\u0091\u008d\3\2\2\2\u0092.\3\2\2\2\u0093\u0094\5=\37\2"+
		"\u0094\60\3\2\2\2\u0095\u0099\7$\2\2\u0096\u0098\n\4\2\2\u0097\u0096\3"+
		"\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7$\2\2\u009d\62\3\2\2\2"+
		"\u009e\u00a2\5\65\33\2\u009f\u00a1\5\67\34\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\64\3\2\2"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00a7\t\5\2\2\u00a6\u00a5\3\2\2\2\u00a7\66"+
		"\3\2\2\2\u00a8\u00ab\5\65\33\2\u00a9\u00ab\t\6\2\2\u00aa\u00a8\3\2\2\2"+
		"\u00aa\u00a9\3\2\2\2\u00ab8\3\2\2\2\u00ac\u00ad\t\7\2\2\u00ad:\3\2\2\2"+
		"\u00ae\u00af\t\6\2\2\u00af<\3\2\2\2\u00b0\u00b2\5? \2\u00b1\u00b0\3\2"+
		"\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b8\5A!\2\u00b4\u00b5"+
		"\5? \2\u00b5\u00b6\7\60\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b1\3\2\2\2\u00b7"+
		"\u00b4\3\2\2\2\u00b8>\3\2\2\2\u00b9\u00bb\5;\36\2\u00ba\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd@\3"+
		"\2\2\2\u00be\u00c0\7\60\2\2\u00bf\u00c1\5;\36\2\u00c0\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3B\3\2\2\2"+
		"\21\2s{\u0081\u0089\u008f\u0091\u0099\u00a2\u00a6\u00aa\u00b1\u00b7\u00bc"+
		"\u00c2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}