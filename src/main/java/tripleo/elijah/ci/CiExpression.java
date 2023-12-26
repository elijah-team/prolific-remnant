package tripleo.elijah.ci;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.i.*;

public interface CiExpression {
	@NotNull ExpressionKind getKind();

	IExpression getLeft();

	boolean is_simple();

	String printableString();

	String repr_();

	void setKind(ExpressionKind aExpressionKind);

	void setLeft(IExpression iexpression);

	@Override
	String toString();
}
