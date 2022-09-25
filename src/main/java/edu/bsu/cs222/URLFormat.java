package edu.bsu.cs222;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.LinkedHashMap;
import static java.net.URLEncoder.encode;

    public class URLFormat {
        private String ArticleTitle;
        private Map<String, String> urlParameters = new LinkedHashMap<>();
        private String fullURL;


        public String constructURL(){
            fullURL = "https://en.wikipedia.org/w/api.php?";

            urlParameters.forEach((k,v) -> fullURL += "&" + k + "=" + v);

            return fullURL;
        }
        //Based on code from https://www.mediawiki.org/wiki/API:Revisions#JavaScript_2
        private void setParameters(){
            urlParameters.put("action", "query");
            urlParameters.put("format", "json");
            urlParameters.put("prop", "revisions");
            urlParameters.put("titles", ArticleTitle);
            urlParameters.put("rvprop", "timestamp|user"); //revision properties -- all possible properties: timestamp|user|comment|content
            urlParameters.put("rvlimit", "27");
            urlParameters.put("redirects", "1"); //"redirects" is a boolean
        }
        public URLFormat(String articleTitle) {
            ArticleTitle = encode(articleTitle, StandardCharsets.UTF_8);
            setParameters();
            fullURL = constructURL();
        }
        public String getURL() {
            return fullURL;
        }
        //Based on code from https://www.mediawiki.org/wiki/API:Revisions#JavaScript_2

    }