/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang.impl.*;
import tripleo.elijah.util.*;

public class Out {
	@Contract(pure = true)
	public static void println(final String s) {
		SimplePrintLoggerToRemoveSoon.println_out_2(s);
	}

	private final @NotNull ParserClosure pc;

	public Out(final String fn, final @NotNull Compilation aCompilation) {
		pc     = new ParserClosureImpl(fn, aCompilation);
	}

	public @NotNull ParserClosure closure() {
		return pc;
	}

	public void FinishModule() {
		pc.module().finish();
	}

	public @NotNull OS_Module module() {
		return pc.module();
	}
}

//
//
//
