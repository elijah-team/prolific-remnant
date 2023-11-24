package tripleo.elijah.stages.deduce.fluffy.impl;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.entrypoints.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.fluffy.i.*;

import java.util.*;

public class FluffyCompImpl implements FluffyComp {

	private final CompilationImpl              _comp;
	private final Map<OS_Module, FluffyModule> fluffyModuleMap = new HashMap<>();

	public FluffyCompImpl(final CompilationImpl aComp) {
		_comp = aComp;
	}

	public static boolean isMainClassEntryPoint(@NotNull final ClassItem input) {
		final FunctionDef fd = (FunctionDef) input;
		return MainClassEntryPoint.is_main_function_with_no_args(fd);
	}

	@Override
	public FluffyModule module(final OS_Module aModule) {
		if (fluffyModuleMap.containsKey(aModule)) {
			return fluffyModuleMap.get(aModule);
		}

		final FluffyModuleImpl fluffyModule = new FluffyModuleImpl(aModule, _comp);

		fluffyModuleMap.put(aModule, fluffyModule);
//		fluffyModule.

		return fluffyModule;
	}
}
