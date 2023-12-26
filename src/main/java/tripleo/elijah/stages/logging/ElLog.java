/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.logging;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.compiler_model.CM_Filename;
import tripleo.elijah.util.SimplePrintLoggerToRemoveSoon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 8/3/21 3:46 AM
 */
public class ElLog {
	private final List<LogEntry> entries = new ArrayList<>();
	private final Verbosity      verbose;
	private final CM_Filename fileName;
	private final String         phase;

	public ElLog(final CM_Filename aFileName, final Verbosity aVerbosity, final String aPhase) {
		fileName = aFileName;
		verbose  = aVerbosity;
		phase    = aPhase;
	}

	public @NotNull List<LogEntry> getEntries() {
		return entries;
	}

	public ElLog(String aFileName, Verbosity aVerbose, String aPhase) {
		fileName = CM_Filename.of(aFileName);
		verbose  = aVerbose;
		phase    = aPhase;
	}

	public void err(String aMessage) {
		long time = System.currentTimeMillis();
		entries.add(new LogEntry(time, LogEntry.Level.ERROR, aMessage));
		if (verbose == Verbosity.VERBOSE)
			SimplePrintLoggerToRemoveSoon.println_err_2(aMessage);
	}

	public String getFileName() {
		return fileName.getString();
	}

	public String getPhase() {
		return phase;
	}

	public enum Verbosity {
		SILENT, VERBOSE
	}

	public void info(String aMessage) {
		long time = System.currentTimeMillis();
		entries.add(new LogEntry(time, LogEntry.Level.INFO, aMessage));
		if (verbose == Verbosity.VERBOSE)
			SimplePrintLoggerToRemoveSoon.println_out_2(aMessage);
	}
}

//
//
//
