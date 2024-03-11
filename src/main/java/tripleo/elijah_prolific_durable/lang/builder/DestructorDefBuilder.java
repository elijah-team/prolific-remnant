/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.lang.builder;

import tripleo.elijah_prolific_durable.lang.*;

/**
 * Created 12/23/20 12:13 AM
 */
public class DestructorDefBuilder extends BaseFunctionDefBuilder {
	private final DestructorDefScope _scope = new DestructorDefScope();
	private       Context            _context;

	@Override
	public DestructorDef build() {
		assert _parent instanceof ClassStatement;

		final DestructorDef destructorDef = new DestructorDef((ClassStatement) _parent, _context);
		destructorDef.setFal(mFal);
		final Scope3 scope3 = new Scope3(destructorDef);
		destructorDef.scope(scope3);
		for (final ElBuilder item : _scope.items()) {
			item.setParent(destructorDef);
			item.setContext(_context);
			destructorDef.add(item.build());
		}
//		assert _species == FunctionDef.Species.DTOR;
		destructorDef.setSpecies(FunctionDef.Species.DTOR);
		destructorDef.postConstruct();
		return destructorDef;
	}

	@Override
	protected void setContext(final Context context) {
		_context = context;
	}

	public DestructorDefScope scope() {
		return _scope;
	}
}

//
//
//
