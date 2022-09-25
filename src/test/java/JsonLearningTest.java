import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class JsonLearningTest {

    @Test
    public void readFirstRevisionAuthor_test() throws IOException, ParseException {
        InputStream jsonInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test_article.json");
        JSONArray jsonDataArray = JsonPath.read(jsonInputStream, "$.query.pages..revisions..user");
        Assertions.assertEquals("Surachit", jsonDataArray.get(0).toString());
        System.out.println(jsonDataArray.get(0).toString());
    }
}
