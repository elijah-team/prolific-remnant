package tripleo.elijah.stages.deduce;

import org.junit.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.contexts.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang.types.*;
import tripleo.elijah.lang2.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah.util.*;

import java.util.*;

import static org.easymock.EasyMock.*;
import static tripleo.elijah.stages.logging.ElLog.Verbosity.*;

public class DoAssignCall_ArgsIdent1_Test {
	/*
	    model and test

	    var f1 = factorial(b1)
	 */

	@Ignore @Test
	public void f1_eq_factorial_b1() {
		final CompilationImpl c             = new CompilationImpl(new StdErrSink(), new IO());
		final OS_Module       mod           = mock(OS_Module.class);
		final PipelineLogic   pipelineLogic = new PipelineLogic(new AccessBus(c));
		final GeneratePhase   generatePhase = new GeneratePhase(VERBOSE, pipelineLogic, c);
		final DeducePhase     phase         = new DeducePhase(generatePhase, pipelineLogic, ElLog.Verbosity.VERBOSE, c);

		expect(mod.getCompilation()).andReturn(c);
		expect(mod.getFileName()).andReturn("foo.elijah");
//		expect(mod.getCompilation()).andReturn(c);
//		expect(mod.getCompilation()).andReturn(c);
//		expect(mod.getCompilation()).andReturn(c);

		replay(mod);

		final DeduceTypes2 d = new DeduceTypes2(mod, phase);

		final FunctionDef fd = mock(FunctionDef.class);
//		final GeneratedFunction generatedFunction = mock(GeneratedFunction.class);
		final GeneratedFunction generatedFunction = new GeneratedFunction(fd);
		final TypeTableEntry    self_type         = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.SPECIFIED, new OS_UserClassType(mock(ClassStatement.class)));
		final int               index_self        = generatedFunction.addVariableTableEntry("self", VariableTableType.SELF, self_type, null);
		final TypeTableEntry    result_type       = null;
		final int               index_result      = generatedFunction.addVariableTableEntry("Result", VariableTableType.RESULT, result_type, null);
		final OS_Type           sts_int           = new OS_BuiltinType(BuiltInTypes.SystemInteger);
		final TypeTableEntry    b1_type           = generatedFunction.newTypeTableEntry(TypeTableEntry.Type.SPECIFIED, sts_int);
		final OS_Type           b1_attached       = sts_int;
		b1_type.setAttached(sts_int);
		final int             index_b1 = generatedFunction.addVariableTableEntry("b1", VariableTableType.VAR, b1_type, null);
		final FunctionContext ctx      = mock(FunctionContext.class);

		final LookupResultList  lrl_b1 = new LookupResultList();
		final VariableSequence  vs     = new VariableSequence();
		final VariableStatement b1_var = new VariableStatement(vs);
		b1_var.setName(Helpers.string_to_ident("b1"));
		final Context b1_ctx = mock(Context.class);
		lrl_b1.add("b1", 1, b1_var, b1_ctx);

		expect(ctx.lookup("b1")).andReturn(lrl_b1);

		replay(fd, /*generatedFunction,*/ ctx, b1_ctx);

		final TypeTableEntry vte_tte = null;
		final OS_Element     el      = null;

		final VariableTableEntry vte              = generatedFunction.getVarTableEntry(index_self);
		final int                instructionIndex = -1;
		final ProcTableEntry     pte              = new ProcTableEntry(-2, null, null, new ArrayList()/*List_of()*/);
		final int                i                = 0;
		final TypeTableEntry     tte              = new TypeTableEntry(-3, TypeTableEntry.Type.SPECIFIED, null, null, null);
		final IdentExpression    identExpression  = Helpers.string_to_ident("b1"); // TODO ctx

		d.do_assign_call_args_ident(generatedFunction, ctx, vte, instructionIndex, pte, i, tte, identExpression);

		d.onExitFunction(generatedFunction, ctx, ctx);

		verify(mod, fd, /*generatedFunction,*/ ctx);
	}

}
