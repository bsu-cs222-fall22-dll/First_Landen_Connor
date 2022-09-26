package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
//Based on Code by Professor Gestwicki
public class WikipediaRevisionReaderTest {
    @Test
    public void testReader() throws IOException {
        WikipediaRevisionReader reader = new WikipediaRevisionReader();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("Zappa.json");
        String timestamp= reader.read();
        Assertions.assertEquals("2022-09-19T02:18:18Z", timestamp);
    }
}
