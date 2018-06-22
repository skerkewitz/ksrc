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
		T__0=1, T__1=2, T__2=3, T__3=4, LET=5, VAR=6, FUNC=7, IF=8, RETURN=9, 
		WHILE=10, ASSIGN=11, LPARENS=12, RPARENS=13, SEMICOLON=14, LINE_COMMENT=15, 
		BLOCK_COMMENT=16, POW=17, MINUS=18, NOT=19, MULT=20, DIV=21, MOD=22, PLUS=23, 
		LTEQ=24, GTEQ=25, LT=26, GT=27, EQ=28, IDEQ=29, NEQ=30, AND=31, OR=32, 
		WS=33, NUMBER=34, INTEGER=35, DECIMAL_INTEGER=36, FLOAT_NUMBER=37, STRING=38, 
		NAME=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "LET", "VAR", "FUNC", "IF", "RETURN", 
		"WHILE", "ASSIGN", "LPARENS", "RPARENS", "SEMICOLON", "LINE_COMMENT", 
		"BLOCK_COMMENT", "POW", "MINUS", "NOT", "MULT", "DIV", "MOD", "PLUS", 
		"LTEQ", "GTEQ", "LT", "GT", "EQ", "IDEQ", "NEQ", "AND", "OR", "WS", "NUMBER", 
		"INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", "STRING", "NAME", "ID_START", 
		"ID_CONTINUE", "NON_ZERO_DIGIT", "DIGIT", "POINT_FLOAT", "INT_PART", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "','", "'->'", "'end'", "'let'", "'var'", "'fn'", "'if'", 
		"'return'", "'while'", "'='", "'('", "')'", "';'", null, null, "'^'", 
		"'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'=<'", "'>='", "'<'", "'>'", 
		"'=='", "'==='", "'!='", "'and'", "'or'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "LET", "VAR", "FUNC", "IF", "RETURN", "WHILE", 
		"ASSIGN", "LPARENS", "RPARENS", "SEMICOLON", "LINE_COMMENT", "BLOCK_COMMENT", 
		"POW", "MINUS", "NOT", "MULT", "DIV", "MOD", "PLUS", "LTEQ", "GTEQ", "LT", 
		"GT", "EQ", "IDEQ", "NEQ", "AND", "OR", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u011c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\20\3\20\7\20\u0090\n\20\f\20\16\20\u0093\13\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u009d\n\21\f\21\16\21\u00a0\13\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		"!\3!\3!\3\"\6\"\u00d2\n\"\r\"\16\"\u00d3\3\"\3\"\3#\3#\5#\u00da\n#\3$"+
		"\3$\3%\3%\7%\u00e0\n%\f%\16%\u00e3\13%\3%\6%\u00e6\n%\r%\16%\u00e7\5%"+
		"\u00ea\n%\3&\3&\3\'\3\'\7\'\u00f0\n\'\f\'\16\'\u00f3\13\'\3\'\3\'\3(\3"+
		"(\7(\u00f9\n(\f(\16(\u00fc\13(\3)\5)\u00ff\n)\3*\3*\5*\u0103\n*\3+\3+"+
		"\3,\3,\3-\5-\u010a\n-\3-\3-\3-\3-\5-\u0110\n-\3.\6.\u0113\n.\r.\16.\u0114"+
		"\3/\3/\6/\u0119\n/\r/\16/\u011a\3\u009e\2\60\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2"+
		"S\2U\2W\2Y\2[\2]\2\3\2\b\4\2\f\f\17\17\5\2\13\f\17\17\"\"\3\2$$\5\2C\\"+
		"aac|\3\2\62;\3\2\63;\2\u0122\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\3_\3\2\2\2\5a\3\2\2\2\7c\3\2\2\2\tf\3\2\2\2\13j\3\2\2\2\rn\3\2\2"+
		"\2\17r\3\2\2\2\21u\3\2\2\2\23x\3\2\2\2\25\177\3\2\2\2\27\u0085\3\2\2\2"+
		"\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2\2\2\37\u008d\3\2\2\2!"+
		"\u0096\3\2\2\2#\u00a7\3\2\2\2%\u00a9\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3"+
		"\2\2\2+\u00af\3\2\2\2-\u00b1\3\2\2\2/\u00b3\3\2\2\2\61\u00b5\3\2\2\2\63"+
		"\u00b8\3\2\2\2\65\u00bb\3\2\2\2\67\u00bd\3\2\2\29\u00bf\3\2\2\2;\u00c2"+
		"\3\2\2\2=\u00c6\3\2\2\2?\u00c9\3\2\2\2A\u00cd\3\2\2\2C\u00d1\3\2\2\2E"+
		"\u00d9\3\2\2\2G\u00db\3\2\2\2I\u00e9\3\2\2\2K\u00eb\3\2\2\2M\u00ed\3\2"+
		"\2\2O\u00f6\3\2\2\2Q\u00fe\3\2\2\2S\u0102\3\2\2\2U\u0104\3\2\2\2W\u0106"+
		"\3\2\2\2Y\u010f\3\2\2\2[\u0112\3\2\2\2]\u0116\3\2\2\2_`\7<\2\2`\4\3\2"+
		"\2\2ab\7.\2\2b\6\3\2\2\2cd\7/\2\2de\7@\2\2e\b\3\2\2\2fg\7g\2\2gh\7p\2"+
		"\2hi\7f\2\2i\n\3\2\2\2jk\7n\2\2kl\7g\2\2lm\7v\2\2m\f\3\2\2\2no\7x\2\2"+
		"op\7c\2\2pq\7t\2\2q\16\3\2\2\2rs\7h\2\2st\7p\2\2t\20\3\2\2\2uv\7k\2\2"+
		"vw\7h\2\2w\22\3\2\2\2xy\7t\2\2yz\7g\2\2z{\7v\2\2{|\7w\2\2|}\7t\2\2}~\7"+
		"p\2\2~\24\3\2\2\2\177\u0080\7y\2\2\u0080\u0081\7j\2\2\u0081\u0082\7k\2"+
		"\2\u0082\u0083\7n\2\2\u0083\u0084\7g\2\2\u0084\26\3\2\2\2\u0085\u0086"+
		"\7?\2\2\u0086\30\3\2\2\2\u0087\u0088\7*\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7+\2\2\u008a\34\3\2\2\2\u008b\u008c\7=\2\2\u008c\36\3\2\2\2\u008d\u0091"+
		"\7%\2\2\u008e\u0090\n\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0094\u0095\b\20\2\2\u0095 \3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098"+
		"\7#\2\2\u0098\u0099\7/\2\2\u0099\u009a\7/\2\2\u009a\u009e\3\2\2\2\u009b"+
		"\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\3"+
		"\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\7/\2\2\u00a2\u00a3\7/\2\2\u00a3\u00a4\7@\2\2\u00a4\u00a5\3\2\2"+
		"\2\u00a5\u00a6\b\21\2\2\u00a6\"\3\2\2\2\u00a7\u00a8\7`\2\2\u00a8$\3\2"+
		"\2\2\u00a9\u00aa\7/\2\2\u00aa&\3\2\2\2\u00ab\u00ac\7#\2\2\u00ac(\3\2\2"+
		"\2\u00ad\u00ae\7,\2\2\u00ae*\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0,\3\2\2"+
		"\2\u00b1\u00b2\7\'\2\2\u00b2.\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\60\3\2"+
		"\2\2\u00b5\u00b6\7?\2\2\u00b6\u00b7\7>\2\2\u00b7\62\3\2\2\2\u00b8\u00b9"+
		"\7@\2\2\u00b9\u00ba\7?\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7>\2\2\u00bc\66"+
		"\3\2\2\2\u00bd\u00be\7@\2\2\u00be8\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0\u00c1"+
		"\7?\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3\u00c4\7?\2\2\u00c4\u00c5"+
		"\7?\2\2\u00c5<\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8\7?\2\2\u00c8>\3"+
		"\2\2\2\u00c9\u00ca\7c\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7f\2\2\u00cc"+
		"@\3\2\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7t\2\2\u00cfB\3\2\2\2\u00d0\u00d2"+
		"\t\3\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\b\"\2\2\u00d6D\3\2\2\2"+
		"\u00d7\u00da\5G$\2\u00d8\u00da\5K&\2\u00d9\u00d7\3\2\2\2\u00d9\u00d8\3"+
		"\2\2\2\u00daF\3\2\2\2\u00db\u00dc\5I%\2\u00dcH\3\2\2\2\u00dd\u00e1\5U"+
		"+\2\u00de\u00e0\5W,\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df"+
		"\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00ea\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e6\7\62\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3"+
		"\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00dd\3\2\2\2\u00e9"+
		"\u00e5\3\2\2\2\u00eaJ\3\2\2\2\u00eb\u00ec\5Y-\2\u00ecL\3\2\2\2\u00ed\u00f1"+
		"\7$\2\2\u00ee\u00f0\n\4\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00f1\3\2"+
		"\2\2\u00f4\u00f5\7$\2\2\u00f5N\3\2\2\2\u00f6\u00fa\5Q)\2\u00f7\u00f9\5"+
		"S*\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fbP\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00ff\t\5\2\2"+
		"\u00fe\u00fd\3\2\2\2\u00ffR\3\2\2\2\u0100\u0103\5Q)\2\u0101\u0103\t\6"+
		"\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103T\3\2\2\2\u0104\u0105"+
		"\t\7\2\2\u0105V\3\2\2\2\u0106\u0107\t\6\2\2\u0107X\3\2\2\2\u0108\u010a"+
		"\5[.\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b"+
		"\u0110\5]/\2\u010c\u010d\5[.\2\u010d\u010e\7\60\2\2\u010e\u0110\3\2\2"+
		"\2\u010f\u0109\3\2\2\2\u010f\u010c\3\2\2\2\u0110Z\3\2\2\2\u0111\u0113"+
		"\5W,\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\\\3\2\2\2\u0116\u0118\7\60\2\2\u0117\u0119\5W,\2"+
		"\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b"+
		"\3\2\2\2\u011b^\3\2\2\2\22\2\u0091\u009e\u00d3\u00d9\u00e1\u00e7\u00e9"+
		"\u00f1\u00fa\u00fe\u0102\u0109\u010f\u0114\u011a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}