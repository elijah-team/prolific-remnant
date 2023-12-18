package tripleo.elijah.nextgen.comp_model;

import com.google.common.base.MoreObjects;
import tripleo.elijah.comp.CompilerInput;
import tripleo.elijah.comp.Finally;
import tripleo.elijah.comp.i.ILazyCompilerInstructions;
import tripleo.elijah.comp.internal.CompilationImpl;
import tripleo.elijah.util.Maybe;

import java.io.File;

public class CM_CompilerInput {
	private final CompilationImpl                  comp;
	private final CompilerInput                    carrier;
	private       String                           inp;
	private       CompilerInput.Ty                 ty;
	private       File                             dir_carrier;
	private       String                           hash;
	private       Maybe<ILazyCompilerInstructions> accept_ci;

	public CM_CompilerInput(final CompilerInput aCompilerInput, final CompilationImpl aCompilation) {
		carrier = aCompilerInput;
		comp    = aCompilation;
		inp     = carrier.inp();
	}

	public boolean inpSameAs(final String aS) {
		return aS.equals(this.inp);
	}

	public void setSourceRoot() {
		ty = CompilerInput.Ty.SOURCE_ROOT;
	}

	public void setDirectory(final File aF) {
		ty          = CompilerInput.Ty.SOURCE_ROOT;
		dir_carrier = aF;
	}

	public void setArg() {
		ty = CompilerInput.Ty.ARG;
	}

	public void accept_hash(final String aHash) {
		this.hash = aHash;
	}

	public String printableString() {
		final String dir_carrierS = dir_carrier == null ? "<null>" : "" + dir_carrier;
		final String hashS        = hash == null ? "<null>" : "" + hash;
		final String accept_ciS   = accept_ci == null ? "<null>" : "" + accept_ci;

		return MoreObjects.toStringHelper(this)
				.add("ty", ty)
				.add("inp", inp)
				.add("accept_ci", accept_ciS)
				.add("dir_carrier", dir_carrierS)
				.add("hash", hashS)
				.toString();
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

	public CompilerInput.Ty getTy() {
		return ty;
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
			public String getName() {
				return inp;
			}
		};
		return new Finally.Input(nameable, aTy);
	}
}
