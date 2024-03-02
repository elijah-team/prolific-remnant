package tripleo.elijah.stages.deduce.zero;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.lang.types.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_fn.*;

import java.util.function.Consumer;

public class Zero_FuncExprType implements IZero {
	private final OS_FuncExprType funcExprType;

	public Zero_FuncExprType(final OS_FuncExprType aFuncExprType) {
		funcExprType = aFuncExprType;
	}

	public void genCIForGenType2(final DeduceTypes2 aDeduceTypes2, Consumer<GeneratedFunction> gfc) {
		final @NotNull GenerateFunctions genf = aDeduceTypes2.getGenerateFunctions(funcExprType.getElement().getContext().module());
		final FunctionInvocation fi = new FunctionInvocation((BaseFunctionDef) funcExprType.getElement(),
		  null,
		  null,
		  aDeduceTypes2._phase().generatePhase);
		final WlGenerateFunction gen = new WlGenerateFunction(genf, fi, aDeduceTypes2._phase().codeRegistrar);
		gen.run(null);
		gen.getResultPromise().then(gfc::accept);
		assert gen.getResultPromise().isResolved();
	}
}
