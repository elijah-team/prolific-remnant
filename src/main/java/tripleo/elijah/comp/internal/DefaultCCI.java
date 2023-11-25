package tripleo.elijah.comp.internal;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.comp.i.CCI;
import tripleo.elijah.comp.i.ILazyCompilerInstructions;
import tripleo.elijah.comp.i.IProgressSink;
import tripleo.elijah.comp.i.ProgressSinkComponent;
import tripleo.elijah.util.Maybe;

public class DefaultCCI implements CCI {
//	private final @NotNull Compilation compilation;
//	private final IProgressSink _ps;
	private final CIS           _cis;

	@Contract(pure = true)
	public DefaultCCI(final @NotNull Compilation ignoredACompilation, final CIS aCis, final IProgressSink ignoredAProgressSink) {
//		compilation = aCompilation;
//		_ps  = aProgressSink;
		_cis = aCis;
	}

	@Override
	public void accept(final @NotNull Maybe<ILazyCompilerInstructions> mcci, final @NotNull IProgressSink aPs) {
		if (mcci.isException()) return;

		final ILazyCompilerInstructions cci = mcci.o;
		final CompilerInstructions      ci  = cci.get();

		aPs.note(IProgressSink.Codes.DefaultCCI_accept, ProgressSinkComponent.CCI, -1, new Object[]{ci.getName()});

		IProgressSink t = null;
		try {
			t       = _cis.ps;
			_cis.ps = aPs;
			_cis.onNext(ci); //CIO::l.add(aCompilerInstructions);
		} finally {
			_cis.ps = t;
		}
		//compilation.pushItem(ci);
	}
}
