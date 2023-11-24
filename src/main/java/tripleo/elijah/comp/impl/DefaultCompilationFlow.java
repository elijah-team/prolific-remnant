package tripleo.elijah.comp.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultCompilationFlow implements CompilationFlow {
	private final List<CompilationFlowMember> flows = new ArrayList<>();

	@Override
	public void add(final CompilationFlowMember aFlowMember) {
		flows.add(aFlowMember);
	}

	@Override
	public void run(final CompilationImpl aCompilation) {
		for (CompilationFlowMember flow : flows) {
			flow.doIt(aCompilation, this);
		}
	}
}
