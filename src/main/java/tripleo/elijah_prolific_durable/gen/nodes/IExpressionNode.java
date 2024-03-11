/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.gen.nodes;

import tripleo.elijah.gen.*;
import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.gen.*;
import tripleo.elijah_prolific_durable.lang.IExpression;

public interface IExpressionNode {
//	String getStringPCE(ProcedureCallExpression expr);

	IExpression getExpr();

	boolean is_const_expr();

	boolean is_underscore();

	boolean is_var_ref();

	boolean is_simple();

	String genText(CompilerContext cctx);

	String genType();

	String genText();

	TypeRef getType();
}
