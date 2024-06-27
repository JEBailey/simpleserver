package io.github.server.filter;

import io.github.server.HttpRequest;
import io.github.server.HttpResponse;
import org.apache.hc.core5.http.protocol.HttpContext;

public interface FilterChain {

    void doFilter(HttpRequest request, HttpResponse response, HttpContext context);

}
