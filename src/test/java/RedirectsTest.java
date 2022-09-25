import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class RedirectsTest {

    @Test
    public void testRedirects_Zappa() throws IOException {
        InputStream zappaJSON = Thread.currentThread().getContextClassLoader().getResourceAsStream("zappa.json");
        RedirectParser redirectParser = new RedirectParser(zappaJSON);
        Redirects redirects = redirectParser.parse();
        Assertions.assertEquals("Zappa", redirects.from());
        Assertions.assertEquals("Frank Zappa", redirects.to());
        Assertions.assertNotEquals(redirects.from(), redirects.to());
    }
    @Test
    public void testRedirects_Boom() throws IOException {
        InputStream jsonData = Thread.currentThread().getContextClassLoader().getResourceAsStream("test_article.json");
        RedirectParser redirectParser = new RedirectParser(jsonData);
        Redirects redirects = redirectParser.parse();
        //If redirects.from() and redirects.to() are equal, then the request was not redirected
        Assertions.assertEquals(redirects.from(), redirects.to());
    }
}
