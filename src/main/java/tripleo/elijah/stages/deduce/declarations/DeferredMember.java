/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce.declarations;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.diagnostic.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;

/**
 * Created 6/27/21 1:41 AM
 */
public class DeferredMember {
	private final OS_Element                                parent;
	private final IInvocation                               invocation;
	private final VariableStatement                         variableStatement;
	private final DeferredObject<GenType, Diagnostic, Void> typePromise = new DeferredObject<GenType, Diagnostic, Void>();
	private final DeferredObject<EvaNode, Void, Void> externalRef = new DeferredObject<EvaNode, Void, Void>();

	public DeferredMember(final OS_Element aParent, final IInvocation aInvocation, final VariableStatement aVariableStatement) {
		parent            = aParent;
		invocation        = aInvocation;
		variableStatement = aVariableStatement;
	}

	public @NotNull Promise<GenType, Diagnostic, Void> typePromise() {
		return typePromise;
	}

	public OS_Element getParent() {
		return parent;
	}

	public IInvocation getInvocation() {
		return invocation;
	}

	public VariableStatement getVariableStatement() {
		return variableStatement;
	}

	// for DeducePhase
	public @NotNull DeferredObject<GenType, Diagnostic, Void> typeResolved() {
		return typePromise;
	}

	public Promise<EvaNode, Void, Void> externalRef() {
		return externalRef.promise();
	}

	public @NotNull DeferredObject<EvaNode, Void, Void> externalRefDeferred() {
		return externalRef;
	}

	@Override
	public @NotNull String toString() {
		return "DeferredMember{" +
		  "parent=" + parent +
		  ", variableName=" + variableStatement.getName() +
		  '}';
	}
}

//
//
//
