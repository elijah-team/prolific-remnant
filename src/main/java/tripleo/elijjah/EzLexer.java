// $ANTLR 2.7.7 (20060906): "ez.g" -> "EzLexer.java"$

package tripleo.elijjah;

import antlr.*;
import antlr.collections.impl.BitSet;

import java.io.*;
import java.util.*;

public class EzLexer extends antlr.CharScanner implements EzTokenTypes, TokenStream {
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());

	public EzLexer(final InputStream in) {
		this(new ByteBuffer(in));
	}

	public EzLexer(final InputBuffer ib) {
		this(new LexerSharedInputState(ib));
	}

	public EzLexer(final LexerSharedInputState state) {
		super(state);
		caseSensitiveLiterals = true;
		setCaseSensitive(true);
		literals = new Hashtable();
		literals.put(new ANTLRHashString("lib", this), Integer.valueOf(9));
		literals.put(new ANTLRHashString("this", this), Integer.valueOf(62));
		literals.put(new ANTLRHashString("false", this), Integer.valueOf(61));
		literals.put(new ANTLRHashString("true", this), Integer.valueOf(60));
		literals.put(new ANTLRHashString("indexing", this), Integer.valueOf(16));
		literals.put(new ANTLRHashString("generate", this), Integer.valueOf(15));
		literals.put(new ANTLRHashString("end", this), Integer.valueOf(8));
		literals.put(new ANTLRHashString("libraries", this), Integer.valueOf(10));
		literals.put(new ANTLRHashString("null", this), Integer.valueOf(63));
		literals.put(new ANTLRHashString("library", this), Integer.valueOf(5));
		literals.put(new ANTLRHashString("shared", this), Integer.valueOf(6));
		literals.put(new ANTLRHashString("program", this), Integer.valueOf(4));
	}

	public EzLexer(final Reader in) {
		this(new CharBuffer(in));
	}

	private static final long[] mk_tokenSet_0() {
		final long[] data = new long[8];
		data[0] = -9217L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	private static final long[] mk_tokenSet_1() {
		final long[] data = new long[8];
		data[0] = -4398046520321L;
		for (int i = 1; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	private static final long[] mk_tokenSet_2() {
		final long[] data = new long[8];
		data[0] = -549755813889L;
		data[1] = -268435457L;
		for (int i = 2; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	private static final long[] mk_tokenSet_3() {
		final long[] data = new long[8];
		data[0] = -17179869185L;
		data[1] = -268435457L;
		for (int i = 2; i <= 3; i++) {
			data[i] = -1L;
		}
		return data;
	}

	private static final long[] mk_tokenSet_4() {
		final long[] data = {0L, 343597383760L, 0L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_5() {
		final long[] data = {287948901175001088L, 541165879422L, 0L, 0L, 0L};
		return data;
	}

	private static final long[] mk_tokenSet_6() {
		final long[] data = {70368744177664L, 481036337264L, 0L, 0L, 0L};
		return data;
	}

	public Token nextToken() throws TokenStreamException {
		Token theRetToken = null;
tryAgain:
		for (; ; ) {
			final Token _token = null;
			int         _ttype = Token.INVALID_TYPE;
			resetText();
			try {   // for char stream error handling
				try {   // for lexical error handling
					switch (LA(1)) {
					case '?': {
						mQUESTION(true);
						theRetToken = _returnToken;
						break;
					}
					case '(': {
						mLPAREN(true);
						theRetToken = _returnToken;
						break;
					}
					case ')': {
						mRPAREN(true);
						theRetToken = _returnToken;
						break;
					}
					case '[': {
						mLBRACK(true);
						theRetToken = _returnToken;
						break;
					}
					case ']': {
						mRBRACK(true);
						theRetToken = _returnToken;
						break;
					}
					case '{': {
						mLCURLY(true);
						theRetToken = _returnToken;
						break;
					}
					case '}': {
						mRCURLY(true);
						theRetToken = _returnToken;
						break;
					}
					case ':': {
						mTOK_COLON(true);
						theRetToken = _returnToken;
						break;
					}
					case ',': {
						mCOMMA(true);
						theRetToken = _returnToken;
						break;
					}
					case '~': {
						mBNOT(true);
						theRetToken = _returnToken;
						break;
					}
					case ';': {
						mSEMI(true);
						theRetToken = _returnToken;
						break;
					}
					case '#': {
						mANNOT(true);
						theRetToken = _returnToken;
						break;
					}
					case '\t':
					case '\n':
					case '\u000c':
					case '\r':
					case ' ': {
						mWS(true);
						theRetToken = _returnToken;
						break;
					}
					case '\'': {
						mCHAR_LITERAL(true);
						theRetToken = _returnToken;
						break;
					}
					case '"': {
						mSTRING_LITERAL(true);
						theRetToken = _returnToken;
						break;
					}
					case '$':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'G':
					case 'H':
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
					case '_':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'g':
					case 'h':
					case 'i':
					case 'j':
					case 'k':
					case 'l':
					case 'm':
					case 'n':
					case 'o':
					case 'p':
					case 'q':
					case 'r':
					case 's':
					case 't':
					case 'u':
					case 'v':
					case 'w':
					case 'x':
					case 'y':
					case 'z': {
						mIDENT(true);
						theRetToken = _returnToken;
						break;
					}
					case '.':
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9': {
						mNUM_INT(true);
						theRetToken = _returnToken;
						break;
					}
					default:
						if ((LA(1) == '>') && (LA(2) == '>') && (LA(3) == '>') && (LA(4) == '=')) {
							mBSR_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '>') && (LA(2) == '>') && (LA(3) == '=')) {
							mSR_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '>') && (LA(2) == '>') && (LA(3) == '>')) {
							mBSR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '<') && (LA(2) == '<') && (LA(3) == '=')) {
							mSL_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '=') && (LA(2) == '=')) {
							mEQUAL(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '!') && (LA(2) == '=')) {
							mNOT_EQUAL(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '/') && (LA(2) == '=')) {
							mDIV_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '+') && (LA(2) == '=')) {
							mPLUS_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '+') && (LA(2) == '+')) {
							mINC(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '-') && (LA(2) == '>')) {
							mTOK_ARROW(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '-') && (LA(2) == '=')) {
							mMINUS_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '-') && (LA(2) == '-')) {
							mDEC(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '*') && (LA(2) == '=')) {
							mSTAR_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '%') && (LA(2) == '=')) {
							mMOD_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '>') && (LA(2) == '>')) {
							mSR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '>') && (LA(2) == '=')) {
							mGE(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '<') && (LA(2) == '<')) {
							mSL(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '<') && (LA(2) == '=')) {
							mLE(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '^') && (LA(2) == '=')) {
							mBXOR_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '|') && (LA(2) == '=')) {
							mBOR_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '|') && (LA(2) == '|')) {
							mLOR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '&') && (LA(2) == '=')) {
							mBAND_ASSIGN(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '&') && (LA(2) == '&')) {
							mLAND(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '/') && (LA(2) == '/')) {
							mSL_COMMENT(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '/') && (LA(2) == '*')) {
							mML_COMMENT(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '=')) {
							mBECOMES(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '!')) {
							mLNOT(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '/')) {
							mDIV(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '+')) {
							mPLUS(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '-')) {
							mMINUS(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '*')) {
							mSTAR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '%')) {
							mMOD(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '>')) {
							mGT(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '<')) {
							mLT_(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '^')) {
							mBXOR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '|')) {
							mBOR(true);
							theRetToken = _returnToken;
						} else if ((LA(1) == '&')) {
							mBAND(true);
							theRetToken = _returnToken;
						} else {
							if (LA(1) == EOF_CHAR) {
								uponEOF();
								_returnToken = makeToken(Token.EOF_TYPE);
							} else {
								throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
							}
						}
					}
					if (_returnToken == null) continue tryAgain; // found SKIP token
					_ttype = _returnToken.getType();
					_returnToken.setType(_ttype);
					return _returnToken;
				} catch (final RecognitionException e) {
					throw new TokenStreamRecognitionException(e);
				}
			} catch (final CharStreamException cse) {
				if (cse instanceof CharStreamIOException) {
					throw new TokenStreamIOException(((CharStreamIOException) cse).io);
				} else {
					throw new TokenStreamException(cse.getMessage());
				}
			}
		}
	}

	public final void mQUESTION(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = QUESTION;
		int _saveIndex;

		match('?');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLPAREN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LPAREN;
		int _saveIndex;

		match('(');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRPAREN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = RPAREN;
		int _saveIndex;

		match(')');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLBRACK(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LBRACK;
		int _saveIndex;

		match('[');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRBRACK(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = RBRACK;
		int _saveIndex;

		match(']');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLCURLY(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LCURLY;
		int _saveIndex;

		match('{');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mRCURLY(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = RCURLY;
		int _saveIndex;

		match('}');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mTOK_COLON(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = TOK_COLON;
		int _saveIndex;

		match(':');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCOMMA(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = COMMA;
		int _saveIndex;

		match(',');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBECOMES(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BECOMES;
		int _saveIndex;

		match('=');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mEQUAL(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = EQUAL;
		int _saveIndex;

		match("==");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLNOT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LNOT;
		int _saveIndex;

		match('!');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBNOT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BNOT;
		int _saveIndex;

		match('~');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mNOT_EQUAL(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = NOT_EQUAL;
		int _saveIndex;

		match("!=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDIV(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = DIV;
		int _saveIndex;

		match('/');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDIV_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = DIV_ASSIGN;
		int _saveIndex;

		match("/=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mPLUS(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = PLUS;
		int _saveIndex;

		match('+');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mPLUS_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = PLUS_ASSIGN;
		int _saveIndex;

		match("+=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mINC(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = INC;
		int _saveIndex;

		match("++");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mTOK_ARROW(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = TOK_ARROW;
		int _saveIndex;

		match("->");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mMINUS(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = MINUS;
		int _saveIndex;

		match('-');
		{
			if ((LA(1) == '>')) {
				match('>');
				_ttype = TOK_ARROW;
			} else {
			}

		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mMINUS_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = MINUS_ASSIGN;
		int _saveIndex;

		match("-=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mDEC(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = DEC;
		int _saveIndex;

		match("--");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSTAR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = STAR;
		int _saveIndex;

		match('*');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSTAR_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = STAR_ASSIGN;
		int _saveIndex;

		match("*=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mMOD(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = MOD;
		int _saveIndex;

		match('%');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mMOD_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = MOD_ASSIGN;
		int _saveIndex;

		match("%=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SR;
		int _saveIndex;

		match(">>");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSR_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SR_ASSIGN;
		int _saveIndex;

		match(">>=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBSR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BSR;
		int _saveIndex;

		match(">>>");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBSR_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BSR_ASSIGN;
		int _saveIndex;

		match(">>>=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mGE(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = GE;
		int _saveIndex;

		match(">=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mGT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = GT;
		int _saveIndex;

		match(">");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSL(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SL;
		int _saveIndex;

		match("<<");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSL_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SL_ASSIGN;
		int _saveIndex;

		match("<<=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLE(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LE;
		int _saveIndex;

		match("<=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLT_(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LT_;
		int _saveIndex;

		match('<');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBXOR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BXOR;
		int _saveIndex;

		match('^');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBXOR_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BXOR_ASSIGN;
		int _saveIndex;

		match("^=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBOR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BOR;
		int _saveIndex;

		match('|');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBOR_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BOR_ASSIGN;
		int _saveIndex;

		match("|=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLOR(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LOR;
		int _saveIndex;

		match("||");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBAND(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BAND;
		int _saveIndex;

		match('&');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mBAND_ASSIGN(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = BAND_ASSIGN;
		int _saveIndex;

		match("&=");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mLAND(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = LAND;
		int _saveIndex;

		match("&&");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSEMI(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SEMI;
		int _saveIndex;

		match(';');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mANNOT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = ANNOT;
		int _saveIndex;

		match("#[");
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mWS(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = WS;
		int _saveIndex;

		{
			switch (LA(1)) {
			case ' ': {
				match(' ');
				break;
			}
			case '\t': {
				match('\t');
				break;
			}
			case '\u000c': {
				match('\f');
				break;
			}
			case '\n':
			case '\r': {
				{
					if ((LA(1) == '\r') && (LA(2) == '\n')) {
						match("\r\n");
					} else if ((LA(1) == '\r')) {
						match('\r');
					} else if ((LA(1) == '\n')) {
						match('\n');
					} else {
						throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
					}

				}
				newline();
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		_ttype = Token.SKIP;
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSL_COMMENT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;

		match("//");
		{
_loop152:
			do {
				if ((_tokenSet_0.member(LA(1)))) {
					{
						match(_tokenSet_0);
					}
				} else {
					break;
				}

			} while (true);
		}
		{
			switch (LA(1)) {
			case '\n': {
				match('\n');
				break;
			}
			case '\r': {
				match('\r');
				{
					if ((LA(1) == '\n')) {
						match('\n');
					} else {
					}

				}
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		_ttype = Token.SKIP;
		newline();
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mML_COMMENT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;

		match("/*");
		{
_loop158:
			do {
				if ((LA(1) == '\r') && (LA(2) == '\n') && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff')) && ((LA(4) >= '\u0000' && LA(4) <= '\u00ff'))) {
					match('\r');
					match('\n');
					newline();
				} else if (((LA(1) == '*') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff'))) && (LA(2) != '/')) {
					match('*');
				} else if ((LA(1) == '\r') && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff')) && ((LA(3) >= '\u0000' && LA(3) <= '\u00ff'))) {
					match('\r');
					newline();
				} else if ((LA(1) == '\n')) {
					match('\n');
					newline();
				} else if ((_tokenSet_1.member(LA(1)))) {
					{
						match(_tokenSet_1);
					}
				} else {
					break;
				}

			} while (true);
		}
		match("*/");
		_ttype = Token.SKIP;
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mCHAR_LITERAL(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = CHAR_LITERAL;
		int _saveIndex;

		match('\'');
		{
			if ((LA(1) == '\\')) {
				mESC(false);
			} else if ((_tokenSet_2.member(LA(1)))) {
				matchNot('\'');
			} else {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}

		}
		match('\'');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mESC(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = ESC;
		int _saveIndex;

		match('\\');
		{
			switch (LA(1)) {
			case 'n': {
				match('n');
				break;
			}
			case 'r': {
				match('r');
				break;
			}
			case 't': {
				match('t');
				break;
			}
			case 'b': {
				match('b');
				break;
			}
			case 'f': {
				match('f');
				break;
			}
			case '"': {
				match('"');
				break;
			}
			case '\'': {
				match('\'');
				break;
			}
			case '\\': {
				match('\\');
				break;
			}
			case 'u': {
				{
					int _cnt168 = 0;
_loop168:
					do {
						if ((LA(1) == 'u')) {
							match('u');
						} else {
							if (_cnt168 >= 1) {
								break;
							} else {
								throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
							}
						}

						_cnt168++;
					} while (true);
				}
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				mHEX_DIGIT(false);
				break;
			}
			case '0':
			case '1':
			case '2':
			case '3': {
				{
					matchRange('0', '3');
				}
				{
					if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff'))) {
						{
							matchRange('0', '7');
						}
						{
							if (((LA(1) >= '0' && LA(1) <= '7')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff'))) {
								matchRange('0', '7');
							} else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff'))) {
							} else {
								throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
							}

						}
					} else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff'))) {
					} else {
						throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
					}

				}
				break;
			}
			case '4':
			case '5':
			case '6':
			case '7': {
				{
					matchRange('4', '7');
				}
				{
					if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0000' && LA(2) <= '\u00ff'))) {
						{
							matchRange('0', '9');
						}
					} else if (((LA(1) >= '\u0000' && LA(1) <= '\u00ff'))) {
					} else {
						throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
					}

				}
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mSTRING_LITERAL(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = STRING_LITERAL;
		int _saveIndex;

		match('"');
		{
_loop164:
			do {
				if ((LA(1) == '\\')) {
					mESC(false);
				} else if ((_tokenSet_3.member(LA(1)))) {
					{
						match(_tokenSet_3);
					}
				} else {
					break;
				}

			} while (true);
		}
		match('"');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mHEX_DIGIT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = HEX_DIGIT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				matchRange('0', '9');
				break;
			}
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F': {
				matchRange('A', 'F');
				break;
			}
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f': {
				matchRange('a', 'f');
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mVOCAB(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = VOCAB;
		int _saveIndex;

		matchRange('\3', '\377');
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mIDENT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = IDENT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z': {
				matchRange('a', 'z');
				break;
			}
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z': {
				matchRange('A', 'Z');
				break;
			}
			case '_': {
				match('_');
				break;
			}
			case '$': {
				match('$');
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		{
_loop182:
			do {
				switch (LA(1)) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'u':
				case 'v':
				case 'w':
				case 'x':
				case 'y':
				case 'z': {
					matchRange('a', 'z');
					break;
				}
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z': {
					matchRange('A', 'Z');
					break;
				}
				case '_': {
					match('_');
					break;
				}
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					matchRange('0', '9');
					break;
				}
				case '$': {
					match('$');
					break;
				}
				default: {
					break _loop182;
				}
				}
			} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	public final void mNUM_INT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int       _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = NUM_INT;
		int     _saveIndex;
		boolean isDecimal = false;

		switch (LA(1)) {
		case '.': {
			match('.');
			_ttype = DOT;
			{
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					{
						int _cnt186 = 0;
_loop186:
						do {
							if (((LA(1) >= '0' && LA(1) <= '9'))) {
								matchRange('0', '9');
							} else {
								if (_cnt186 >= 1) {
									break;
								} else {
									throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
								}
							}

							_cnt186++;
						} while (true);
					}
					{
						if ((LA(1) == 'E' || LA(1) == 'e')) {
							mEXPONENT(false);
						} else {
						}

					}
					{
						if ((_tokenSet_4.member(LA(1)))) {
							mFLOAT_SUFFIX(false);
						} else {
						}

					}
					_ttype = NUM_FLOAT;
				} else {
				}

			}
			break;
		}
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': {
			{
				switch (LA(1)) {
				case '0': {
					match('0');
					isDecimal = true;
					{
						switch (LA(1)) {
						case 'X':
						case 'x': {
							{
								switch (LA(1)) {
								case 'x': {
									match('x');
									break;
								}
								case 'X': {
									match('X');
									break;
								}
								default: {
									throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
								}
								}
							}
							{
								int _cnt193 = 0;
_loop193:
								do {
									if ((_tokenSet_5.member(LA(1)))) {
										mHEX_DIGIT(false);
									} else {
										if (_cnt193 >= 1) {
											break;
										} else {
											throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
										}
									}

									_cnt193++;
								} while (true);
							}
							break;
						}
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7': {
							{
								int _cnt195 = 0;
_loop195:
								do {
									if (((LA(1) >= '0' && LA(1) <= '7'))) {
										matchRange('0', '7');
									} else {
										if (_cnt195 >= 1) {
											break;
										} else {
											throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
										}
									}

									_cnt195++;
								} while (true);
							}
							break;
						}
						default: {
						}
						}
					}
					break;
				}
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9': {
					{
						matchRange('1', '9');
					}
					{
_loop198:
						do {
							switch (LA(1)) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9': {
								matchRange('0', '9');
								break;
							}
							case '_': {
								match('_');
								break;
							}
							default: {
								break _loop198;
							}
							}
						} while (true);
					}
					isDecimal = true;
					break;
				}
				default: {
					throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
				}
				}
			}
			{
				switch (LA(1)) {
				case 'L':
				case 'l': {
					{
						switch (LA(1)) {
						case 'l': {
							match('l');
							break;
						}
						case 'L': {
							match('L');
							break;
						}
						default: {
							throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
						}
						}
					}
					break;
				}
				case 'i':
				case 'u': {
					{
						switch (LA(1)) {
						case 'u': {
							match('u');
							break;
						}
						case 'i': {
							match('i');
							break;
						}
						default: {
							throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
						}
						}
					}
					{
						switch (LA(1)) {
						case '8': {
							match("8");
							break;
						}
						case '1': {
							match("16");
							break;
						}
						case '3': {
							match("32");
							break;
						}
						case '6': {
							match("64");
							break;
						}
						case 's': {
							match("size");
							break;
						}
						default: {
							throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
						}
						}
					}
					break;
				}
				default:
					if (((_tokenSet_6.member(LA(1)))) && (isDecimal)) {
						{
							switch (LA(1)) {
							case '.': {
								match('.');
								{
_loop205:
									do {
										if (((LA(1) >= '0' && LA(1) <= '9'))) {
											matchRange('0', '9');
										} else {
											break;
										}

									} while (true);
								}
								{
									if ((LA(1) == 'E' || LA(1) == 'e')) {
										mEXPONENT(false);
									} else {
									}

								}
								{
									if ((_tokenSet_4.member(LA(1)))) {
										mFLOAT_SUFFIX(false);
									} else {
									}

								}
								break;
							}
							case 'E':
							case 'e': {
								mEXPONENT(false);
								{
									if ((_tokenSet_4.member(LA(1)))) {
										mFLOAT_SUFFIX(false);
									} else {
									}

								}
								break;
							}
							case 'D':
							case 'F':
							case 'd':
							case 'f': {
								mFLOAT_SUFFIX(false);
								break;
							}
							default: {
								throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
							}
							}
						}
						_ttype = NUM_FLOAT;
					} else {
					}
				}
			}
			break;
		}
		default: {
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mEXPONENT(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = EXPONENT;
		int _saveIndex;

		{
			switch (LA(1)) {
			case 'e': {
				match('e');
				break;
			}
			case 'E': {
				match('E');
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		{
			switch (LA(1)) {
			case '+': {
				match('+');
				break;
			}
			case '-': {
				match('-');
				break;
			}
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				break;
			}
			default: {
				throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
			}
			}
		}
		{
			int _cnt213 = 0;
_loop213:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					matchRange('0', '9');
				} else {
					if (_cnt213 >= 1) {
						break;
					} else {
						throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
					}
				}

				_cnt213++;
			} while (true);
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

	protected final void mFLOAT_SUFFIX(final boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		final int _ttype;
		Token     _token = null;
		final int _begin = text.length();
		_ttype = FLOAT_SUFFIX;
		int _saveIndex;

		switch (LA(1)) {
		case 'f': {
			match('f');
			break;
		}
		case 'F': {
			match('F');
			break;
		}
		case 'd': {
			match('d');
			break;
		}
		case 'D': {
			match('D');
			break;
		}
		default: {
			throw new NoViableAltForCharException(LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if (_createToken && _token == null && _ttype != Token.SKIP) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length() - _begin));
		}
		_returnToken = _token;
	}

}
