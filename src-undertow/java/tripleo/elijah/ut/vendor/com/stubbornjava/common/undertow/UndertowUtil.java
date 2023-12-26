package tripleo.elijah.ut.vendor.com.stubbornjava.common.undertow;

import io.undertow.*;
import io.undertow.Undertow.*;
import io.undertow.server.*;
import org.slf4j.*;

import java.net.*;
import java.util.function.*;

public class UndertowUtil {
	private static final Logger logger = LoggerFactory.getLogger(UndertowUtil.class);

	/**
	 * This is currently intended to be used in unit tests but may
	 * be appropriate in other situations as well. It's not worth building
	 * out a test module at this time so it lives here.
	 * <p>
	 * This helper will spin up the http handler on a random available port.
	 * The full host and port will be passed to the hostConsumer and the server
	 * will be shut down after the consumer completes.
	 *
	 * @param builder
	 * @param handler
	 * @param hostConusmer
	 */
	public static void useLocalServer(Undertow.Builder builder,
	                                  HttpHandler handler,
	                                  Consumer<String> hostConusmer) {
		Undertow undertow = null;
		try {
			// Starts server on a random open port
			undertow = builder.addHttpListener(0, "127.0.0.1", handler).build();
			undertow.start();
			ListenerInfo      listenerInfo = undertow.getListenerInfo().get(0);
			InetSocketAddress addr         = (InetSocketAddress) listenerInfo.getAddress();
			String            host         = "http://localhost:" + addr.getPort();
			hostConusmer.accept(host);
		} finally {
			if (undertow != null) {
				undertow.stop();
			}
		}
	}
}
