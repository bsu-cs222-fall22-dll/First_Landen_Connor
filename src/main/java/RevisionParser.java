import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RevisionParser {
    private JSONArray userArray;
    private JSONArray timestampArray;


    public RevisionParser(InputStream jsonData) throws IOException {
        JSONArray parsedJSON = JsonPath.read(jsonData, "$.query.pages..revisions");
        userArray = JsonPath.read(parsedJSON, "$.*..user");
        timestampArray = JsonPath.read(parsedJSON, "$.*..timestamp");
    }


    public List<Revision> parse() {
        List<Revision> revisionList = new ArrayList<>();
        String user;
        String timestamp;

        for (int index = 0; index < userArray.size(); index++){
            user = userArray.get(index).toString();
            timestamp = timestampArray.get(index).toString();
            System.out.println(user + " " + timestamp);
            Revision revision = new Revision(user, timestamp);
            revisionList.add(revision);
        }

        return revisionList;
    }

}

