package tripleo.elijah.stages.deduce.tastic;

import tripleo.elijah.comp.i.ErrSink;
import tripleo.elijah.stages.logging.ElLog;

/**
 * Purpose: A "closure" for these three<br><br>
 * a la CompilerEnclosure or maybe Rosetta.something<br>
 *
 * @param LOG
 * @param errSink
 * @param central
 */
public record DT_Env(ElLog LOG, ErrSink errSink, DeduceCentral central) { }
