package tripleo.elijah.stages.deduce.fluffy2;

import org.jdeferred2.DoneCallback;
import org.jetbrains.annotations.*;
import tripleo.elijah.Eventual;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang.types.*;
import tripleo.elijah.lang2.BuiltInTypes;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.NotImplementedException;
import tripleo.elijah_prolific.v.V;

import java.util.*;

public class FluffyFnCallArgs {
    private final FnCallArgs            fca;
    private final DeduceTypes2          deduceTypes2;
    private final BaseGeneratedFunction generatedFunction;

    public FluffyFnCallArgs(FnCallArgs fnCallArgs, DeduceTypes2 deduceTypes2, @NotNull BaseGeneratedFunction aGf) {
        this.fca               = fnCallArgs;
        this.deduceTypes2      = deduceTypes2;
        this.generatedFunction = aGf;
    }

    public void do_assign_call(final @NotNull Context ctx,
                               final @NotNull VariableTableEntry vte,
                               final @NotNull Instruction instruction) {
        final int                           instructionIndex = instruction.getIndex();
        final Optional<InstructionArgument> oia              = fca.getArg2(0);

        if (oia.isEmpty()) return; // style !!
        else {
            final InstructionArgument ia = oia.get();

            final @NotNull ProcTableEntry pte     = generatedFunction.getProcTableEntry(deduceTypes2.to_int(ia));
            @NotNull final IdentIA        identIA = (IdentIA) pte.expression_num;

            if (vte.getStatus() == BaseTableEntry.Status.UNCHECKED) {
                pte.typePromise().then(new DoneCallback<GenType>() {
                    @Override
                    public void onDone(final GenType result) {
                        vte.resolveType(result);
                    }
                });
                if (vte.getResolvedElement() != null) {
                    try {
                        final IExpression el2 = deduceTypes2.dac_lookup_token__(vte.getResolvedElement());
                        final OS_Element  el  = DeduceLookupUtils.lookup__(el2, ctx, deduceTypes2);
                        vte.setStatus(BaseTableEntry.Status.KNOWN, new GenericElementHolder(el));
                    } catch (final ResolveError aResolveError) {
                        deduceTypes2._errSink().reportDiagnostic(aResolveError);
                        return;
                    }
                }
            }

            if (identIA != null) {
//			LOG.info("594 "+identIA.getEntry().getStatus());

                deduceTypes2.resolveIdentIA_(ctx, identIA, generatedFunction, new FoundElement(deduceTypes2._phase()) {
                    final Fluffy2ResolveOp ro = new Fluffy2ResolveOp(deduceTypes2, ctx, identIA, generatedFunction, "resolveIdentIA_,identIA!=null,FluffyFnCallArgs::do_assign_call", null);
                    final String xx = generatedFunction.getIdentIAPathNormal(identIA);

                    @Override
                    public void foundElement(final OS_Element e) {
                        _foundElement_001(e, pte, vte, instructionIndex, ro);
                    }

                    @Override
                    public void noFoundElement() {
                        // TODO create Diagnostic and quit
                        deduceTypes2._LOG().info("1005 Can't find element for " + xx);
                    }
                });
            }
            final List<TypeTableEntry> args = pte.getArgs();
            for (int i = 0; i < args.size(); i++) {
                final TypeTableEntry tte = args.get(i); // TODO this looks wrong
//			    LOG.info("770 "+tte);
                _do_assign_call__args_TTE(ctx, vte, tte, instructionIndex, pte, i);
            }
            _do_assign_call__post(ctx, vte, instruction, pte, instructionIndex, identIA);
        }
    }

    private void _do_assign_call__post(final @NotNull Context ctx,
                                       final @NotNull VariableTableEntry vte,
                                       final @NotNull Instruction instruction,
                                       final @NotNull ProcTableEntry pte,
                                       final int instructionIndex,
                                       final @NotNull IdentIA identIA) {
        if (pte.expression_num == null) {
            if (fca.expression_to_call.getName() != InstructionName.CALLS) {
                final String           text = ((IdentExpression) pte.expression).getText();
                final LookupResultList lrl  = ctx.lookup(text);

                final @Nullable OS_Element best = lrl.chooseBest(null);
                if (best != null)
                    pte.setResolvedElement(best); // TODO do we need to add a dependency for class?
                else {
                    deduceTypes2._errSink().reportError("Cant resolve " + text);
                }
            } else {
                deduceTypes2.implement_calls__(generatedFunction, ctx.getParent(), instruction.getArg(1), pte, instructionIndex);
            }
        } else {
            final int y = 2;
            deduceTypes2.resolveIdentIA_(ctx, identIA, generatedFunction, new FoundElement(deduceTypes2._phase()) {
                final String x = generatedFunction.getIdentIAPathNormal(identIA);

                @Override
                public void foundElement(final OS_Element el) {
                    _foundElement_002(el, pte, vte, instructionIndex);
                }

                @Override
                public void noFoundElement() {
                    deduceTypes2._LOG().err("IdentIA path cannot be resolved " + x);
                }
            });
        }
    }

    private void _foundElement_002(final OS_Element el,
                                   final @NotNull ProcTableEntry pte,
                                   final @NotNull VariableTableEntry vte,
                                   final int instructionIndex) {
        if (pte.getResolvedElement() == null)
            pte.setResolvedElement(el);
        if (el instanceof @NotNull final FunctionDef fd) {
            ((FluffyFunctionDef) deduceTypes2.getFluffy(fd, generatedFunction))._foundElement_002(pte, vte, instructionIndex);
        } else if (el instanceof @NotNull final ClassStatement kl) {
            ((FluffyClassStatement) deduceTypes2.getFluffy(kl, generatedFunction))._foundElement_002(pte, vte, instructionIndex);
        } else {
            deduceTypes2._LOG().err("7890 " + el.getClass().getName());
        }
    }

    private void _do_assign_call__args_TTE(final @NotNull Context ctx, final @NotNull VariableTableEntry vte, final TypeTableEntry tte, final int instructionIndex, final @NotNull ProcTableEntry pte, final int i) {
        final IExpression e = tte.expression;
        if (e == null) return;
        switch (e.getKind()) {
            case NUMERIC:
                tte.setAttached(new OS_BuiltinType(BuiltInTypes.SystemInteger));
                //vte.type = tte;
                break;
            case CHAR_LITERAL:
                tte.setAttached(new OS_BuiltinType(BuiltInTypes.SystemCharacter));
                break;
            case IDENT:
                deduceTypes2.do_assign_call_args_ident__(generatedFunction, ctx, vte, instructionIndex, pte, i, tte, (IdentExpression) e);
                break;
            case PROCEDURE_CALL: {
                final @NotNull ProcedureCallExpression pce = (ProcedureCallExpression) e;
                try {
                    final LookupResultList lrl  = DeduceLookupUtils.lookupExpression(pce.getLeft(), ctx, deduceTypes2);
                    @Nullable OS_Element   best = lrl.chooseBest(null);
                    if (best != null) {
                        while (best instanceof AliasStatement) {
                            best = DeduceLookupUtils._resolveAlias2((AliasStatement) best, deduceTypes2);
                        }
                        if (best instanceof FunctionDef) {
                            final OS_Element            parent = best.getParent();
                            @Nullable final IInvocation invocation;
                            if (parent instanceof NamespaceStatement) {
                                invocation = deduceTypes2._phase().registerNamespaceInvocation((NamespaceStatement) parent);
                            } else if (parent instanceof ClassStatement) {
                                @NotNull final ClassInvocation ci = new ClassInvocation((ClassStatement) parent, null);
                                invocation = deduceTypes2._phase().registerClassInvocation(ci);
                            } else
                                throw new NotImplementedException(); // TODO implement me

                            deduceTypes2.forFunction__(deduceTypes2.newFunctionInvocation__((FunctionDef) best, pte, invocation, deduceTypes2._phase()), new ForFunction() {
                                @Override
                                public void typeDecided(@NotNull final GenType aType) {
                                    tte.setAttached(deduceTypes2.gt__(aType)); // TODO stop setting attached!
                                    tte.genType.copy(aType);
//										vte.addPotentialType(instructionIndex, tte);
                                }
                            });
//								tte.setAttached(new OS_FuncType((FunctionDef) best));

                        } else {
                            final int y = 2;
                            throw new NotImplementedException();
                        }
                    } else {
                        final int y = 2;
                        throw new NotImplementedException();
                    }
                } catch (final ResolveError aResolveError) {
//					aResolveError.printStackTrace();
//					final int y = 2;
//					throw new NotImplementedException();
                    V.asv(V.e.DT2_1785, "" + aResolveError);
                }
            }
            break;
            case DOT_EXP: {
                final @NotNull DotExpression de = (DotExpression) e;
                try {
                    final LookupResultList lrl  = DeduceLookupUtils.lookupExpression(de.getLeft(), ctx, deduceTypes2);
                    @Nullable OS_Element   best = lrl.chooseBest(null);
                    if (best != null) {
                        while (best instanceof AliasStatement) {
                            best = DeduceLookupUtils._resolveAlias2((AliasStatement) best, deduceTypes2);
                        }
                        if (best instanceof FunctionDef) {
                            tte.setAttached(new OS_FuncType((FunctionDef) best));
                            //vte.addPotentialType(instructionIndex, tte);
                        } else if (best instanceof ClassStatement) {
                            tte.setAttached(new OS_UserClassType((ClassStatement) best));
                        } else if (best instanceof final @NotNull VariableStatement vs) {
                            @Nullable final InstructionArgument vte_ia = generatedFunction.vte_lookup(vs.getName());
                            final TypeTableEntry                tte1   = ((IntegerIA) vte_ia).getEntry().type;
                            tte.setAttached(tte1.getAttached());
                        } else {
                            final int y = 2;
                            deduceTypes2._LOG().err(best.getClass().getName());
                            throw new NotImplementedException();
                        }
                    } else {
                        final int y = 2;
                        throw new NotImplementedException();
                    }
                } catch (final ResolveError aResolveError) {
                    aResolveError.printStackTrace();
                    final int y = 2;
                    throw new NotImplementedException();
                }
            }
            break;

            case GET_ITEM: {
                final @NotNull GetItemExpression gie = (GetItemExpression) e;
                deduceTypes2.do_assign_call_GET_ITEM__(gie, tte, generatedFunction, ctx);
                return;
            }
//				break;
            default:
                throw new IllegalStateException("Unexpected value: " + e.getKind());
        }
    }

    private void _foundElement_001(final OS_Element e,
                                   final @NotNull ProcTableEntry pte,
                                   final @NotNull VariableTableEntry vte,
                                   final int instructionIndex,
                                   final Fluffy2ResolveOp op) {
        final @NotNull IdentIA identIA = op.identIA();

//					LOG.info(String.format("600 %s %s", xx ,e));
//					LOG.info("601 "+identIA.getEntry().getStatus());
        final OS_Element resolved_element = identIA.getEntry().getResolvedElement();
        assert e == resolved_element;
//					set_resolved_element_pte(identIA, e, pte);
        pte.setStatus(BaseTableEntry.Status.KNOWN, new ConstructableElementHolder(e, identIA));
        pte.onFunctionInvocation(aFunctionInvocation -> aFunctionInvocation.generateDeferred().done(bgf -> {
            final @NotNull DeduceTypes2.PromiseExpectation<GenType> pe = deduceTypes2.promiseExpectation(bgf, "Function Result type");

            final Eventual<GenType> egt = new Eventual<>();
            egt.then(result -> {
                pe.satisfy(result);
                final @NotNull TypeTableEntry tte = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.TRANSIENT, result.resolved); // TODO there has to be a better way
                tte.genType.copy(result);
                vte.addPotentialType(instructionIndex, tte);
            });

            egt.register(op.deduceTypes2().PromiseExpectationRegister()); // really want dt2.

            bgf.onType(egt::resolve);
        }));
    }
}
