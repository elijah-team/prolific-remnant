package tripleo.elijah.test_help;

import tripleo.elijah.contexts.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.util.*;

import java.util.*;

public class BoilerplateFunctionBuilder {
	final private List<BFB_Child> children = new ArrayList<>();
	private       OS_Element      parent;
	private       String          functionNameString;

	public void parent(final OS_Element aParent) {
		parent = aParent;
	}

	public FunctionDef build() {
		final ClassStatement cs = (ClassStatement) parent;

		final FunctionDef fd = cs.funcDef();
		fd.setName(Helpers.string_to_ident(functionNameString));
		final Scope3 scope3 = new Scope3(fd);

		final BFB_State s = new BFB_State(fd, scope3);

		for (final BFB_Child child : children) {
			child.process(s);
		}

		fd.scope(scope3);
//		fd.postConstruct();
		return fd;
	}

	public void name(final String aFunctionNameString) {
		functionNameString = aFunctionNameString;
	}

	public void vars(final String aVariableNameString, final String aVariableTypeString) {
		vars(aVariableNameString, aVariableTypeString, null);
	}

	public void vars(final String aVariableNameString, final String aVariableTypeString, final DeduceTypeWatcher aDtw) {
		final BFCH_Vars vars = new BFCH_Vars(aVariableNameString, aVariableTypeString, aDtw);
		children.add(vars);
	}

	interface IBFB_State {
		Scope3 getScope();

		FunctionDef getFD();

		FunctionContext getContext();
	}

	interface BFB_Child {
		void process(IBFB_State s);
	}

	class BFB_State implements IBFB_State {

		private final FunctionDef fd;
		private final Scope3      scope3;

		public BFB_State(final FunctionDef aFd, final Scope3 aScope3) {
			fd     = aFd;
			scope3 = aScope3;
		}

		@Override
		public Scope3 getScope() {
			return scope3;
		}

		@Override
		public FunctionDef getFD() {
			return fd;
		}

		@Override
		public FunctionContext getContext() {
			return (FunctionContext) fd.getContext();
		}
	}

	class BFCH_Vars implements BFB_Child {
		private final String            variableNameString;
		private final String            variableTypeString;
		private final DeduceTypeWatcher dtw;

		public BFCH_Vars(final String aVariableNameString, final String aVariableTypeString, final DeduceTypeWatcher aDtw) {
			variableNameString = aVariableNameString;
			variableTypeString = aVariableTypeString;
			dtw                = aDtw;
		}

		/**
		 * Add a single element varSeq conforming to `var $name : $type` to current "scope"
		 */
		@Override
		public void process(final IBFB_State s) {
			final FunctionContext   context = s.getContext();
			final VariableSequence  vss     = s.getScope().statementClosure().varSeq(context);
			final VariableStatement vs      = vss.next();
			final IdentExpression   x       = Helpers.string_to_ident(variableNameString);
			x.setContext(context);
			vs.setName(x);
			final Qualident qu = new Qualident();
			qu.append(Helpers.string_to_ident(variableTypeString));
			((NormalTypeName) vs.typeName()).setName(qu);
			vs.typeName().setContext(context);

			vs.dtw = dtw;
			if (dtw != null) {
				vs.dtw.element(vs);
			}
		}
	}
}
