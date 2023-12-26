/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jdeferred2.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.contexts.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang.types.*;
import tripleo.elijah.nextgen.query.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.deduce.zero.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah.util.*;

import java.util.*;

/**
 * Created 5/31/21 1:32 PM
 */
public class GenType {
	static @Nullable GenType makeFromOSType(@NotNull OS_Type aVt, ClassInvocation.CI_GenericPart aGenericPart, @NotNull DeduceTypes2 dt2, DeducePhase phase, @NotNull ElLog aLOG, @NotNull ErrSink errSink) {
		return makeGenTypeFromOSType(aVt, aGenericPart, aLOG, errSink, dt2, phase);
	}
	static @Nullable GenType makeGenTypeFromOSType(@NotNull OS_Type aType,
	                                               ClassInvocation.@NotNull CI_GenericPart aGenericPart,
	                                               @NotNull ElLog aLOG,
	                                               @NotNull ErrSink errSink, @NotNull DeduceTypes2 dt2, DeducePhase phase) {
		GenType gt = new GenType();
		gt.setTypeName(aType);
		if (aType.getType() == OS_Type.Type.USER) {
			final TypeName tn1 = aType.getTypeName();
			if (tn1.isNull()) return null; // TODO Unknown, needs to resolve somewhere

			assert tn1 instanceof NormalTypeName;
			final NormalTypeName       tn  = (NormalTypeName) tn1;
			final LookupResultList     lrl = tn.getContext().lookup(tn.getName());
			final @Nullable OS_Element el  = lrl.chooseBest(null);

			DeduceTypes2.ProcessElement.processElement(el, new DeduceTypes2.IElementProcessor() {
				private void __hasElement__typeNameElement(final ClassContext.@NotNull OS_TypeNameElement typeNameElement) {
					assert aGenericPart != null;

					final OS_Type x = aGenericPart.get(typeNameElement.getTypeName());

					switch (x.getType()) {
						case USER_CLASS:
							final @Nullable ClassStatement classStatement1 = x.getClassOf(); // always a ClassStatement

							assert classStatement1 != null;

							// TODO test next 4 (3) lines are copies of above
							gt.setResolved(classStatement1.getOS_Type());
							break;
						case USER:
							final NormalTypeName tn2 = (NormalTypeName) x.getTypeName();
							final LookupResultList lrl2 = tn.getContext().lookup(tn2.getName());
							final @Nullable OS_Element el2 = lrl2.chooseBest(null);

							// TODO test next 4 lines are copies of above
							if (el2 instanceof final @NotNull ClassStatement classStatement2) {
								gt.setResolved(classStatement2.getOS_Type());
							} else
								throw new NotImplementedException();
							break;
					}
				}

				@Override
				public void elementIsNull() {
					NotImplementedException.raise();
				}

				private void gotResolved(final @NotNull GenType gt) {
					if (gt.getResolved().getClassOf().getGenericPart().size() != 0) {
						//throw new AssertionError();
						aLOG.info("149 non-generic type " + tn1);
					}
					gt.genCI(null, dt2, errSink, phase); // TODO aGenericPart
					assert gt.getCi() != null;
					genNodeForGenType2(gt);
				}

				@Override
				public void hasElement(final OS_Element el) {
					final Operation2<OS_Element> best1 = preprocess(el);
					if (best1.mode() == Mode.FAILURE) {
						aLOG.err("152 Can't resolve Alias statement " + el);
						errSink.reportDiagnostic(best1.failure());
						return;
					}

					final OS_Element best = best1.success();

					switch (DecideElObjectType.getElObjectType(best)) {
						case CLASS:
							final ClassStatement classStatement = (ClassStatement) best;
							gt.setResolved(classStatement.getOS_Type());
							break;
						case TYPE_NAME_ELEMENT:
							final ClassContext.OS_TypeNameElement typeNameElement = (ClassContext.OS_TypeNameElement) best;
							__hasElement__typeNameElement(typeNameElement);
							break;
						default:
							aLOG.err("143 " + el);
							throw new NotImplementedException();
					}

					if (gt.getResolved() != null)
						gotResolved(gt);
					else {
						int y = 2; //05/22
					}
				}

				private @NotNull Operation2<@NotNull OS_Element> preprocess(final OS_Element el) {
					@Nullable OS_Element best = el;
					try {
						while (best instanceof AliasStatement) {
							best = DeduceLookupUtils._resolveAlias2((AliasStatement) best, dt2);
						}
						assert best != null;
						return Operation2.success(best);
					} catch (ResolveError aResolveError) {
						return Operation2.failure(aResolveError);
					}
				}
			});
		} else
			throw new AssertionError("Not a USER Type");
		return gt;
	}
	public NamespaceStatement resolvedn;
	public OS_Type            typeName; // TODO or just TypeName ??
	public TypeName           nonGenericTypeName;
	public OS_Type            resolved;
	public IInvocation        ci;
	public EvaNode      node;
	public FunctionInvocation functionInvocation;

	@Contract(pure = true)
	public GenType(final NamespaceStatement aNamespaceStatement) {
		resolvedn = /*new OS_Type*/(aNamespaceStatement);
	}

	public GenType(final @NotNull ClassStatement aClassStatement) {
		resolved = aClassStatement.getOS_Type();
	}

	public GenType(final OS_Type aAttached,
	               final OS_Type aOS_type,
	               final boolean aB,
	               final TypeName aTypeName,
	               final DeduceTypes2 deduceTypes2,
	               final ErrSink errSink,
	               final DeducePhase phase) {
		typeName = aAttached;
		resolved = aOS_type;
		if (aB) {
			ci = genCI(aTypeName, deduceTypes2, errSink, phase);
		}
	}

	public ClassInvocation genCI(final TypeName aGenericTypeName,
	                             final DeduceTypes2 deduceTypes2,
	                             final ErrSink errSink,
	                             final DeducePhase phase) {
		final SetGenCI        sgci = new SetGenCI();
		final ClassInvocation ci   = sgci.call(this, aGenericTypeName, deduceTypes2, errSink, phase);
		return ci;
	}

	public GenType() {
	}

	@Override
	public boolean equals(final Object aO) {
		if (this == aO) return true;
		if (aO == null || getClass() != aO.getClass()) return false;

		final GenType genType = (GenType) aO;

		if (!Objects.equals(resolvedn, genType.resolvedn)) return false;
		if (!Objects.equals(typeName, genType.typeName)) return false;
		if (!Objects.equals(nonGenericTypeName, genType.nonGenericTypeName))
			return false;
		if (!Objects.equals(resolved, genType.resolved)) return false;
		if (!Objects.equals(ci, genType.ci)) return false;
		if (!Objects.equals(node, genType.node)) return false;
		return Objects.equals(functionInvocation, genType.functionInvocation);
	}

	@Override
	public int hashCode() {
		int result = resolvedn != null ? resolvedn.hashCode() : 0;
		result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
		result = 31 * result + (nonGenericTypeName != null ? nonGenericTypeName.hashCode() : 0);
		result = 31 * result + (resolved != null ? resolved.hashCode() : 0);
		result = 31 * result + (ci != null ? ci.hashCode() : 0);
		result = 31 * result + (node != null ? node.hashCode() : 0);
		result = 31 * result + (functionInvocation != null ? functionInvocation.hashCode() : 0);
		return result;
	}

	public String asString() {
		final String sb = "GenType{" + "resolvedn=" + resolvedn +
		  ", typeName=" + typeName +
		  ", nonGenericTypeName=" + nonGenericTypeName +
		  ", resolved=" + resolved +
		  ", ci=" + ci +
		  ", node=" + node +
		  ", functionInvocation=" + functionInvocation +
		  '}';
		return sb;
	}

	public void set(final @NotNull OS_Type aType) {
		switch (aType.getType()) {
		case USER:
			typeName = aType;
			break;
		case USER_CLASS:
			resolved = aType;
			break;
		default:
			SimplePrintLoggerToRemoveSoon.println_err2("48 Unknown in set: " + aType);
		}
	}

	public boolean isNull() {
		if (resolvedn != null) return false;
		if (typeName != null) return false;
		if (nonGenericTypeName != null) return false;
		if (resolved != null) return false;
		if (ci != null) return false;
		return node == null;
	}

	public void copy(final GenType aGenType) {
		if (resolvedn == null) resolvedn = aGenType.resolvedn;
		if (typeName == null) typeName = aGenType.typeName;
		if (nonGenericTypeName == null) nonGenericTypeName = aGenType.nonGenericTypeName;
		if (resolved == null) resolved = aGenType.resolved;
		if (ci == null) ci = aGenType.ci;
		if (node == null) node = aGenType.node;
	}

	public void genCIForGenType2(final DeduceTypes2 aDeduceTypes2) {
		genCI(nonGenericTypeName, aDeduceTypes2, aDeduceTypes2._errSink(), aDeduceTypes2._phase());
		final IInvocation invocation = ci;
		if (invocation instanceof final NamespaceInvocation namespaceInvocation) {
			namespaceInvocation.resolveDeferred().then(new DoneCallback<EvaNamespace>() {
				@Override
				public void onDone(final EvaNamespace result) {
					node = result;
				}
			});
		} else if (invocation instanceof final ClassInvocation classInvocation) {
			classInvocation.resolvePromise().then(new DoneCallback<EvaClass>() {
				@Override
				public void onDone(final EvaClass result) {
					node = result;
				}
			});
		} else {
			if (resolved instanceof final OS_FuncExprType funcExprType) {

				final Zero_FuncExprType zfet = aDeduceTypes2.getZero(funcExprType);

				node = zfet.genCIForGenType2(aDeduceTypes2);
			} else if (resolved instanceof final OS_FuncType funcType) {
				final int         y        = 2;
			} else
				throw new IllegalStateException("invalid invocation");
		}
	}

	/**
	 * Sets the node for a GenType, invocation must already be set
	 */
	public void genNodeForGenType2() {
//		assert aGenType.nonGenericTypeName != null;

		final IInvocation invocation = ci;

		if (invocation instanceof final NamespaceInvocation namespaceInvocation) {
			namespaceInvocation.resolveDeferred().then(new DoneCallback<EvaNamespace>() {
				@Override
				public void onDone(final EvaNamespace result) {
					node = result;
				}
			});
		} else if (invocation instanceof final ClassInvocation classInvocation) {
			classInvocation.resolvePromise().then(new DoneCallback<EvaClass>() {
				@Override
				public void onDone(final EvaClass result) {
					node = result;
				}
			});
		} else
			throw new IllegalStateException("invalid invocation");
	}

	static class SetGenCI {

		public ClassInvocation call(@NotNull final GenType genType, final TypeName aGenericTypeName, final @NotNull DeduceTypes2 deduceTypes2, final ErrSink errSink, final DeducePhase phase) {
			if (genType.nonGenericTypeName != null) {
				return nonGenericTypeName(genType, deduceTypes2, errSink, phase);
			}
			if (genType.resolved != null) {
				final OS_Type.Type type = genType.resolved.getType();
				switch (type) {
				case USER_CLASS:
					return ((OS_UserClassType) genType.resolved).resolvedUserClass(genType, aGenericTypeName, phase, deduceTypes2, errSink);
				case FUNCTION:
					return ((OS_FuncType) genType.resolved).resolvedFunction(genType, aGenericTypeName, deduceTypes2, errSink, phase);
				case FUNC_EXPR:
					// TODO what to do here?
					final int y = 2;
					break;
				}
			}
			return null;
		}

		private @NotNull ClassInvocation nonGenericTypeName(final @NotNull GenType genType, final DeduceTypes2 deduceTypes2, final ErrSink errSink, final DeducePhase phase) {
			@NotNull final NormalTypeName aTyn1           = (NormalTypeName) genType.nonGenericTypeName;
			@Nullable final String        constructorName = null; // TODO this comes from nowhere

			switch (genType.resolved.getType()) {
			case GENERIC_TYPENAME:
				final int y = 2; // TODO seems to not be necessary
				assert false;
				return null;
			case USER_CLASS:
				final @NotNull ClassStatement best = genType.resolved.getClassOf();
				//
				ClassInvocation clsinv2 = DeduceTypes2.ClassInvocationMake.withGenericPart(best, constructorName, aTyn1, deduceTypes2, errSink);
				clsinv2 = phase.registerClassInvocation(clsinv2);
				genType.ci = clsinv2;
				return clsinv2;
			default:
				throw new IllegalStateException("Unexpected value: " + genType.resolved.getType());
			}
		}

	}
}

//
//
//
