package tripleo.elijah_prolific_durable.stages.deduce.fluffy.impl;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah_prolific_durable.comp.internal.CompilationImpl;
import tripleo.elijah_prolific_durable.entrypoints.MainClassEntryPoint;
import tripleo.elijah_prolific_durable.lang.*;
import tripleo.elijah_prolific_durable.stages.deduce.fluffy.i.*;

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
