package io.github;

import io.github.server.ExceptionHandler;
import io.github.server.RequestBuilder;
import io.github.server.LoggingStreamListener;
import io.github.server.PrimaryRequestHandller;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.impl.bootstrap.HttpServer;
import org.apache.hc.core5.http.impl.bootstrap.ServerBootstrap;
import org.apache.hc.core5.io.CloseMode;
import org.apache.hc.core5.util.TimeValue;

import java.io.IOException;
import java.util.*;

/**
 */
public class SimpleServer {

    private final int port;
    private final ServerBootstrap bootstrap;
    private final PrimaryRequestHandller primaryRequestHandller;
    private HttpServer server;

    private SimpleServer(int port) {
        this.port = port;
        this.primaryRequestHandller = new PrimaryRequestHandller();
        bootstrap = ServerBootstrap.bootstrap()
                .setListenerPort(port)
                .setStreamListener(new LoggingStreamListener())
                .setExceptionListener(new ExceptionHandler())
                .register("*", primaryRequestHandller);
    }

    /**
     *
     */
    public void start()  {
        server = bootstrap.create();

            try {
                server.start();
                Runtime.getRuntime().addShutdownHook(new Thread(() -> server.close(CloseMode.GRACEFUL)));
                server.awaitTermination(TimeValue.MAX_VALUE);
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }



        System.out.println("Listening on port " + port);

    }

    public void addRequestHandler(RequestBuilder requestHandler) {

        primaryRequestHandller.addHandler(requestHandler.path,requestHandler);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static RequestBuilder post(String path) {
        return new RequestBuilder(Method.POST,path);
    }

    public static RequestBuilder get(String path) {
        return new RequestBuilder(Method.GET,path);
    }

    public static RequestBuilder put(String path) {
        return new RequestBuilder(Method.PUT,path);
    }

    public static RequestBuilder request(Method method, String path) {
        return new RequestBuilder(method,path);
    }

    public void close() {
          server.close(CloseMode.GRACEFUL);
    }


    public static class Builder {

        int port;

        final List<RequestBuilder> handlers = new ArrayList<>();

        public Builder port(int port) {
            this.port = port;
            return this;
        }

        public Builder handle(RequestBuilder request) {
            handlers.add(request);
            return this;
        }

        public SimpleServer build() {
            SimpleServer simpleServer = new SimpleServer(port);
            handlers.forEach(simpleServer::addRequestHandler);
            return simpleServer;
        }
    }
}