package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.net.URLConnection;

public class WikipediaRevisionReader {
    public static void main (String[]args){
        WikipediaRevisionReader revisionReader = new WikipediaRevisionReader();
        Scanner scanner= new Scanner(System.in);
        String line = scanner.nextLine();
        String timestamp = revisionReader.getLatestRevisionOf(line);
        System.out.println(timestamp);
    }

    public String getLatestRevisionOf(String line) {
        String urlString= String.format("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=%s&rvprop=timestamp&rvlimit=1"),
        articleTitle;
        String encodedUrlString = URLEncoder.encode(urlString, Charset.defaultCharset());
        try{
            URL url = new URL(encodedUrlString);
            URLConnection URLConnection = url.openConnection();
            URLConnection.setRequestProperty("User-Agent","edu.bsu.cs222.WikipediaRevisionReader/0.1(landen.finlinson@bsu.edu)");
            InputStream inputStream = URLConnection.getInputStream();

        }catch (IOException malformedURLException){
            throw new RuntimeException(malformedURLException);
        }
        return urlString;
    }
}
