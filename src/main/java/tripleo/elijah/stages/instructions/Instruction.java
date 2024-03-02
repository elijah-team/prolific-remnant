/*
 * Elijjah compiler, copyright Tripleo <oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 *
 */
package tripleo.elijah.stages.instructions;

import tripleo.elijah.util.Eventual;
import tripleo.elijah._ElTaggableMixin;
import tripleo.elijah.comp.diagnostic.ExceptionDiagnostic;
import tripleo.elijah.lang.*;
import tripleo.elijah.stages.deduce.*;

import java.util.*;

/**
 * Created 9/10/20 3:16 PM
 */
public class Instruction extends _ElTaggableMixin {
	public  DeduceElement   deduceElement;
	List<InstructionArgument> args;
	private InstructionName name;
	private int             index = -1;
	private Context context;

	public void setArgs(final List<InstructionArgument> args_) {
		args = args_;
	}

	public InstructionName getName() {
		return name;
	}

	public void setName(final InstructionName aName) {
		name = aName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(final int l) {
		index = l;
	}

	@Override
	public String toString() {
		return "Instruction{" +
		  "name=" + name +
		  ", index=" + index +
		  ", args=" + args +
		  '}';
	}

	public InstructionArgument getArg(final int i) {
		return args.get(i);
	}

	public Context getContext() {
		return context;
	}

	public void setContext(final Context context) {
		this.context = context;
	}

	public int getArgsSize() {
		return args.size();
	}

	public Eventual<InstructionArgument> getArg2(int i) {
		Eventual<InstructionArgument> e = new Eventual<>();
		try {
			Objects.checkIndex(i, args.size()); // kinda lazy, but by spec (aka source aka lucky its not illegal)
			e.resolve(args.get(i));
		} catch (IndexOutOfBoundsException ex) {
			e.fail(new ExceptionDiagnostic(ex));
		}
		return e;
	}

//	public List<InstructionArgument> getArgs() {
//		return args;
//	}
}

//
//
//
