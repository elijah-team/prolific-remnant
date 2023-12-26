/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
/*
 * Created on May 19, 2019 23:47
 *
 * $Id$
 *
 */
package tripleo.elijah.lang;

import antlr.*;
import tripleo.elijah.util.*;

public class FloatExpression implements IExpression {

	final         float carrier;
	private final Token n;
	OS_Type _type;

	public FloatExpression(final Token n) {
		this.n  = n;
		carrier = Float.parseFloat(n.getText());
	}

	@Override
	public ExpressionKind getKind() {
		return ExpressionKind.FLOAT; // TODO
	}

	@Override
	public void setKind(final ExpressionKind aType) {
		// log and ignore
		SimplePrintLoggerToRemoveSoon.println_err2("Trying to set ExpressionType of FloatExpression to " + aType.toString());
	}

	@Override
	public IExpression getLeft() {
		return this;
	}

	@Override
	public void setLeft(final IExpression aLeft) {
		throw new NotImplementedException(); // TODO
	}

	@Override
	public String repr_() {
		return toString();
	}

	@Override
	public String toString() {
		return String.format("FloatExpression (%f)", carrier);
	}

	@Override
	public boolean is_simple() {
		return true;
	}

	@Override
	public OS_Type getType() {
		return _type;
	}

	@Override
	public void setType(final OS_Type deducedExpression) {
		_type = deducedExpression;
	}

}

//
//
//
