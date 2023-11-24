package tripleo.elijah.comp.notation;

import org.jetbrains.annotations.NotNull;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.world.i.WorldModule;

import java.util.function.Consumer;

public record GN_PL_Run2_Env(@NotNull PipelineLogic pipelineLogic,
							 @NotNull WorldModule mod,
							 @NotNull CompilationEnclosure ce,
							 @NotNull Consumer<WorldModule> worldConsumer) implements GN_Env {
}
