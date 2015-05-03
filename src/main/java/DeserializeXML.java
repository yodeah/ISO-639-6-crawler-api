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

    private String getFileAccess() {
        return file_access;
    }

    public void setFileAccess(String file_access) {
        this.file_access = file_access;
    }

    public void Execute(){
   // public ArrayList Execute(){
        try{
            this.xml = Files.readAllLines(Paths.get("/home/andras/IdeaProjects/crwler/xmls/tesztfile.txt"), Charset.defaultCharset());
            System.out.println(this.xml.size());
        }catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        }

        System.out.println("l");
    }



}
