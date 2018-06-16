// Generated from C:/Users/stefa/IdeaProjects/ksrc/src/de/skerkewitz/ksrc/antlr\KSrc.g4 by ANTLR 4.7
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
		FLOAT_NUMBER=18, NAME=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "LET", "FUNC", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", 
		"FLOAT_NUMBER", "NAME", "ID_START", "ID_CONTINUE", "NON_ZERO_DIGIT", "DIGIT", 
		"POINT_FLOAT", "INT_PART", "FRACTION"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", "','", "'{'", "'}'", 
		"'let'", "'fn'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "LET", 
		"FUNC", "ASSIGN", "WS", "NUMBER", "INTEGER", "DECIMAL_INTEGER", "FLOAT_NUMBER", 
		"NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0097\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16"+
		"\3\16\3\17\6\17V\n\17\r\17\16\17W\3\17\3\17\3\20\3\20\5\20^\n\20\3\21"+
		"\3\21\3\22\3\22\7\22d\n\22\f\22\16\22g\13\22\3\22\6\22j\n\22\r\22\16\22"+
		"k\5\22n\n\22\3\23\3\23\3\24\3\24\7\24t\n\24\f\24\16\24w\13\24\3\25\5\25"+
		"z\n\25\3\26\3\26\5\26~\n\26\3\27\3\27\3\30\3\30\3\31\5\31\u0085\n\31\3"+
		"\31\3\31\3\31\3\31\5\31\u008b\n\31\3\32\6\32\u008e\n\32\r\32\16\32\u008f"+
		"\3\33\3\33\6\33\u0094\n\33\r\33\16\33\u0095\2\2\34\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\2+\2-\2/\2\61\2\63\2\65\2\3\2\6\5\2\13\f\17\17\"\"\5\2C\\aac|\3\2"+
		"\62;\3\2\63;\2\u009a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3\67\3\2\2\2\59\3\2\2"+
		"\2\7;\3\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2"+
		"\2\23G\3\2\2\2\25I\3\2\2\2\27K\3\2\2\2\31O\3\2\2\2\33R\3\2\2\2\35U\3\2"+
		"\2\2\37]\3\2\2\2!_\3\2\2\2#m\3\2\2\2%o\3\2\2\2\'q\3\2\2\2)y\3\2\2\2+}"+
		"\3\2\2\2-\177\3\2\2\2/\u0081\3\2\2\2\61\u008a\3\2\2\2\63\u008d\3\2\2\2"+
		"\65\u0091\3\2\2\2\678\7=\2\28\4\3\2\2\29:\7,\2\2:\6\3\2\2\2;<\7\61\2\2"+
		"<\b\3\2\2\2=>\7-\2\2>\n\3\2\2\2?@\7/\2\2@\f\3\2\2\2AB\7*\2\2B\16\3\2\2"+
		"\2CD\7+\2\2D\20\3\2\2\2EF\7.\2\2F\22\3\2\2\2GH\7}\2\2H\24\3\2\2\2IJ\7"+
		"\177\2\2J\26\3\2\2\2KL\7n\2\2LM\7g\2\2MN\7v\2\2N\30\3\2\2\2OP\7h\2\2P"+
		"Q\7p\2\2Q\32\3\2\2\2RS\7?\2\2S\34\3\2\2\2TV\t\2\2\2UT\3\2\2\2VW\3\2\2"+
		"\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\b\17\2\2Z\36\3\2\2\2[^\5!\21\2\\^\5"+
		"%\23\2][\3\2\2\2]\\\3\2\2\2^ \3\2\2\2_`\5#\22\2`\"\3\2\2\2ae\5-\27\2b"+
		"d\5/\30\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fn\3\2\2\2ge\3\2\2\2"+
		"hj\7\62\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2ma\3\2\2"+
		"\2mi\3\2\2\2n$\3\2\2\2op\5\61\31\2p&\3\2\2\2qu\5)\25\2rt\5+\26\2sr\3\2"+
		"\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v(\3\2\2\2wu\3\2\2\2xz\t\3\2\2yx\3\2"+
		"\2\2z*\3\2\2\2{~\5)\25\2|~\t\4\2\2}{\3\2\2\2}|\3\2\2\2~,\3\2\2\2\177\u0080"+
		"\t\5\2\2\u0080.\3\2\2\2\u0081\u0082\t\4\2\2\u0082\60\3\2\2\2\u0083\u0085"+
		"\5\63\32\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2"+
		"\u0086\u008b\5\65\33\2\u0087\u0088\5\63\32\2\u0088\u0089\7\60\2\2\u0089"+
		"\u008b\3\2\2\2\u008a\u0084\3\2\2\2\u008a\u0087\3\2\2\2\u008b\62\3\2\2"+
		"\2\u008c\u008e\5/\30\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u008f\u0090\3\2\2\2\u0090\64\3\2\2\2\u0091\u0093\7\60\2\2\u0092"+
		"\u0094\5/\30\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\66\3\2\2\2\17\2W]ekmuy}\u0084\u008a\u008f"+
		"\u0095\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}