/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah_prolific_durable.stages.generate;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.util.*;
import tripleo.elijah_prolific_durable.comp.Compilation;
import tripleo.elijah_prolific_durable.stages.gen_fn.*;
import tripleo.elijah_prolific_durable.stages.gen_generic.*;
import tripleo.elijah_prolific_durable.util.SimplePrintLoggerToRemoveSoon;

import java.util.*;

/**
 * Created 1/8/21 11:02 PM
 */
public class ElSystem {
	private final Map<GeneratedFunction, String> gfm_map = new HashMap<GeneratedFunction, String>();
	public        boolean                        verbose = true;
	private OutputStrategy outputStrategy;
	private Compilation    compilation;

	public void generateOutputs(@NotNull final GenerateResult gr) {
		final @NotNull OutputStrategyC outputStrategyC = new OutputStrategyC(this.outputStrategy);

		for (final GenerateResultItem ab : gr.results()) {
			final String s = generateOutputs_Internal(ab.node, ab.ty, outputStrategyC);
			assert s != null;
			ab.output = s;
		}

		if (verbose) {
			for (final GenerateResultItem ab : gr.results()) {
				if (ab.node instanceof GeneratedFunction) continue;
				SimplePrintLoggerToRemoveSoon.println2("** " + ab.node + " " + ab.output);
			}
		}
	}

	String generateOutputs_Internal(final GeneratedNode node, final GenerateResult.TY ty, final OutputStrategyC outputStrategyC) {
		final String s;
		String       ss;
		if (node instanceof final GeneratedNamespace generatedNamespace) {
			s = outputStrategyC.nameForNamespace(generatedNamespace, ty);
//			tripleo.elijah.util.Stupidity.println2("41 "+generatedNamespace+" "+s);
			for (final GeneratedFunction gf : generatedNamespace.functionMap.values()) {
				ss = generateOutputs_Internal(gf, ty, outputStrategyC);
				gfm_map.put(gf, ss);
			}
		} else if (node instanceof final GeneratedClass generatedClass) {
			s = outputStrategyC.nameForClass(generatedClass, ty);
//			tripleo.elijah.util.Stupidity.println2("48 "+generatedClass+" "+s);
			for (final GeneratedFunction gf : generatedClass.functionMap.values()) {
				ss = generateOutputs_Internal(gf, ty, outputStrategyC);
				gfm_map.put(gf, ss);
			}
		} else if (node instanceof final GeneratedFunction generatedFunction) {
			s = outputStrategyC.nameForFunction(generatedFunction, ty);
//			tripleo.elijah.util.Stupidity.println2("55 "+generatedFunction+" "+s);
		} else if (node instanceof final GeneratedConstructor generatedConstructor) {
			s = outputStrategyC.nameForConstructor(generatedConstructor, ty);
//			tripleo.elijah.util.Stupidity.println2("55 "+generatedConstructor+" "+s);
		} else
			throw new IllegalStateException("Can't be here.");
		return s;
	}

	public void setOutputStrategy(final OutputStrategy outputStrategy) {
		this.outputStrategy = outputStrategy;
	}

	public void setCompilation(final Compilation compilation) {
		this.compilation = compilation;
	}
}

//
//
//
