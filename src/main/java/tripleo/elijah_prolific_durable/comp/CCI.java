package tripleo.elijah_prolific_durable.comp;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.ci.CompilerInstructions;
import tripleo.elijah_prolific_durable.comp.i.*;
import tripleo.elijah_prolific_durable.stages.deduce.post_bytecode.Maybe;

class CCI {
	//private final @NotNull Compilation compilation;
	private final Compilation.CIS _cis;
	private final IProgressSink   _ps;

	public CCI(final CT_CompilationRunner ct) {
		//compilation = aCompilation;
		_cis = ct.cis();
		_ps  = ct.ps();
	}

	public void accept(final @NotNull Maybe<ILazyCompilerInstructions> mcci) {
		if (mcci.isException()) return;

		final ILazyCompilerInstructions cci = mcci.o;
		final CompilerInstructions      ci  = cci.get();

		_ps.note(131, ProgressSinkComponent.CCI, -1, new Object[]{ci.getName()});

		_cis.onNext(ci);
		//compilation.pushItem(ci);
	}
}
