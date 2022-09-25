import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Article {

    private String articleTitle;
    private String finalURL;
    private List<Revision> revisionList;
    private InputStream jsonData;
    private String jsonDataString;

    private Redirects redirects;

    public Article(String articleTitle) throws IOException {
        this.articleTitle = articleTitle;
        CreateURL(articleTitle);
        //UseTestData();
        jsonData = liveData(finalURL);
        jsonDataString = new String(jsonData.readAllBytes(), StandardCharsets.UTF_8);
        ParseRevisions(jsonDataString);
        ParseRedirects(jsonDataString);
    }

    private void CreateURL(String articleTitle){
        URLFormat url = new URLFormat(articleTitle);
        finalURL = url.getURL();
    }

    private void UseTestData() throws IOException {
        jsonData = Thread.currentThread().getContextClassLoader().getResourceAsStream("zappa.json");
    }

    private void ParseRevisions(String jsonData) throws IOException {
        RevisionParser revisionParser = new RevisionParser(new ByteArrayInputStream(jsonData.getBytes()));
        revisionList = revisionParser.parse();
    }

    private void ParseRedirects(String jsonData) throws IOException {
        RedirectParser redirectParser = new RedirectParser(new ByteArrayInputStream(jsonData.getBytes()));
        redirects = redirectParser.parse();

    }

    private InputStream liveData(String finalURL) throws IOException {
        DataFetcher dataFetcher = new DataFetcher(finalURL);
        return dataFetcher.json();
    }

    public String getURL(){
        return finalURL;
    }

    public List<Revision> getRevisionsList(){
        return revisionList;
    }

    public String getJsonData(){
        return jsonDataString;
    }

    public String getRedirectFrom(){
        return redirects.from();
    }

    public String getRedirectTo(){
        return redirects.to();
    }
}