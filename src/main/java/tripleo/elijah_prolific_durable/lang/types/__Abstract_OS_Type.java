package tripleo.elijah_prolific_durable.lang.types;

import tripleo.elijah.lang.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.lang2.BuiltInTypes;

abstract class __Abstract_OS_Type implements OS_Type {
	@Override
	public ClassStatement getClassOf() {
		return null;
	}

	@Override
	public OS_Type resolve(final Context ctx) {
		assert ctx != null;
		switch (getType()) {
		case BUILT_IN: {
			//
			// TODO These are technically not right
			//
			switch (getBType()) {
			case SystemInteger: {
				final LookupResultList r;
				OS_Element             best;

				r    = ctx.lookup("SystemInteger");
				best = r.chooseBest(null);
				while (best instanceof final AliasStatement aliasStatement) {
					final LookupResultList lrl            = aliasStatement.getContext().lookup(aliasStatement.getExpression().toString());
					best = lrl.chooseBest(null);
				}
				return ((ClassStatement) best).getOS_Type();
			}
			case Boolean: {
				final LookupResultList r;
				final OS_Element       best;

				r    = ctx.lookup("Boolean");
				best = r.chooseBest(null);
				return ((ClassStatement) best).getOS_Type();
			}
			case Unit: {
				return new OS_UnitType();
			}
			case String_: {
				final LookupResultList r;
				final OS_Element       best;

				r    = ctx.lookup("String8"); // TODO not sure about this
				best = r.chooseBest(null);
				return ((ClassStatement) best).getOS_Type();
			}
			default:
				throw new IllegalStateException("Unexpected value: " + getBType());
			}
		}
		case USER: {
			final LookupResultList r    = ctx.lookup(getTypeName().toString()); // TODO
			final OS_Element       best = r.chooseBest(null);
			return ((ClassStatement) best).getOS_Type();
		}
		case USER_CLASS:
		case FUNCTION:
			return this;
		default:
			throw new IllegalStateException("can't be here.");
		}
	}

	@Override
	public boolean isUnitType() {
		return false;
	}

	@Override
	public BuiltInTypes getBType() {
		return null;
	}

	@Override
	public TypeName getTypeName() {
		return null;
	}

	@Override
	public boolean isEqual(final OS_Type aType) {
		if (aType.getType() != getType()) return false;

		return _isEqual(aType);
	}

	protected abstract boolean _isEqual(final OS_Type aType);

}

