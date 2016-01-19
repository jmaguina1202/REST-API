package steps;

import cucumber.api.java.en.When;
import org.json.JSONObject;
import utils.CommonUtils;
import java.util.List;
import utils.PropertiesReader;
import java.util.Map;

public class ResourcesSteps {
    private String jsonResponse;
    private CommonUtils util = new CommonUtils();
    PropertiesReader reader = PropertiesReader.instance();

    public String getJsonResponse() {
        return jsonResponse;
    }

    @When("^I did a post request:$")
    public void iDidPostRequest(Map<String, String> data){
        JSONObject project = new JSONObject(data);
        jsonResponse = util.postRequest(reader.url, reader.authorization, project.toString());
    }

    @When("^I did a get all request")
    public void iDidGetAllRequest(){
        jsonResponse = util.getRequest(reader.url, reader.authorization);
    }

    @When("^I did a get request with the id \"(.*?)\"")
    public void iDidGetRequest(String id){
        jsonResponse = util.getRequestId(reader.url, reader.authorization, id);
    }

    @When("^I did a put request with the id \"(.*?)\" and the values:$")
    public void iDidPutRequest(String id,Map<String, String> data){
        JSONObject project = new JSONObject(data);
        jsonResponse = util.putRequest(reader.url, reader.authorization, id, project.toString());
    }

    @When("^I did a delete request with the id \"(.*?)\"")
    public void iDidDeleteRequest(String id){
        jsonResponse = util.deleteRequest(reader.url, reader.authorization, id);
    }
}
