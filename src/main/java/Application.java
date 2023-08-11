import java.util.ArrayList;

/**
 * Created by andras on 2015.04.18..
 */
public class Application {

    public static void main(String[] args) {
        DataOutputTest();
        //DownloadElementsIntoAnXML();
        runBDDTests();
    }

    public static void DownloadElementsIntoAnXML(){
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        //char[] alphabet = "a".toCharArray();
        ArrayList<AlphaObject> AllLanguages = new ArrayList<AlphaObject>();

        Crawler crawler = new Crawler();
        for (char letter : alphabet) {
            crawler.crawlGeoLangForLetter(letter);
            AllLanguages.addAll(crawler.getDataFromDoc());
        }

        //System.out.println(AllLanguages);

        Export2XML xml_export = new Export2XML();
        xml_export.setAllLanguages(AllLanguages);
        String xml = xml_export.Execute();

        FileHandler lol = new FileHandler();
        lol.setFileContent(xml);
        lol.Execute();
    }

    public static void DataOutputTest(){
        DeserializeXML deserializer = new DeserializeXML();
        deserializer.setFileAccess("xmls/tesztfile.txt");
        //ArrayList<AlphaObject> = deserializer.Execute();
        deserializer.Execute();
    }
    
    public static void runBDDTests(){
        // Code to run BDD tests using Cucumber library
    }

}