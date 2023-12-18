package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.Finally;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.stages.deduce.declarations.DeferredMember;
import tripleo.elijah.stages.gen_fn.BaseEvaFunction;
import tripleo.elijah.stages.gen_fn.ConstantTableEntry;
import tripleo.elijah.stages.gen_fn.GenType;
import tripleo.elijah.stages.gen_fn.VariableTableEntry;

public class DebugPrint {
	public static void addDependentType(final BaseEvaFunction aGeneratedFunction, final GenType aGenType) {
		System_err_println("**** addDependentType " + aGeneratedFunction + " " + aGenType);
	}

	public static void addDeferredMember(final DeferredMember aDm) {
		System_err_println("**** addDeferredMember " + aDm);
	}

	public static void addPotentialType(final @NotNull VariableTableEntry aVte, final ConstantTableEntry aCte) {
		var c = aVte._deduceTypes2().module.getCompilation();
		addPotentialType(c, aVte, aCte);
	}

	public static void addPotentialType(final Compilation c, final VariableTableEntry aVte, final ConstantTableEntry aCte) {
		if (c.reports().outputOn(Finally.Outs.Out_2121)) {
			final String s = "**** addPotentialType " + aVte + " " + aCte;
			System_err_println(s);
		}
	}

	public static void System_err_println(final String aString) {
		System.err.println(aString);
	}
}
