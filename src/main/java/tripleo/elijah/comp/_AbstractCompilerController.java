package tripleo.elijah.comp;

import tripleo.elijah.comp.internal.DefaultProgressSink;

import java.util.List;
import java.util.function.Supplier;

public abstract class _AbstractCompilerController implements CompilerController {
    protected Compilation c;
    List<String>    args;
    String[]        args2;
    protected ICompilationBus cb;


    @Override
    public void printUsage() {
        System.out.println("Usage: eljc [--showtree] [-sE|O] <directory or .ez file names>");
    }

    protected void _internal_processOptions(Supplier<ICompilationBus> scb) {
        final OptionsProcessor             op  = new ApacheOptionsProcessor();
        final CompilerInstructionsObserver cio = new CompilerInstructionsObserver(c, op, c._cis);

        final ICompilationBus cb1 = scb.get();
        this.cb = cb1;

        try {
            args2 = op.process(c, args, cb1);
        } catch (final Exception e) {
            c.getErrSink().exception(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void runner() {
        try {
            final CT_CompilationRunner ct = new CT_CompilationRunner(c, c._cis, cb, new DefaultProgressSink());

            c.__cr = new CompilationRunner(ct);
            c.__cr.doFindCIs(args2, cb);
        } catch (final Exception e) {
            c.getErrSink().exception(e);
            throw new RuntimeException(e);
        }
    }

    public void _set(final Compilation aCompilation, final List<String> aArgs) {
        c    = aCompilation;
        args = aArgs;
    }
}
