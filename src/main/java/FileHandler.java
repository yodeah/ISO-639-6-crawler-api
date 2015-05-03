import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by andras on 2015.05.02..
 */
public class FileHandler {
    
    private String file_access;
    private String file_name;
    private String file_content;

    private String getFileContent() {
        return file_content;
    }

    public void setFileContent(String file_content) {
        this.file_content = file_content;
    }
    private String getFileAccess() {
        return file_access;
    }

    public void setFileAccess(String file_access) {
        this.file_access = file_access;
    }


    private String getFileName() {
        return file_name;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    public void Execute(){
        try {

            File file = new File("xmls/tesztfile.txt");

            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.getFileContent());
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
