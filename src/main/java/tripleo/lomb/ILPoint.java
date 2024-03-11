package tripleo.lomb;

import tripleo.elijah_prolific_durable.lang.OS_Module;

public interface ILPoint {
	OS_Module definedModule();
	int getLine();
	int getcolumn();
}
