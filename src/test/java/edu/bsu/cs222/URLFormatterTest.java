package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class URLFormatterTest {

    @Test
    public void TestURLConstruction() {
        String articleTitle = "Boom goes the dynamite";
        URLFormat url = new URLFormat(articleTitle);
        System.out.println("Click this link to test that it is valid: " + url.getURL());
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?&action=query&format=json&prop=revisions&titles=Boom+goes+the+dynamite&rvprop=timestamp|user&rvlimit=27&redirects=1"
                , url.getURL());
    }

    @Test
    public void TestURLConstruction_Zappa() {
        String articleTitle = "Zappa";
        URLFormat url = new URLFormat(articleTitle);
        System.out.println("Frank Zappa link: " + url.getURL());
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?&action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=27&redirects=1",
                url.getURL());
    }
}