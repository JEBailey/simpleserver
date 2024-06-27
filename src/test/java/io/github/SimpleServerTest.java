package io.github;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.github.SimpleServer.post;
import static io.github.server.RequestBuilder.contentType;
import static io.github.server.RequestValidator.header;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class SimpleServerTest {

    private static SimpleServer simpleServer;

    @BeforeAll
    public static void beforeAll() throws IOException, InterruptedException {
        simpleServer = SimpleServer.builder()
                .port(8080)
                .handle(post("/this/is/the/way")
                        .with(header("foo","bar"))
                        .with(contentType("application/json"))
                        .returns(() -> "This is the way"))
                .build();
        simpleServer.start();
    }

    @Test
    public void testInitiateRequest() {
        assertTrue(true);
    }

    @AfterAll
    public static void afterAll(){
        simpleServer.close();
    }

    public boolean request(String path, P )

}
