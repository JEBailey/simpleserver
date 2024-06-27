package io.github;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.impl.HttpProcessors;
import org.apache.hc.core5.http.impl.bootstrap.HttpRequester;
import org.apache.hc.core5.http.impl.bootstrap.RequesterBootstrap;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.http.protocol.HttpProcessor;
import org.apache.hc.core5.net.URIAuthority;

import java.io.IOException;

public class Client {

    private HttpRequester requester;

    public Client(){
            this.requester = RequesterBootstrap.bootstrap()
                    .setHttpProcessor(HttpProcessors.client())
                    .create();
    }

    public ClassicHttpResponse execute(
            final HttpHost targetHost,
            final ClassicHttpRequest request,
            final HttpContext context) throws HttpException, IOException {
        if (request.getAuthority() == null) {
            request.setAuthority(new URIAuthority(targetHost));
        }
        request.setScheme(targetHost.getSchemeName());
        return requester.execute(targetHost, request, context);
    }

}
