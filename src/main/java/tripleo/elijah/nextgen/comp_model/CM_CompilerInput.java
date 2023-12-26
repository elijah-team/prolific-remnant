package tripleo.elijah.nextgen.comp_model;

import com.google.common.base.MoreObjects;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.Finally;
import tripleo.elijah.comp.i.CompilationClosure;
import tripleo.elijah.comp.i.ErrSink;
import tripleo.elijah.comp.i.ILazyCompilerInstructions;
import tripleo.elijah.comp.internal.CW_inputIsDirectory;
import tripleo.elijah.comp.internal.CompilationImpl;
import tripleo.elijah.comp.percy.*;
import tripleo.elijah.util.Maybe;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;
import java.util.regex.*;
//import tripleo.wrap.File;

public class CM_CompilerInput {
	private final CompilationImpl comp;
	private final CompilerInput carrier;
	private String inp;
	private CompilerInput.Ty ty;
	private File dir_carrier;
	private String hash;
	private Maybe<ILazyCompilerInstructions> accept_ci;
	public CM_CompilerInput(final CompilerInput aCompilerInput, final CompilationImpl aCompilation) {
		carrier = aCompilerInput;
		comp = aCompilation;
		inp = carrier.inp();
	}

	public CompilerInput getCarrier() {
		return carrier;
	}

	public boolean inpSameAs(final String aS) {
		return aS.equals(this.inp);
	}

	public void setSourceRoot() {
		ty = CompilerInput.Ty.SOURCE_ROOT;
	}

	public void setDirectory(final File aF) {
		ty = CompilerInput.Ty.SOURCE_ROOT;
		dir_carrier = aF;
	}

	public void setArg() {
		ty = CompilerInput.Ty.ARG;
	}

	public void accept_hash(final String aHash) {
		this.hash = aHash;
	}

	public String printableString() {
		return MoreObjects.toStringHelper(this)
				.add("ty", ty)
				.add("inp", inp)
				.add("accept_ci", accept_ci.toString())
				.add("dir_carrier", dir_carrier)
				.add("hash", hash)
				.toString();
	}

	public CompilerInput.Ty getTy() {
		return ty;
	}

	public void accept_ci(final Maybe<ILazyCompilerInstructions> mci) {
		accept_ci = mci;
	}

	public Maybe<ILazyCompilerInstructions> acceptance_ci() {
		return accept_ci;
	}

	public String getInp() {
		return inp;
	}

	public void setInp(final String aInp) {
		inp = aInp;
	}

	public File fileOf() {
		final File f = new File(inp);
		return f;
	}

	public void onIsEz() {
		final ILazyCompilerInstructions ilci = ILazyCompilerInstructions.of(carrier, comp.getCompilationClosure());

		final Maybe<ILazyCompilerInstructions> m4 = new Maybe<>(ilci, null);
		carrier.accept_ci(m4);
	}

	public Finally.Input createInput(final Finally.Out2 aTy) {
		var nameable = new Finally.Nameable() {
			@Override
			public String getNameableString() {
				return inp;
			}
		};
		return new Finally.Input(nameable, aTy);
	}

	public CompilationClosure getComp() {
		return comp.getCompilationClosure();
	}

	public void trigger_inputIsDirectory() {
		final CompilerInput input = getCarrier();
		final File f = fileOf();
		final @NotNull CompilationClosure c = getComp();

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
		CW_inputIsDirectory.apply(this, c, f);
	}

	public void trigger_inputIsEz(final @NotNull CompilationClosure c,
	                              final @NotNull Consumer<CompilerInput> x) {
		final @NotNull File f = this.fileOf();
		final @NotNull CompilerInput input = getCarrier();
		final @NotNull ErrSink errSink = c.errSink();

		final String file_name = getInp();
		final boolean matches2 = Pattern.matches(".+\\.ez$", file_name);
		if (matches2) {
			// TODO 11/24 access3/4
			c.compilerInputWatcher_Event(CN_CompilerInputWatcher.e.IS_EZ, input, this);
			x.accept(input);
		} else {
			//errSink.reportError("9996 Not an .ez file "+file_name);
			final NotDirectoryException d = new NotDirectoryException(f.toString());
			errSink.reportError("9995 Not a directory " + f.getAbsolutePath());
		}
	}
}
