import com.sun.org.apache.xpath.internal.SourceTree;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by andras on 2015.04.21..
 */
public class Crawler {

    private Document doc;

    public void crawlGeoLangForLetter(char letter) {
        try {
            doc = Jsoup.connect("http://www.geolang.com/iso639-6/sortAlpha4.asp")
            .data("selectA4letter", String.valueOf(letter))
            .data("viewAlpha4", "View").post();

        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }
    }

    public ArrayList getDataFromDoc(){

        Elements resultAlphaIds = doc.select("table[width=750][cellspacing=1] tbody tr td:first-child");
        Elements resultAlphaParentIds = doc.select("table[width=750][cellspacing=1] tbody tr td:nth-child(2)");
        Elements resultReferenceNames = doc.select("table[width=750][cellspacing=1] tbody tr td:nth-child(3)");
        
        ArrayList<AlphaObject> Languages = new ArrayList<AlphaObject>();

        int Count = 0;
        for (Element resultAlphaId : resultAlphaIds) {
            if (0 < Count++) {
                Element resultAlphaParentId = resultAlphaParentIds.get(Count-1);
                Element resultReferenceName = resultReferenceNames.get(Count-1);
                
                String alpha_id = resultAlphaId.text();
                String alpha_parent_id = resultAlphaParentId.text();
                String reference_name = resultReferenceName.text();
                
                System.out.println(alpha_id);
                Languages.add(new AlphaObject(alpha_id,alpha_parent_id,reference_name));
            }
        }
        return Languages;
    }

}
