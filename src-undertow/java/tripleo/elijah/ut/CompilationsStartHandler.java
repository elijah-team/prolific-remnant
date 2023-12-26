//package tripleo.elijah.ut;
//
//import com.google.common.base.*;
//import io.undertow.server.*;
//import io.undertow.util.*;
//import tripleo.elijah.comp.*;
//import tripleo.elijah.comp.i.*;
//import tripleo.elijah.comp.i.Compilation;
//import tripleo.elijah.comp.i.CompilerController;
//import tripleo.elijah.factory.comp.*;
//
//import java.io.*;
//import java.nio.file.*;
//import java.util.*;
//import java.util.stream.*;
//
//import static tripleo.elijah.util.Helpers.*;
//
//public class CompilationsStartHandler implements HttpHandler {
//
//	//	private final Map<Integer, Compilation> cs = new HashMap<>();
//
//
//	private final UT_Root            utr;
//	private CompilerController utc = null;
//
//	public CompilationsStartHandler(final UT_Root aUtr) {
//		utr = aUtr;
//	}
//
//	public static List<Path> listFiles(final Path path) throws IOException {
//		final List<Path> result;
//		try (final Stream<Path> walk = Files.walk(path)) {
//			result = walk.filter(Files::isRegularFile)
//			             .filter(x -> x.toFile().getName().endsWith(".ez"))
//			             .collect(Collectors.toList());
//		}
//		return result;
//	}
//
//	@Override
//	public void handleRequest(final HttpServerExchange exchange) throws Exception {
//		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/html");
//
//		final StringBuilder sb    = new StringBuilder();
//		final int           num   = Integer.parseInt(exchange.getRequestPath().substring(7)) - 1;
//		final List<Path>    paths = utr.paths;
//		final Path          p     = paths.get(num);
//		final Compilation c     = CompilationFactory.mkCompilation(new StdErrSink(), new IO());
//
//		if (utc == null) {
//			Preconditions.checkNotNull(utr);
//
//			utc = new UT_Controller(utr);
//		}
//
//		c.feedCmdLine(List_of(p.toString()), utc);
//
//		final UT_CompilationBus          cb = getController().cb();
//		final CB_Process l  = cb.getLast();
//
//		sb.append("<html><body>\n");
//
////		sb.append("<h3>"+l.name()+"</h3>\n");
//
//		final List<CB_Action> actions = getController().actions();
//
//		for (final CB_Action step : l.steps()) {
//			final String f = "" + new Random().nextInt();
//			sb.append("<a href=\"/do/" + f + "\">" + step.name() + "</a><br>");
//
//			utr.dcs(f, step);
//		}
//
//		sb.append("</body></html>\n");
//
//		exchange.getResponseSender().send(sb.toString());
//	}
//
//	private UT_Controller getController() {
//		return (UT_Controller) utc;
//	}
//}
