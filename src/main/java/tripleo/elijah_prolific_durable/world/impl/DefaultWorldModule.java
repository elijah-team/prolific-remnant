package tripleo.elijah_prolific_durable.world.impl;

import tripleo.elijah_prolific_durable.comp.CompilationEnclosure;
import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.nextgen.inputtree.EIT_ModuleInput;
import tripleo.elijah_prolific_durable.stages.deduce.DeducePhase;
import tripleo.elijah_prolific_durable.util.Eventual;
import tripleo.elijah_prolific_durable.world.i.WorldModule;

public class DefaultWorldModule implements WorldModule {
	final Eventual<DeducePhase.GeneratedClasses> _p_GeneratedClasses = new Eventual<>();
//	private       ModuleThing thing;

//	@Getter
//	private GN_PL_Run2.GenerateFunctionsRequest rq;
	private final OS_Module mod;

	public DefaultWorldModule(final OS_Module aMod, final CompilationEnclosure aCe) {
		mod = aMod;
	}

//	public DefaultWorldModule(final OS_Module aMod, final GN_PL_Run2.GenerateFunctionsRequest aRq) {
//		mod = aMod;
//		rq  = aRq;
//	}

	@Override
	public OS_Module module() {
		return mod;
	}

	@Override
	public EIT_ModuleInput input() {
		return null;
	}

//	@Override
//	public GN_PL_Run2.GenerateFunctionsRequest rq() {
//		return rq;
//	}

//	public DefaultWorldModule(final OS_Module aMod, final @NotNull CompilationEnclosure ce) {
//		mod = aMod;
//		final ModuleThing mt = ce.addModuleThing(mod);
//		setThing(mt);
//	}

	@Override
	public Eventual<DeducePhase.GeneratedClasses> getEventual() {
		return _p_GeneratedClasses;
	}

//	public void setRq(final GN_PL_Run2.GenerateFunctionsRequest aRq) {
//		rq = aRq;
//	}

//	public ModuleThing thing() {
//		return thing;
//	}

//	public void setThing(final ModuleThing aThing) {
//		thing = aThing;
//	}
}
