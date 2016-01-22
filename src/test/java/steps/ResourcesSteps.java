package steps;

import cucumber.api.java.en.When;
import org.json.JSONObject;
import utils.LocalStore;
import utils.RequestManager;

import java.io.IOException;
import java.util.Map;

public class ResourcesSteps {
    private String jsonResponse;
    private static final PropertiesReader READER = PropertiesReader.instance();

    public String getJsonResponse() {
        return jsonResponse;
    }

    @When("^I did a post request \"(.*?)\" with the values:$")
    public void iDidPostRequest(String value, Map<String, String> data) throws IOException {
        JSONObject project = new JSONObject(data);
        jsonResponse = RequestManager.postRequest(READER.getEndPoint(value), READER.getAuthorizationString(),
                project.toString());
    }

    @When("^I did a get all request \"(.*?)\"")
    public void iDidGetAllRequest(String value) throws IOException {
        jsonResponse = RequestManager.getRequest(READER.getEndPoint(value), READER.getAuthorizationString());
    }

    @When("^I did a get request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidGetRequest(String value, String projectId) throws IOException {
        jsonResponse = RequestManager.getRequestId(READER.getEndPoint(value), READER.getAuthorizationString(),
                LocalStore.getId(projectId));
    }

    @When("^I did a put request \"(.*?)\" with the id \"(.*?)\" and the values:$")
    public void iDidPutRequest(String value, String projectId, Map<String, String> data) throws IOException {
        JSONObject project = new JSONObject(data);
        jsonResponse = RequestManager.putRequest(READER.getEndPoint(value), READER.getAuthorizationString(),
                LocalStore.getId(projectId), project.toString());
    }

    @When("^I did a delete request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidDeleteRequest(String value, String projectId) throws IOException {
        jsonResponse = RequestManager.deleteRequest(READER.getEndPoint(value), READER.getAuthorizationString(),
                LocalStore.getId(projectId));
    }

    @When("^I store the response \"(.*?)\"")
    public void iStoreResponse(String key) throws IOException {
        JSONObject body = new JSONObject(jsonResponse);
        LocalStore.localStore.put(key, body);
    }
}
