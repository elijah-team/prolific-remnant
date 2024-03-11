/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import tripleo.elijah_prolific_durable.lang2.ElElementVisitor;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

public class YieldExpression /*extends BasicBinaryExpression*/ implements OS_Element, StatementItem {

	public YieldExpression(final IExpression aExpr) {
		// TODO Auto-generated constructor stub
		throw new NotImplementedException();
	}

	@Override
	public void visitGen(final ElElementVisitor visit) {
		visit.visitYield(this);
	}

	@Override
	public Context getContext() {
		throw new NotImplementedException();
//		return null;
	}

	@Override
	public OS_Element getParent() {
		throw new NotImplementedException();
//		return null;
	}
}

//
//
//
