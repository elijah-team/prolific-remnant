/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tripleo.elijah.nextgen.outputtree;

import tripleo.elijah.nextgen.outputstatement.*;
import tripleo.elijah_prolific.v.V;

import java.nio.file.*;
import java.util.*;

/**
 * @author olu
 */
public class EOT_OutputTree {
	public List<EOT_OutputFile> list;

	public void set(final List<EOT_OutputFile> aLeof) {
		list = aLeof;
	}

	public void _putSeq(final String aKey, final Path aPath, final EG_Statement aStatement) {
//		System.err.printf("[_putSeq] %s %s {{%s}}%n", aKey, aPath, aStatement.getExplanation().getText());
		V.asv(V.e._putSeq, aKey);
	}
}
