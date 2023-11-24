package tripleo.elijah.world.i;

import tripleo.elijah.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.nextgen.inputtree.*;
import tripleo.elijah.stages.deduce.*;

public interface WorldModule {
	OS_Module module();

	EIT_ModuleInput input();

//	GN_PL_Run2.GenerateFunctionsRequest rq();

	Eventual<DeducePhase.GeneratedClasses> getEventual();
}
