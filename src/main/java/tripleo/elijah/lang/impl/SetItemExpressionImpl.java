/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

/**
 * Created 8/6/20 1:15 PM
 */
public class SetItemExpressionImpl extends BasicBinaryExpressionImpl
		implements tripleo.elijah.lang.i.SetItemExpression {
	public SetItemExpressionImpl(final GetItemExpression left_, final IExpression right_) {
		this.setLeft(left_);
		this.setRight(right_);
		this.setKind(ExpressionKind.SET_ITEM);
	}
}

//
//
//
