package tripleo.elijah_prolific_durable.stages.deduce.zero;

import tripleo.elijah_prolific_durable.lang.OS_Type;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.GenType;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

class ZeroResolver {

	GenType gt;
	private DeduceTypes2 deduceTypes2;

	public Zero_Type resolve_type(final OS_Type ty) {
		try {
			gt = deduceTypes2.resolve_type(ty, ty.getTypeName().getContext());
			return new Zero_Type(gt);
		} catch (final ResolveError aE) {
			NotImplementedException.raise();
		}
		return null;
	}
}
