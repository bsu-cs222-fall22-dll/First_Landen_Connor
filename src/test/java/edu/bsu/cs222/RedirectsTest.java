package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RedirectsTest {
    @Test
    public void redirectionTest() throws IOException {
        Redirects redirection = new Redirects();
        InputStream testDataStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("zappa.json");
        JSONArray Ridirect = JsonPath.read(testDataStream, "$..*");
        Assertions.assertEquals("",
                redirection.checkRedirect(redirection));
    }
}