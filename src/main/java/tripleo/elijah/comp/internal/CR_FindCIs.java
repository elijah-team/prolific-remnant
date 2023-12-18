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
import java.nio.file.NotDirectoryException;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class CR_FindCIs extends DefaultStateful implements CR_Action {
	private final @NotNull List<CompilerInput> inputs;
	private @NotNull       CCI                 cci;
	private final @NotNull IProgressSink       _ps;

	public CR_FindCIs(final @NotNull CompilerBeginning beginning) {
		State st = CompilationRunner.ST.INITIAL; // que?? 07/01

		inputs = beginning.compilerInput();

		var comp = beginning.compilation();
		var progressSink = beginning.progressSink();

		var plane = beginning.compilation().getConnectionPlane();
		plane.onCCI(acci->{cci=acci;});
		//cci = beginning.compilation().getCompilationEnclosure().getCompilationRunner()._accessCCI();
		// TODO 09/05 look at 2 different progressSinks
		_ps = comp.getCompilationEnclosure().getCompilationBus().defaultProgressSink();

		//eventualCR_FindCIs.resolve(this);
	}

	@Override
	public @NotNull Operation<Ok> execute(final @NotNull CR_State st, final @NotNull CB_Output aO) {
		final Compilation c = st.ca().getCompilation(); // TODO 11/24 not closure here?
		final ErrSink errSink = c.getErrSink();

		for (final CompilerInput input : inputs) {
			_processInput(c.getCompilationClosure(), errSink, (compilerInput) -> {
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
							   final @NotNull ErrSink errSink,
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
			_inputIsDirectory(c, input, f);
		} else {
			final String file_name = cm.getInp();
			final boolean matches2 = Pattern.matches(".+\\.ez$", file_name);
			if (matches2) {
				// TODO 11/24 access3/4
				c.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.IS_EZ, input, cm);
				x.accept(input);
			} else {
				//errSink.reportError("9996 Not an .ez file "+file_name);
                final NotDirectoryException d = new NotDirectoryException(f.toString());
                errSink.reportError("9995 Not a directory " + f.getAbsolutePath());
            }
		}
	}

	private void _inputIsDirectory(final @NotNull CompilationClosure c,
								   final @NotNull CompilerInput input,
								   final @NotNull File f) {
		c.getCompilation().addCompilerInputWatcher(new CN_CompilerInputWatcher() {
			@Override
			public void event(final e aEvent, final CompilerInput aCompilerInput, final Object aObject) {
				switch (aEvent) {
					case ACCEPT_CI -> {
						final Maybe<ILazyCompilerInstructions> mci = (Maybe<ILazyCompilerInstructions>) aObject;
						input.accept_ci(mci);
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
		});
		CW_inputIsDirectory.apply(input, c, f);
	}

	@Override
	public @NotNull String name() {
		return "find cis";
	}
}
