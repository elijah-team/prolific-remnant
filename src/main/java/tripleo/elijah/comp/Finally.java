package tripleo.elijah.comp;

import org.jetbrains.annotations.*;
import tripleo.elijah.nextgen.outputtree.*;

import java.util.*;

public class Finally {
	private final Set<Outs>    outputOffs = new HashSet<>();
	private final List<Input>  inputs  = new ArrayList<>();
	private final List<Output> outputs = new ArrayList<>();
	private       boolean      turnAllOutputOff;

	public void turnOutputOff(final Outs aOut) {
		outputOffs.add(aOut);
	}

	public boolean outputOn(final Outs aOuts) {
		return !turnAllOutputOff && !outputOffs.contains(aOuts);
	}

	public void addInput(final Nameable aNameable, final Out2 ty) {
		inputs.add(new Input(aNameable, ty));
	}

//	public void addInput(final CompilerInput aInp, final Out2 ty) {
//		inputs.add(new Input(aInp, ty));
//	}

	public boolean containsInput(final String aS) {
		return inputs.stream().anyMatch(i -> i.name().equals(aS));
	}

	public void turnAllOutputOff() {
		turnAllOutputOff = true;
	}

//	public void addInput(final CompFactory.InputRequest aInp, final Out2 ty) {
//		inputs.add(new Input(aInp, ty));
//	}

	public boolean containsCodeOutput(@NotNull final String s) {
		return outputs.stream().anyMatch(i -> i.name().equals(s));
	}

	public void addCodeOutput(final EOT_OutputFile.FileNameProvider aFileNameProvider, final EOT_OutputFile aOff) {
		outputs.add(new Output(aFileNameProvider, aOff));
	}

	public enum Outs {Out_6262, Out_727, Out_350, Out_364, Out_252, Out_2121, Out_486, Out_5757, Out_1069, Out_141, Out_EVTE_159, Out_401b}

	public enum Out2 {
		EZ, ELIJAH
	}

	interface Nameable {
		String getName();
	}

	public class Input {

		private final Nameable nameable;
		private final Out2 ty;

		public Input(final Nameable aNameable, final Out2 aTy) {
			nameable = aNameable;
			ty       = aTy;
		}

		public Input(final CompilerInput aInp, final Out2 aTy) {
			nameable = new Nameable() {
				@Override
				public String getName() {
					return aInp.getInp();
				}
			};
			ty  = aTy;
		}

		public Input(final CompFactory.InputRequest aInp, final Out2 aTy) {
			nameable = new Nameable() {
				@Override
				public String getName() {
					return aInp.file().toString();
				}
			};
			ty = aTy;
		}

		@Override
		public String toString() {
			return "Input{" +
			  "name=" + nameable.getName() +
			  ", ty=" + ty +
			  '}';
		}

		public String name() {
			return nameable.getName();
		}
	}

	class Output {
		private final EOT_OutputFile.FileNameProvider fileNameProvider;
		private final EOT_OutputFile off;

		public Output(final EOT_OutputFile.FileNameProvider aFileNameProvider, final EOT_OutputFile aOff) {
			fileNameProvider = aFileNameProvider;
			off              = aOff;
		}

		public String name() {
			return fileNameProvider.getFilename();
		}
	}
}
