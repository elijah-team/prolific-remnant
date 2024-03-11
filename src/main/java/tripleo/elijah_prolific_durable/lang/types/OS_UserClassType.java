package tripleo.elijah_prolific_durable.lang.types;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.comp.ErrSink;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.GenType;

import java.text.MessageFormat;
import java.util.List;

public class OS_UserClassType extends __Abstract_OS_Type {
	private final ClassStatement _classStatement;

	public OS_UserClassType(final ClassStatement aClassStatement) {
		_classStatement = aClassStatement;
	}

	@Override
	public OS_Element getElement() {
		return _classStatement;
	}

	@Override
	public Type getType() {
		return Type.USER_CLASS;
	}

	@Override
	public String asString() {
		return MessageFormat.format("<OS_UserClassType {0}>", _classStatement);
	}

	@NotNull
	public ClassInvocation resolvedUserClass(final @NotNull GenType genType, final TypeName aGenericTypeName, final DeducePhase phase, final DeduceTypes2 deduceTypes2, final ErrSink errSink) {
		final ClassStatement   best            = _classStatement;
		@Nullable final String constructorName = null; // TODO what to do about this, nothing I guess

		@NotNull final List<TypeName> gp = best.getGenericPart();
		@Nullable ClassInvocation     clsinv;
		if (genType.ci == null) {
			clsinv = DeduceTypes2.ClassInvocationMake.withGenericPart(best, constructorName, (NormalTypeName) aGenericTypeName, deduceTypes2, errSink);
			if (clsinv == null) return null;
			clsinv     = phase.registerClassInvocation(clsinv);
			genType.ci = clsinv;
		} else
			clsinv = (ClassInvocation) genType.ci;
		return clsinv;
	}

	@Override
	public ClassStatement getClassOf() {
		return _classStatement;
	}

	protected boolean _isEqual(final OS_Type aType) {
		return aType.getType() == Type.USER_CLASS && _classStatement.equals(((OS_UserClassType) aType)._classStatement);
	}
}
