package tripleo.elijah_prolific_durable.comp;

import tripleo.elijah_prolific_durable.comp.i.IProgressSink;

public record CT_CompilationRunner(
        Compilation compilation,
        Compilation.CIS cis,
        ICompilationBus cb,
        IProgressSink ps
) { }
