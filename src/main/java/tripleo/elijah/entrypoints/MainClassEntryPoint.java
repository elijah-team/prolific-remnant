/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.entrypoints;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.*;

/**
 * Created 6/14/21 7:28 AM
 */
public class MainClassEntryPoint implements EntryPoint {
	private final ClassStatement klass;
	private       FunctionDef    main_function;

	public MainClassEntryPoint(final ClassStatement aKlass) {
		final Collection<ClassItem> main = aKlass.findFunction("main");
		for (final ClassItem classItem : main) {
			final FunctionDef fd       = (FunctionDef) classItem;
			final boolean     return_type_is_null;
			final TypeName    typeName = fd.returnType();
			if (typeName == null)
				return_type_is_null = true;
			else
				return_type_is_null = typeName.isNull();
			if (fd.getArgs().size() == 0 && return_type_is_null) {
				main_function = fd;
			}
		}
		if (main_function == null)
			throw new IllegalArgumentException("Class does not define main");
		klass = aKlass;
	}

	public static boolean isMainClass(@NotNull final ClassStatement classStatement) {
		// TODO what about Library (for windows dlls) etc?
		return classStatement.getPackageName() == OS_Package.default_package && classStatement.name().equals("Main");
	}

	public static boolean is_main_function_with_no_args(@NotNull final FunctionDef aFunctionDef) {
		switch (aFunctionDef.getSpecies()) {
		case REG_FUN:
		case DEF_FUN:
			if (aFunctionDef.name().equals("main")) {
				return !aFunctionDef.getArgs().iterator().hasNext();
			}
			break;
		}
		return false;
	}

	public FunctionDef getMainFunction() {
		return main_function;
	}

	public ClassStatement getKlass() {
		return klass;
	}
}

//
//
//
