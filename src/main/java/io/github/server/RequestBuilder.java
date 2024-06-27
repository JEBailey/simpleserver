package io.github.server;

import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.Method;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.IOException;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RequestBuilder implements RequestHandler {

    private final Method method;
    public final String path;
    BiPredicate<HttpRequest,HttpContext> validator;
    RequestHandler requestHandler;

    public RequestBuilder(Method method, String path) {
        this.validator = (request, context) -> method.isSame(request.getMethod());
        this.path = path;
        this.method = method;
    }

    public RequestBuilder with(RequestValidator predicate) {
        this.validator = this.validator.and(predicate);
        return this;
    }

    public RequestBuilder with(Predicate<HttpRequest> predicate) {
        this.validator = this.validator.and((request, context) -> predicate.test(request));
        return this;
    }

    public static RequestValidator contentType(String value){
        return (request,context) ->{
            var headValue = request.getFirstHeader(HttpHeaders.CONTENT_TYPE);
            return headValue != null && headValue.getValue().equals(value);
        };
    }

    public RequestBuilder returns(Supplier<Object> supplier) {
        this.requestHandler = RequestHandler.withSupplier(supplier);
        return this;
    }

    public RequestBuilder returns(RequestHandler handler) {
        this.requestHandler = handler;
        return this;
    }

    public boolean isValid(HttpRequest handler, HttpContext context) {
        return validator.test(handler, context);
    }

    @Override
    public void apply(HttpRequest incoming, HttpResponse outgoing, HttpContext context) throws HttpException, IOException {
        requestHandler.apply(incoming, outgoing, context);
    }
}
