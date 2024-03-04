package tripleo.elijah.stages.deduce;

import io.reactivex.rxjava3.annotations.*;
import io.reactivex.rxjava3.subjects.*;
import org.jdeferred2.*;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.*;
import tripleo.elijah.util.Eventual;
import tripleo.elijah.diagnostic.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.EventualExtract;
import tripleo.elijah.work.*;
import tripleo.elijah_prolific.eva.*;
import tripleo.elijah_prolific.util.PRU_ObserverAdapter;

public class Dependencies {
	final         WorkList     wl = new WorkList();
	final         WorkManager  wm;
	private final DeduceTypes2 deduceTypes2;

	Dependencies(final DeduceTypes2 aDeduceTypes2, final WorkManager aWm) {
		deduceTypes2 = aDeduceTypes2;
		wm           = aWm;
	}

	public void action_type(@NotNull final GenType genType) {
		// TODO work this out further, maybe like a Deepin flavor
		if (genType.resolvedn != null) {
			@NotNull final OS_Module           mod = genType.resolvedn.getContext().module();
			final Eventual<GenerateFunctions> egf = deduceTypes2.phase.generatePhase.getGenerateFunctions2(mod);
			final @NotNull GenerateFunctions   gf  = EventualExtract.of(egf);
			final NamespaceInvocation          ni  = deduceTypes2.phase.registerNamespaceInvocation(genType.resolvedn);
			@NotNull final WlGenerateNamespace gen = new WlGenerateNamespace(gf, ni, deduceTypes2.phase.generatedClasses, deduceTypes2.phase.codeRegistrar);

			assert genType.ci == null || genType.ci == ni;
			genType.ci = ni;

			wl.addJob(gen);

			ni.resolvePromise().then(new DoneCallback<GeneratedNamespace>() {
				@Override
				public void onDone(final @NotNull GeneratedNamespace result) {
					genType.node = result;
					result.dependentTypes().add(genType);
				}
			});
		} else if (genType.resolved != null) {
			if (genType.functionInvocation != null) {
				action_function(genType.functionInvocation);
				return;
			}

			final ClassStatement             c   = genType.resolved.getClassOf();
			final @NotNull OS_Module          mod = c.getContext().module();
			final Eventual<GenerateFunctions> egf = deduceTypes2.phase.generatePhase.getGenerateFunctions2(mod);


			final @NotNull GenerateFunctions  gf  = EventualExtract.of(egf);
			@Nullable ClassInvocation        ci;
			if (genType.ci == null) {
				ci = new ClassInvocation(c, null);
				ci = deduceTypes2.phase.registerClassInvocation(ci);

				genType.ci = ci;
			} else {
				assert genType.ci instanceof ClassInvocation;
				ci = (ClassInvocation) genType.ci;
			}

			final Promise<ClassDefinition, Diagnostic, Void> pcd = deduceTypes2.phase.generateClass(gf, ci);

			pcd.then((ClassDefinition aClassDefinition) -> {
				final GeneratedClass genclass = aClassDefinition.getNode();

				genType.node = genclass;
				genclass.dependentTypes().add(genType);
			});
		}
		//
		wm.addJobs(wl);
	}

	public void action_function(@NotNull final FunctionInvocation aDependentFunction) {
		final var dependentFunction = PR_EvaFactory.newDependentFunction(aDependentFunction, this);

		final BaseFunctionDef    function = aDependentFunction.getFunction();
		final @NotNull OS_Module mod;

		final Eventual<WorkJob> ewj = new Eventual<>();

		if (function == ConstructorDef.defaultVirtualCtor) {
			final ClassInvocation ci = aDependentFunction.getClassInvocation();
			if (ci == null) {
				final NamespaceInvocation ni = aDependentFunction.getNamespaceInvocation();
				assert ni != null;
				mod = ni.getNamespace().getContext().module();

				ni.resolvePromise().then(aGeneratedNamespace -> dependentFunction.attachNamespace(aGeneratedNamespace, ni));
			} else {
				mod = ci.getKlass().getContext().module();
				ci.resolvePromise().then(aGeneratedClass -> dependentFunction.attachClass(aGeneratedClass, ci));
			}
			deduceTypes2.getGenerateFunctions2(mod).then((final @NotNull GenerateFunctions gf)->{
				final WlGenerateDefaultCtor wlGenerateDefaultCtor = new WlGenerateDefaultCtor(gf, aDependentFunction, deduceTypes2._phase().codeRegistrar);
//				gen[0] = wlGenerateDefaultCtor;
				ewj.resolve(wlGenerateDefaultCtor);
			});
		} else {
			mod = function.getContext().module();
			deduceTypes2.getGenerateFunctions2(mod).then((final @NotNull GenerateFunctions gf)->{
				final WlGenerateFunction wlGenerateFunction = new WlGenerateFunction(gf, aDependentFunction, deduceTypes2._phase().codeRegistrar);
//				gen[0] = wlGenerateFunction;
				ewj.resolve(wlGenerateFunction);
			});
		}

		ewj.then(j -> {
			wl.addJob(j);
			wl.addJob(new WlDeduceFunction(j, null, deduceTypes2));
			wm.addJobs(wl);
		});

		assert ewj.isResolved();
	}

	public void subscribeFunctions(final Subject<FunctionInvocation> aDependentFunctionSubject) {
		aDependentFunctionSubject.subscribe(new PRU_ObserverAdapter<>() { // not the look i was going for...
			@Override
			public void onNext(@NonNull final FunctionInvocation aFunctionInvocation) {
				action_function(aFunctionInvocation);
			}
		});
	}

	public void subscribeTypes(final Subject<GenType> aDependentTypesSubject) {
		aDependentTypesSubject.subscribe(new PRU_ObserverAdapter<>() { // not the look i was going for...
			@Override
			public void onNext(final GenType aGenType) {
				action_type(aGenType);
			}
		});
	}
}
