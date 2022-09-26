package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class Redirects {
    public String checkRedirect(InputStream inputStream0) throws IOException {
        JSONArray redirects = JsonPath.read(inputStream0,"$..redirects");
        if (redirects.size() > 0) {
            String redirect = ("Redirects " + (redirects.get(0).toString()));
            return redirect;
        }

        return null;
    }
}
