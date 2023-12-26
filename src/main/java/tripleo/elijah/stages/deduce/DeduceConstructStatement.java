/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.deduce;

import org.jetbrains.annotations.*;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.gen_fn.*;
import tripleo.elijah.stages.instructions.*;

import java.util.*;

/**
 * Created 12/11/21 9:27 PM
 */
public class DeduceConstructStatement implements DeduceElement {
	private final BaseEvaFunction     generatedFunction;
	private final ConstructStatement        constructStatement;
	public        boolean                   toEvaluateTarget;
	public        InstructionArgument       target;
	public        List<InstructionArgument> args;
	public        ProcIA                    call;

	public DeduceConstructStatement(final @NotNull BaseEvaFunction aEvaFunction, final ConstructStatement aConstructStatement) {
		generatedFunction  = aEvaFunction;
		constructStatement = aConstructStatement;
	}

	@Override
	public OS_Element element() {
		return constructStatement;
	}

	@Override
	public DeclAnchor declAnchor() {
		// TODO should this be the VariableStatement used to declare the type?
		return null;
	}
}

//
// vim:set shiftwidth=4 softtabstop=0 noexpandtab:
//
