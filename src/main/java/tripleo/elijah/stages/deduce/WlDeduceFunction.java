package tripleo.elijah.stages.deduce;

import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.*;
import tripleo.elijah.work.*;

import java.util.*;

class WlDeduceFunction implements WorkJob {
	private final WorkJob                     workJob;
	private final List<BaseGeneratedFunction> coll;
	private final DeduceTypes2                dt2;
	private       boolean                     _isDone;

	public WlDeduceFunction(final WorkJob aWorkJob, final List<BaseGeneratedFunction> aColl, final DeduceTypes2 aDeduceTypes2) {
		workJob = aWorkJob;
		coll    = aColl;
		dt2     = aDeduceTypes2;
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

		assert coll.size() == 1;

		_isDone = true;
	}

	@Override
	public boolean isDone() {
		return _isDone;
	}
}
