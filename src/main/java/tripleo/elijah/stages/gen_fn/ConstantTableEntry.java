/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.post_bytecode.*;

/**
 * Created 9/10/20 4:47 PM
 */
public class ConstantTableEntry {
	public final  IExpression                       initialValue;
	public final  TypeTableEntry                    type;
	final         int                               index;
	private final String                            name;
	private       DeduceElement3_ConstantTableEntry _de3;

	public ConstantTableEntry(final int index, final String name, final IExpression initialValue, final TypeTableEntry type) {
		this.index        = index;
		this.name         = name;
		this.initialValue = initialValue;
		this.type         = type;
	}

	@Override
	public @NotNull String toString() {
		return "ConstantTableEntry{" +
		  "index=" + index +
		  ", name='" + name + '\'' +
		  ", initialValue=" + initialValue +
		  ", type=" + type +
		  '}';
	}

	public String getName() {
		return name;
	}

	public TypeTableEntry getTypeTableEntry() {
		return type;
	}

//    public void setName(String name) {
//        this.name = name;
//    }

	public DeduceElement3_ConstantTableEntry getDeduceElement3() {
		if (_de3 == null) {
			_de3 = new DeduceElement3_ConstantTableEntry(this);
//			_de3.
		}
		return _de3;
	}

}

//
//
//
