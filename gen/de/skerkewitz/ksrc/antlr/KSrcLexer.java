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
		T__9=10, LET=11, FUNC=12, RETURN=13, ASSIGN=14, WS=15, NUMBER=16, INTEGER=17, 
		DECIMAL_INTEGER=18, FLOAT_NUMBER=19, STRING=20, NAME=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "LET", "FUNC", "RETURN", "ASSIGN", "WS", "NUMBER", "INTEGER", 
		"DECIMAL_INTEGER", "FLOAT_NUMBER", "STRING", "NAME", "ID_START", "ID_CONTINUE", 
		"NON_ZERO_DIGIT", "DIGIT", "POINT_FLOAT", "INT_PART", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "','", "'{'", "'}'", 
		"'let'", "'fn'", "'return'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "LET", 
		"FUNC", "RETURN", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", 
		"FLOAT_NUMBER", "STRING", "NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\6\20"+
		"a\n\20\r\20\16\20b\3\20\3\20\3\21\3\21\5\21i\n\21\3\22\3\22\3\23\3\23"+
		"\7\23o\n\23\f\23\16\23r\13\23\3\23\6\23u\n\23\r\23\16\23v\5\23y\n\23\3"+
		"\24\3\24\3\25\3\25\7\25\177\n\25\f\25\16\25\u0082\13\25\3\25\3\25\3\26"+
		"\3\26\7\26\u0088\n\26\f\26\16\26\u008b\13\26\3\27\5\27\u008e\n\27\3\30"+
		"\3\30\5\30\u0092\n\30\3\31\3\31\3\32\3\32\3\33\5\33\u0099\n\33\3\33\3"+
		"\33\3\33\3\33\5\33\u009f\n\33\3\34\6\34\u00a2\n\34\r\34\16\34\u00a3\3"+
		"\35\3\35\6\35\u00a8\n\35\r\35\16\35\u00a9\2\2\36\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\2/\2\61\2\63\2\65\2\67\29\2\3\2\7\5\2\13\f\17\17\"\"\3\2$$\5"+
		"\2C\\aac|\3\2\62;\3\2\63;\2\u00af\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2\2\2"+
		"\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2"+
		"\2\31S\3\2\2\2\33V\3\2\2\2\35]\3\2\2\2\37`\3\2\2\2!h\3\2\2\2#j\3\2\2\2"+
		"%x\3\2\2\2\'z\3\2\2\2)|\3\2\2\2+\u0085\3\2\2\2-\u008d\3\2\2\2/\u0091\3"+
		"\2\2\2\61\u0093\3\2\2\2\63\u0095\3\2\2\2\65\u009e\3\2\2\2\67\u00a1\3\2"+
		"\2\29\u00a5\3\2\2\2;<\7=\2\2<\4\3\2\2\2=>\7,\2\2>\6\3\2\2\2?@\7\61\2\2"+
		"@\b\3\2\2\2AB\7-\2\2B\n\3\2\2\2CD\7/\2\2D\f\3\2\2\2EF\7*\2\2F\16\3\2\2"+
		"\2GH\7+\2\2H\20\3\2\2\2IJ\7.\2\2J\22\3\2\2\2KL\7}\2\2L\24\3\2\2\2MN\7"+
		"\177\2\2N\26\3\2\2\2OP\7n\2\2PQ\7g\2\2QR\7v\2\2R\30\3\2\2\2ST\7h\2\2T"+
		"U\7p\2\2U\32\3\2\2\2VW\7t\2\2WX\7g\2\2XY\7v\2\2YZ\7w\2\2Z[\7t\2\2[\\\7"+
		"p\2\2\\\34\3\2\2\2]^\7?\2\2^\36\3\2\2\2_a\t\2\2\2`_\3\2\2\2ab\3\2\2\2"+
		"b`\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\b\20\2\2e \3\2\2\2fi\5#\22\2gi\5\'\24"+
		"\2hf\3\2\2\2hg\3\2\2\2i\"\3\2\2\2jk\5%\23\2k$\3\2\2\2lp\5\61\31\2mo\5"+
		"\63\32\2nm\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2qy\3\2\2\2rp\3\2\2\2s"+
		"u\7\62\2\2ts\3\2\2\2uv\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xl\3\2\2\2"+
		"xt\3\2\2\2y&\3\2\2\2z{\5\65\33\2{(\3\2\2\2|\u0080\7$\2\2}\177\n\3\2\2"+
		"~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7$\2\2\u0084*\3\2\2\2\u0085"+
		"\u0089\5-\27\2\u0086\u0088\5/\30\2\u0087\u0086\3\2\2\2\u0088\u008b\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a,\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008e\t\4\2\2\u008d\u008c\3\2\2\2\u008e.\3\2\2\2\u008f"+
		"\u0092\5-\27\2\u0090\u0092\t\5\2\2\u0091\u008f\3\2\2\2\u0091\u0090\3\2"+
		"\2\2\u0092\60\3\2\2\2\u0093\u0094\t\6\2\2\u0094\62\3\2\2\2\u0095\u0096"+
		"\t\5\2\2\u0096\64\3\2\2\2\u0097\u0099\5\67\34\2\u0098\u0097\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009f\59\35\2\u009b\u009c\5\67"+
		"\34\2\u009c\u009d\7\60\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e"+
		"\u009b\3\2\2\2\u009f\66\3\2\2\2\u00a0\u00a2\5\63\32\2\u00a1\u00a0\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"8\3\2\2\2\u00a5\u00a7\7\60\2\2\u00a6\u00a8\5\63\32\2\u00a7\u00a6\3\2\2"+
		"\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa:"+
		"\3\2\2\2\20\2bhpvx\u0080\u0089\u008d\u0091\u0098\u009e\u00a3\u00a9\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}