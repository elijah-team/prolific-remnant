package tripleo.elijah.stages.deduce.tastic;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.IdentTableEntry;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;
import tripleo.elijah.stages.instructions.Instruction;

public interface ITastic {
	void do_assign_call(BaseEvaFunction aGeneratedFunction, Context aFdCtx, IdentTableEntry aIdte, int aIndex);

	void do_assign_call(BaseEvaFunction aGeneratedFunction, Context aContext, VariableTableEntry aVte, Instruction aInstruction, final OS_Element aName);
}
