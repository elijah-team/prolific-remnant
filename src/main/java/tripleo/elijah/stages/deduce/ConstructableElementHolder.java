/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.*;

/**
 * Created 6/30/21 2:55 AM
 */
public class ConstructableElementHolder implements IElementHolder {
	private final OS_Element    element;
	private final Constructable constructable;

	@Contract(pure = true)
	public ConstructableElementHolder(final OS_Element aElement, final Constructable aConstructable) {
		element       = aElement;
		constructable = aConstructable;
	}

	@Override
	public OS_Element getElement() {
		return element;
	}

	public Constructable getConstructable() {
		return constructable;
	}
}

//
//
//
