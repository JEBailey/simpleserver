package io.github.server;

import org.apache.hc.core5.http.HttpConnection;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.impl.Http1StreamListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingStreamListener implements Http1StreamListener {

    protected static final Logger logger = LogManager.getLogger();

    @Override
    public void onRequestHead(final HttpConnection connection, final HttpRequest request) {
        logger.atTrace().log("[client->server] {} {} {}", Thread.currentThread(), request.getMethod(), request.getRequestUri());
    }

    @Override
    public void onResponseHead(final HttpConnection connection, final HttpResponse response) {
        logger.atTrace().log("[client<-server] {} status {}", Thread.currentThread(), response.getCode());
    }

    @Override
    public void onExchangeComplete(final HttpConnection connection, final boolean keepAlive) {
        logger.atTrace().log("[client<-server] {} request completed connection {}", Thread.currentThread(), (keepAlive ? "kept alive" : "cannot be kept alive"));
    }
}
