package tripleo.elijah_prolific_durable.lang.types;

import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.*;

import java.text.*;


public class OS_UserType extends __Abstract_OS_Type {
	private final TypeName typeName;

	public OS_UserType(final TypeName aTypeName) {
		typeName = aTypeName;
	}

	@Override
	public OS_Element getElement() {
		return null;
	}

	@Override
	public Type getType() {
		return Type.USER;
	}

	@Override
	public String asString() {
		return MessageFormat.format("<OS_UserType {0}>", typeName);
	}

	@Override
	public OS_Type resolve(final Context ctx) {
		assert ctx != null;

		final LookupResultList r    = ctx.lookup(getTypeName().toString()); // TODO
		final OS_Element       best = r.chooseBest(null);
		return ((ClassStatement) best).getOS_Type();
	}

	@Override
	public TypeName getTypeName() {
		return typeName;
	}

	protected boolean _isEqual(final OS_Type aType) {
		return aType.getType() == Type.USER && typeName.equals(aType.getTypeName());
	}

}

