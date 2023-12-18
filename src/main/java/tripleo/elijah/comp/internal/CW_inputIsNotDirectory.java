package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Nullable;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.CompilationClosure;
import tripleo.elijah.comp.percy.CN_CompilerInputWatcher;
import tripleo.elijah.nextgen.comp_model.*;

import java.io.File;
//import java.nio.file.NotDirectoryException;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class CW_inputIsNotDirectory {
	private final CM_CompilerInput cm;

	public CW_inputIsNotDirectory(final CM_CompilerInput aCm) {
		cm = aCm;
	}

	public void apply(final CompilerInput input, final CompilationClosure cc, final File f, @Nullable Consumer<CompilerInput> x) {
		final String        file_name = cm.getInp();
		final boolean       matches2  = Pattern.matches(".+\\.ez$", file_name);

		if (matches2) {
			// TODO 11/24 access3/4
			cc.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.IS_EZ, input, cm);
			x.accept(input);
		} else {
			//errSink.reportError("9996 Not an .ez file "+file_name);
//			final NotDirectoryException d = new NotDirectoryException(f.toString());
			cc.errSink().reportError("9995 Not a directory " + f.getAbsolutePath());
		}
	}
}
