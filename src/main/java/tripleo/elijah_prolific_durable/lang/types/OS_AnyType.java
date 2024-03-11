/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang.types;


import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.lang2.BuiltInTypes;

/**
 * Created 4/25/21 4:43 AM
 */
public class OS_AnyType extends __Abstract_OS_Type {
	public OS_AnyType() {
	}

	@Override
	public ClassStatement getClassOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OS_Type resolve(final Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUnitType() {
		return false;
	}

	@Override
	public BuiltInTypes getBType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeName getTypeName() {
		// TODO Auto-generated method stub
		return null;
	}

	protected boolean _isEqual(final @NotNull OS_Type aType) {
		return aType.getType() == Type.ANY;
	}

	@Override
	public OS_Element getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType() {
		return Type.ANY;
	}

	@Override
	public String asString() {
		return "<OS_AnyType>";
	}
}

//
//
//
