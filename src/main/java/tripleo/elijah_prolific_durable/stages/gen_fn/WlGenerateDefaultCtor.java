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
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.deduce.*;
import tripleo.elijah_prolific_durable.stages.gen_generic.ICodeRegistrar;
import tripleo.elijah_prolific_durable.util.*;
import tripleo.elijah_prolific_durable.work.*;

/**
 * Created 5/31/21 2:26 AM
 */
public class WlGenerateDefaultCtor implements WorkJob {
	private final GenerateFunctions              generateFunctions;
	private final FunctionInvocation             functionInvocation;
	private final ICodeRegistrar                 codeRegistrar;
	private       boolean                        _isDone = false;
	private       Eventual<GeneratedConstructor> egc     = new Eventual<>();

	@Contract(pure = true)
	public WlGenerateDefaultCtor(@NotNull final GenerateFunctions aGenerateFunctions, final FunctionInvocation aFunctionInvocation, final ICodeRegistrar aCodeRegistrar) {
		generateFunctions  = aGenerateFunctions;
		functionInvocation = aFunctionInvocation;
		codeRegistrar      = aCodeRegistrar;
	}

	@Override
	public void run(final WorkManager aWorkManager) {
		if (functionInvocation.generateDeferred().isPending()) {
			final ClassStatement         klass     = functionInvocation.getClassInvocation().getKlass();
			final Holder<GeneratedClass> hGenClass = new Holder<>();
			functionInvocation.getClassInvocation().resolvePromise().then(hGenClass::set);
			final GeneratedClass genClass = hGenClass.get();
			assert genClass != null;

			final ConstructorDef cd = new ConstructorDef(null, klass, klass.getContext());
//			cd.setName(Helpers.string_to_ident("<ctor>"));
			cd.setName(ConstructorDef.emptyConstructorName);
			final Scope3 scope3 = new Scope3(cd);
			cd.scope(scope3);
			for (final GeneratedContainer.VarTableEntry varTableEntry : genClass.varTable) {
				if (varTableEntry.initialValue != IExpression.UNASSIGNED) {
					final IExpression left  = varTableEntry.nameToken;
					final IExpression right = varTableEntry.initialValue;

					final IExpression e = ExpressionBuilder.build(left, ExpressionKind.ASSIGNMENT, right);
					scope3.add(new WrappedStatementWrapper(e, cd.getContext(), cd, varTableEntry.vs));
				} else {
					if (true) {
						scope3.add(new ConstructStatement(cd, cd.getContext(), varTableEntry.nameToken, null, null));
					}
				}
			}

			final OS_Element classStatement = cd.getParent();
			assert classStatement instanceof ClassStatement;
			@NotNull final GeneratedConstructor gf = generateFunctions.generateConstructor(cd, (ClassStatement) classStatement, functionInvocation);
//		lgf.add(gf);

			final ClassInvocation ci = functionInvocation.getClassInvocation();
			ci.resolvePromise().done(result -> {
				codeRegistrar.registerFunction(gf);
				gf.setClass(result);
				result.constructors.put(cd, gf);
			});

			functionInvocation.generateDeferred().resolve(gf);
			functionInvocation.setGenerated(gf);
			egc.resolve(gf);
		} else {
			functionInvocation.generatePromise().then(p -> egc.resolve((GeneratedConstructor) p));
		}

		_isDone = true;
	}

	@Override
	public boolean isDone() {
		return _isDone;
	}

	private boolean getPragma(final String aAuto_construct) {
		return false;
	}

	public Eventual<GeneratedConstructor> getResultPromise() {
		return egc;
	}
}

//
//
//
