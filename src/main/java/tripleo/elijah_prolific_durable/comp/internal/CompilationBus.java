package tripleo.elijah_prolific_durable.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific.v.V;
import tripleo.elijah_prolific_durable.ci.CompilerInstructions;
import tripleo.elijah_prolific_durable.comp.*;

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
		V.asv(V.e.CB_INST_CI, ""+compilerInstructions.getFilename());
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


