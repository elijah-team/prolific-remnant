/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.gen.nodes;

import tripleo.elijah.gen.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.gen.CompilerContext;
import tripleo.elijah_prolific_durable.lang.VariableReference;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

public class VariableReferenceNode {
	private final CompilerContext   _cctx;
	private final VariableReference _varref;

	public VariableReferenceNode(final CompilerContext cctx, final VariableReference varref) {
		NotImplementedException.raise();
		this._cctx   = cctx;
		this._varref = varref;
	}

	public TypeNameNode getType() {
		NotImplementedException.raise();
		return null;
	}

	public String genText() {
		NotImplementedException.raise();
		return "vtn"; // TODO hardcoded
	}
}

//
//
//
