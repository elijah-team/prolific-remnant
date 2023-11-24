package tripleo.elijah.stages.deduce.post_bytecode;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

public class DG_FunctionDef implements DG_Item {
	private final FunctionDef functionDef;

	public DG_FunctionDef(final FunctionDef aFunctionDef) {
		functionDef = aFunctionDef;
	}

	public OS_Element getFunctionDef() {
		return functionDef;
	}
}
