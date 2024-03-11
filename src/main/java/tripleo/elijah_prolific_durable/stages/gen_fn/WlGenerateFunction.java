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
import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah_prolific_durable.util.*;
import tripleo.elijah_prolific_durable.work.*;

/**
 * Created 5/16/21 12:46 AM
 */
public class WlGenerateFunction implements WorkJob {
	private final FunctionDef                 functionDef;
	private final GenerateFunctions           generateFunctions;
	private final FunctionInvocation          functionInvocation;
	private final ICodeRegistrar              codeRegistrar;
	private       boolean                     _isDone = false;
	private       GeneratedFunction           result;
	private final Eventual<GeneratedFunction> egf = new Eventual<>();

	public WlGenerateFunction(final GenerateFunctions aGenerateFunctions, @NotNull final FunctionInvocation aFunctionInvocation, final ICodeRegistrar aCodeRegistrar) {
		functionDef        = (FunctionDef) aFunctionInvocation.getFunction();
		generateFunctions  = aGenerateFunctions;
		functionInvocation = aFunctionInvocation;
		codeRegistrar      = aCodeRegistrar;
	}

	@Override
	public void run(final WorkManager aWorkManager) {
//		if (_isDone) return;

		if (functionInvocation.getGenerated() == null) {
			final OS_Element                 parent = functionDef.getParent();
			@NotNull final GeneratedFunction gf     = generateFunctions.generateFunction(functionDef, parent, functionInvocation);

			{
				int i = 0;
				for (final TypeTableEntry tte : functionInvocation.getArgs()) {
					i = i + 1;
					if (tte.getAttached() == null) {
						final String s = String.format("4949 null tte #%d %s in %s%n", i, tte, gf);
						SimplePrintLoggerToRemoveSoon.println_err2(s);
					}
				}
			}

//			lgf.add(gf);

			if (parent instanceof NamespaceStatement) {
				final NamespaceInvocation nsi = functionInvocation.getNamespaceInvocation();
				assert nsi != null;
				nsi.resolveDeferred().done(new DoneCallback<GeneratedNamespace>() {
					@Override
					public void onDone(final GeneratedNamespace result) {
						if (result.getFunction(functionDef) == null) {
							codeRegistrar.registerFunction(gf);
							result.addFunction(functionDef, gf);
						}
						gf.setClass(result);
					}
				});
			} else {
				final ClassInvocation ci = functionInvocation.getClassInvocation();
				ci.resolvePromise().done(new DoneCallback<GeneratedClass>() {
					@Override
					public void onDone(final GeneratedClass result) {
						if (result.getFunction(functionDef) == null) {
							codeRegistrar.registerFunction(gf);
							result.addFunction(functionDef, gf);
						}
						gf.setClass(result);
					}
				});
			}
			egf.resolve(gf);
			egf.then(result -> {
				functionInvocation.setGenerated(result);
				functionInvocation.generateDeferred().resolve(result);
			});
		} else {
			egf.resolve((GeneratedFunction) functionInvocation.getGenerated()); // double, watch
		}
		_isDone = true;
	}

	@Override
	public boolean isDone() {
		return _isDone;
	}

	@Deprecated public GeneratedFunction getResult() {
		return EventualExtract.of(egf);
	}
	public Eventual<GeneratedFunction> getResultPromise() {
		return egf;
	}
}

//
//
//
