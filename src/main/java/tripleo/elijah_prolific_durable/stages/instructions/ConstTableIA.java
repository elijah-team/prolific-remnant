/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.instructions;

import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

/**
 * Created 9/10/20 3:35 PM
 */
public class ConstTableIA implements InstructionArgument {
	private final BaseGeneratedFunction gf;
	private final int                   index;

	public ConstTableIA(final int index, final BaseGeneratedFunction generatedFunction) {
		this.index = index;
		this.gf    = generatedFunction;
	}

	@Override
	public String toString() {
		final ConstantTableEntry constantTableEntry = gf.cte_list.get(index);
		final String             name               = constantTableEntry.getName();
		if (name != null)
			return String.format("(ct %d) [%s=%s]", index, name, constantTableEntry.initialValue);
		else
			return String.format("(ct %d) [%s]", index, constantTableEntry.initialValue);
	}

	public int getIndex() {
		return index;
	}

	public ConstantTableEntry getEntry() {
		return gf.getConstTableEntry(index);
	}
}

//
//
//
