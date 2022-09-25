import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DataFetcher {

    private InputStream jsonData;

    public DataFetcher(String articleURL) throws IOException {
        URL url = new URL(articleURL);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent","Revision Reporter/0.1 (jazinkie@bsu.edu)");
        jsonData = connection.getInputStream();
//        BufferedReader inputData = new BufferedReader(
//                new InputStreamReader(inputStream));
//        String inputLine;
//        while ((inputLine = inputData.readLine()) != null){
//            jsonData += inputLine;
//        }
        System.out.println(jsonData.toString());

    }


    public InputStream json() {
        return jsonData;
    }
}
