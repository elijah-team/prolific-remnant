/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.comp;

import org.jetbrains.annotations.NotNull;
import tripleo.util.io.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class IO {

	// exists, delete, isType ....

	public final List<File> recordedreads  = new ArrayList<File>();
	final        List<File> recordedwrites = new ArrayList<File>();

	public boolean recordedRead(final File file) {
		return recordedreads.contains(file);
	}

	public boolean recordedWrite(final File file) {
		return recordedwrites.contains(file);
	}

	public CharSource openRead(final Path p) {
		record(FileOption.READ, p);
		return null;
	}

	private void record(final FileOption read, @NotNull final Path p) {
		record(read, p.toFile());
	}

	private void record(@NotNull final FileOption read, @NotNull final File file) {
		switch (read) {
		case WRITE:
			recordedwrites.add(file);
			break;
		case READ:
			recordedreads.add(file);
			break;
		default:
			throw new IllegalStateException("Cant be here");
		}
	}

	public CharSink openWrite(final Path p) throws IOException {
		record(FileOption.WRITE, p);
		return new FileCharSink(Files.newOutputStream(p));
	}

	public InputStream readFile(final File f) throws FileNotFoundException {
		record(FileOption.READ, f);
		return new FileInputStream(f);
	}
}

//
//
//
