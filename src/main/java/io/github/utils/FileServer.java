package io.github.utils;

import io.github.server.HttpRequest;
import io.github.server.HttpResponse;
import io.github.server.RequestHandler;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.IOException;

public class FileServer implements RequestHandler {



    @Override
    public void apply(HttpRequest incoming, HttpResponse outgoing, HttpContext context) throws HttpException, IOException {

    }
}
