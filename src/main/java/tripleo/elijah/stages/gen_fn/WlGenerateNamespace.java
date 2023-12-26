/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;

/**
 * Created 5/31/21 3:01 AM
 */
public class WlGenerateNamespace implements WorkJob {
	private final GenerateFunctions                      generateFunctions;
	private final NamespaceStatement                     namespaceStatement;
	private final NamespaceInvocation                    namespaceInvocation;
	private final DeducePhase.@Nullable EvaClasses coll;
	private final ICodeRegistrar                         codeRegistrar;
	private       boolean                                _isDone = false;
	private       EvaNamespace                     Result;

	public WlGenerateNamespace(@NotNull final GenerateFunctions aGenerateFunctions,
	                           @NotNull final NamespaceInvocation aNamespaceInvocation,
	                           @Nullable final DeducePhase.EvaClasses aColl,
	                           final ICodeRegistrar aCodeRegistrar) {
		generateFunctions   = aGenerateFunctions;
		namespaceStatement  = aNamespaceInvocation.getNamespace();
		namespaceInvocation = aNamespaceInvocation;
		coll                = aColl;
		codeRegistrar       = aCodeRegistrar;
	}

	@Override
	public void run(final WorkManager aWorkManager) {
		final DeferredObject<EvaNamespace, Void, Void> resolvePromise = namespaceInvocation.resolveDeferred();
		switch (resolvePromise.state()) {
		case PENDING:
			@NotNull final EvaNamespace ns = generateFunctions.generateNamespace(namespaceStatement);
			codeRegistrar.registerNamespace(ns);
			if (coll != null)
				coll.add(ns);

			resolvePromise.resolve(ns);
			Result = ns;
			break;
		case RESOLVED:
			resolvePromise.then(new DoneCallback<EvaNamespace>() {
				@Override
				public void onDone(final EvaNamespace result) {
					Result = result;
				}
			});
			break;
		case REJECTED:
			throw new NotImplementedException();
		}
		_isDone = true;
//		tripleo.elijah.util.Stupidity.println2(String.format("** GenerateNamespace %s at %s", namespaceInvocation.getNamespace().getName(), this));
	}

	@Override
	public boolean isDone() {
		return _isDone;
	}

	public EvaNode getResult() {
		return Result;
	}
}

//
//
//
