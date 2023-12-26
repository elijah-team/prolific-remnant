package tripleo.elijah.comp.graph.i;

import tripleo.elijah.comp.nextgen.i.*;
import tripleo.elijah.nextgen.inputtree.*;

public interface CK_ObjectTree {
	void asseverate(Object o, Asseverate asseveration);

	void asseverate(Asseveration aAsseveration);

	EIT_InputTree getInputTree();

	EIT_ModuleList getModuleList();
}
