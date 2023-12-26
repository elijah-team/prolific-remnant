package tripleo.elijah.comp;

import org.jdeferred2.DoneCallback;
import tripleo.elijah.Eventual;
import tripleo.elijah.comp.i.*;
import tripleo.elijah.comp.internal.*;

@SuppressWarnings("FieldCanBeLocal")
public class CK_ConnectionPlane {
	private final Compilation                 compilation;
	private final CompilerController          compilerController;
	private final Eventual<CR_State>          _p_CR_State          = new Eventual<>();
	private final Eventual<CCI>               _p_CCI               = new Eventual<>();
	private final Eventual<CompilationRunner> _p_CompilationRunner = new Eventual<>();
	private       boolean                     __already_CR_State;

	public CK_ConnectionPlane(final Compilation aC, final CompilerController aCompilerController) {
		compilation        = aC;
		compilerController = aCompilerController;
	}

	public void onCrState(final DoneCallback<CR_State> cb) {
		_p_CR_State.then(cb);
	}

	public void provide(final CompilationRunner aCompilationRunner) {
		if (compilation.getCompilationEnclosure().getCompilationRunner() == null) {
			compilation.getCompilationEnclosure().setCompilationRunner(aCompilationRunner);

			_p_CompilationRunner.resolve(aCompilationRunner);
		}
	}

	public void provide(final ICompilationAccess aca) {
		//noinspection ConstantValue
		if (compilation.getCompilationEnclosure().getCompilationAccess() == null) {
			compilation.getCompilationEnclosure().setCompilationAccess(aca);
		}
	}

	public void provide(final CR_State aCR_state) {
		if (!this.__already_CR_State) {
			_p_CompilationRunner.then(aCR_state::setRunner);

			_p_CR_State.resolve(aCR_state);

			this.__already_CR_State = true;
		}
	}

	public void onCCI(final DoneCallback<CCI> cb) {
		_p_CCI.then(cb);
	}

	public void _defaultCCI(final IProgressSink aProgressSink) {
		var cci = new DefaultCCI(this.compilation, this.compilation._cis(), aProgressSink);
		_p_CCI.resolve(cci);
	}

	public void onCompilationRunner(final DoneCallback<CompilationRunner> cb) {
		_p_CompilationRunner.then(cb);
	}
}
