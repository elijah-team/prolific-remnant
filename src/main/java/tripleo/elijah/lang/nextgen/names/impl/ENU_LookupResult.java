package tripleo.elijah.lang.nextgen.names.impl;

import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.List;
import java.util.stream.Collectors;

public class ENU_LookupResult implements EN_Understanding {

	private int                    level;
	private LookupResultList       lrl;
	private ImmutableList<Context> contexts;

	public ENU_LookupResult(LookupResultList aLrl, int aLevel, ImmutableList<Context> aContexts) {
		this.lrl      = aLrl;
		this.level    = aLevel;
		this.contexts = aContexts;
	}

	public ENU_LookupResult(@NotNull LookupResultList lrl2) {
		this.lrl   = lrl2;
		this.level = -10000;

		final List<Context> collect = lrl2.results().stream().map(lr -> lr.getContext()).collect(Collectors.toList());
		this.contexts = ImmutableList.copyOf(collect);
	}

}
