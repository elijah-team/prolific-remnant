package tripleo.elijah_prolific.deduce;

import tripleo.elijah_prolific_durable.comp.ErrSink;
import tripleo.elijah_prolific_durable.lang.Context;
import tripleo.elijah_prolific_durable.lang.OS_Element;
import tripleo.elijah_prolific_durable.stages.deduce.DeduceTypes2;
import tripleo.elijah_prolific_durable.stages.gen_fn.BaseGeneratedFunction;

public interface DT_Element3 {
	OS_Element getResolvedElement();

	void setErrSink(ErrSink aErrSink);

	void setGeneratedFunction(BaseGeneratedFunction aGeneratedFunction);

	void setContext(Context aContext);

	void setDeduceTypes2(DeduceTypes2 aDeduceTypes2);

	void op_fail(DTEL aDTEL);

	ErrSink getErrSink();

	public enum DTEL {
		d999_163
	}
}
