/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import antlr.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.util.SimplePrintLoggerToRemoveSoon;


public class VariableReference extends AbstractExpression implements OS_Expression {

	String main;
//	List<VR_Parts> parts = new ArrayList<VR_Parts>();
	OS_Type _type;

	/**
	 * Called from ElijahParser.variableReference.  Will `setMain' later
	 */
	public VariableReference() {
		//NotImplementedException.raise();
		setLeft(this); // TODO is this better left null?
		// no contract specifies NotNull...
		setKind(ExpressionKind.VARREF);
	}

	public void setMain(final String s) {
		main = s;
		SimplePrintLoggerToRemoveSoon.println2(repr_());
	}

	@Override
	public String repr_() {
		return String.format("VariableReference (%s)", main);
	}

	public void setMain(final Token t) {
		final String s = t.getText();
		main = s;
		SimplePrintLoggerToRemoveSoon.println2(repr_());
	}

	/**
	 * * no parts, just an ident '
	 * * qualident not implemented
	 * * all parts is dotpart array can be simple too, depending and so can proccall
	 *
	 * @return if no parts specified
	 */
	@Override
	public boolean is_simple() {
		return false;   //parts.size() == 0; // TODO ; || type==VARREF_SIMPLE??
	}

	@Override
	public OS_Type getType() {
		return _type;
	}

	@Override
	public void setType(final OS_Type deducedExpression) {
		_type = deducedExpression;
	}

	@Override
	public String toString() {
		return repr_();
	}

	public String getName() {
//		if (parts.size() >0) throw new IllegalStateException();
		return main;
	}

//	interface VR_Parts {
//
//	}

}


//
//
//
