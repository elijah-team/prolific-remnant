/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.Eventual;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.EventualExtract;

import java.util.*;

import static tripleo.elijah.util.Helpers.*;

/**
 * Created 1/21/21 9:04 PM
 */
public class FunctionInvocation {
	public final      ProcTableEntry                                    pte;
	private final     BaseFunctionDef                                   fd;
	private final     DeferredObject<BaseGeneratedFunction, Void, Void> generateDeferred = new DeferredObject<tripleo.elijah.stages.gen_fn.BaseGeneratedFunction, Void, Void>();
	private           ClassInvocation                                   classInvocation;
	private           NamespaceInvocation                               namespaceInvocation;
	private @Nullable BaseGeneratedFunction                             _generated       = null;

	public FunctionInvocation(final BaseFunctionDef aFunctionDef, final ProcTableEntry aProcTableEntry, final @NotNull IInvocation invocation, final GeneratePhase phase) {
		this.fd  = aFunctionDef;
		this.pte = aProcTableEntry;
		assert invocation != null;
		invocation.setForFunctionInvocation(this);
/*
		if (invocation instanceof ClassInvocation)
			setClassInvocation((ClassInvocation) invocation);
		else if (invocation instanceof NamespaceInvocation)
			setNamespaceInvocation((NamespaceInvocation) invocation);
		else if (invocation == null)
			throw new NotImplementedException();
		else
			throw new IllegalArgumentException("Unknown invocation");
*/
//		setPhase(phase);
	}

/*
	public void setPhase(final GeneratePhase generatePhase) {
		if (pte != null)
			pte.completeDeferred().then(new DoneCallback<ProcTableEntry>() {
				@Override
				public void onDone(ProcTableEntry result) {
					makeGenerated(generatePhase, null);
				}
			});
		else
			makeGenerated(generatePhase, null);
	}
*/

	void makeGenerated(@NotNull final GeneratePhase generatePhase, @NotNull final DeducePhase aPhase) {
		@Nullable OS_Module module = null;
		if (fd != null)
			module = fd.getContext().module();
		if (module == null)
			module = classInvocation.getKlass().getContext().module(); // README for constructors
		if (fd == ConstructorDef.defaultVirtualCtor) {
			final Eventual<GenerateFunctions> egf = generatePhase.getGenerateFunctions2(module);
			@NotNull final WlGenerateDefaultCtor wlgdc = new WlGenerateDefaultCtor(EventualExtract.of(egf), this, aPhase.codeRegistrar);
			wlgdc.run(null);
//			GeneratedFunction gf = wlgdc.getResult();
		} else {
			final Eventual<GenerateFunctions> egf1 = generatePhase.getGenerateFunctions2(module);
			@NotNull final WlGenerateFunction wlgf = new WlGenerateFunction(EventualExtract.of(egf1), this, aPhase.codeRegistrar);
			wlgf.run(null);
			final @Nullable OS_Module finalModule = module;
			wlgf.getResultPromise().then(gf->{
				if (gf.getGenClass() == null) {
					if (namespaceInvocation != null) {
//					namespaceInvocation = aPhase.registerNamespaceInvocation(namespaceInvocation.getNamespace());
						final Eventual<GenerateFunctions> egf = generatePhase.getGenerateFunctions2(finalModule);
						@NotNull final WlGenerateNamespace wlgn = new WlGenerateNamespace(EventualExtract.of(egf),
								namespaceInvocation,
								aPhase.generatedClasses,
								aPhase.codeRegistrar);
						wlgn.run(null);
						final int y = 2;
					}
				}
			});
		}
//		if (generateDeferred.isPending()) {
//			generateDeferred.resolve(gf);
//			_generated = gf;
//		}
	}

	public @Nullable BaseGeneratedFunction getGenerated() {
		return _generated;
	}

	public void setGenerated(final BaseGeneratedFunction aGeneratedFunction) {
		_generated = aGeneratedFunction;
	}

	public BaseFunctionDef getFunction() {
		return fd;
	}

	public ClassInvocation getClassInvocation() {
		return classInvocation;
	}

	public void setClassInvocation(@NotNull final ClassInvocation aClassInvocation) {
		classInvocation = aClassInvocation;
	}

	public NamespaceInvocation getNamespaceInvocation() {
		return namespaceInvocation;
	}

	public void setNamespaceInvocation(final NamespaceInvocation aNamespaceInvocation) {
		namespaceInvocation = aNamespaceInvocation;
	}

	public @NotNull DeferredObject<BaseGeneratedFunction, Void, Void> generateDeferred() {
		return generateDeferred;
	}

	public Promise<BaseGeneratedFunction, Void, Void> generatePromise() {
		return generateDeferred.promise();
	}

	public List<TypeTableEntry> getArgs() {
		if (pte == null)
			return List_of();
		return pte.args;
	}

	public boolean sameAs(final @NotNull FunctionInvocation aFunctionInvocation) {
		if (fd != aFunctionInvocation.fd) return false;
		if (pte != aFunctionInvocation.pte) return false;
		if (classInvocation != aFunctionInvocation.classInvocation) return false;
		if (namespaceInvocation != aFunctionInvocation.namespaceInvocation) return false;
		return _generated == aFunctionInvocation._generated;
	}

	public WlGenerateFunction generateFunction(final DeduceTypes2 deduceTypes2, final @NotNull OS_Element aElement) {
		return generateFunction(deduceTypes2, aElement.getContext().module());
	}

	public WlGenerateFunction generateFunction(final @NotNull DeduceTypes2 deduceTypes2, final @NotNull OS_Module aModule) {
		return new WlGenerateFunction(deduceTypes2.getGenerateFunctions(aModule), this, deduceTypes2._phase().codeRegistrar);
	}
}

//
//
//
