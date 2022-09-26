package edu.bsu.cs222;

import net.minidev.json.JSONArray;

public class WikipediaRevision {

    String username;
    String timestamp;

    public WikipediaRevision() {
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

    public String checkRevison(JSONArray revision) {
        return null;
    }
}