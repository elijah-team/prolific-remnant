package tripleo.elijah.comp;

import com.google.common.base.MoreObjects;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.ILazyCompilerInstructions;
import tripleo.elijah.util.Maybe;

import java.io.File;
import java.util.Optional;

public record CompilerInput(
		String                           inp,
		Optional<Compilation> oc
) {

	public void accept_ci(final Maybe<ILazyCompilerInstructions> mci) {
		if (oc.isEmpty()) {
			throw new IllegalStateException("compilation not set");
		}

		oc.get().get(this).accept_ci(mci);
	}

	public Maybe<ILazyCompilerInstructions> acceptance_ci() {
		if (oc.isEmpty()) {
			throw new IllegalStateException("compilation not set");
		}

		return oc.get().get(this).acceptance_ci();
    }

	public boolean isNull() {
		if (oc.isEmpty()) {
			throw new IllegalStateException("compilation not set");
		}

		return oc.get().get(this).getTy() == Ty.NULL;
	}

	public boolean isSourceRoot() {
		if (oc.isEmpty()) {
			throw new IllegalStateException("compilation not set");
		}

		return oc.get().get(this).getTy() == Ty.SOURCE_ROOT;
	}

	public void setSourceRoot() {
		if (oc.isPresent()) {
			oc.get().get(this).setSourceRoot();
		}
		throw new IllegalStateException("compilation not set");
	}
	
	public void setArg() {
		if (oc.isPresent()) {
			oc.get().get(this).setArg();
		}
		throw new IllegalStateException("compilation not set");
	}

	public void accept_hash(final String hash) {
		if (oc.isPresent()) {
			oc.get().get(this).accept_hash(hash);
		}
		throw new IllegalStateException("compilation not set");
	}

	@Override
	public String toString() {
        if (oc.isEmpty()) {
            return MoreObjects.toStringHelper(this)
                    .add("inp", inp)
                    .toString();
        }
        return oc.get().get(this).printableString();
    }

	public enum Ty {NULL, SOURCE_ROOT, ARG}

	public Ty ty() {
        if (oc.isEmpty()) {
            throw new IllegalStateException("compilation not set");
        } else {
            return oc.get().get(this).getTy();
        }
    }
}
