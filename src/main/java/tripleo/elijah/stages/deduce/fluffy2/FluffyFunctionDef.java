package tripleo.elijah.stages.deduce.fluffy2;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.NotImplementedException;

import java.util.List;

public class FluffyFunctionDef {
    private final FunctionDef           fd;
    private final DeduceTypes2          deduceTypes2;
    private final BaseGeneratedFunction generatedFunction;

    public FluffyFunctionDef(final FunctionDef aFd, final DeduceTypes2 aDeduceTypes2, final BaseGeneratedFunction aGf) {
        fd                = aFd;
        deduceTypes2      = aDeduceTypes2;
        generatedFunction = aGf;
    }

    public void _foundElement_002(final ProcTableEntry pte, final VariableTableEntry vte, final int instructionIndex) {
        final @Nullable IInvocation invocation;
        if (fd.getParent() == generatedFunction.getFD().getParent()) {
            invocation = deduceTypes2.getInvocation((GeneratedFunction) generatedFunction);
        } else {
            if (fd.getParent() instanceof NamespaceStatement) {
                final NamespaceInvocation ni = deduceTypes2._phase().registerNamespaceInvocation((NamespaceStatement) fd.getParent());
                invocation = ni;
            } else if (fd.getParent() instanceof final @NotNull ClassStatement classStatement) {
                @Nullable ClassInvocation     ci          = new ClassInvocation(classStatement, null);
                final @NotNull List<TypeName> genericPart = classStatement.getGenericPart();
                if (genericPart.size() > 0) {
                    // TODO handle generic parameters somehow (getInvocationFromBacklink?)

                }
                ci         = deduceTypes2._phase().registerClassInvocation(ci);
                invocation = ci;
            } else
                throw new NotImplementedException();
        }

        final FunctionInvocation functionInvocation = deduceTypes2.newFunctionInvocation__(fd, pte, invocation, deduceTypes2._phase());
        deduceTypes2.forFunction__(functionInvocation, new ForFunction() {
            @Override
            public void typeDecided(@NotNull final GenType aType) {
                if (!vte.typeDeferred_isPending()) {
                    if (vte.resolvedType() == null) {
                        final @Nullable ClassInvocation ci = deduceTypes2.genCI(aType, null);
                        assert ci != null;
                        vte.type.genTypeCI(ci);
                        ci.resolvePromise().then(vte::resolveTypeToClass);
                    }
                    deduceTypes2._LOG().err("2041 type already found " + vte);
                    return; // type already found
                }
                // I'm not sure if below is ever called
                @NotNull final TypeTableEntry tte = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.TRANSIENT, deduceTypes2.gt__(aType), pte.expression, pte);
                vte.addPotentialType(instructionIndex, tte);
            }
        });
    }
}
