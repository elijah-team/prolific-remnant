package tripleo.elijah.lang.nextgen.names.impl;

import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.stages.deduce.post_bytecode.DeduceElement3_IdentTableEntry;

public record EN_NameUsage(
		EN_Name theName,
		DeduceElement3_IdentTableEntry deduceElement3_identTableEntry
) implements EN_Usage {
}
