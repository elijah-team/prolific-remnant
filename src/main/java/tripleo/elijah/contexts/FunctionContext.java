/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.contexts;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.util.*;

import java.util.*;

/**
 * @author Tripleo
 * <p>
 * Created 	Mar 26, 2020 at 6:13:58 AM
 */
public class FunctionContext extends Context {

	private final BaseFunctionDef carrier;
	private final Context         _parent;

	public FunctionContext(final Context aParent, final BaseFunctionDef fd) {
		_parent = aParent;
		carrier = fd;
	}

	@Override
	public LookupResultList lookup(final String name, final int level, final LookupResultList Result, final List<Context> alreadySearched, final boolean one) {
		alreadySearched.add(carrier.getContext());
		for (final FunctionItem item : carrier.getItems()) {
			if (!(item instanceof ClassStatement) &&
			  !(item instanceof NamespaceStatement) &&
			  !(item instanceof FunctionDef) &&
			  !(item instanceof VariableSequence)
			) continue;
			if (item instanceof OS_Element2) {
				if (((OS_Element2) item).name().equals(name)) {
					Result.add(name, level, item, this);
				}
			} else if (item instanceof VariableSequence) {
				SimplePrintLoggerToRemoveSoon.println2("[FunctionContext#lookup] VariableSequence " + item);
				for (final VariableStatement vs : ((VariableSequence) item).items()) {
					if (vs.getName().equals(name))
						Result.add(name, level, vs, this);
				}
			}
		}
		for (final FormalArgListItem arg : carrier.getArgs()) {
			if (arg.name().equals(name)) {
				Result.add(name, level, arg, this);
			}
		}
		if (carrier.getParent() != null) {
			final Context context = getParent()/*carrier.getParent().getContext()*/;
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
