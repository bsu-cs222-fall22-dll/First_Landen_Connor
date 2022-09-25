package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SearchRedirectionTest {
    @Test
    public void redirectionTest() throws IOException {
        SearchRedirection redirection = new SearchRedirection();
        InputStream testDataStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("zappa.json");
        JSONArray searchRedirection = JsonPath.read(testDataStream, "$..*");
        Assertions.assertEquals("You were redirected to Frank Zappa",
                redirection.checkRedirect(searchRedirection));
    }

}