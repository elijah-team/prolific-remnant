package tripleo.elijah.stages.deduce.fluffy.impl;

import com.google.common.collect.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tripleo.elijah.comp.i.Compilation;
import tripleo.elijah.entrypoints.MainClassEntryPoint;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyComp;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyLsp;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyMember;
import tripleo.elijah.stages.deduce.fluffy.i.FluffyModule;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class FluffyModuleImpl implements FluffyModule {
	/**
	 * If classStatement is a "main class", send to consumer
	 *
	 * @param classStatement
	 * @param ccs
	 */
	private static void faep_002(final @NotNull ClassStatement classStatement, final Consumer<ClassStatement> ccs) {
		// README 12/24 FTR, I want to combine this into one big stream-statement-of-pure-bliss,
		//  but you just can't rely on ie, stream debugger or slt, b/c reasons
		//  the explanation is "just use printf"

		final Collection<ClassItem> x     = classStatement.findFunction("main");
		final Stream<FunctionDef>   found = x.stream().filter(FluffyCompImpl::isMainClassEntryPoint).map(x7 -> (FunctionDef) x7);

		found
				.map(aFunctionDef -> (ClassStatement) aFunctionDef.getParent())
				.forEach(ccs);
	}

	private final Compilation compilation;

	private final OS_Module module;

	private FluffyModuleImplInjector __inj = new FluffyModuleImplInjector();

	public FluffyModuleImpl(final OS_Module aModule, final Compilation aCompilation) {
		module      = aModule;
		compilation = aCompilation;
	}

	@Override
	public void find_all_entry_points() {
		//
		// FIND ALL ENTRY POINTS (should only be one per module)
		//
		final Consumer<ClassStatement> ccs = (x) -> module.entryPoints().add(_inj().new_MainClassEntryPoint(x));

		module.getItems().stream()
				.filter(item -> item instanceof ClassStatement)
				.map(item -> (ClassStatement) item)
				.filter(classStatement -> MainClassEntryPoint.isMainClass(classStatement))
				.forEach(classStatement -> faep_002(classStatement, ccs));
	}

	private FluffyModuleImplInjector _inj() {
		return this.__inj;
	}

	@Override
	public void find_multiple_items(final @NotNull FluffyComp aFc) {
		aFc.find_multiple_items(module);
	}

	@Override
	public @Nullable FluffyLsp lsp() {
		return null;
	}

	@Override
	public @Nullable List<FluffyMember> members() {
		return null;
	}

	@Override
	public @Nullable String name() {
		return null;
	} // TODO 12/24 LocatableString

	@Override
	public void find_multiple_items() {
		final Multimap<String, ModuleItem> items_map = ArrayListMultimap.create(this.getItems().size(), 1);

		this.getItems().stream()
				.filter(Objects::nonNull)
				.filter(x -> !(x instanceof ImportStatement))
				.forEach(item -> {
					// README likely for member functions.
					// README Also note elijah has single namespace
					items_map.put(item.name().asString(), item);
				});

		for (final String key : items_map.keys()) {
			boolean warn = false;

			final Collection<ModuleItem> moduleItems = items_map.get(key);
			if (moduleItems.size() == 1)
				continue;

			final Collection<ElObjectType> t = moduleItems
					.stream()
					.map(DecideElObjectType::getElObjectType)
					.collect(Collectors.toList());

			final Set<ElObjectType> st = new HashSet<ElObjectType>(t);
			if (st.size() > 1)
				warn = true;
			if (moduleItems.size() > 1) {
				if (moduleItems.iterator().next() instanceof NamespaceStatement && st.size() == 1) {
					;
				} else {
					warn = true;
				}
			}

			//
			//
			//

			if (warn) {
				// FIXME 07/28 out of place

				final String module_name = this.toString(); // TODO print module name or something
				final String s = String.format(
						"[Module#add] %s Already has a member by the name of %s",
						module_name, key);
				module.getCompilation().getErrSink().reportWarning(s);
			}
		}
	}

	private @NotNull Collection<ModuleItem> getItems() {
		return module.getItems();
	}

	static class FluffyModuleImplInjector {

		public MainClassEntryPoint new_MainClassEntryPoint(ClassStatement x) {
			return new MainClassEntryPoint(x);
		}
	}
}
