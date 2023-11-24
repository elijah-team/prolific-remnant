/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.util.*;

/**
 * Created 11/18/21 12:02 PM
 */
public class DeduceTypeResolve {
	private final BaseTableEntry                              bte;
	private final DeferredObject<GenType, ResolveError, Void> typeResolution = new DeferredObject<GenType, ResolveError, Void>();
	BaseTableEntry backlink;

	public DeduceTypeResolve(final BaseTableEntry aBte) {
		bte = aBte;
		if (bte instanceof IdentTableEntry) {
			((IdentTableEntry) bte).backlinkSet()
			                       .then((final InstructionArgument backlink0) ->
			                         __setBacklink_for_IdentTableEntry(backlink0));
		} else if (bte instanceof VariableTableEntry) {
			backlink = null;
		} else if (bte instanceof ProcTableEntry) {
			backlink = null;
		} else
			throw new IllegalStateException();

		if (backlink != null) {
		} else {
			bte.addStatusListener(new BaseTableEntry.StatusListener() {
				@Override
				public void onChange(final IElementHolder eh, final BaseTableEntry.Status newStatus) {
					if (newStatus != BaseTableEntry.Status.KNOWN) return;

					final GenType genType = new GenType();
					__modifyGenType(eh, genType);

					if (!typeResolution.isPending()) {
						final int y = 2;

						final GenType[] x = new GenType[1];

						typeResolution.promise()
						              .then((xx) -> {
							              x[0] = xx;
						              });

						SimplePrintLoggerToRemoveSoon.println_err("** typeResolution already resolved for " + eh.getElement() + " to " + x[0]);
					} else {
						if (!genType.isNull())
							typeResolution.resolve(genType);
					}
				}

				private void __modifyGenType(final @NotNull IElementHolder eh, final @NotNull GenType genType) {
					eh.getElement().visitGen(new AbstractCodeGen() {
						@Override
						public void addClass(final ClassStatement klass) {
							genType.resolved = klass.getOS_Type();
						}

						@Override
						public void visitAliasStatement(final AliasStatement aAliasStatement) {
							SimplePrintLoggerToRemoveSoon.println_err(String.format("** AliasStatement %s points to %s%n", aAliasStatement.name(), aAliasStatement.getExpression()));
						}

						@Override
						public void visitFormalArgListItem(final @NotNull FormalArgListItem aFormalArgListItem) {
							final OS_Type attached;
							if (bte instanceof VariableTableEntry)
								attached = ((VariableTableEntry) bte).type.getAttached();
							else if (bte instanceof IdentTableEntry) {
								final IdentTableEntry identTableEntry = (IdentTableEntry) DeduceTypeResolve.this.bte;
								if (identTableEntry.type == null)
									return;
								attached = identTableEntry.type.getAttached();
							} else
								throw new IllegalStateException("invalid entry (bte) " + bte);

							final String s;
							if (attached != null)
								s = String.format("** FormalArgListItem %s attached is not null. Type is %s. Points to %s%n",
								  aFormalArgListItem.name(), aFormalArgListItem.typeName(), attached);
							else
								s = String.format("** FormalArgListItem %s attached is null. Type is %s.%n",
								  aFormalArgListItem.name(), aFormalArgListItem.typeName());

							SimplePrintLoggerToRemoveSoon.println_err2(s);
						}

						@Override
						public void visitFunctionDef(final FunctionDef aFunctionDef) {
							genType.resolved = aFunctionDef.getOS_Type();
						}

						@Override
						public void visitIdentExpression(final IdentExpression aIdentExpression) {
							new DTR_IdentExpresssion(DeduceTypeResolve.this, aIdentExpression, bte).run(eh, genType);
						}

						@Override
						public void visitMC1(final MatchConditional.MC1 aMC1) {
							if (aMC1 instanceof final MatchConditional.MatchArm_TypeMatch typeMatch) {
								final int                                 yy        = 2;
							}
						}

						@Override
						public void visitPropertyStatement(final PropertyStatement aPropertyStatement) {
							genType.typeName = new OS_UserType(aPropertyStatement.getTypeName());
							// TODO resolve??
						}

						@Override
						public void visitVariableStatement(final VariableStatement variableStatement) {
							new DTR_VariableStatement(DeduceTypeResolve.this, variableStatement).run(eh, genType);
						}

						@Override
						public void visitConstructorDef(final ConstructorDef aConstructorDef) {
							final int y = 2;
						}

						@Override
						public void visitDefFunction(final DefFunctionDef aDefFunctionDef) {
							SimplePrintLoggerToRemoveSoon.println_err(String.format("** DefFunctionDef %s is %s%n", aDefFunctionDef.name(), ((StatementWrapper) aDefFunctionDef.getItems().iterator().next()).getExpr()));
						}

						@Override
						public void defaultAction(final OS_Element anElement) {
							SimplePrintLoggerToRemoveSoon.println_err2("158 " + anElement);
							throw new IllegalStateException();
						}

					});
				}
			});
		}


	}

	private void __setBacklink_for_IdentTableEntry(final InstructionArgument backlink0) {
		if (backlink0 instanceof IdentIA) {
			setBacklinkCallback_(((IdentIA) backlink0).getEntry());
		} else if (backlink0 instanceof IntegerIA) {
			setBacklinkCallback_(((IntegerIA) backlink0).getEntry());
		} else if (backlink0 instanceof ProcIA) {
			setBacklinkCallback_(((ProcIA) backlink0).getEntry());
		} else {
			// README "fails" here for Label, LabelIA, SymbolIA, ConstTableIA, FnCallArgs
			backlink = null;
		}
	}

	private static void variableTableEntry_typeResolvePromise(final GenType result, final IElementHolder eh, final VariableTableEntry variableTableEntry) {
		if (eh instanceof final Resolve_Ident_IA.GenericElementHolderWithDC eh1) {
			final DeduceTypes2.DeduceClient3                  dc  = eh1.getDC();
			dc.genCIForGenType2(result);
		}
		// maybe set something in ci to INHERITED, but thats what DeduceProcCall is for
		if (eh.getElement() instanceof FunctionDef) {
			if (result.node instanceof final GeneratedClass generatedClass) {
				generatedClass.functionMapDeferred((FunctionDef) eh.getElement(), new FunctionMapDeferred() {
					@Override
					public void onNotify(final GeneratedFunction aGeneratedFunction) {
						result.node = aGeneratedFunction;
					}
				});
			}
		}
		variableTableEntry.type.setAttached(result);
	}

	private void setBacklinkCallback_(final BaseTableEntry aBacklink) {
		assert bte instanceof IdentTableEntry;

		backlink = aBacklink;

		//

		backlink.addStatusListener(new BaseTableEntry.StatusListener() {
			@Override
			public void onChange(final IElementHolder eh, final BaseTableEntry.Status newStatus) {
				if (newStatus != BaseTableEntry.Status.KNOWN) return;

				if (backlink instanceof final IdentTableEntry identTableEntry) {
					identTableEntry.typeResolvePromise().done(new DoneCallback<GenType>() {
						@Override
						public void onDone(final GenType result) {
							if (identTableEntry.type != null) // TODO addPotentialType
								identTableEntry.type.setAttached(result);
						}
					});
				} else if (backlink instanceof final VariableTableEntry variableTableEntry) {
					variableTableEntry.typeResolvePromise()
					                  .done((aGenType__) ->
					                    variableTableEntry_typeResolvePromise(aGenType__, eh, variableTableEntry));
				} else if (backlink instanceof final ProcTableEntry procTableEntry) {
					procTableEntry.typeResolvePromise()
					              .done((final GenType aGenType__) ->
					                procTableEntry_typeResolvePromise(aGenType__, procTableEntry));
				}
			}
		});

	}

	private void procTableEntry_typeResolvePromise(final GenType result, final ProcTableEntry procTableEntry) {
		// procTableEntry.type.setAttached(result);

		procTableEntry.typePromise().then(aGenType__ -> {
			assert aGenType__ == result;
		});

		final int            y              = 2;
		final ClassStatement classStatement = result.resolved.getClassOf();

		assert bte instanceof IdentTableEntry;

		final String               text = ((IdentTableEntry) bte).getIdent().getText();
		final LookupResultList     lrl  = classStatement.getContext().lookup(text);
		final @Nullable OS_Element e    = lrl.chooseBest(null);

//		procTableEntry.setStatus(BaseTableEntry.Status.KNOWN, new GenericElementHolder(classStatement));  // infinite recursion
		final ProcTableEntry callablePTE = ((IdentTableEntry) bte).getCallablePTE();
		if (callablePTE != null && e != null) {
			assert e instanceof BaseFunctionDef;  // sholud fail for constructor and destructor
			callablePTE.setStatus(BaseTableEntry.Status.KNOWN, new GenericElementHolder(e));
		}
	}

	public Promise<GenType, ResolveError, Void> typeResolution() {
		return typeResolution.promise();
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
