/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.gen_fn;

import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.logging.*;
import tripleo.elijah.work.*;

import java.util.*;

/**
 * Created 5/16/21 12:35 AM
 */
public class GeneratePhase {
	public final WorkManager wm = new WorkManager();

	final         Map<OS_Module, GenerateFunctions> generateFunctions = new HashMap<OS_Module, GenerateFunctions>();
	private final ElLog.Verbosity                   verbosity;
	private final PipelineLogic                     pipelineLogic;
	private final Compilation                       compilation;

	public GeneratePhase(final ElLog.Verbosity aVerbosity, final PipelineLogic aPipelineLogic, final Compilation aCompilation) {
		verbosity     = aVerbosity;
		pipelineLogic = aPipelineLogic;

		compilation = aCompilation;
	}

	@NotNull
	public GenerateFunctions getGenerateFunctions(@NotNull final OS_Module mod) {
		final GenerateFunctions Result;
		if (generateFunctions.containsKey(mod))
			Result = generateFunctions.get(mod);
		else {
			Result = new GenerateFunctions(this, mod, pipelineLogic);
			generateFunctions.put(mod, Result);
		}
		return Result;
	}

	public ElLog.Verbosity getVerbosity() {
		return verbosity;
	}
}

//
//
//
