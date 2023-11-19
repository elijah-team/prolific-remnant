package tripleo.elijah.ut.vendor.com.stubbornjava.examples.undertow.routing;

import io.undertow.server.*;
import io.undertow.util.*;

// {{start:handler}}
public class ConstantStringHandler implements HttpHandler {
	private final String value;

	public ConstantStringHandler(String value) {
		this.value = value;
	}

	@Override
	public void handleRequest(HttpServerExchange exchange) throws Exception {
		exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
		exchange.getResponseSender().send(value + "\n");
	}

}
// {{end:handler}}
