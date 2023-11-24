/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.lang.builder;

import tripleo.elijah.contexts.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.*;

/**
 * Created 12/23/20 1:40 AM
 */
public class IfConditionalBuilder extends ElBuilder {
	public Doublet base_expr = new Doublet();
	public Doublet else_part = new Doublet();
	List<Doublet> doubles = new ArrayList<Doublet>();
	private Context _context;

	public Doublet new_expr() {
		final Doublet doublet = new Doublet();
		doubles.add(doublet);
		return doublet;
	}

	@Override
	protected IfConditional build() {
		final IfConditional ifConditional = new IfConditional(_parent);
		ifConditional.setContext(new IfConditionalContext(_context, ifConditional));
		ifConditional.expr(base_expr.expr);
		final Scope3 scope3 = new Scope3(ifConditional);
		for (final ElBuilder item : base_expr.items) {
			item.setParent(ifConditional);
			item.setContext(ifConditional.getContext());
			scope3.add(item.build());
		}
		ifConditional.scope(scope3);
		for (final Doublet aDouble : doubles) {
			final IfConditional ifConditional2 = new IfConditional(ifConditional);
			ifConditional.expr(aDouble.expr);
			final Scope3 scope31 = new Scope3(ifConditional);
			for (final ElBuilder item : aDouble.items) {
				item.setParent(ifConditional2);
				item.setContext(ifConditional2.getContext());
				scope31.add(item.build());
			}
			ifConditional.scope(scope31);
		}

		return ifConditional;
	}

	@Override
	protected void setContext(final Context context) {
		_context = context;
	}

	public static class IfConditionalScope extends BaseScope2 {

	}

	public static class Doublet {
		IExpression        expr;
		List<ElBuilder>    items  = new ArrayList<ElBuilder>();
		IfConditionalScope _scope = new IfConditionalScope();

		public void expr(final IExpression expr) {
			this.expr = expr;
		}

		public BaseScope scope() {
			return _scope;
		}
	}
}

//
//
//
