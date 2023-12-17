package tripleo.elijah.nextgen.inputtree;

import org.jetbrains.annotations.Contract;
import tripleo.elijah.lang.i.OS_Module;

import java.util.List;
import java.util.stream.Stream;

public class EIT_ModuleList {

	private final List<OS_Module> mods;

	@Contract(pure = true)
	public EIT_ModuleList(final List<OS_Module> aMods) {
		mods = aMods;
	}

	// TODO use WorldModule here
	public List<OS_Module> getMods() {
		return mods;
	}

	public void add(final OS_Module m) {
		mods.add(m);
	}

	public Stream<OS_Module> stream() {
		return mods.stream();
	}

}
