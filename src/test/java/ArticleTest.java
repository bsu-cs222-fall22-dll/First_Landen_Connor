import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ArticleTest {

    @Test
    public void testCreateArticle() throws IOException {
        String articleTitle = "Zappa";
        Article article = new Article(articleTitle);
        Assertions.assertEquals("https://en.wikipedia.org/w/api.php?&action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp|user&rvlimit=27&redirects=1", article.getURL());
        System.out.println(article.getRevisionsList().toString());
    }

    @Test
    public void testArticleGetJson() throws IOException {
        String articleTitle = "Zappa";
        Article article = new Article(articleTitle);
        //String jsonData = Files.readString(Path.of("src/test/java/zappa.json"));
        //Assertions.assertEquals(jsonData, article.getJsonData());
        System.out.println(article.getJsonData());
    }

    @Test
    public void testArticleRedirects() throws IOException {
        String articleTitle = "Zappa";
        Article article = new Article(articleTitle);
        Assertions.assertEquals("Zappa", article.getRedirectFrom());
        Assertions.assertEquals("Frank Zappa", article.getRedirectTo());
    }

    @Test
    public void testFetchLiveData() throws IOException {
        String articleTitle = "Obama";
        Article article = new Article(articleTitle);
        System.out.println(article.getJsonData());
    }

    @Test
    public void testArticleDoesNotExist() throws IOException {
        String articleTitle = "Jax Zinkie";
        Article article = new Article(articleTitle);
        System.out.println(article.getJsonData());
    }
}
