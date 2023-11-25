package tripleo.elijah.comp.notation;

import com.google.common.base.*;
import org.jetbrains.annotations.NotNull;
import tripleo.elijah.*;
import tripleo.elijah.ci.i.CompilerInstructions;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.comp.i.CompilationEnclosure;
import tripleo.elijah.comp.i.IPipelineAccess;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.nextgen.inputtree.EIT_ModuleList;
import tripleo.elijah.stages.gen_generic.*;
import tripleo.elijah.stages.gen_generic.pipeline_impl.GenerateResultSink;
import tripleo.elijah.stages.gen_generic.pipeline_impl.ProcessedNode;
import tripleo.elijah.stages.logging.ElLog;
import tripleo.elijah.util.*;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public record GN_GenerateNodesIntoSinkEnv(List<ProcessedNode> lgc,
                                          GenerateResultSink resultSink1,
                                          EIT_ModuleList moduleList,
                                          ElLog.Verbosity verbosity,
                                          Old_GenerateResult gr,
                                          IPipelineAccess pa,
                                          CompilationEnclosure ce) implements GN_Env {

	@NotNull
	public static Operation<String> getLang(final @NotNull OS_Module mod) {
		final LibraryStatementPart lsp = mod.getLsp();

		if (lsp == null) {
			final String message = "7777777777777777777 mod.getFilename " + mod.getFileName();
			SimplePrintLoggerToRemoveSoon.println_err_2(message);
			return Operation.failure(new Exception(message));
		}

		final CompilerInstructions ci = lsp.getInstructions();
		if (ci.genLang().isPresent()) {
			return Operation.success(ci.genLang().get());
		} else {
			// FIXME 11/24 HACK this returns something even when it shouldn't
//			return Operation.success("c");
			throw new ProgramIsWrongIfYouGetHere();
		}
	}

	@NotNull
	static GenerateFiles getGenerateFiles(final OutputFileFactoryParams params,
	                                      final @NotNull OS_Module mod,
	                                      final Supplier<GenerateResultEnv> fgs) {
		Preconditions.checkNotNull(mod);

		final Operation<String> lang0 = getLang(mod);

		if (lang0.mode() == Mode.SUCCESS) {
			String lang = lang0.success();
			GenerateResultEnv fileGen;

			if (Objects.equals(lang, "c")) {
				fileGen = fgs.get();
			} else {
				fileGen = null;
			}

			Preconditions.checkNotNull(lang);
			Preconditions.checkNotNull(fileGen);

			// TODO creates more than one GenerateC, look into this
			return OutputFileFactory.create(lang, params, fileGen);
		}

		throw new ProgramIsWrongIfYouGetHere();
		//return OutputFileFactory.create(Objects.requireNonNull(lang), params, fileGen);
	}
}
