import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RevisionParserTest {

    @Test
    public void testFirstRevision() throws IOException {
        InputStream jsonData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test_article.json");
        RevisionParser parser = new RevisionParser(jsonData);
        Revision revision = parser.parse().get(0);
        Assertions.assertEquals("Surachit", revision.getUser());
        Assertions.assertEquals("2022-09-15T20:14:46Z", revision.getTimestamp());
    }

    @Test
    public void testLastRevision() throws IOException {
        InputStream jsonData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test_article.json");
        RevisionParser parser = new RevisionParser(jsonData);
        List<Revision> revisionList = parser.parse();
        Revision lastRevision = revisionList.get(revisionList.size()-1);
        Assertions.assertEquals("Monkbot", lastRevision.getUser());
        Assertions.assertEquals("2020-12-13T00:44:13Z", lastRevision.getTimestamp());
    }

    @Test
    public void testRevisionsList() throws IOException {
        InputStream jsonData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test_article.json");
        RevisionParser parser = new RevisionParser(jsonData);
        List<Revision> revisionList = parser.parse();
        System.out.println(revisionList);
    }
}

