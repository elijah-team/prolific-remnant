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
import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;

/**
 * Created 5/16/21 12:46 AM
 */
public class WlGenerateFunction implements WorkJob {
	private final FunctionDef        functionDef;
	private final GenerateFunctions  generateFunctions;
	private final FunctionInvocation functionInvocation;
	private final ICodeRegistrar     codeRegistrar;
	private       boolean            _isDone = false;
	private       GeneratedFunction  result;

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
						Stupidity.println_err2(s);
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
			result = gf;
			functionInvocation.setGenerated(result);
			functionInvocation.generateDeferred().resolve(result);
		} else {
			result = (GeneratedFunction) functionInvocation.getGenerated();
		}
		_isDone = true;
	}

	@Override
	public boolean isDone() {
		return _isDone;
	}

	public GeneratedFunction getResult() {
		return result;
	}
}

//
//
//
