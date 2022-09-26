package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class Redirect {
    public String checkRedirect(JSONArray jsonArray){
        try {
            JSONArray result = JsonPath.read(jsonArray, "$..redirects");
            JSONArray redirection = JsonPath.read(result, "$..to");
            return String.format("", redirection.get(0).toString());

        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            return "";
        }
    }
}