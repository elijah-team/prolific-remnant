/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.gen_fn;

import org.jdeferred2.DoneCallback;
import org.jdeferred2.impl.DeferredObject;
import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.lang.NamespaceStatement;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah_prolific_durable.util.NotImplementedException;
import tripleo.elijah_prolific_durable.work.*;

/**
 * Created 5/31/21 3:01 AM
 */
public class WlGenerateNamespace implements WorkJob {
	private final GenerateFunctions                      generateFunctions;
	private final NamespaceStatement                     namespaceStatement;
	private final NamespaceInvocation                    namespaceInvocation;
	private final DeducePhase.@Nullable GeneratedClasses coll;
	private final ICodeRegistrar                         codeRegistrar;
	private       boolean                                _isDone = false;
	private       GeneratedNamespace                     Result;

	public WlGenerateNamespace(@NotNull final GenerateFunctions aGenerateFunctions,
	                           @NotNull final NamespaceInvocation aNamespaceInvocation,
	                           @Nullable final DeducePhase.GeneratedClasses aColl,
	                           final ICodeRegistrar aCodeRegistrar) {
		generateFunctions   = aGenerateFunctions;
		namespaceStatement  = aNamespaceInvocation.getNamespace();
		namespaceInvocation = aNamespaceInvocation;
		coll                = aColl;
		codeRegistrar       = aCodeRegistrar;
	}

	@Override
	public void run(final WorkManager aWorkManager) {
		final DeferredObject<GeneratedNamespace, Void, Void> resolvePromise = namespaceInvocation.resolveDeferred();
		switch (resolvePromise.state()) {
		case PENDING:
			@NotNull final GeneratedNamespace ns = generateFunctions.generateNamespace(namespaceStatement);
			codeRegistrar.registerNamespace(ns);
			if (coll != null)
				coll.add(ns);

			resolvePromise.resolve(ns);
			Result = ns;
			break;
		case RESOLVED:
			resolvePromise.then(new DoneCallback<GeneratedNamespace>() {
				@Override
				public void onDone(final GeneratedNamespace result) {
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

	public GeneratedNode getResult() {
		return Result;
	}
}

//
//
//
