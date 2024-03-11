package tripleo.elijah_prolific_durable.comp;

import io.reactivex.rxjava3.annotations.*;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.*;
import tripleo.elijah.ci.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.ci.CompilerInstructions;
import tripleo.elijah_prolific_durable.util.NotImplementedException;

import java.util.*;

public class CompilerInstructionsObserver implements Observer<CompilerInstructions> {
	private final List<CompilerInstructions> l = new ArrayList<>();
	private final Compilation                compilation;

	public CompilerInstructionsObserver(final Compilation aCompilation, final OptionsProcessor ignoredAOp) {
		compilation = aCompilation;
	}

	public CompilerInstructionsObserver(final Compilation aCompilation, final OptionsProcessor ignoredAOp, final Compilation.CIS cis) {
		compilation = aCompilation;
		cis._cio    = this;

		cis.subscribe(this);
	}

	@Override
	public void onSubscribe(@NonNull final Disposable d) {

	}

	@Override
	public void onNext(@NonNull final CompilerInstructions aCompilerInstructions) {
		l.add(aCompilerInstructions);
		//NotImplementedException.raise();
	}

	@Override
	public void onError(@NonNull final Throwable e) {
		NotImplementedException.raise();
	}

	@Override
	public void onComplete() {
		throw new RuntimeException();
	}

	public void almostComplete() {
		try {
			compilation.hasInstructions(l);
		} catch (final Exception aE) {
			compilation.getErrSink().exception(aE);
//			NotImplementedException.raise();
			throw new RuntimeException(aE);
		}
	}
}
