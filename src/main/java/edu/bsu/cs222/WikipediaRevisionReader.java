package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.net.URLConnection;

public class WikipediaRevisionReader {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        RevisionParser revisionParser = new RevisionParser();

        InputStream inputStream0 = revisionParser.encodedUrl(userInput);
        Redirects redirects = new Redirects();
        System.out.println(redirects.checkRedirect(inputStream0));

        InputStream inputStream = revisionParser.encodedUrl(userInput);
        ArrayList<String> usersList = revisionParser.parseUsers(inputStream);

        InputStream inputStream1 = revisionParser.encodedUrl(userInput);
        ArrayList<String> timestampsList = revisionParser.parseTimestamp(inputStream1);

        System.out.println("Revisions for " + userInput);
        Formatter formatter = new Formatter();
        formatter.formatted(usersList, timestampsList);
    }
}