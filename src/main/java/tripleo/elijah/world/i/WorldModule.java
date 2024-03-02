package tripleo.elijah.world.i;

import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.inputtree.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.util.Eventual;

public interface WorldModule {
	OS_Module module();

	EIT_ModuleInput input();

//	GN_PL_Run2.GenerateFunctionsRequest rq();

	Eventual<DeducePhase.GeneratedClasses> getEventual();
}
