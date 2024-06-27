package io.github.server;

import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.util.function.BiPredicate;

@FunctionalInterface
public interface RequestValidator extends BiPredicate<HttpRequest,HttpContext> {

    static RequestValidator contentType(String value){
        return (request,context) ->{
            var headValue = request.getFirstHeader(HttpHeaders.CONTENT_TYPE);
            return headValue != null && headValue.getValue().equals(value);
        };
    }

    static RequestValidator header(String header,String value){
        return (request,context) ->{
            var headValue = request.getFirstHeader(header);
            return headValue != null && headValue.getValue().equals(value);
        };
    }

}
