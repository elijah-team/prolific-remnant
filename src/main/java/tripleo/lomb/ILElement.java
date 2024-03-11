package tripleo.lomb;

import org.jetbrains.annotations.Nullable;

import tripleo.elijah_prolific_durable.lang.IExpression;
import tripleo.elijah_prolific_durable.lang.OS_Element;

public record ILElement(Object principal, ILPoint point, ILSourceRole sourceRole) {
	public @Nullable OS_Element asElement() {
		if (!isElement()) return null;
		return ((OS_Element) principal);
	}
	
	public @Nullable IExpression asExpression() {
		if (!isExpression()) return null;
		return ((IExpression) principal);
	}	

	public boolean isElement() {
		return principal instanceof OS_Element;
	}

	public boolean isExpression() {
		return principal instanceof IExpression;
	}

}
