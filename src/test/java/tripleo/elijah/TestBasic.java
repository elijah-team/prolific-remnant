/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah;

import com.google.common.base.*;
import com.google.common.io.*;
import org.jdeferred2.*;
import org.jdeferred2.impl.*;
import org.jetbrains.annotations.*;
import org.junit.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah.nextgen.outputstatement.*;
import tripleo.elijah.nextgen.outputtree.*;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

import static tripleo.elijah.util.Helpers.*;

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

		Assert.assertEquals(12, c.getOutputTree().list.size());
		Assert.assertEquals(24, c.errorCount()); // TODO Error count obviously should be 0
	}

	@Test
	public final void testBasic_listfolders4() {
		final String s = "test/basic/listfolders4/listfolders4.ez";

		final ErrSink     eee = new StdErrSink();
		final Compilation c   = new CompilationImpl(eee, new IO());

		c.feedCmdLine(List_of(s, "-sO"));

		if (c.errorCount() != 0)
			System.err.printf("Error count should be 0 but is %d for %s%n", c.errorCount(), s);

		Assert.assertEquals(22, c.errorCount()); // TODO Error count obviously should be 0
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

		select(cot.list, f -> f.getFilename().equals("/main2/Main.h"))
		  .then(f -> {
			  System.out.println(((EG_SequenceStatement) f.getStatementSequence())._list().stream().map(EG_Statement::getText).collect(Collectors.toList()));
		  });
		select(cot.list, f -> f.getFilename().equals("/main2/Main.c"))
		  .then(f -> {
			  System.out.println(((EG_SequenceStatement) f.getStatementSequence())._list().stream().map(EG_Statement::getText).collect(Collectors.toList()));
		  });

		// TODO Error count obviously should be 0
		Assert.assertEquals(123, c.errorCount()); // FIXME why 123?? 04/15
	}
}

//
//
//
