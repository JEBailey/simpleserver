package io.github.server;

import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpException;
import org.apache.hc.core5.http.io.entity.FileEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.protocol.HttpContext;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public interface RequestHandler {

    void apply(HttpRequest incoming, HttpResponse outgoing, HttpContext context) throws HttpException, IOException;

    static RequestHandler withSupplier(Supplier<Object> supplier) {
        return (incoming, outgoing, context) -> {
            Object response = supplier.get();
            HttpEntity entity = switch (response){
                case String string -> new StringEntity(string);
                case HttpEntity he -> he;
                case File f ->  new FileEntity(f, ContentType.APPLICATION_OCTET_STREAM);
                default ->  new StringEntity("foo");
            };
            outgoing.setCode(200);
            outgoing.setEntity(entity);
        };
    }


}
