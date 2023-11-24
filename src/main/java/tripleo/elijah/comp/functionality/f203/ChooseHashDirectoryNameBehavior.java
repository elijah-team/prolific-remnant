package tripleo.elijah.comp.functionality.f203;

import org.apache.commons.codec.digest.*;
import org.jetbrains.annotations.*;
import tripleo.elijah.comp.*;import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;
import tripleo.elijah.comp.*;import tripleo.elijah.lang.*;import tripleo.elijah.comp.i.*;
import tripleo.elijah.lang.i.*;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.stream.*;

import static org.apache.commons.codec.digest.MessageDigestAlgorithms.*;

public class ChooseHashDirectoryNameBehavior implements ChooseDirectoryNameBehavior {
	private final Compilation   c;
	private final LocalDateTime localDateTime;

	@Contract(pure = true)
	public ChooseHashDirectoryNameBehavior(final Compilation aC, final LocalDateTime aLocalDateTime) {
		c             = aC;
		localDateTime = aLocalDateTime;
	}

	@Override
	public File chooseDirectory() {
		return choose_dir_name();
	}

	private @NotNull File choose_dir_name() {
		final List<File> recordedreads = c.getIO().recordedreads;
		final List<String> recordedread_filenames = recordedreads.stream()
		                                                         .map(File::toString)
		                                                         .collect(Collectors.toList());

//		for (final File file : recordedreads) {
//			final String fn = file.toString();
//
//			append_hash(buf, fn, c.getErrSink());
//		}

		// TODO can't use stream because of exception
//		recordedread_filenames
//				.forEach(fn -> append_hash(buf, fn, c.getErrSink()));

		final DigestUtils digestUtils = new DigestUtils(SHA_256);

		final StringBuilder sb1 = new StringBuilder();

//		Map<String, Integer> unSortedMap = getUnSortedMap();
//		// LinkedHashMap preserves the ordering of elements in which they are inserted
//
//		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//		unSortedMap.entrySet()
//				.stream()
//				.sorted(Map.Entry.comparingByKey())
//				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

		recordedread_filenames
		  .stream()
		  .sorted().map(digestUtils::digestAsHex)
		  .forEach(sha256 -> sb1.append(sha256));

//		final byte[] c_name0 = digestUtils.digest(sb1.toString());
//		final String c_name = Base36.toBase36(c_name0);
		final String c_name = digestUtils.digestAsHex(sb1.toString());

		//
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");

		final String date = formatter.format(localDateTime); //15-02-2022 12:43

		final File fn00 = new File("COMP", c_name);
		final File fn0  = new File(fn00, date);
		fn0.mkdirs();

		final String fn1 = new File(fn0, "inputs.txt").toString();
//		final String fn1 = new File(file_prefix, "inputs.txt").toString();
		return fn0;
	}
}
