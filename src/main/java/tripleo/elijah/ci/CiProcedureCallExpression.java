package tripleo.elijah.ci;

import tripleo.elijah.lang.i.*;

// FIXME wrap IExpression and ExpressionList and ExpressionKind too
public interface CiProcedureCallExpression extends CiExpression {
	CiExpressionList exprList();

	CiExpressionList getExpressionList();

	void identifier(IExpression ee);

	void setExpressionList(CiExpressionList ael);

	void setArgs(CiExpressionList aEl);
}
