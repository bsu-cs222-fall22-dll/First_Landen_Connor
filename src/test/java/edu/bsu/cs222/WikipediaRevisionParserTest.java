package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class WikipediaRevisionParserTest {
    @Test
    public void testParse(){
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Zappa.json");
        String timestamp= parser.parse(testDataStream);
        Assertions.assertEquals("2022-09-17T05:54:56Z", timestamp);
    }
}
