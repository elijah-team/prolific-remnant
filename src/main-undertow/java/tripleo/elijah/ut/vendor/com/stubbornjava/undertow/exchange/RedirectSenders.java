package tripleo.elijah.ut.vendor.com.stubbornjava.undertow.exchange;

import io.undertow.server.*;
import io.undertow.util.*;

public interface RedirectSenders {

	// {{start:temporary}}
	default void temporary(HttpServerExchange exchange, String location) {
		exchange.setStatusCode(StatusCodes.FOUND);
		exchange.getResponseHeaders().put(Headers.LOCATION, location);
		exchange.endExchange();
	}
	// {{end:temporary}}

	// {{start:permanent}}
	default void permanent(HttpServerExchange exchange, String location) {
		exchange.setStatusCode(StatusCodes.MOVED_PERMANENTLY);
		exchange.getResponseHeaders().put(Headers.LOCATION, location);
		exchange.endExchange();
	}
	// {{end:permanent}}

	// {{start:referer}}
	default void referer(HttpServerExchange exchange) {
		exchange.setStatusCode(StatusCodes.FOUND);
		exchange.getResponseHeaders().put(Headers.LOCATION, exchange.getRequestHeaders().get(Headers.REFERER, 0));
		exchange.endExchange();
	}
	// {{end:referer}}
}
