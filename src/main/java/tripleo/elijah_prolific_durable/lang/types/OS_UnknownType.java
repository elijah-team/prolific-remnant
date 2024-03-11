/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang.types;

import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.*;

/**
 * Created 1/22/21 8:34 AM
 */
public class OS_UnknownType extends __Abstract_OS_Type {
	private final OS_Element _element;

	public OS_UnknownType(final OS_Element aElement) {
		_element = aElement;
	}

	@Override
	public OS_Element getElement() {
		return _element; // !!
	}

	@Override
	public Type getType() {
		return Type.UNKNOWN;
	}

	@Override
	public String asString() {
		return ("<OS_UnknownType>");
	}

	protected boolean _isEqual(final OS_Type aType) {
		return aType.getType() == Type.UNKNOWN;
	}
}

//
//
//
