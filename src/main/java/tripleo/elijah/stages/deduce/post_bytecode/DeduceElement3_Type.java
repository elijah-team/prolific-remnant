package tripleo.elijah.stages.deduce.post_bytecode;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.GenType;
import tripleo.elijah.stages.gen_fn.TypeTableEntry;
import tripleo.elijah.util.Operation2;

/**
 * Also {@link tripleo.elijah.stages.deduce.post_bytecode.DeduceType3}
 */
public interface DeduceElement3_Type {
	GenType genType();

	Operation2<GenType> resolved(Context ectx);

	TypeTableEntry typeTableEntry();
}
