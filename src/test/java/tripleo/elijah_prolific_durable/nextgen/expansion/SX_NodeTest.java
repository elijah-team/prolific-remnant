package tripleo.elijah_prolific_durable.nextgen.expansion;

import junit.framework.*;
import tripleo.elijah_prolific_durable.comp.*;
import tripleo.elijah_prolific_durable.comp.internal.CompilationImpl;
import tripleo.elijah_prolific_durable.lang.OS_Module;
import tripleo.elijah_prolific_durable.nextgen.model.*;
import tripleo.elijah_prolific_durable.stages.gen_generic.*;
import tripleo.elijah_prolific_durable.stages.logging.ElLog;

import java.util.*;

public class SX_NodeTest extends TestCase {

	public void testFullText() {
		final StdErrSink      errSink       = new StdErrSink();
		final IO              io            = new IO();
		final CompilationImpl comp          = new CompilationImpl(errSink, io);
		final AccessBus       ab            = new AccessBus(comp);
		final PipelineLogic   pipelineLogic = new PipelineLogic(ab);
		final OS_Module mod = comp.moduleBuilder()
		                          .withFileName("filename.elijah")
		                          .addToCompilation()
		                          .build();
		final OutputFileFactoryParams p    = new OutputFileFactoryParams(mod, errSink, ElLog.Verbosity.SILENT, pipelineLogic);
		final GenerateFiles           fgen = OutputFileFactory.create(CompilationAlways.defaultPrelude(), p);

		final SM_ClassDeclaration node = new SM_ClassDeclaration() {
			@Override
			public SM_Name name() {
				return new SM_Name() {
					@Override
					public String getText() {
						return "Main";
					}
				};
			}

			@Override
			public SM_ClassSubtype subType() {
				return SM_ClassSubtype.NORMAL;
			}

			@Override
			public SM_ClassInheritance inheritance() {
				return new SM_ClassInheritance() {
					@Override
					public List<SM_Name> names() {
						return List_of(new SM_Name() {
							@Override
							public String getText() {
								return "Arguments";
							}
						});
					}
				};
			}

			@Override
			public SM_ClassBody classBody() {
				return null;
			}
		};

		fgen.forNode(node);
	}
}