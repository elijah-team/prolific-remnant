/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.gen_fn;

import org.jetbrains.annotations.*;

/**
 * Created 8/29/21 5:04 AM
 */
public abstract class BaseTableEntry1 extends BaseTableEntry {

	private ProcTableEntry callable_pte;

	public @Nullable ProcTableEntry getCallablePTE() {
		return callable_pte;
	}

	public void setCallablePTE(final ProcTableEntry aProcTableEntry) {
		callable_pte = aProcTableEntry;
	}

}

//
//
//
