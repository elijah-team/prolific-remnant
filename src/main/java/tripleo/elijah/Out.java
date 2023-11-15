/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.util.*;

public class Out {

//	private final Compilation compilation;
//	private boolean do_out = false;

	private final ParserClosure pc;

/*
	private static TabbedOutputStream getTOSLog() throws FileNotFoundException {
		final @NotNull SimpleDateFormat sdf      = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		final String                    filename = String.format("eljc-%s.out", sdf.format(new Date()));
		return new TabbedOutputStream(new FileOutputStream(filename));
	}
*/

	public Out(final String fn, final Compilation compilation, final boolean do_out) {
		pc = new ParserClosure(fn, compilation);
//		this.compilation = compilation;
//		this.do_out = do_out;
	}

	public static void println(final String s) {
		SimplePrintLoggerToRemoveSoon.println2(s);
	}

	//@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("NM_METHOD_NAMING_CONVENTION")
	public void FinishModule() {
/*
		final TabbedOutputStream tos;
		println("** FinishModule");
		try {
*/
//			pc.module.print_osi(tos);
		pc.module.finish();
		//
/*
			if (do_out) {
				tos = getTOSLog();
	    		tos.put_string_ln(pc.module.getFileName());
				Helpers.printXML(pc.module, tos);
				tos.close();
			}
*/
		//
		//
/*
		} catch (final FileNotFoundException fnfe) {
			println("&& FileNotFoundException");
		} catch (final IOException ioe) {
			println("&& IOException");
		}
*/
	}

	public ParserClosure closure() {
		return pc;
	}

	public @NotNull OS_Module module() {
		return pc.module;
	}
}

//
//
//
