package tripleo.elijah_prolific.v;

import tripleo.elijah_prolific_durable.stages.gen_generic.*;

import java.io.PrintStream;

public class V {
	public static void asv(final e aE, final String aKey) {
		switch (aE) {
		case TEST_TB_FACT1_168, TEST_TB_FACT1_173 -> {
			return;
		}
		default -> {
			System.err.println("{{V.asv}} " + aE + " " + aKey);
		}
		}
	}

	public static void gri(final GenerateResult gr) {
		final PrintStream stream = System.out;

		for (GenerateResultItem ab : gr.results()) {
//			stream.println(ab.counter);
			final String ty = "" + ab.ty;
//			stream.println(ty);
			final String ou = "" + ab.output;
//			stream.println(ou);
			final String ns = "" + ab.node.identityString();
//			stream.println(ns);
			final String bt = "" + ab.buffer.getText();
//			stream.println(bt);
			System.err.println("{{V.gr}} " + ty + " " + ou + " " + ns);
		}
	}

	public static void exit() {
		System.err.println("{{V.exit}}");
	}

	public enum e {f202_writing_logs, _putSeq, DT2_1785, d399_147, TEST_TB_FACT1_168, TEST_TB_FACT1_173, CB_INST_CI, USE_MOD_ABSOLUTE_PATH, DT2_2304}
}
