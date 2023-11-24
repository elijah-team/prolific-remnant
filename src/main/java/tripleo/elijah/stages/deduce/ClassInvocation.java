/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.gen_fn.*;

import java.util.*;

/**
 * Created 3/5/21 3:51 AM
 */
public class ClassInvocation implements IInvocation {
	public final @Nullable Map<TypeName, OS_Type>                     genericPart;
	private final @NotNull ClassStatement                             cls;
	private final          String                                     constructorName;
	private final          DeferredObject<GeneratedClass, Void, Void> resolvePromise = new DeferredObject<GeneratedClass, Void, Void>();

	public ClassInvocation(@NotNull final ClassStatement aClassStatement, final String aConstructorName) {
		cls = aClassStatement;
		final @NotNull List<TypeName> genericPart1 = aClassStatement.getGenericPart();
		if (genericPart1.size() > 0) {
			genericPart = new HashMap<TypeName, OS_Type>(genericPart1.size());
			for (final TypeName typeName : genericPart1) {
				genericPart.put(typeName, new OS_UnknownType(null)); // TODO DeduceType here because deferred
			}
		} else {
			genericPart = null;
		}
		constructorName = aConstructorName;
	}

	public @NotNull DeferredObject<GeneratedClass, Void, Void> resolveDeferred() {
		return resolvePromise;
	}

	public void set(final int aIndex, final TypeName aTypeName, @NotNull final OS_Type aType) {
		assert aType.getType() == OS_Type.Type.USER_CLASS;
		genericPart.put(aTypeName, aType);
	}

	public @NotNull ClassStatement getKlass() {
		return cls;
	}

	public @NotNull Promise<GeneratedClass, Void, Void> resolvePromise() {
		return resolvePromise.promise();
	}

	public String getConstructorName() {
		return constructorName;
	}

	@Override
	public void setForFunctionInvocation(@NotNull final FunctionInvocation aFunctionInvocation) {
		aFunctionInvocation.setClassInvocation(this);
	}

	public @NotNull Promise<GeneratedClass, Void, Void> promise() {
		return resolvePromise;
	}
}

//
//
//
