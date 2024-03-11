/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.comp.functionality.f202;

import tripleo.elijah.comp.*;
import tripleo.elijah.comp.functionality.f203.*;
import tripleo.elijah_prolific_durable.comp.Compilation;
import tripleo.elijah_prolific_durable.comp.functionality.f203.F203;

import java.io.*;

/**
 * Created 8/11/21 5:55 AM
 */
public class DefaultGetLogDirectoryBehavior implements GetLogDirectoryBehavior {
	private final Compilation c;

	public DefaultGetLogDirectoryBehavior(final Compilation aCompilation) {
		c = aCompilation;
	}

	@Override
	public File getLogDirectory() {
//		final File file1 = new File("COMP", c.getCompilationNumberString());
		final File file1 = new F203(c.getErrSink(), c).chooseDirectory();
		final File file2 = new File(file1, "logs");
		file2.mkdirs();

		return file2;
	}
}

//
//
//
