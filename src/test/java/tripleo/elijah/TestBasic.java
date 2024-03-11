/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.jdeferred2.Promise;
import org.jdeferred2.impl.DeferredObject;
import org.jetbrains.annotations.NotNull;
import org.junit.*;
import tripleo.elijah_prolific_durable.comp.*;
import tripleo.elijah_prolific_durable.comp.internal.CompilationImpl;
import tripleo.elijah_prolific_durable.nextgen.outputstatement.*;
import tripleo.elijah_prolific_durable.nextgen.outputtree.EOT_OutputTree;
import tripleo.elijah_prolific.v.V;

import java.io.File;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;
import static tripleo.elijah_prolific_durable.util.Helpers.List_of;

/**
 * @author Tripleo(envy)
 */
public class TestBasic {

	@Test
	public final void testBasicParse() throws Exception {
		final List<String> ez_files = Files.readLines(new File("test/basic/ez_files.txt"), Charsets.UTF_8);
		final List<String> args     = new ArrayList<String>();
		args.addAll(ez_files);
		args.add("-sE");
		final ErrSink     eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		c.feedCmdLine(args);

		Assert.assertEquals(0, c.errorCount());
	}

	static <T> @NotNull Promise<T, Void, Void> select(@NotNull final List<T> list, final Predicate<T> p) {
		final DeferredObject<T, Void, Void> d = new DeferredObject<T, Void, Void>();
		for (final T t : list) {
			if (p.test(t)) {
				d.resolve(t);
				return d;
			}
		}
		d.reject(null);
		return d;
	}

	//	@Test
	public final void testBasic() throws Exception {
		final List<String>          ez_files   = Files.readLines(new File("test/basic/ez_files.txt"), Charsets.UTF_8);
		final Map<Integer, Integer> errorCount = new HashMap<Integer, Integer>();
		int                         index      = 0;

		for (final String s : ez_files) {
//			List<String> args = List_of("test/basic", "-sO"/*, "-out"*/);
			final ErrSink     eee = new StdErrSink();
			final Compilation c   = new CompilationImpl(eee, new IO());

			c.feedCmdLine(List_of(s, "-sO"));

			if (c.errorCount() != 0)
				System.err.printf("Error count should be 0 but is %d for %s%n", c.errorCount(), s);
			errorCount.put(index, c.errorCount());
			index++;
		}

		// README this needs changing when running make
		Assert.assertEquals(7, (int) errorCount.get(0)); // TODO Error count obviously should be 0
		Assert.assertEquals(20, (int) errorCount.get(1)); // TODO Error count obviously should be 0
		Assert.assertEquals(9, (int) errorCount.get(2)); // TODO Error count obviously should be 0
	}

	@Test
	public final void testBasic_listfolders3() throws Exception {
		final String s = "test/basic/listfolders3/listfolders3.ez";

		final ErrSink     eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		c.feedCmdLine(List_of(s, "-sO"));

		if (c.errorCount() != 0)
			System.err.printf("Error count should be 0 but is %d for %s%n", c.errorCount(), s);

		final EOT_OutputTree outputTree = c.getOutputTree();
		Assert.assertEquals(12, outputTree.list.size());
		Assert.assertEquals(12, c.errorCount()); // TODO Error count obviously should be 0

		assertThat(outputTree.namelist()).containsExactly(
				"/listfolders3/Main.h"
				, "/listfolders3/Main.c"

				, "/prelude/Prelude/Integer64.h"
				, "/prelude/Prelude/Integer64.c"

				, "/listfolders3/wpkotlin_c.demo.list_folders/MainLogic.h"
				, "/listfolders3/wpkotlin_c.demo.list_folders/MainLogic.c"

				, "/listfolders3/wpkotlin_c.demo.list_folders/__MODULE__.h"
				, "/listfolders3/wpkotlin_c.demo.list_folders/__MODULE__.c"

				, "/prelude/Prelude/Boolean.h"
				, "/prelude/Prelude/Boolean.c"

				, "/prelude/Prelude/Arguments.h"
				, "/prelude/Prelude/Arguments.c"
		);
	}

	@Test
	public final void testBasic_listfolders4() {
		final String s = "test/basic/listfolders4/listfolders4.ez";

		final ErrSink     eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		c.feedCmdLine(List_of(s, "-sO"));

		if (c.errorCount() != 0)
			System.err.printf("Error count should be 0 but is %d for %s%n", c.errorCount(), s);

		Assert.assertEquals(9, c.errorCount()); // TODO Error count obviously should be 0

		final EOT_OutputTree outputTree = c.getOutputTree();
		assertThat(outputTree.namelist()).containsExactly(
				"/listfolders4/Main.h"
				, "/listfolders4/Main.c"

				, "/prelude/Prelude/Integer64.h"
				, "/prelude/Prelude/Integer64.c"

				, "/listfolders4/wpkotlin_c.demo.list_folders/MainLogic.h"
				, "/listfolders4/wpkotlin_c.demo.list_folders/MainLogic.c"

				, "/listfolders4/wpkotlin_c.demo.list_folders/__MODULE__.h"
				, "/listfolders4/wpkotlin_c.demo.list_folders/__MODULE__.c"

				, "/prelude/Prelude/Boolean.h"
				, "/prelude/Prelude/Boolean.c"

				, "/prelude/Prelude/Arguments.h"
				, "/prelude/Prelude/Arguments.c"
		);
	}

	@Test
	public final void testBasic_fact1() throws Exception {
		final String s = "test/basic/fact1/main2";

		final ErrSink     eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		c.feedCmdLine(List_of(s, "-sO"));

		if (c.errorCount() != 0)
			System.err.printf("Error count should be 0 but is %d for %s%n", c.errorCount(), s);

		final @NotNull EOT_OutputTree cot = c.getOutputTree();

		Assert.assertEquals(18, cot.list.size()); // TODO why not 6?

		assertThat(cot.namelist())
				.containsExactly(
						"/main2/Main.h"
						, "/main2/Main.c"

						, "/prelude/Prelude/Prelude.h"
						, "/prelude/Prelude/Prelude.c"

						, "/prelude/Prelude/Boolean.h"
						, "/prelude/Prelude/Boolean.c"

						, "/main2/wprust.demo.fact/fact1.h"
						, "/main2/wprust.demo.fact/fact1.c"

						, "/prelude/Prelude/Arguments.h"
						, "/prelude/Prelude/Arguments.c"

						, "/prelude/Prelude/Integer64.h"
						, "/prelude/Prelude/Integer64.c"

						, "/prelude/Prelude/Unsigned64.h"
						, "/prelude/Prelude/Unsigned64.c"

						, "/prelude/Prelude/ConstString.h"
						, "/prelude/Prelude/ConstString.c"

						, "/prelude/Prelude/IPrintable.h"
						, "/prelude/Prelude/IPrintable.c"
				);

		select(cot.list, f -> f.getFilename().equals("/main2/Main.h"))
				.then(f -> {
					final List<String> collect = ((EG_SequenceStatement) f.getStatementSequence())._list().stream().map(EG_Statement::getText).collect(Collectors.toList());
//			  System.out.println(collect);
					V.asv(V.e.TEST_TB_FACT1_168, "" + collect);
				});
		select(cot.list, f -> f.getFilename().equals("/main2/Main.c"))
				.then(f -> {
					final List<String> collect = ((EG_SequenceStatement) f.getStatementSequence())._list().stream().map(EG_Statement::getText).collect(Collectors.toList());
//			  System.out.println(collect);
					V.asv(V.e.TEST_TB_FACT1_173, "" + collect);
				});

		// TODO Error count obviously should be 0
		Assert.assertEquals(52, c.errorCount());

//		assertThat(c.errorList())
//				.containsExactly();

		// FIXME enumerate all these errors and the (123-52) diags, infos and warnings
	}
}

//
//
//
