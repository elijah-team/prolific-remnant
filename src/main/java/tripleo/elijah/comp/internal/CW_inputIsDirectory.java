package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.CompilerInstructions;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.Finally;
import tripleo.elijah.comp.diagnostic.TooManyEz_ActuallyNone;
import tripleo.elijah.comp.diagnostic.TooManyEz_BeSpecific;
import tripleo.elijah.comp.i.CompilationClosure;
import tripleo.elijah.comp.i.ILazyCompilerInstructions;
import tripleo.elijah.comp.percy.CN_CompilerInputWatcher;
import tripleo.elijah.comp.queries.QuerySearchEzFiles;
import tripleo.elijah.diagnostic.Diagnostic;
import tripleo.elijah.nextgen.comp_model.CM_CompilerInput;
import tripleo.elijah.util.Maybe;
import tripleo.elijah.util.Operation2;

import java.io.File;
import java.util.List;

import static tripleo.elijah.util.Helpers.List_of;

public class CW_inputIsDirectory {
	public static void apply(final CM_CompilerInput cm,
	                         final CompilationClosure c,
	                         final @NotNull File f) {
		CompilerInstructions ez_file;

//		final CM_CompilerInput cm = c.getCompilation().get(input);
		cm.setDirectory(f);

		final @NotNull CompilerInput input = cm.getCarrier();

		final List<CompilerInstructions> ezs = searchEzFiles(f, c);

		switch (ezs.size()) {
			case 0 -> {
				final Diagnostic d_toomany = new TooManyEz_ActuallyNone();
				final Maybe<ILazyCompilerInstructions> m = new Maybe<>(null, d_toomany);
				c.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.ACCEPT_CI, input, m);
				input.accept_ci(m); // TDOO 11/24 move this??
				assert false;
			}
			case 1 -> {
				ez_file = ezs.get(0);
				final ILazyCompilerInstructions ilci = ILazyCompilerInstructions.of(ez_file);
				final Maybe<ILazyCompilerInstructions> m3 = new Maybe<>(ilci, null);
				c.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.ACCEPT_CI, input, m3);
			}
			default -> {
				//final Diagnostic d_toomany = new TooManyEz_UseFirst();
				//add_ci(ezs.get(0));

				// more than 1 (negative is not possible)
				final Diagnostic d_toomany2 = new TooManyEz_BeSpecific();
				final Maybe<ILazyCompilerInstructions> m2 = new Maybe<>(null, d_toomany2);
				c.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.ACCEPT_CI, input, m2);
				input.accept_ci(m2); // TDOO 11/24 move this??
				assert false;
			}
		}

		final Finally.Input input2 = cm.createInput(Finally.Out2.EZ);
		c.getCompilation().reports().addInput(input2);
	}

	private static List<CompilerInstructions> searchEzFiles(final @NotNull File directory, final @NotNull CompilationClosure ccl) {
		final QuerySearchEzFiles q = new QuerySearchEzFiles(ccl);
		final Operation2<List<CompilerInstructions>> olci = q.process(directory);

		switch (olci.mode()) {
			case SUCCESS -> {
				return olci.success();
			}
			case FAILURE -> {
				ccl.errSink().reportDiagnostic(olci.failure());
				return List_of();
			}
			default -> throw new IllegalStateException("Unexpected value: " + olci.mode());
		}
	}
}
