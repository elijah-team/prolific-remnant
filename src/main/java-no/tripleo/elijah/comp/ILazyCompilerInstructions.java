package tripleo.elijah.comp;

import org.jetbrains.annotations.*;
import tripleo.elijah.ci.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.io.*;
import java.util.*;

public interface ILazyCompilerInstructions {
	@Contract(value = "_ -> new", pure = true)
	static @NotNull ILazyCompilerInstructions of(final CompilerInstructions aCompilerInstructions) {
		return () -> aCompilerInstructions;
	}

	@Contract(value = "_, _ -> new", pure = true)
	static @NotNull ILazyCompilerInstructions of(final File aFile, final Compilation c) {
		return new ILazyCompilerInstructions() {
			@Override
			public CompilerInstructions get() {
				try {
					final Operation<CompilerInstructions> parsed = CX_ParseEzFile.parseAndCache(aFile, c, c._accessCompilerRunner().ezCache());
					return Objects.requireNonNull(parsed).success();
				} catch (final Exception aE) {
					throw new RuntimeException(aE); // TODO ugh
				}
			}
		};
	}

	CompilerInstructions get();
}
