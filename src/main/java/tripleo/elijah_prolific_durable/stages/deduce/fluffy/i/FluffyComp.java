package tripleo.elijah_prolific_durable.stages.deduce.fluffy.i;

import com.google.common.collect.*;
import tripleo.elijah_prolific_durable.lang.*;

import java.util.*;
import java.util.stream.Collectors;

public interface FluffyComp {
	default void find_multiple_items(final OS_Module aModule) {
		final Multimap<String, ModuleItem> items_map = ArrayListMultimap.create(aModule.items.size(), 1);
		for (final ModuleItem item : aModule.items) {
			if (!(item instanceof OS_Element2/* && item != anElement*/))
				continue;
			final String item_name = ((OS_Element2) item).name();
			items_map.put(item_name, item);
		}
		for (final String key : items_map.keys()) {
			boolean warn = false;

			final Collection<ModuleItem> moduleItems = items_map.get(key);
			if (moduleItems.size() < 2) // README really 1
				continue;

			final Collection<ElObjectType> t = moduleItems
			  .stream()
			  .map((final ModuleItem input) -> DecideElObjectType.getElObjectType(input))
			  .collect(Collectors.toList());

			final Set<ElObjectType> st = new HashSet<ElObjectType>(t);
			if (st.size() > 1)
				warn = true;
			if (moduleItems.size() > 1)
				if (moduleItems.iterator().next() instanceof NamespaceStatement && st.size() == 1)
					;
				else
					warn = true;

			//
			//
			//

			if (warn) {
				final String module_name = aModule.toString(); // TODO print module name or something
				final String s = String.format(
				  "[Module#add] %s Already has a member by the name of %s",
				  module_name, key);
				aModule.parent.getErrSink().reportWarning(s);
			}
		}
	}

	FluffyModule module(OS_Module aModule);
}
