package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;

public class RevisionTest {
    private Object WikipediaRevision;

    public void Revision() throws IOException {
        WikipediaRevision revision = new WikipediaRevision();
        InputStream testUsername = Thread.currentThread().getContextClassLoader().getResourceAsStream("zappa.json");
        JSONArray Revision = JsonPath.read(testUsername, "$..*");
        Assertions.assertEquals("", revision.checkRevision);
    }
}