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
    private static final PropertiesReader READER = PropertiesReader.instance();

    public String getJsonResponse() {
        return jsonResponse;
    }

    @When("^I did a post request \"(.*?)\" with the values:$")
    public void iDidPostRequest(String value, Map<String, String> data)throws Throwable {
        JSONObject project = new JSONObject(data);
        jsonResponse = util.postRequest(READER.getEndPoint(value), READER.getAuthorizationString(), project.toString());
    }

    @When("^I did a get all request \"(.*?)\"")
    public void iDidGetAllRequest(String value) throws Throwable {
        jsonResponse = util.getRequest(READER.getEndPoint(value), READER.getAuthorizationString());
    }

    @When("^I did a get request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidGetRequest(String value,String id) throws Throwable{
        jsonResponse = util.getRequestId(READER.getEndPoint(value), READER.getAuthorizationString(), id);
    }

    @When("^I did a put request \"(.*?)\" with the id \"(.*?)\" and the values:$")
    public void iDidPutRequest(String value, String id, Map<String, String> data) throws Throwable {
        JSONObject project = new JSONObject(data);
        jsonResponse = util.putRequest(READER.getEndPoint(value), READER.getAuthorizationString(), id, project.toString());
    }

    @When("^I did a delete request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidDeleteRequest(String value, String id) throws Throwable {
        jsonResponse = util.deleteRequest(READER.getEndPoint(value), READER.getAuthorizationString(), id);
    }
}
