/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.util.*;

/**
 * Created 12/22/20 5:39 PM
 */
public class GeneratedNamespace extends GeneratedContainerNC implements GNCoded {
	private final OS_Module          module;
	private final NamespaceStatement namespaceStatement;
	public GeneratedNamespace(final NamespaceStatement namespace1, final OS_Module module) {
		this.namespaceStatement = namespace1;
		this.module             = module;
	}

	public void addAccessNotation(final AccessNotation an) {
		throw new NotImplementedException();
	}

	public void createCtor0() {
		// TODO implement me
		final FunctionDef fd = new FunctionDef(namespaceStatement, namespaceStatement.getContext());
		fd.setName(Helpers.string_to_ident("<ctor$0>"));
		final Scope3 scope3 = new Scope3(fd);
		fd.scope(scope3);
		for (final VarTableEntry varTableEntry : varTable) {
			if (varTableEntry.initialValue != IExpression.UNASSIGNED) {
				final IExpression left  = varTableEntry.nameToken;
				final IExpression right = varTableEntry.initialValue;

				final @NotNull IExpression e = ExpressionBuilder.build(left, ExpressionKind.ASSIGNMENT, right);
				scope3.add(new StatementWrapper(e, fd.getContext(), fd));
			} else {
				if (getPragma("auto_construct")) {
					scope3.add(new ConstructStatement(fd, fd.getContext(), varTableEntry.nameToken, null, null));
				}
			}
		}
	}

	private boolean getPragma(final String auto_construct) { // TODO this should be part of Context
		return false;
	}

	public String getName() {
		return namespaceStatement.getName();
	}

	@Override
	public OS_Element getElement() {
		return getNamespaceStatement();
	}

	public NamespaceStatement getNamespaceStatement() {
		return this.namespaceStatement;
	}

	@Override
	@Nullable
	public VarTableEntry getVariable(final String aVarName) {
		for (final VarTableEntry varTableEntry : varTable) {
			if (varTableEntry.nameToken.getText().equals(aVarName))
				return varTableEntry;
		}
		return null;
	}

	@Override
	public void generateCode(final CodeGenerator aCodeGenerator, final GenerateResult aGr) {
		aCodeGenerator.generate_namespace(this, aGr);
	}

	@Override
	public @NotNull String identityString() {
		return String.valueOf(namespaceStatement);
	}

	@Override
	public OS_Module module() {
		return module;
	}

	@Override
	public Role getRole() {
		return Role.NAMESPACE;
	}
}

//
//
//
