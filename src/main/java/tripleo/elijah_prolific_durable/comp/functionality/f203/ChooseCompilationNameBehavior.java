package tripleo.elijah_prolific_durable.comp.functionality.f203;

import tripleo.elijah.comp.*;
import tripleo.elijah_prolific_durable.comp.Compilation;

import java.io.*;

public class ChooseCompilationNameBehavior implements ChooseDirectoryNameBehavior {
	private final Compilation c;

	public ChooseCompilationNameBehavior(final Compilation aC) {
		c = aC;
	}

	@Override
	public File chooseDirectory() {
		final String c_name = c.getCompilationNumberString();

		final File fn00 = new File("COMP", c_name);
//		final File fn0 = new File(fn00, "date");

		return fn00;
	}
}
