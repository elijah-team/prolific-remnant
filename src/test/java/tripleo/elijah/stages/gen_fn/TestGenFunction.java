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
import org.junit.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.entrypoints.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;
import tripleo.elijah.stages.instructions.*;
import tripleo.elijah.work.*;

import java.io.*;
import java.util.*;

import static tripleo.elijah.util.Helpers.*;

/**
 * Created 9/10/20 2:20 PM
 */
public class TestGenFunction {

	@Test
	public void testDemoElNormalFact1Elijah() throws Exception {
		final StdErrSink  eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		final String    f    = "test/demo-el-normal/fact1.elijah";
		final File      file = new File(f);
		final OS_Module m    = c.realParseElijjahFile(f, file, false);
		Assert.assertNotNull("Method parsed correctly", m);
		m.prelude = c.findPrelude("c").success(); // TODO we dont know which prelude to find yet

		//
		//
		//
		final ClassStatement main_class = (ClassStatement) m.findClass("Main");
		assert main_class != null;
		final MainClassEntryPoint mainClassEntryPoint = new MainClassEntryPoint(main_class);
//		m.entryPoints = new EntryPointList();
		m.entryPoints.add(mainClassEntryPoint);
		//
		//
		//

		final List<FunctionMapHook> ran_hooks = new ArrayList<>();


		final AccessBus ab = new AccessBus(c);
		ab.addPipelineLogic(PipelineLogic::new);

		c.pipelineLogic = ab.__getPL();

		final @NotNull GeneratePhase generatePhase1 = c.pipelineLogic.generatePhase;//new GeneratePhase();
		final GenerateFunctions      gfm            = generatePhase1.getGenerateFunctions(m);
		final @NotNull DeducePhase   dp             = c.pipelineLogic.dp;//new DeducePhase(generatePhase1);
		gfm.generateFromEntryPoints(m.entryPoints, dp);

		final DeducePhase.@NotNull EvaClasses lgc = dp.generatedClasses; //new ArrayList<>();

/*
		List<EvaNode> lgf = new ArrayList<>();
		for (EvaNode generatedNode : lgc) {
			if (generatedNode instanceof EvaClass)
				lgf.addAll(((EvaClass) generatedNode).functionMap.values());
			if (generatedNode instanceof EvaNamespace)
				lgf.addAll(((EvaNamespace) generatedNode).functionMap.values());
			// TODO enum
		}
*/

//		Assert.assertEquals(2, lgf.size());

		final WorkManager wm = new WorkManager();

		c.addFunctionMapHook(new FunctionMapHook() {
			@Override
			public boolean matches(final FunctionDef fd) {
				final boolean b = fd.name().equals("main") && fd.getParent() == main_class;
				return b;
			}

			@Override
			public void apply(final Collection<EvaFunction> aEvaFunctions) {
				assert aEvaFunctions.size() == 1;

				final EvaFunction gf = aEvaFunctions.iterator().next();

				int pc = 0;
				Assert.assertEquals(InstructionName.E, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.DECL, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.AGNK, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.DECL, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.AGN, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.CALL, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.X, gf.getInstruction(pc++).getName());

				ran_hooks.add(this);
			}
		});

		c.addFunctionMapHook(new FunctionMapHook() {
			@Override
			public boolean matches(final FunctionDef fd) {
				final boolean b = fd.name().equals("factorial") && fd.getParent() == main_class;
				return b;
			}

			@Override
			public void apply(final Collection<EvaFunction> aEvaFunctions) {
				assert aEvaFunctions.size() == 1;

				final EvaFunction gf = aEvaFunctions.iterator().next();

				int pc = 0;
				Assert.assertEquals(InstructionName.E, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.DECL, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.AGNK, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.ES, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.DECL, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.AGNK, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.JE, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.CALLS, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.CALLS, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.JMP, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.XS, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.AGN, gf.getInstruction(pc++).getName());
				Assert.assertEquals(InstructionName.X, gf.getInstruction(pc++).getName());

				ran_hooks.add(this);
			}
		});

		c.addFunctionMapHook(new FunctionMapHook() {
			@Override
			public boolean matches(final FunctionDef fd) {
				final boolean b = fd.name().equals("main") && fd.getParent() == main_class;
				return b;
			}

			@Override
			public void apply(final Collection<EvaFunction> aEvaFunctions) {
				assert aEvaFunctions.size() == 1;

				final EvaFunction gf = aEvaFunctions.iterator().next();

				System.out.println("main\n====");
				for (int i = 0; i < gf.vte_list.size(); i++) {
					final VariableTableEntry vte = gf.getVarTableEntry(i);
					System.out.printf("8007 %s %s %s%n", vte.getName(), vte.type, vte.potentialTypes());
					if (vte.type.getAttached() != null) {
						Assert.assertNotEquals(OS_Type.Type.BUILT_IN, vte.type.getAttached().getType());
						Assert.assertNotEquals(OS_Type.Type.USER, vte.type.getAttached().getType());
					}
				}
				System.out.println();

				ran_hooks.add(this);
			}
		});

		c.addFunctionMapHook(new FunctionMapHook() {
			@Override
			public boolean matches(final FunctionDef fd) {
				final boolean b = fd.name().equals("factorial") && fd.getParent() == main_class;
				return b;
			}

			@Override
			public void apply(final Collection<EvaFunction> aEvaFunctions) {
				assert aEvaFunctions.size() == 1;

				final EvaFunction gf = aEvaFunctions.iterator().next();

				System.out.println("factorial\n=========");
				for (int i = 0; i < gf.vte_list.size(); i++) {
					final VariableTableEntry vte = gf.getVarTableEntry(i);
					System.out.printf("8008 %s %s %s%n", vte.getName(), vte.type, vte.potentialTypes());
					if (vte.type.getAttached() != null) {
						Assert.assertNotEquals(OS_Type.Type.BUILT_IN, vte.type.getAttached().getType());
						Assert.assertNotEquals(OS_Type.Type.USER, vte.type.getAttached().getType());
					}
				}
				System.out.println();

				ran_hooks.add(this);
			}
		});

		dp.deduceModule(m, lgc, false, Compilation.gitlabCIVerbosity());
		dp.finish(dp.generatedClasses);

		Assert.assertEquals("Not all hooks ran", 4, ran_hooks.size());
		Assert.assertEquals(108, c.errorCount());
	}

	@Test
	public void testGenericA() throws Exception {
		final StdErrSink  errSink = new StdErrSink();
		final Compilation c       = new CompilationImpl(errSink, new IO());

		final String f = "test/basic1/genericA/";

		c.feedCmdLine(List_of(f));
	}

	//	@Test // ignore because of generateAllTopLevelClasses
	public void testBasic1Backlink1Elijah() throws Exception {
//		final StdErrSink eee = new StdErrSink();
//		final Compilation c = new CompilationImpl(eee, new IO());
//
//		final String f = "test/basic1/backlink1.elijah";
//		final File file = new File(f);
//		final OS_Module m = c.realParseElijjahFile(f, file, false);
//		Assert.assertTrue("Method parsed correctly", m != null);
//		m.prelude = c.findPrelude("c").success(); // TODO we dont know which prelude to find yet
//
//		c.findStdLib("c");
//
//		for (final CompilerInstructions ci : c.cis) {
//			c.use(ci, false);
//		}
//
//		final ElLog.Verbosity verbosity1 = c.gitlabCIVerbosity();
//		final AccessBus       ab         = new AccessBus(c);
//
//		ab.addPipelineLogic(PipelineLogic::new);
//		final PipelineLogic pl = ab.__getPL();
//
//		final GeneratePhase       generatePhase = pl.generatePhase;
//		final GenerateFunctions   gfm           = generatePhase.getGenerateFunctions(m);
//		final List<EvaNode> lgc           = new ArrayList<>();
//		gfm.generateAllTopLevelClasses(lgc);
//
//		final DeducePhase dp = new DeducePhase(generatePhase, pl, verbosity1);
//
//		final WorkManager wm = new WorkManager();
//
//		final List<EvaNode> lgf = new ArrayList<>();
//		for (final EvaNode generatedNode : lgc) {
//			if (generatedNode instanceof EvaClass)
//				lgf.addAll(((EvaClass) generatedNode).functionMap.values());
//			if (generatedNode instanceof EvaNamespace)
//				lgf.addAll(((EvaNamespace) generatedNode).functionMap.values());
//			// TODO enum
//		}
//
//		for (final EvaNode gn : lgf) {
//			if (gn instanceof EvaFunction) {
//				final EvaFunction gf = (EvaFunction) gn;
//				for (final Instruction instruction : gf.instructions()) {
//					System.out.println("8100 " + instruction);
//				}
//			}
//		}
//
//		dp.deduceModule(m, lgc, true, c.gitlabCIVerbosity());
//		dp.finish(dp.generatedClasses);
////		new DeduceTypes2(m).deduceFunctions(lgf);
//
//		for (final EvaNode gn : lgf) {
//			if (gn instanceof EvaFunction) {
//				final EvaFunction gf = (EvaFunction) gn;
//				System.out.println("----------------------------------------------------------");
//				System.out.println(gf.name());
//				System.out.println("----------------------------------------------------------");
//				EvaFunction.printTables(gf);
////				System.out.println("----------------------------------------------------------");
//			}
//		}
//
//		final OutputFileFactoryParams p   = new OutputFileFactoryParams(m, eee, c.gitlabCIVerbosity(), pl);
//		final GenerateC               ggc = new GenerateC(p);
//		ggc.generateCode(lgf, wm);
//
//		final GenerateResult gr = new GenerateResult();
//
//		for (final EvaNode generatedNode : lgc) {
//			if (generatedNode instanceof EvaClass) {
//				ggc.generate_class((EvaClass) generatedNode, gr);
//			} else {
//				System.out.println(lgc.getClass().getName());
//			}
//		}
	}

	@Test
	public void testBasic1Backlink3Elijah() throws Exception {
		final StdErrSink  eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		final String ff = "test/basic1/backlink3/";
		c.feedCmdLine(List_of(ff));
	}
}

//
//
//
