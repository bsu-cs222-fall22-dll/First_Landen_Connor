package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class WikipediaRevision {

    final String username;
    final String timestamp;

    public WikipediaRevision(String username, String timestamp) {
        String formattedString = username;
        formattedString = formattedString.replace("[\"", " ");
        formattedString = formattedString.replace("\"]", " ");
        formattedString = formattedString.trim();
        this.username = formattedString;
        this.timestamp = timestamp;
    }

    public String ShowRevisionTimestamp() {
        return String.format("%s made a revision at %s.\n", username, timestamp);
    }
}