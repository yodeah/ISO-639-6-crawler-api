import com.thoughtworks.xstream.XStream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andras on 2015.05.03..
 */
public class DeserializeXML {

    private String file_access;
    private List<String> xml;
    ArrayList<AlphaObject> AllLanguages = new ArrayList<AlphaObject>();

    private String getFileAccess() {
        return file_access;
    }

    public void setFileAccess(String file_access) {
        this.file_access = file_access;
    }

    public void Execute(){
        try{
            this.xml = Files.readAllLines(Paths.get("/home/andras/IdeaProjects/crwler/xmls/tesztfile.txt"), Charset.defaultCharset());
            System.out.println(this.xml.size());
        }catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        XStream xstream = new XStream();
        int line = 0;
        String objectXML = "";

        for (String objectXMLline : xml){
            objectXML += objectXMLline;
           if(line%5==0 && line!=0) {
               AlphaObject lol = (AlphaObject) xstream.fromXML(objectXML);
               AllLanguages.add(lol);
               System.out.println(objectXML);
               System.out.println("");
               objectXML = "";
           }
            line++;
        }

        System.out.printf("LOL");
    }



}
