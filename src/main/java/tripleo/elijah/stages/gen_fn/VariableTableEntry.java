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
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.deduce.post_bytecode.*;
import tripleo.elijah.stages.deduce.zero.*;
import tripleo.elijah.stages.instructions.*;

import java.util.*;

/**
 * Created 9/10/20 4:51 PM
 */
public class VariableTableEntry extends BaseTableEntry1 implements Constructable, TableEntryIV, DeduceTypes2.ExpectationBase {
	public final          VariableTableType                          vtt;
	public final @NotNull Map<Integer, TypeTableEntry>               potentialTypes        = new HashMap<Integer, TypeTableEntry>();
	public final          DeduceLocalVariable                        dlv                   = new DeduceLocalVariable(this);
	final                 DeferredObject<ProcTableEntry, Void, Void> constructableDeferred = new DeferredObject<>();
	private final         int                                        index;
	private final         String                                     name;
	private final         DeferredObject2<GenType, Void, Void>       typeDeferred          = new DeferredObject2<GenType, Void, Void>();
	public                TypeTableEntry                             type;
	public                int                                        tempNum               = -1;
	public                ProcTableEntry                             constructable_pte;
	public                GenType                                    genType               = new GenType();
	// endregion constructable
	@Nullable             GenType                                    _resolveTypeCalled    = null;

	private GeneratedNode _resolvedType;
	private DeduceElement3_VariableTableEntry _de3;
	private VTE_Zero _zero;

	public VariableTableEntry(final int aIndex, final VariableTableType aVtt, final String aName, final TypeTableEntry aTTE, final OS_Element el) {
		this.index = aIndex;
		this.name  = aName;
		this.vtt   = aVtt;
		this.type  = aTTE;
		this.setResolvedElement(el);
		setupResolve();
	}

	public String getName() {
		return name;
	}

	public @NotNull Collection<TypeTableEntry> potentialTypes() {
		return potentialTypes.values();
	}

	public int getIndex() {
		return index;
	}

//	public DeferredObject<GenType, Void, Void> typeDeferred() {
//		return typeDeferred;
//	}

	@Override
	public @NotNull String toString() {
		return "VariableTableEntry{" +
		  "index=" + index +
		  ", name='" + name + '\'' +
		  ", status=" + status +
		  ", type=" + type.index +
		  ", vtt=" + vtt +
		  ", potentialTypes=" + potentialTypes +
		  '}';
	}

	public Promise<GenType, Void, Void> typePromise() {
		return typeDeferred.promise();
	}

	public boolean typeDeferred_isPending() {
		return typeDeferred.isPending();
	}

	public void addPotentialType(final int instructionIndex, final TypeTableEntry tte) {
		if (!typeDeferred.isPending()) {
			tripleo.elijah.util.Stupidity.println_err2("62 addPotentialType while typeDeferred is already resolved " + this);//throw new AssertionError();
			return;
		}
		//
		if (!potentialTypes.containsKey(instructionIndex))
			potentialTypes.put(instructionIndex, tte);
		else {
			final TypeTableEntry v = potentialTypes.get(instructionIndex);
			if (v.getAttached() == null) {
				v.setAttached(tte.getAttached());
				type.genType.copy(tte.genType); // README don't lose information
			} else if (tte.lifetime == TypeTableEntry.Type.TRANSIENT && v.lifetime == TypeTableEntry.Type.SPECIFIED) {
				//v.attached = v.attached; // leave it as is
			} else if (tte.lifetime == v.lifetime && v.getAttached() == tte.getAttached()) {
				// leave as is
			} else if (v.getAttached().equals(tte.getAttached())) {
				// leave as is
			} else {
				assert false;
				//
				// Make sure you check the differences between USER and USER_CLASS types
				// May not be any
				//
//				tripleo.elijah.util.Stupidity.println_err2("v.attached: " + v.attached);
//				tripleo.elijah.util.Stupidity.println_err2("tte.attached: " + tte.attached);
				tripleo.elijah.util.Stupidity.println2("72 WARNING two types at the same location.");
				if ((tte.getAttached() != null && tte.getAttached().getType() != OS_Type.Type.USER) || v.getAttached().getType() != OS_Type.Type.USER_CLASS) {
					// TODO prefer USER_CLASS as we are assuming it is a resolved version of the other one
					if (tte.getAttached() == null)
						tte.setAttached(v.getAttached());
					else if (tte.getAttached().getType() == OS_Type.Type.USER_CLASS)
						v.setAttached(tte.getAttached());
				}
			}
		}
	}

	public GeneratedNode resolvedType() {
		return _resolvedType;
	}

	@Override
	public void setConstructable(final ProcTableEntry aPte) {
		if (constructable_pte != aPte) {
			constructable_pte = aPte;
			constructableDeferred.resolve(constructable_pte);
		}
	}

	// region constructable

	@Override
//	public void setConstructable(final ProcTableEntry aPte) {
//		constructable_pte = aPte;
//	}

//	@Override
	public void resolveTypeToClass(final GeneratedNode aNode) {
		_resolvedType = aNode;
		genType.node  = aNode;
		type.resolve(aNode); // TODO maybe this obviates above
	}

	@Override
	public void setGenType(final GenType aGenType) {
		genType.copy(aGenType);
		resolveType(aGenType);
	}

	public void resolveType(final @NotNull GenType aGenType) {
		if (_resolveTypeCalled != null) { // TODO what a hack
			if (_resolveTypeCalled.resolved != null) {
				if (!aGenType.equals(_resolveTypeCalled)) {
					System.err.printf("** 130 Attempting to replace %s with %s in %s%n", _resolveTypeCalled.asString(), aGenType.asString(), this);
//					throw new AssertionError();
				}
			} else {
				_resolveTypeCalled = aGenType;
				typeDeferred.reset();
				typeDeferred.resolve(aGenType);
			}
			return;
		}
		if (typeDeferred.isResolved()) {
			tripleo.elijah.util.Stupidity.println_err2("126 typeDeferred is resolved " + this);
		}
		_resolveTypeCalled = aGenType;
		typeDeferred.resolve(aGenType);
	}

	@Override
	public Promise<ProcTableEntry, Void, Void> constructablePromise() {
		return constructableDeferred.promise();
	}

	@Override
	public @NotNull String expectationString() {
		return "VariableTableEntry{" +
		  "index=" + index +
		  ", name='" + name + '\'' +
		  "}";
	}

	public void setDeduceTypes2(final DeduceTypes2 aDeduceTypes2, final Context aContext, final BaseGeneratedFunction aGeneratedFunction) {
		dlv.setDeduceTypes2(aDeduceTypes2, aContext, aGeneratedFunction);
	}

	public void resolve_var_table_entry_for_exit_function() {
		dlv.resolve_var_table_entry_for_exit_function();
	}

	public boolean typeDeferred_isResolved() {
		return typeDeferred.isResolved();
	}

	public PostBC_Processor getPostBC_Processor(final Context aFd_ctx, final DeduceTypes2.DeduceClient1 aDeduceClient1) {
		return PostBC_Processor.make_VTE(this, aFd_ctx, aDeduceClient1);
	}

	public IDeduceElement3 getDeduceElement3() {
		if (_de3 == null) {
			_de3 = new DeduceElement3_VariableTableEntry(this);
//			_de3.
		}
		return _de3;
	}

	public VTE_Zero zero() {
		if (_zero == null) {
			_zero = new VTE_Zero(this);
		}
		return _zero;
	}

	public void setLikelyType(final GenType aGenType) {
		final GenType bGenType = type.genType;

		// 1. copy arg into member
		bGenType.copy(aGenType);

		// 2. set node when available
		((ClassInvocation) bGenType.ci).resolvePromise().done(aGeneratedClass -> {
			bGenType.node = aGeneratedClass;
			resolveTypeToClass(aGeneratedClass);
			genType = bGenType; // TODO who knows if this is necessary?
		});

	}

//	public Promise<GenType, Void, Void> typeResolvePromise() {
//		return typeDeferred.promise();
//	}
}

//
//
//
