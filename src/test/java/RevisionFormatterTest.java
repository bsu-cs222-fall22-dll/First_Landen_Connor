import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RevisionFormatterTest {

    @Test
    public void testRevisionFormat() throws IOException {
        String properFormat = "2022-09-04\t09:40:17\tVorlee";
        InputStream zappaJSON = Thread.currentThread().getContextClassLoader().getResourceAsStream("zappa.json");
        RevisionParser revisionsJSON = new RevisionParser(zappaJSON);
        List<Revision> revisionList = revisionsJSON.parse();
        RevisionFormatter revision = new RevisionFormatter(revisionList.get(0));
        String formattedRevision = revision.format();
        Assertions.assertEquals(properFormat, formattedRevision);
    }
}
