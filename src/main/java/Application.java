import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Created by andras on 2015.04.18..
 */
public class Application {

    public static void main(String[] args) {
        //char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphabet = "a".toCharArray();

        Crawler crawler = new Crawler();
        for (char letter : alphabet) {
            crawler.crawlGeoLangForLetter(letter);
            crawler.getDataFromDoc();
        }

        System.out.println("vegeztem");
    }

}
