package tripleo.elijah.ut.vendor.com.stubbornjava.undertow.handlers;

import io.undertow.server.*;
import io.undertow.server.handlers.*;

// {{start:handler}}
public class XContentTypeOptionsHandler {
	private static final String X_CONTENT_TYPE_OPTIONS_STRING = "X-Content-Type-Options";

	public static HttpHandler nosniff(HttpHandler next) {
		return new SetHeaderHandler(next, X_CONTENT_TYPE_OPTIONS_STRING, "nosniff");
	}
}
// {{end:handler}}
