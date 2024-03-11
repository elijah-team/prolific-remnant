package tripleo.elijah_prolific_durable.comp;

import tripleo.elijah_prolific_durable.comp.internal.CompilationBus;

public class DefaultCompilerController extends _AbstractCompilerController implements CompilerController {
    @Override
    public void processOptions() {
        var cb2 = new CompilationBus(c);

        _internal_processOptions(() -> cb2);
    }

//    @Override
    public void __runner() {
        try {
            var ct = new CT_CompilationRunner(c, c._cis, cb, null);
            c.__cr = new CompilationRunner(ct);
            c.__cr.doFindCIs(args2, cb);
        } catch (final Exception e) {
            c.getErrSink().exception(e);
            throw new RuntimeException(e);
        }
    }
}
