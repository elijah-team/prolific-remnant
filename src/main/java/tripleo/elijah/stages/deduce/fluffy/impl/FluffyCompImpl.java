package tripleo.elijah.stages.deduce.fluffy.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.internal.CompilationImpl;
import tripleo.elijah.entrypoints.MainClassEntryPoint;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyComp;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyModule;

import java.util.*;
import java.util.stream.Collectors;

public class FluffyCompImpl implements FluffyComp {

	private final CompilationImpl _comp;

	public static boolean isMainClassEntryPoint(@NotNull final ClassItem input) {
		// TODO 08/27 Use understanding/~ processor for this
		final FunctionDef fd = (FunctionDef) input;
		return MainClassEntryPoint.is_main_function_with_no_args(fd);
	}

	private final Map<OS_Module, FluffyModule> fluffyModuleMap = new HashMap<>();

	public FluffyCompImpl(final CompilationImpl aComp) {
		_comp = aComp;
	}

	@Override
	public void find_multiple_items(final @NotNull OS_Module aModule) {
		getFluffyModule(aModule).find_multiple_items();
	}

	private FluffyModule getFluffyModule(final OS_Module aModule) {
		return module(aModule);
	}

	@Override
	public FluffyModule module(final OS_Module aModule) {
		if (fluffyModuleMap.containsKey(aModule)) {
			return fluffyModuleMap.get(aModule);
		}

		final FluffyModuleImpl fluffyModule = _inj().new_FluffyModuleImpl(aModule, _comp);
		fluffyModuleMap.put(aModule, fluffyModule);
		return fluffyModule;
	}

	private FluffyCompImplInjector _inj() {
		return __inj;
	}

	FluffyCompImplInjector __inj = new FluffyCompImplInjector();

	static class FluffyCompImplInjector {
		public FluffyModuleImpl new_FluffyModuleImpl(final OS_Module aModule, final CompilationImpl aComp) {
			return new FluffyModuleImpl(aModule, aComp);
		}
	}
}
