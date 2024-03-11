package tripleo.elijah_prolific_durable.stages.deduce;

import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.util.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;
import tripleo.elijah_prolific.eva.*;
import tripleo.elijah_prolific_durable.work.*;

class WlDeduceFunction implements WorkJob {
	private final WorkJob                      workJob;
	private final PR_EvaFunctionList           coll;
	private final DeduceTypes2                 dt2;

	private final Eventual<PR_EvaFunctionList> resultPromise = new Eventual<>();

	final private Eventual<Ok>                 donePromise   = new Eventual<>();
	public WlDeduceFunction(final WorkJob aWorkJob, final PR_EvaFunctionList aColl, final DeduceTypes2 aDeduceTypes2) {
		workJob = aWorkJob;
		dt2     = aDeduceTypes2;
		if (aColl == null) {
			coll = PR_EvaFactory.newFunctionList();
		} else {
			coll = aColl;
		}

		donePromise.then(aOk -> {
			resultPromise.resolve(coll);
		});
	}

	@Override
	public void run(final WorkManager aWorkManager) {
		// TODO assumes result is in the same file as this (DeduceTypes2)

		if (workJob instanceof final WlGenerateFunction wlgf) {
			wlgf.getResultPromise().then((final GeneratedFunction generatedFunction1) -> {
				if (!coll.contains(generatedFunction1)) {
					var generatedFunction2 = generatedFunction1.deductionOf(dt2);
					coll.add(generatedFunction2.getCarrier()); // FIXME remove `carrier'
				}
			});
		} else if (workJob instanceof WlGenerateDefaultCtor wlgdc) {
			wlgdc.getResultPromise().then((final GeneratedConstructor generatedConstructor) -> {
				if (!coll.contains(generatedConstructor)) {
					var generatedFunction2 = generatedConstructor.deductionOf(dt2);
					coll.add(generatedFunction2.getCarrier()); // FIXME remove `carrier'
				}
			});
		} else if (workJob instanceof WlGenerateCtor wlgc) {
			wlgc.getResultPromise().then((final GeneratedConstructor generatedConstructor) -> {
				if (!coll.contains(generatedConstructor)) {
					var generatedFunction2 = generatedConstructor.deductionOf(dt2);
					coll.add(generatedFunction2.getCarrier()); // FIXME remove `carrier'
				}
			});
		} else
			throw new NotImplementedException();

		assert coll.sizeAtLeast(1);

		donePromise.resolve(Ok.instance());
	}

	@Override
	public boolean isDone() {
		return !donePromise.isPending();
	}

	public Eventual<PR_EvaFunctionList> getResultPromise() {
		return resultPromise;
	}
}
