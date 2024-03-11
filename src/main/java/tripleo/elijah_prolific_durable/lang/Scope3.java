/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang;

import antlr.Token;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.contexts.IfConditionalContext;

import java.util.*;

/**
 * Created 1/4/21 3:10 AM
 */
public class Scope3 implements Documentable {
	private final OS_Element             parent;
	private final Scope3StatementClosure asc         = new Scope3StatementClosure();
	private final List<OS_Element>       _items      = new ArrayList<OS_Element>();
	private final List<Token>            _docstrings = new ArrayList<Token>();

	public Scope3(final OS_Element aParent) {
		parent = aParent;
	}

	public List<OS_Element> items() {
		return _items;
	}

	public Iterable<? extends Token> docstrings() {
		return _docstrings;
	}

	@Override
	public void addDocString(final Token aText) {
		_docstrings.add(aText);
	}

	public OS_Element getParent() {
		return parent;
	}

	public StatementClosure statementClosure() {
		return asc;
	}

	public void statementWrapper(final IExpression expr) {
		add(new StatementWrapper(expr, parent.getContext(), parent)); // TODO is this right?
	}

	public void add(final OS_Element element) {
		_items.add(element);
	}

	public VariableSequence varSeq() {
		return asc.varSeq(asc.getParent().getContext());
	}

	private class Scope3StatementClosure implements StatementClosure {
		@Override
		public VariableSequence varSeq(final Context ctx) {
			final VariableSequence vsq = new VariableSequence(ctx);
			vsq.setParent(parent); // TODO look at this
			assert ctx == parent.getContext();
			vsq.setContext(ctx);
			add(vsq);
			return vsq;
		}

		@Override
		public ProcedureCallExpression procedureCallExpression() {
			final ProcedureCallExpression pce = new ProcedureCallExpression();
			add(new StatementWrapper(pce, getParent().getContext(), getParent()));
			return pce;
		}

		@Override
		public Loop loop() {
			final Loop loop = new Loop(parent, parent.getContext());
			add(loop);
			return loop;
		}

		@Override
		public void constructExpression(final @NotNull IExpression aExpr, final ExpressionList aO) {
			final ConstructStatement constructExpression = new ConstructStatement(parent, parent.getContext(), aExpr, null, aO); // TODO provide for name
			add(constructExpression);
		}

		@Override
		public void yield(final IExpression aExpr) {
			final YieldExpression yiex = new YieldExpression(aExpr);
			add(yiex);
		}

		@Override
		public IfConditional ifConditional(final OS_Element aParent, final Context cur) {
			final IfConditional ifex = new IfConditional(aParent);
			ifex.setContext(new IfConditionalContext(cur, ifex));
			add(ifex);
			return ifex;
		}

		@Override
		public BlockStatement blockClosure() {
			final BlockStatement bs = new BlockStatement(null);
//			add(bs);  // TODO make this an Element
			return bs;
		}

		@Override
		public CaseConditional caseConditional(final Context parentContext) {
			final CaseConditional caseConditional = new CaseConditional(getParent(), parentContext);
			add(caseConditional);
			return caseConditional;
		}

		@Override
		public MatchConditional matchConditional(final Context parentContext) {
			final MatchConditional matchConditional = new MatchConditional(getParent(), parentContext);
			add(matchConditional);
			return matchConditional;
		}

		@Override
		public void statementWrapper(final IExpression expr) {
//			parent_scope.statementWrapper(expr);
			add(new StatementWrapper(expr, parent.getContext(), parent)); // TODO is this right?
		}

		private OS_Element getParent() {
			return parent;
		}
	}
}

//
//
//
