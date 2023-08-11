import java.util.ArrayList;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeserializeXMLTest {

    private DeserializeXML deserializer;
    private String fileAccess;
    private ArrayList<AlphaObject> result;

    @Given("a DeserializeXML and a file access {string}")
    public void a_deserializeXML_and_a_file_access(String fileAccess) {
        deserializer = new DeserializeXML();
        this.fileAccess = fileAccess;
    }

    @When("the DeserializeXML executes")
    public void the_deserializeXML_executes() {
        deserializer.setFileAccess(fileAccess);
        result = deserializer.Execute();
    }

    @Then("the result should not be empty")
    public void the_result_should_not_be_empty() {
        Assert.assertFalse(result.isEmpty());
    }
}