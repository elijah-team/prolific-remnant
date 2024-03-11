/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang.builder;

import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.*;

/**
 * Created 12/23/20 4:31 AM
 */
public class SyntacticBlockBuilder extends ElBuilder {
	private final SyntacticBlockScope _scope = new SyntacticBlockScope();
	private       Context             _context;

	@Override
	protected SyntacticBlock build() {
		final SyntacticBlock syntacticBlock = new SyntacticBlock(_parent);
		for (final ElBuilder builder : _scope.items()) {
//			if (builder instanceof AccessNotation) {
//				cs.addAccess((AccessNotation) builder);
//			} else {
//				cs.add(builder);
//			}
			final OS_Element built;
			builder.setParent(_parent);
			builder.setContext(_context);
			built = builder.build();
			syntacticBlock.add(built);
		}
		syntacticBlock.postConstruct();
		return syntacticBlock;
	}

	@Override
	protected void setContext(final Context context) {
		_context = context;
	}

	public BaseScope scope() {
		return _scope;
	}
}

//
//
//
