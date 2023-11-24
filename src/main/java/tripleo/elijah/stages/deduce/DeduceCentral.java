package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

class DeduceCentral {
	private final DeduceTypes2 deduceTypes2;

	public DeduceCentral(final DeduceTypes2 aDeduceTypes2) {
		deduceTypes2 = aDeduceTypes2;
	}

	public DeduceTypes2 getDeduceTypes2() {
		return deduceTypes2;
	}

	public @NotNull DC_ClassNote note_Class(final ClassStatement aE, final Context aCtx) {
		DC_ClassNote cn = deduceTypes2._inj().new_DC_ClassNote(aE, aCtx, this);
		return cn;
	}
}
