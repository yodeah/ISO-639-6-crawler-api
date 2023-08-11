import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CrawlerTest {

    private Crawler crawler;
    private char letter;
    private ArrayList<AlphaObject> result;

    @Given("a Crawler and a letter {char}")
    public void a_crawler_and_a_letter(char letter) {
        crawler = new Crawler();
        this.letter = letter;
    }

    @When("the Crawler crawls GeoLang for the letter")
    public void the_crawler_crawls_GeoLang_for_the_letter() {
        crawler.crawlGeoLangForLetter(letter);
        result = crawler.getDataFromDoc();
    }

    @Then("the result should not be empty")
    public void the_result_should_not_be_empty() {
        Assert.assertFalse(result.isEmpty());
    }
}
