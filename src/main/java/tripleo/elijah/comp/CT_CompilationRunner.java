package tripleo.elijah.comp;

import tripleo.elijah.comp.i.IProgressSink;

public record CT_CompilationRunner(
        Compilation compilation,
        Compilation.CIS cis,
        ICompilationBus cb,
        IProgressSink ps
) { }
