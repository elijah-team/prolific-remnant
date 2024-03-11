/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.deduce;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import org.jetbrains.annotations.*;
import tripleo.elijah_prolific_durable.diagnostic.*;
import tripleo.elijah_prolific_durable.lang.VariableStatement;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;

import java.io.PrintStream;
import java.util.*;

/**
 * Created 4/13/21 5:46 AM
 */
public class CantDecideType implements Diagnostic {
	private final          VariableTableEntry         vte;
	private final @NotNull Collection<TypeTableEntry> types;

	public CantDecideType(final VariableTableEntry aVte, @NotNull final Collection<TypeTableEntry> aTypes) {
		vte   = aVte;
		types = aTypes;
	}

	@Override
	public @NotNull String code() {
		return "E1001";
	}

	@Override
	public @NotNull Severity severity() {
		return Severity.ERROR;
	}

	@Override
	public @NotNull Locatable primary() {
		@NotNull final VariableStatement vs = (VariableStatement) vte.getResolvedElement();
		return vs;
	}

	@Override
	public @NotNull List<Locatable> secondary() {
		@NotNull final Collection<Locatable> c = Collections2.transform(types, new Function<TypeTableEntry, Locatable>() {

			@Nullable
			@Override
			public Locatable apply(@org.jetbrains.annotations.Nullable final TypeTableEntry input) {
//				return input.attached.getElement(); // TODO All elements should be Locatable
//				return (TypeName)input.attached.getTypename();
				return null;
			}
		});

		return new ArrayList<Locatable>(c);
	}

	@Override
	public void report(@NotNull final PrintStream stream) {
		stream.printf("---[%s]---: %s%n", code(), message());
		// linecache.print(primary);
		for (final Locatable sec : secondary()) {
			//linecache.print(sec)
		}
		stream.flush();
	}

	private @NotNull String message() {
		return "Can't decide type";
	}
}

//
//
//
