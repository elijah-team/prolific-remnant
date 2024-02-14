package tripleo.elijah.ut;

import tripleo.elijah.comp.*;

import java.util.List;

public class UT_Controller extends _AbstractCompilerController implements CompilerController {
    private final UT_Root utr;

    public UT_Controller(final UT_Root aUtr) {
        utr = aUtr;
    }

    @Override
    public void processOptions() {
        var cb2 = new UT_CompilationBus(c, this);

        _internal_processOptions(() -> cb2);
    }

    public List<ICompilationBus.CB_Action> actions() {
        return ((UT_CompilationBus) cb).actions;
    }

    public UT_CompilationBus cb() {
        return (UT_CompilationBus) cb;
    }
}
