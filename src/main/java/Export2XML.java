import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

/**
 * Created by andras on 2015.05.02..
 */
public class Export2XML {

    private ArrayList<AlphaObject> all_languages;

    private ArrayList<AlphaObject> getAllLanguages() {
        return all_languages;
    }

    public void setAllLanguages(ArrayList<AlphaObject> all_languages) {
        this.all_languages = all_languages;
    }

    public String Execute(){
        XStream xstream = new XStream();

        int all_languages_count = all_languages.size();

        String xml = "";

        for (int x = 0; x < all_languages_count; x++) {
            xml += xstream.toXML(all_languages.get(x));
        }

        return xml;
    }


}
