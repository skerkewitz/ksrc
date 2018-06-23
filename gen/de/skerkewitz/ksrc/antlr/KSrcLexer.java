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
		T__0=1, T__1=2, T__2=3, LET=4, VAR=5, FUNC=6, IF=7, RETURN=8, WHILE=9, 
		ASSIGN=10, ELSE=11, END=12, LPARENS=13, RPARENS=14, SEMICOLON=15, LINE_COMMENT=16, 
		BLOCK_COMMENT=17, POW=18, MINUS=19, NOT=20, MULT=21, DIV=22, MOD=23, PLUS=24, 
		LTEQ=25, GTEQ=26, LT=27, GT=28, EQ=29, IDEQ=30, NEQ=31, AND=32, OR=33, 
		WS=34, DECIMAL_INTEGER=35, FLOAT_LITERAL=36, STRING=37, NAME=38;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "LET", "VAR", "FUNC", "IF", "RETURN", "WHILE", 
		"ASSIGN", "ELSE", "END", "LPARENS", "RPARENS", "SEMICOLON", "LINE_COMMENT", 
		"BLOCK_COMMENT", "POW", "MINUS", "NOT", "MULT", "DIV", "MOD", "PLUS", 
		"LTEQ", "GTEQ", "LT", "GT", "EQ", "IDEQ", "NEQ", "AND", "OR", "WS", "DECIMAL_INTEGER", 
		"FLOAT_LITERAL", "STRING", "NAME", "ID_START", "ID_CONTINUE", "NON_ZERO_DIGIT", 
		"DIGIT", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','", "'->'", "'let'", "'var'", "'fn'", "'if'", "'return'", 
		"'while'", "'='", "'else:'", "'end'", "'('", "')'", "';'", null, null, 
		"'^'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'=<'", "'>='", "'<'", 
		"'>'", "'=='", "'==='", "'!='", "'and'", "'or'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "LET", "VAR", "FUNC", "IF", "RETURN", "WHILE", 
		"ASSIGN", "ELSE", "END", "LPARENS", "RPARENS", "SEMICOLON", "LINE_COMMENT", 
		"BLOCK_COMMENT", "POW", "MINUS", "NOT", "MULT", "DIV", "MOD", "PLUS", 
		"LTEQ", "GTEQ", "LT", "GT", "EQ", "IDEQ", "NEQ", "AND", "OR", "WS", "DECIMAL_INTEGER", 
		"FLOAT_LITERAL", "STRING", "NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0109\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\7\21\u0090\n\21\f\21\16\21\u0093\13\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u009d\n\22\f\22\16\22\u00a0\13\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3\""+
		"\3\"\3\"\3#\6#\u00d2\n#\r#\16#\u00d3\3#\3#\3$\3$\7$\u00da\n$\f$\16$\u00dd"+
		"\13$\3$\6$\u00e0\n$\r$\16$\u00e1\5$\u00e4\n$\3%\3%\3%\3&\3&\7&\u00eb\n"+
		"&\f&\16&\u00ee\13&\3&\3&\3\'\3\'\7\'\u00f4\n\'\f\'\16\'\u00f7\13\'\3("+
		"\5(\u00fa\n(\3)\3)\5)\u00fe\n)\3*\3*\3+\3+\3,\3,\6,\u0106\n,\r,\16,\u0107"+
		"\3\u009e\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S\2U\2W\2\3\2\b\4\2\f\f\17\17\5\2"+
		"\13\f\17\17\"\"\3\2$$\6\2//C\\aac|\3\2\62;\3\2\63;\2\u010d\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2"+
		"\2K\3\2\2\2\2M\3\2\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\t`\3\2\2\2\13"+
		"d\3\2\2\2\rh\3\2\2\2\17k\3\2\2\2\21n\3\2\2\2\23u\3\2\2\2\25{\3\2\2\2\27"+
		"}\3\2\2\2\31\u0083\3\2\2\2\33\u0087\3\2\2\2\35\u0089\3\2\2\2\37\u008b"+
		"\3\2\2\2!\u008d\3\2\2\2#\u0096\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2"+
		")\u00ab\3\2\2\2+\u00ad\3\2\2\2-\u00af\3\2\2\2/\u00b1\3\2\2\2\61\u00b3"+
		"\3\2\2\2\63\u00b5\3\2\2\2\65\u00b8\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2"+
		"\2\2;\u00bf\3\2\2\2=\u00c2\3\2\2\2?\u00c6\3\2\2\2A\u00c9\3\2\2\2C\u00cd"+
		"\3\2\2\2E\u00d1\3\2\2\2G\u00e3\3\2\2\2I\u00e5\3\2\2\2K\u00e8\3\2\2\2M"+
		"\u00f1\3\2\2\2O\u00f9\3\2\2\2Q\u00fd\3\2\2\2S\u00ff\3\2\2\2U\u0101\3\2"+
		"\2\2W\u0103\3\2\2\2YZ\7<\2\2Z\4\3\2\2\2[\\\7.\2\2\\\6\3\2\2\2]^\7/\2\2"+
		"^_\7@\2\2_\b\3\2\2\2`a\7n\2\2ab\7g\2\2bc\7v\2\2c\n\3\2\2\2de\7x\2\2ef"+
		"\7c\2\2fg\7t\2\2g\f\3\2\2\2hi\7h\2\2ij\7p\2\2j\16\3\2\2\2kl\7k\2\2lm\7"+
		"h\2\2m\20\3\2\2\2no\7t\2\2op\7g\2\2pq\7v\2\2qr\7w\2\2rs\7t\2\2st\7p\2"+
		"\2t\22\3\2\2\2uv\7y\2\2vw\7j\2\2wx\7k\2\2xy\7n\2\2yz\7g\2\2z\24\3\2\2"+
		"\2{|\7?\2\2|\26\3\2\2\2}~\7g\2\2~\177\7n\2\2\177\u0080\7u\2\2\u0080\u0081"+
		"\7g\2\2\u0081\u0082\7<\2\2\u0082\30\3\2\2\2\u0083\u0084\7g\2\2\u0084\u0085"+
		"\7p\2\2\u0085\u0086\7f\2\2\u0086\32\3\2\2\2\u0087\u0088\7*\2\2\u0088\34"+
		"\3\2\2\2\u0089\u008a\7+\2\2\u008a\36\3\2\2\2\u008b\u008c\7=\2\2\u008c"+
		" \3\2\2\2\u008d\u0091\7%\2\2\u008e\u0090\n\2\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2"+
		"\2\2\u0093\u0091\3\2\2\2\u0094\u0095\b\21\2\2\u0095\"\3\2\2\2\u0096\u0097"+
		"\7>\2\2\u0097\u0098\7#\2\2\u0098\u0099\7/\2\2\u0099\u009a\7/\2\2\u009a"+
		"\u009e\3\2\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a2\7/\2\2\u00a2\u00a3\7/\2\2\u00a3\u00a4\7@\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\b\22\2\2\u00a6$\3\2\2\2\u00a7\u00a8"+
		"\7`\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7/\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7"+
		"#\2\2\u00ac*\3\2\2\2\u00ad\u00ae\7,\2\2\u00ae,\3\2\2\2\u00af\u00b0\7\61"+
		"\2\2\u00b0.\3\2\2\2\u00b1\u00b2\7\'\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7"+
		"-\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7?\2\2\u00b6\u00b7\7>\2\2\u00b7\64"+
		"\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\u00ba\7?\2\2\u00ba\66\3\2\2\2\u00bb"+
		"\u00bc\7>\2\2\u00bc8\3\2\2\2\u00bd\u00be\7@\2\2\u00be:\3\2\2\2\u00bf\u00c0"+
		"\7?\2\2\u00c0\u00c1\7?\2\2\u00c1<\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3\u00c4"+
		"\7?\2\2\u00c4\u00c5\7?\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8@\3\2\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc"+
		"\7f\2\2\u00ccB\3\2\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7t\2\2\u00cfD\3"+
		"\2\2\2\u00d0\u00d2\t\3\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b#"+
		"\2\2\u00d6F\3\2\2\2\u00d7\u00db\5S*\2\u00d8\u00da\5U+\2\u00d9\u00d8\3"+
		"\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc"+
		"\u00e4\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00e0\7\62\2\2\u00df\u00de\3"+
		"\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00d7\3\2\2\2\u00e3\u00df\3\2\2\2\u00e4H\3\2\2\2"+
		"\u00e5\u00e6\5G$\2\u00e6\u00e7\5W,\2\u00e7J\3\2\2\2\u00e8\u00ec\7$\2\2"+
		"\u00e9\u00eb\n\4\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00f0\7$\2\2\u00f0L\3\2\2\2\u00f1\u00f5\5O(\2\u00f2\u00f4\5Q)\2\u00f3"+
		"\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2"+
		"\2\2\u00f6N\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00fa\t\5\2\2\u00f9\u00f8"+
		"\3\2\2\2\u00faP\3\2\2\2\u00fb\u00fe\5O(\2\u00fc\u00fe\t\6\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fc\3\2\2\2\u00feR\3\2\2\2\u00ff\u0100\t\7\2\2\u0100"+
		"T\3\2\2\2\u0101\u0102\t\6\2\2\u0102V\3\2\2\2\u0103\u0105\7\60\2\2\u0104"+
		"\u0106\5U+\2\u0105\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2"+
		"\2\u0107\u0108\3\2\2\2\u0108X\3\2\2\2\16\2\u0091\u009e\u00d3\u00db\u00e1"+
		"\u00e3\u00ec\u00f5\u00f9\u00fd\u0107\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}