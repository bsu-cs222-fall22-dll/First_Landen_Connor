package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
//Based on Code by Professor Gestwicki
public class WikipediaRevisionParserTest {
    @Test
    public void testParse() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Zappa.json");
        String timestamp= parser.parse(testDataStream);
        Assertions.assertEquals("2022-09-19T02:18:18Z", timestamp);
    }
}
