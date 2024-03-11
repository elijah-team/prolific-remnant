/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific.eva.PR_GeneratedConstructor;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.deduce.*;

/**
 * Created 6/27/21 9:45 AM
 */
public class GeneratedConstructor extends BaseGeneratedFunction {
	public final @Nullable ConstructorDef          cd;
	private                PR_GeneratedConstructor deduction;

	public GeneratedConstructor(final @Nullable ConstructorDef aConstructorDef) {
		cd = aConstructorDef;
	}

	public void setFunctionInvocation(final FunctionInvocation fi) {
		final GenType genType = new GenType();

		// TODO will fail on namespace constructors; next line too
		if (genType.ci instanceof final ClassInvocation classInvocation) {
//			throw new IllegalStateException("34 Needs class invocation");

			genType.ci       = classInvocation;
			genType.resolved = classInvocation.getKlass().getOS_Type();
		} else if (genType.ci instanceof final NamespaceInvocation namespaceInvocation) {

			genType.ci       = namespaceInvocation;
			genType.resolved = namespaceInvocation.getNamespace().getOS_Type();
		}

		genType.node = this;

		resolveTypeDeferred(genType);
	}

	//
	// region toString
	//

	@Override
	public String toString() {
		return String.format("<GeneratedConstructor %s>", cd);
	}

	public String name() {
		if (cd == null)
			throw new IllegalArgumentException("null cd");
		return cd.name();
	}

	// endregion

	@Override
	public String identityString() {
		return String.valueOf(cd);
	}

	@Override
	public @NotNull BaseFunctionDef getFD() {
		if (cd == null) throw new IllegalStateException("No function");
		return cd;
	}

	@Override
	public VariableTableEntry getSelf() {
		if (getFD().getParent() instanceof ClassStatement)
			return getVarTableEntry(0);
		else
			return null;
	}

	public PR_GeneratedConstructor deductionOf(final DeduceTypes2 dt2) {
		final GeneratedConstructor _c = this;

		if (deduction == null) {
			deduction = new PR_GeneratedConstructor() {
				@Override
				public GeneratedConstructor getCarrier() {
					return _c;
				}
			};

			if (!_c.deducedAlready) {
				dt2.deduce_generated_constructor(_c);
			}
			_c.deducedAlready = true;
		}
		return deduction;
	}
}

//
//
//
