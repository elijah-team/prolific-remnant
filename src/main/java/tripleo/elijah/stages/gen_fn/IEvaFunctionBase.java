package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.nextgen.reactive.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.util.range.*;

import java.util.*;

public interface IEvaFunctionBase {
	int add(InstructionName aName, List<InstructionArgument> args_, Context ctx);

	void addContext(Context context, Range r);

	void addElement(OS_Element aElement, DeduceElement aDeduceElement);

	int addIdentTableEntry(IdentExpression ident, Context context);

	@NotNull Label addLabel();

	@NotNull Label addLabel(String base_name, boolean append_int);

	int addVariableTableEntry(String name, VariableTableType vtt, TypeTableEntry type, OS_Element el);

	String expectationString();

	@Nullable Label findLabel(int index);

	@NotNull InstructionArgument get_assignment_path(@NotNull IExpression expression,
													 @NotNull GenerateFunctions generateFunctions,
													 Context context);

	int getCode();

	@NotNull ConstantTableEntry getConstTableEntry(int index);

	Context getContextFromPC(int pc);

	Dependency getDependency();

	@NotNull FunctionDef getFD();

	String getFunctionName();

	EvaNode getGenClass();

	String getIdentIAPathNormal(IdentIA ia2);

	@NotNull IdentTableEntry getIdentTableEntry(int index);

	@Nullable IdentTableEntry getIdentTableEntryFor(IExpression expression);

	Instruction getInstruction(int anIndex);

	EvaContainerNC getParent();

	@NotNull ProcTableEntry getProcTableEntry(int index);

	@Nullable VariableTableEntry getSelf();

	@NotNull TypeTableEntry getTypeTableEntry(int index);

	@NotNull VariableTableEntry getVarTableEntry(int index);

	@NotNull List<Instruction> instructions();

	@NotNull List<Label> labels();

	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type);

	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, IExpression expression);

	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, IExpression expression, TableEntryIV aTableEntryIV);

	@NotNull TypeTableEntry newTypeTableEntry(TypeTableEntry.Type type1, OS_Type type, TableEntryIV aTableEntryIV);

	int nextTemp();

	void place(@NotNull Label label);

	void resolveTypeDeferred(GenType aType);

	void setClass(@NotNull EvaNode aNode);

	void setCode(int aCode);

	void setParent(EvaContainerNC aEvaContainerNC);

	//DeferredObject<GenType, Void, Void> typeDeferred();
	//
	//Promise<GenType, Void, Void> typePromise();

	@Nullable InstructionArgument vte_lookup(String text);

	interface BaseEvaFunction_Reactive extends Reactive {}
}
