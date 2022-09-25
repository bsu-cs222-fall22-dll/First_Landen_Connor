import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RedirectParser {

    //This class returns lists because if there are no redirects and we try to make this
    //class return strings instead, it fails.
    private List<String> redirectFrom;
    private List<String> redirectTo;

    public RedirectParser(InputStream jsonData) throws IOException {
        JSONArray redirects = JsonPath.read(jsonData, "$..[?(@.redirects)]");
        redirectFrom = JsonPath.read(redirects, "$.*..from");
        redirectTo = JsonPath.read(redirects, "$.*..to");
    }

    public Redirects parse(){
        Redirects redirect = new Redirects(redirectFrom, redirectTo);
        return redirect;
    }
}
