package edu.bsu.cs222;

public class WikipediaRevision {

    public String checkRevision;
    String username;
    String timestamp;

    public WikipediaRevision() {
        String formattedString = username;
        formattedString = formattedString.replace("[\"", " ");
        formattedString = formattedString.replace("\"]", " ");
        formattedString = formattedString.trim();
        this.username = formattedString;
    }

    public String ShowRevisionTimestamp() {
        return String.format("%s made a revision at %s.\n", username, timestamp);
    }

    public String checkRevision() {
        return null;
    }
}