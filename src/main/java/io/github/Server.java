package io.github;


import io.github.server.RequestBuilder;
import io.github.server.RequestValidator;


/**
 * Unit test for simple App.
 */
public class Server {

    private static SimpleServer simpleServer;

    public static void main(String[] args) {
        simpleServer = SimpleServer.builder()
                .port(8080)
                .handle(SimpleServer.post("/this/is/the/way")
                      .with(RequestValidator.header("foo","bar"))
                      .with(RequestBuilder.contentType("application/json"))
                        .returns(() -> "This is the way"))
                .build();
        simpleServer.start();
    }

}
