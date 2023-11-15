/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.util;

import antlr.*;
import org.apache.commons.codec.digest.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.lang.*;
import tripleo.elijjah.*;

import java.io.*;
import java.security.*;
import java.util.*;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.*;

/**
 * Created 9/10/20 3:44 PM
 */
public class Helpers {
	public static void printXML(final Object obj, @NotNull final TabbedOutputStream tos) {
		SimplePrintLoggerToRemoveSoon.println_err2("** XStream support has been disabled");
/*
		final XStream x = new XStream();
		//x.setMode(XStream.ID_REFERENCES);
		x.toXML(obj, tos.getStream());
*/
	}

	@NotNull
	public static <E> List<E> List_of(@NotNull final E... e1) {
		final List<E> r = new ArrayList<E>();
		Collections.addAll(r, e1);
		return r;
	}

	public static IExpression qualidentToDotExpression2(@NotNull final Qualident q) {
		return qualidentToDotExpression2(q.parts(), 1);
	}

	public static @Nullable IExpression qualidentToDotExpression2(@NotNull final List<IdentExpression> ts) {
		return qualidentToDotExpression2(ts, 1);
	}

	public static IExpression qualidentToDotExpression2(@NotNull final List<IdentExpression> ts, int i) {
		if (ts.size() == 1) return ts.get(0);
		if (ts.size() == 0) return null;
		IExpression r = ts.get(0);
//		int i=1;
		while (ts.size() > i) {
			final IExpression dotExpression = qualidentToDotExpression2(ts.subList(i++, ts.size()), i + 1);
			if (dotExpression == null) break;
//			r.setRight(dotExpression);
			r = new DotExpression(r, dotExpression);
		}
		return r;
	}

	public static Token makeToken(final String aText) {
		final CommonToken t = new CommonToken();
		t.setText(aText);
		return t;
	}

	@NotNull
	public static String remove_single_quotes_from_string(final @NotNull String s) {
		assert s.length() >= 3;
		return s.substring(1, s.length() - 1);
	}

	public static String String_join(final String separator, final Iterable<String> stringIterable) {
		if (false) {
			final StringBuilder sb = new StringBuilder();

			for (final String part : stringIterable) {
				sb.append(part);
				sb.append(separator);
			}
			final String          ss        = sb.toString();
			final @NotNull String substring = separator.substring(0, ss.length() - separator.length());
			return substring;
		}
		// since Java 1.8
		return String.join(separator, stringIterable);
	}

	public static Qualident string_to_qualident(final String x) {
		final Qualident q = new Qualident();
		for (final String xx : x.split("\\.")) {
			q.append(string_to_ident(xx));
		}
		return q;
	}

	@NotNull
	public static IdentExpression string_to_ident(final String txt) {
		final CommonToken t = new CommonToken(ElijjahTokenTypes.IDENT, txt);
		return new IdentExpression(t);
	}

	public static String getHashForFilename(final String aFilename, final ErrSink aErrSink) throws IOException {
		final String hdigest = new DigestUtils(SHA_256).digestAsHex(new File(aFilename));
		return hdigest;
	}

	@Nullable
	public static String getHashForFilenameJava(final @NotNull String aFilename, final ErrSink aErrSink) throws IOException {
		final File      file = new File(aFilename);
		final long      size = file.length();
		final byte[]    ba   = new byte[(int) size];  // README Counting on reasonable sizes here
		FileInputStream bb   = null;
		try {
			bb = new FileInputStream(file);
			bb.read(ba);

			try {
				final String hh = getHash(ba);
				return hh;
			} catch (final NoSuchAlgorithmException aE) {
				aErrSink.exception(aE);
//				aE.printStackTrace();
			}
		} finally {
			if (bb != null)
				bb.close();
		}
		return null;
	}

	public static String getHash(final byte[] aBytes) throws NoSuchAlgorithmException {
		final MessageDigest md = MessageDigest.getInstance("SHA-256");

//		String input;
//		md.update(input.getBytes(StandardCharsets.UTF_8));
		md.update(aBytes);

		final byte[] hashBytes = md.digest();

		final StringBuilder sb = new StringBuilder();
		for (final byte b : hashBytes) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();
	}
}

//
//
//
