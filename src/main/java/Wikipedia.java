import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Wikipedia {
    public static void main(String[] args) throws IOException {
        URL WikiLink = new URL("https://en.wikipedia.org/wiki/Tennis");
        URLConnection connect = new URLConnection() {
            @Override
            public void connect() throws IOException {


            }
        }
    }
}