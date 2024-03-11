package tripleo.elijah_prolific_durable.comp;

import tripleo.elijah_prolific_durable.stages.deduce.post_bytecode.Maybe;

import java.io.File;

public class CompilerInput {
	private final String                           inp;
	private       Maybe<ILazyCompilerInstructions> accept_ci;
	private       File                             dir_carrier;
	private       Ty                               ty;
	private       String                           hash;

	public CompilerInput(final String aS) {
		inp = aS;
		ty  = Ty.NULL;
	}

	public String getInp() {
		return inp;
	}

	public void accept_ci(final Maybe<ILazyCompilerInstructions> aM3) {
		accept_ci = aM3;
	}

	public Maybe<ILazyCompilerInstructions> acceptance_ci() {
		return accept_ci;
	}

	public boolean isNull() {
		return ty == Ty.NULL;
	}

	public boolean isSourceRoot() {
		return ty == Ty.SOURCE_ROOT;
	}

	public void setSourceRoot() {
		ty = Ty.SOURCE_ROOT;
	}

	public void setDirectory(File f) {
		ty          = Ty.SOURCE_ROOT;
		dir_carrier = f;
	}

	public void setArg() {
		ty = Ty.ARG;
	}

	public void accept_hash(final String hash) {
		this.hash = hash;
	}

	public Ty ty() {
		return ty;
	}

	public enum Ty {NULL, SOURCE_ROOT, ARG}
}
