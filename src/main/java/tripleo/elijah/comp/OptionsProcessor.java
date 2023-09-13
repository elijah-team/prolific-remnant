package tripleo.elijah.comp;

import java.util.*;

@FunctionalInterface
public interface OptionsProcessor {
	String[] process(final Compilation c, final List<String> args) throws Exception;
}
