package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.i.*;
import tripleo.elijah.comp.percy.CN_CompilerInputWatcher;
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
	private final @NotNull IProgressSink       _ps;
	private @NotNull       CCI                 cci;

	public CR_FindCIs(final @NotNull CompilerBeginning beginning) {
		State st = CompilationRunner.ST.INITIAL; // que?? 07/01

		inputs = beginning.compilerInput();

		var comp         = beginning.compilation();
		var progressSink = beginning.progressSink();

		var plane = beginning.compilation().getConnectionPlane();
		plane.onCCI(acci -> {
			cci = acci;
		});
		//cci = beginning.compilation().getCompilationEnclosure().getCompilationRunner()._accessCCI();
		// TODO 09/05 look at 2 different progressSinks
		_ps = comp.getCompilationEnclosure().getCompilationBus().defaultProgressSink();

		//eventualCR_FindCIs.resolve(this);

		comp.addCompilerInputWatcher(new inputIsDirectory_CN_CompilerInputWatcher());
	}

	CT_InputProcessor ip = new CT_InputProcessor() {
		@Override
		public void action(final CompilerInput aCompilerInput) {
			final Maybe<ILazyCompilerInstructions> mcci = aCompilerInput.acceptance_ci();
			if (mcci != null) {
				cci.accept(mcci, _ps);
			} else {
				NotImplementedException.raise_stop();
			}
		}

		@Override
		public void process(final CompilationClosure cc, final CompilerInput aInput) {
			switch (aInput.ty()) {
				case NULL, SOURCE_ROOT -> {}
				default -> { return; }
			}

			final CM_CompilerInput cm = cc.getCompilation().get(aInput);
			final File             f  = cm.fileOf();
			if (f.isDirectory()) {
				//errSink.reportError("9996 Not an .ez file "+file_name);
				CW_inputIsDirectory.apply(aInput, cc, f);
			} else {
				new CW_inputIsNotDirectory(cm).apply(aInput, cc, f, this::action);
			}
		}
	};

	@Override
	public @NotNull Operation<Ok> execute(final @NotNull CR_State st, final @NotNull CB_Output aO) {
		final Compilation c       = st.ca().getCompilation(); // TODO 11/24 not closure here?

		for (final CompilerInput input : inputs) {
			ip.process(c.getCompilationClosure(), input);
		}

		return Operation.success(Ok.instance());
	}

	@Override
	public void attach(final @NotNull CompilationRunner cr) {
	}

	@Override
	public @NotNull String name() {
		return "find cis";
	}

	private static class inputIsDirectory_CN_CompilerInputWatcher implements CN_CompilerInputWatcher {
		@Override
		public void event(final e aEvent, final CompilerInput aCompilerInput, final Object aObject) {
			switch (aEvent) {
				case ACCEPT_CI -> {
					final Maybe<ILazyCompilerInstructions> mci = (Maybe<ILazyCompilerInstructions>) aObject;
					aCompilerInput.accept_ci(mci);

					if (aCompilerInput.ty() == CompilerInput.Ty.SOURCE_ROOT) {
						var c = aCompilerInput.oc().get();
						c.pushItem(aCompilerInput.acceptance_ci().o.get());
					}
				}
				case IS_EZ -> {
					final CM_CompilerInput cm = (CM_CompilerInput) aObject;
					cm.onIsEz();
				}
				default -> {
					System.err.println("~~ [11/24 111] " + aEvent + " " + aCompilerInput);
				}
			}
		}
	}
}
