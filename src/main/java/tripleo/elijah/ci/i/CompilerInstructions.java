/* -*- Mode: Java; tab-width: 4; indent-tabs-mode: t; c-basic-offset: 4 -*- */
/*
 * Elijjah compiler,copyright Tripleo<oluoluolu+elijah@gmail.com>
 *
 * The contents of this library are released under the LGPL licence v3,
 * the GNU Lesser General Public License text was downloaded from
 * http://www.gnu.org/licenses/lgpl.html from `Version 3, 29 June 2007'
 */
package tripleo.elijah.ci.i;

import tripleo.elijah.ci.CiIndexingStatement;
import tripleo.elijah.ci.GenerateStatement;
import tripleo.elijah.ci.LibraryStatementPart;
import tripleo.elijah.xlang.LocatableString;
import tripleo.elijah.compiler_model.CM_Filename;

import java.util.List;
import java.util.Optional;

public interface CompilerInstructions {
	void add(GenerateStatement generateStatement);

	void add(LibraryStatementPart libraryStatementPart);

	List<LibraryStatementPart> getLibraryStatementParts();

	Optional<String> genLang();  // not a promise? Calculated? C<O<S>>>??

	CM_Filename getFilename();

	void setFilename(CM_Filename filename);

	String getName();

	LocatableString getLocatableName();

	CiIndexingStatement indexingStatement();

	void setName(LocatableString name);

	interface CompilerInstructionsBuilder {
		CompilerInstructions build();

		void add(GenerateStatement generateStatement);

		void add(LibraryStatementPart libraryStatementPart);

		void setGenLang(String aGenLangString);  // ??

		void setFilename(CM_Filename filename);

		CiIndexingStatement createIndexingStatement();

		void setName(LocatableString name);
	}
}
