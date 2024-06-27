package io.github.utils;

import io.github.server.HttpRequest;
import io.github.server.HttpResponse;
import io.github.server.RequestHandler;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.protocol.HttpContext;
import org.apache.hc.core5.util.TextUtils;

import java.util.*;

public class Proxy implements RequestHandler {


    public Proxy(String host){

    }

    private final static Set<String> HOP_BY_HOP = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            TextUtils.toLowerCase(HttpHeaders.HOST),
            TextUtils.toLowerCase(HttpHeaders.CONTENT_LENGTH),
            TextUtils.toLowerCase(HttpHeaders.TRANSFER_ENCODING),
            TextUtils.toLowerCase(HttpHeaders.CONNECTION),
            TextUtils.toLowerCase(HttpHeaders.KEEP_ALIVE),
            TextUtils.toLowerCase(HttpHeaders.PROXY_AUTHENTICATE),
            TextUtils.toLowerCase(HttpHeaders.TE),
            TextUtils.toLowerCase(HttpHeaders.TRAILER),
            TextUtils.toLowerCase(HttpHeaders.UPGRADE))));

    @Override
    public void apply(HttpRequest incoming, HttpResponse outgoing, HttpContext context) {
        for (final Iterator<Header> it = incoming.headerIterator(); it.hasNext(); ) {
            final Header header = it.next();
            if (!HOP_BY_HOP.contains(TextUtils.toLowerCase(header.getName()))) {
                outgoing.addHeader(header);
            }
        }
        outgoing.setEntity(incoming.getEntity());
    }
}
