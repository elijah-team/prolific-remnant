/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.comp.functionality.f202;

import tripleo.elijah.comp.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah_prolific.v.V;

import java.io.*;
import java.util.*;

/**
 * Created 8/11/21 5:46 AM
 */
public class F202 {
	final         GetLogDirectoryBehavior gld;
	final         GetLogNameBehavior      gln;
	final         ProcessLogEntryBehavior ple;
	final         ProgressBehavior        pre;
	private final ErrSink                 errSink;

	public F202(final ErrSink aErrSink, final Compilation c) {
		errSink = aErrSink;
		gld     = new DefaultGetLogDirectoryBehavior(c);
		gln     = new DefaultGetLogNameBehavior();
		ple     = new DefaultProcessLogEntryBehavior();
		pre     = new DefaultProgressBehavior();
	}

	public void processLogs(final Collection<ElLog> aElLogs) {
		if (aElLogs.size() == 0) return; // TODO progress message? should be impossible anyway

		final ElLog firstLog = aElLogs.iterator().next();

		final String s2    = gln.getLogName(firstLog);
		final File   file2 = gld.getLogDirectory();

		final File   psf = new File(file2, s2);
		final String s1  = firstLog.getFileName();
		final String a = psf.toString();
		pre.reportProgress(a);
		V.asv(V.e.f202_writing_logs, a);

		ple.initialize(psf, s1, errSink);
		ple.start();
		for (final ElLog elLog : aElLogs) {
			ple.processPhase(elLog.getPhase());

			for (final LogEntry entry : elLog.getEntries()) {
				ple.processLogEntry(entry);
			}

			ple.donePhase();
		}
		ple.finish();
	}
}

//
//
//
