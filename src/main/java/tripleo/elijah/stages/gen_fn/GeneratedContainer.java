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
import tripleo.elijah.lang.types.*;

import java.util.*;

/**
 * Created 2/28/21 3:23 AM
 */
public interface EvaContainer extends EvaNode {
	OS_Element getElement();

	@Nullable VarTableEntry getVariable(String aVarName);

	class VarTableEntry {
		public final  VariableStatement                                  vs;
		public final  IdentExpression                                    nameToken;
		public final  IExpression                                        initialValue;
		public final  DeferredObject<UpdatePotentialTypesCB, Void, Void> updatePotentialTypesCBPromise = new DeferredObject<>();
		public final  List<ConnectionPair>                               connectionPairs               = new ArrayList<>();
		final         TypeName                                           typeName;
		final         List<TypeTableEntry>                               potentialTypes                = new ArrayList<TypeTableEntry>();
		private final OS_Element                                         parent;
		public        OS_Type                                            varType;
		UpdatePotentialTypesCB updatePotentialTypesCB;
		private EvaNode _resolvedType;

		public VarTableEntry(final VariableStatement aVs,
		                     final @NotNull IdentExpression aNameToken,
		                     final IExpression aInitialValue,
		                     final @NotNull TypeName aTypeName,
		                     final @NotNull OS_Element aElement) {
			vs           = aVs;
			nameToken    = aNameToken;
			initialValue = aInitialValue;
			typeName     = aTypeName;
			varType      = new OS_UserType(typeName);
			parent       = aElement;
		}

		public void addPotentialTypes(@NotNull final Collection<TypeTableEntry> aPotentialTypes) {
			potentialTypes.addAll(aPotentialTypes);
		}

		public void resolve(@NotNull final EvaNode aResolvedType) {
			System.out.printf("** [EvaContainer 56] resolving VarTableEntry %s to %s%n", nameToken, aResolvedType.identityString());
			_resolvedType = aResolvedType;
		}

		public @Nullable EvaNode resolvedType() {
			return _resolvedType;
		}

		public @NotNull OS_Element getParent() {
			return parent;
		}

		public void connect(final VariableTableEntry aVte, final EvaConstructor aConstructor) {
			connectionPairs.add(new ConnectionPair(aVte, aConstructor));
		}

		public void updatePotentialTypes(final @NotNull EvaContainer aEvaContainer) {
//			assert aEvaContainer == EvaContainer.this;
			updatePotentialTypesCBPromise.then(new DoneCallback<UpdatePotentialTypesCB>() {
				@Override
				public void onDone(final UpdatePotentialTypesCB result) {
					result.call(aEvaContainer);
				}
			});
		}

		public interface UpdatePotentialTypesCB {
			void call(final @NotNull EvaContainer aEvaContainer);
		}

		public static class ConnectionPair {
			public final VariableTableEntry   vte;
			final        EvaConstructor constructor;

			public ConnectionPair(final VariableTableEntry aVte, final EvaConstructor aConstructor) {
				vte         = aVte;
				constructor = aConstructor;
			}
		}
	}
}

//
//
//
