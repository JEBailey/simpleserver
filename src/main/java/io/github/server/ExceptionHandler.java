package io.github.server;


import org.apache.hc.core5.http.ConnectionClosedException;
import org.apache.hc.core5.http.ExceptionListener;
import org.apache.hc.core5.http.HttpConnection;

import java.net.SocketException;
import java.net.SocketTimeoutException;

public class ExceptionHandler implements ExceptionListener {
    @Override
    public void onError(final Exception ex) {
        if (ex instanceof SocketException) {
            System.out.println("[client->server] " + Thread.currentThread() + " " + ex.getMessage());
        } else {
            System.out.println("[client->server] " + Thread.currentThread() + " " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void onError(final HttpConnection connection, final Exception ex) {
        if (ex instanceof SocketTimeoutException) {
            System.out.println("[client->server] " + Thread.currentThread() + " time out");
        } else if (ex instanceof SocketException || ex instanceof ConnectionClosedException) {
            System.out.println("[client->server] " + Thread.currentThread() + " " + ex.getMessage());
        } else {
            System.out.println("[client->server] " + Thread.currentThread() + " " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
    }
}
