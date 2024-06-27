package io.github.server;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.HttpRequestHandler;
import org.apache.hc.core5.http.protocol.*;

import java.io.IOException;

public class PrimaryRequestHandller implements HttpRequestHandler {

    public final LookupRegistry<RequestBuilder> handlers = new UriPatternMatcher<>();

    public void addHandler(String path, RequestBuilder handler) {
        handlers.register(path,handler);
    }

    @Override
    public void handle(ClassicHttpRequest classicHttpRequest, ClassicHttpResponse classicHttpResponse, HttpContext httpContext) throws HttpException, IOException {
        var builder = handlers.lookup(classicHttpRequest.getPath());
        if (builder != null) {
            HttpRequest request = new HttpRequestWrapper(classicHttpRequest);
            HttpResponse response = new HttpResponseWrapper(classicHttpResponse);

            if (builder.isValid(request,httpContext)){
                builder.apply(request,response,httpContext);
            }
        }
    }
}
