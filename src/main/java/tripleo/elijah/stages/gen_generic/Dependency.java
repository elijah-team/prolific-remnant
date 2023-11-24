/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_generic;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.util.*;

import java.util.*;

/**
 * Created 9/13/21 4:00 AM
 */
public class Dependency {
	public final IDependencyReferent referent;
	public final Set<Dependency>     deps = new HashSet<>();

	public DependencyRef dref;
	public OS_Element    resolved;

	public Dependency(final IDependencyReferent aReferent) {
		referent = aReferent;
	}

	public DependencyRef getRef() {
		return dref;
	}

	public void setRef(final DependencyRef aDref) {
		dref = aDref;
	}

	public void noteDependencies(final AbstractDependencyTracker aDependencyTracker,
	                             final List<FunctionInvocation> aDependentFunctions,
	                             final List<GenType> aDependentTypes) {
		for (final FunctionInvocation dependentFunction : aDependentFunctions) {
			final BaseGeneratedFunction generatedFunction = dependentFunction.getGenerated();
			if (generatedFunction != null)
				deps.add(generatedFunction.getDependency());
			else
				SimplePrintLoggerToRemoveSoon.println_err2("52 false FunctionInvocation " + dependentFunction);
		}
		for (final GenType dependentType : aDependentTypes) {
			final GeneratedContainerNC node = (GeneratedContainerNC) dependentType.node;
			if (node != null)
				deps.add(node.getDependency());
			else {
				SimplePrintLoggerToRemoveSoon.println_err2("46 node is null " + (dependentType.resolved != null ? dependentType.resolved : dependentType.resolvedn));
				final Dependency d = new Dependency(null);
				d.resolved = dependentType.resolved != null ? dependentType.resolved.getClassOf() : dependentType.resolvedn;
				deps.add(d);
			}
		}
	}

	public @NotNull Set<Dependency> getNotedDeps() {
		return deps;
	}
}

//
//
//
