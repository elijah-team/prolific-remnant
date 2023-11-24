/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
/**
 *
 */
package tripleo.elijah.gen.nodes;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.gen.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

/**
 * @author Tripleo(sb)
 *
 */
public class TmpSSACtxNode {

	private final CompilerContext _ctx;
	public        LocalAgnTmpNode _tmp = null;
	private       IExpression     __expr;
	private       IExpressionNode _node;

	public TmpSSACtxNode(final CompilerContext cctx) {
		// TODO Auto-generated constructor stub
		this._ctx = cctx;
	}

	public String text() {
		return ExpressionNode.getStringPCE((ProcedureCallExpression) getExprType());
		//"--------------------"; // TODO hardcoded
	}

	public IExpression getExprType() {
		return __expr;
	}

	public void setExprType(final IExpression __expr) {
		this.__expr = __expr;
	}

	public void setExprType(final IExpressionNode node) {
		this._node = node;
	}

	public IExpressionNode getType() {
		if (_node != null)
			return _node;
		return new ExpressionNode(getExprType());
	}

	public CompilerContext getCtx() {
		return _ctx;
	}

	public void GenLocalAgn(final CompilerContext cctx, final GenBuffer gbn) {
		// TODO Auto-generated method stub

	}
}

//
//
//
