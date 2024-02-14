/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.junit.*;
import tripleo.elijah.comp.*;
import tripleo.elijah.comp.internal.*;
import tripleo.elijah_prolific.v.V;

import static com.google.common.truth.Truth.assertThat;
import static tripleo.elijah.util.Helpers.*;

/**
 * Created 9/9/21 4:16 AM
 */
public class Feb2021 {

	@Test
	public void testProperty() throws Exception {
		final Compilation c = new CompilationImpl(new StdErrSink(), new IO());

		c.feedCmdLine(List_of("test/feb2021/property/"));

		assertThat(c.getOutputTree().namelist()).containsExactly(
				 "/prelude/Prelude/ConstString.h"
		, "/property/Pr.c"
		, "/prelude/Prelude/IPrintable.c"
		, "/property/Pr.h"
		, "/prelude/Prelude/Prelude.c"
		, "/property/Main.c"
		, "/property/Foo.h"
		, "/prelude/Prelude/Prelude.h"
		, "/property/Main.h"
		, "/prelude/Prelude/ConstString.c"
		, "/property/Foo.c"
		, "/prelude/Prelude/IPrintable.h"
		);
	}

	@Test
	public void testFunction() throws Exception {
		final Compilation c = new CompilationImpl(new StdErrSink(), new IO());

		c.feedCmdLine(List_of("test/feb2021/function/"));

		assertThat(c.getOutputTree().namelist()).containsExactly(
				 "/function/Main.c"
				, "/fun/Main.h"
		);
	}

	@Test
	public void testHier() throws Exception {
		final Compilation c = new CompilationImpl(new StdErrSink(), new IO());

		c.feedCmdLine(List_of("test/feb2021/hier/"));
	}

}

//
//
//
