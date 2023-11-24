/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.contexts;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah.util.*;

import java.util.*;

import static tripleo.elijah.contexts.ClassInfo.ClassInfoType.*;


/**
 * @author Tripleo
 * <p>
 * Created 	Mar 26, 2020 at 6:04:02 AM
 */
public class ClassContext extends Context {

	public final  Map<TypeName, ClassStatement> _inheritance = new HashMap<>();
	private final ClassStatement                carrier;
	private final Context                       _parent;
	private       boolean                       _didInheritance;

	public ClassContext(final Context aParent, final ClassStatement cls) {
		_parent = aParent;
		carrier = cls;
	}

	@Override
	public LookupResultList lookup(final String name, final int level, final LookupResultList Result, final List<Context> alreadySearched, final boolean one) {
		alreadySearched.add(carrier.getContext());
		for (final ClassItem item : carrier.getItems()) {
			if (!(item instanceof ClassStatement) &&
			  !(item instanceof NamespaceStatement) &&
			  !(item instanceof BaseFunctionDef) &&
			  !(item instanceof VariableSequence) &&
			  !(item instanceof AliasStatement) &&
			  !(item instanceof PropertyStatement)
			) continue;
			if (item instanceof OS_Element2) {
				if (((OS_Element2) item).name().equals(name)) {
					Result.add(name, level, item, this);
				}
			}
			if (item instanceof VariableSequence) {
				SimplePrintLoggerToRemoveSoon.println2("102 " + item);
				for (final VariableStatement vs : ((VariableSequence) item).items()) {
					if (vs.getName().equals(name))
						Result.add(name, level, vs, this);
				}
			}
		}

		for (final Map.Entry<TypeName, ClassStatement> entry : inheritance().entrySet()) {
			final ClassStatement   best  = entry.getValue();
			final LookupResultList lrl2  = best.getContext().lookup(name);
			final OS_Element       best2 = lrl2.chooseBest(null);

			if (best2 != null)
				Result.add(name, level, best2, this, new ClassInfo(best, INHERITED));
		}

		for (final TypeName tn1 : carrier.getGenericPart()) {
			if (tn1 instanceof final NormalTypeName tn) {
				final String         name1 = tn.getName(); // TODO this may return a string with DOTs in it.
				if (name1.equals(name)) {
//					LookupResultList lrl = tn.getContext().lookup(name);
//					OS_Element best = lrl.chooseBest(null);
//					if (best == null) {
//						throw new AssertionError();
//					} else
					Result.add(name, level, new OS_TypeNameElement(tn1), this, new ClassInfo(tn, GENERIC));
				}
			} else {
				// TODO probable error
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

	public Map<TypeName, ClassStatement> inheritance() {
		if (!_didInheritance) {
			for (final TypeName tn1 : carrier.classInheritance().tns) {
				SimplePrintLoggerToRemoveSoon.println2("1001 " + tn1);
				final NormalTypeName       tn  = (NormalTypeName) tn1;
				final @Nullable OS_Element best;
				final LookupResultList     tnl = tn.getContext().lookup(tn.getName());
				SimplePrintLoggerToRemoveSoon.println2("1002 " + tnl.results());
				best = tnl.chooseBest(null);

				if (best != null) {
					_inheritance.put(tn1, (ClassStatement) best);
				}

//				tripleo.elijah.util.Stupidity.println2("1003 "+name+" "+Result.results());
				_didInheritance = true;
			}
		}
		return _inheritance;
	}

	public ClassStatement getCarrier() {
		return carrier;
	}

	/**
	 * An Element that only holds a {@link TypeName}.
	 * <p>
	 * NOTE: It seems to be connected to {@link ClassContext}
	 */
	public class OS_TypeNameElement implements OS_Element {
		private final TypeName typeName;

		public OS_TypeNameElement(final TypeName aTypeName) {
			typeName = aTypeName;
		}

		public TypeName getTypeName() {
			return typeName;
		}

		@Override
		public void visitGen(final ElElementVisitor visit) {
			visit.visitTypeNameElement(this);
		}

		@Override
		public Context getContext() {
			return ClassContext.this;
		}

		@Override
		public OS_Element getParent() {
			return carrier;
		}
	}
}

//
//
//
