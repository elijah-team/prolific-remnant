/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.comp.functionality.f202;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.logging.*;

import java.io.*;

/**
 * Created 8/11/21 6:04 AM
 */
public class DefaultProcessLogEntryBehavior implements ProcessLogEntryBehavior {
	private PrintStream ps;
	private String      s1;

	@Override
	public void processLogEntry(final LogEntry entry) {
		final String logentry = String.format("[%s] [%tD %tT] %s %s", s1, entry.time, entry.time, entry.level, entry.message);
		ps.println(logentry);
	}

	@Override
	public void initialize(final File aLogFile, final String aElLogFileName, final ErrSink aErrSink) {
		try {
			ps = new PrintStream(aLogFile);
			s1 = aElLogFileName;
		} catch (final FileNotFoundException exception) {
			aErrSink.exception(exception);
		}
	}

	@Override
	public void start() {

	}

	@Override
	public void finish() {

	}

	@Override
	public void processPhase(final String aPhase) {
		ps.println(aPhase);
		final StringBuilder sb = new StringBuilder(aPhase.length());
		for (int i = 0; i < aPhase.length(); i++) {
			sb.append('=');
		}
		ps.println(sb);
	}

	@Override
	public void donePhase() {
		ps.println();
	}
}

//
//
//
