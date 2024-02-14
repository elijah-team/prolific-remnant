package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.*;
import tripleo.elijah.ci.CompilerInstructions;
import tripleo.elijah.comp.*;
import tripleo.elijah_prolific.v.V;

public class CompilationBus implements ICompilationBus {
	private final Compilation c;

	public CompilationBus(final Compilation aC) {
		c = aC;
	}

	@Override
	public void option(final @NotNull CompilationChange aChange) {
		aChange.apply(c);
	}

	@Override
	public void inst(final @NotNull ILazyCompilerInstructions aLazyCompilerInstructions) {
		final CompilerInstructions compilerInstructions = aLazyCompilerInstructions.get();

		//System.out.println("** [ci] " + compilerInstructions);
		V.asv(V.e.CB_INST_CI, ""+compilerInstructions);
	}

	public void add(final CB_Action action) {
		action.execute();
	}

	@Override
	public void add(final CB_Process aProcess) {
//		throw new NotImplementedException();

		aProcess.steps().stream()
		        .forEach(action -> {
			        action.execute();
		        });
	}

}


