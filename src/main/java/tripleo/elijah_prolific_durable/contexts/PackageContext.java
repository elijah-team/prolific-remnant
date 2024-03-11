/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.contexts;

import tripleo.elijah.lang.*;
import tripleo.elijah_prolific_durable.lang.*;

import java.util.*;

/**
 * Created 8/15/20 6:32 PM
 */
public class PackageContext extends Context {
	private final Context    _parent;
	private final OS_Package carrier;

	public PackageContext(final Context aParent, final OS_Package os_package) {
		_parent = aParent;
		carrier = os_package;
	}

	@Override
	public LookupResultList lookup(final String name, final int level, final LookupResultList Result, final List<Context> alreadySearched, final boolean one) {
		alreadySearched.add(this);
		for (final OS_Element element : carrier.getElements()) {
			if (element instanceof final OS_Element2 element2) {
				if (element2.name().equals(name)) {
					Result.add(name, level, element, this);
				}
			}
		}
		if (getParent() != null) {
			final Context context = getParent();
			if (!alreadySearched.contains(context) || !one)
				return context.lookup(name, level + 1, Result, alreadySearched, false);
		}
		return Result;
	}

	@Override
	public Context getParent() {
		return _parent;
	}
}

//
//
//
