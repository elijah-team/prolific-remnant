package tripleo.elijah_prolific_durable.stages.gen_c.c_ast1;

import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.logging.ElLog;

import java.util.function.Supplier;

public class C_HeaderString {
	private final String result;

	@Contract(pure = true)
	public C_HeaderString(final String aResult) {
		result = aResult;
	}

	public static @NotNull C_HeaderString forClass(final GeneratedClass aGeneratedClass,
	                                               final @NotNull Supplier<String> classNameSupplier,
	                                               final String return_type,
	                                               final String name,
	                                               final @NotNull String args_string,
	                                               final ElLog LOG) {
		final String class_name0 = classNameSupplier.get();

		if (false) {
			LOG.info("234 class_name >> " + class_name0);
		}

		final String if_args = args_string.length() == 0 ? "" : ", ";

		final String result = String.format("%s %s%s(%s* vsc%s%s)",
		  return_type,
		  class_name0,
		  name,
		  class_name0,
		  if_args,
		  args_string);
		return new C_HeaderString(result);
	}

	@Contract("_, _, _, _, _, _ -> new")
	public static @NotNull C_HeaderString forNamespace(final @NotNull GeneratedNamespace st,
	                                                   final java.util.function.@NotNull Supplier<String> classNameSupplier,
	                                                   final String return_type,
	                                                   final String name,
	                                                   final @NotNull String args_string,
	                                                   final @NotNull ElLog LOG) {
		//final String       class_name = gc.getTypeName(st);
		final String class_name = classNameSupplier.get();
		LOG.info(String.format("240 (namespace) %s -> %s", st.getName(), class_name));
		//final String if_args = args_string.length() == 0 ? "" : ", ";

//		assert args_string.length() == 0;

		// TODO vsi for namespace instance??
		//tos.put_string_ln(String.format("%s %s%s(%s* vsi%s%s) {", returnType, class_name, name, class_name, if_args, args));

		final String result = String.format("%s %s%s(%s)", return_type, class_name, name, args_string);

		return new C_HeaderString(result);
	}

	@Contract("_, _, _, _ -> new")
	public static @NotNull C_HeaderString forOther(final GeneratedContainerNC aParent,
	                                               final String return_type,
	                                               final String name,
	                                               final String args_string) {
		final String result = String.format("%s %s(%s)", return_type, name, args_string);

		return new C_HeaderString(result);
	}

	public String getResult() {
		return result;
	}
}
