package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.*;
import tripleo.elijah.nextgen.comp_model.CM_CompilerInput;
import tripleo.elijah.stateful.DefaultStateful;
import tripleo.elijah.stateful.State;
import tripleo.elijah.util.Maybe;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah.util.Ok;
import tripleo.elijah.util.Operation;

import java.io.File;
import java.util.List;
import java.util.function.Consumer;

public class CR_FindCIs extends DefaultStateful implements CR_Action {
	private final @NotNull List<CompilerInput> inputs;
	private final @NotNull CCI cci;
	private final @NotNull IProgressSink _ps;

	public CR_FindCIs(final @NotNull CompilerBeginning beginning) {
		State st = CompilationRunner.ST.INITIAL; // que?? 07/01

		inputs = beginning.compilerInput();

		var comp = beginning.compilation();
		var progressSink = beginning.progressSink();

		// TODO 09/05 look at 2 different progressSinks
		cci = new DefaultCCI(comp, comp._cis(), progressSink);
		_ps = comp.getCompilationEnclosure().getCompilationBus().defaultProgressSink();

		//eventualCR_FindCIs.resolve(this);
	}

	@Override
	public @NotNull Operation<Ok> execute(final @NotNull CR_State st, final @NotNull CB_Output aO) {
		final Compilation c = st.ca().getCompilation(); // TODO 11/24 not closure here?
		final ErrSink errSink = c.getErrSink();

		for (final CompilerInput input : inputs) {
			_processInput(c.getCompilationClosure(), (compilerInput) -> {
				final Maybe<ILazyCompilerInstructions> mcci = compilerInput.acceptance_ci();
				if (mcci != null) {
					cci.accept(mcci, _ps);
				} else {
					NotImplementedException.raise_stop();
				}
			}, input);
		}

		return Operation.success(Ok.instance());
	}

	@Override
	public void attach(final @NotNull CompilationRunner cr) {
	}

	private void _processInput(final @NotNull CompilationClosure c,
	                           final @NotNull Consumer<CompilerInput> x,
	                           final @NotNull CompilerInput input) {
		switch (input.ty()) {
			case NULL -> {
			}
			case SOURCE_ROOT -> {
			}
			default -> {
				return;
			}
		}

		final CM_CompilerInput cm = c.getCompilation().get(input);
		final File f = cm.fileOf();
		if (f.isDirectory()) {
			//errSink.reportError("9996 Not an .ez file "+file_name);
			cm.trigger_inputIsDirectory();
		} else {
			cm.trigger_inputIsEz(c, x);
		}
	}

	@Override
	public @NotNull String name() {
		return "find cis";
	}
}
