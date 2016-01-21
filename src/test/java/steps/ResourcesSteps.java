package steps;

import cucumber.api.java.en.When;
import org.json.JSONObject;
import utils.CommonUtils;
import java.io.IOException;
import java.util.HashMap;
import utils.PropertiesReader;
import java.util.Map;

public class ResourcesSteps {
    private String jsonResponse;
    private CommonUtils util = new CommonUtils();
    private static final PropertiesReader READER = PropertiesReader.instance();
    public static Map<String, JSONObject> localStore = new HashMap();

    public String getJsonResponse() {
        return jsonResponse;
    }

    @When("^I did a post request \"(.*?)\" with the values:$")
    public void iDidPostRequest(String value, Map<String, String> data) throws IOException {
        JSONObject project = new JSONObject(data);
        jsonResponse = util.postRequest(READER.getEndPoint(value), READER.getAuthorizationString(), project.toString());
    }

    @When("^I did a get all request \"(.*?)\"")
    public void iDidGetAllRequest(String value) throws IOException {
        jsonResponse = util.getRequest(READER.getEndPoint(value), READER.getAuthorizationString());
    }

    @When("^I did a get request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidGetRequest(String value, String projectId) throws IOException {
        String[] values = projectId.split("\\.");
        jsonResponse = util.getRequestId(READER.getEndPoint(value), READER.getAuthorizationString(), localStore.get(values[0]).get(values[1]).toString());
    }

    @When("^I did a put request \"(.*?)\" with the id \"(.*?)\" and the values:$")
    public void iDidPutRequest(String value, String projectId, Map<String, String> data) throws IOException {
        JSONObject project = new JSONObject(data);
        String[] values = projectId.split("\\.");
        jsonResponse = util.putRequest(READER.getEndPoint(value), READER.getAuthorizationString(), localStore.get(values[0]).get(values[1]).toString(), project.toString());
    }

    @When("^I did a delete request \"(.*?)\" with the id \"(.*?)\"")
    public void iDidDeleteRequest(String value, String projectId) throws IOException {
        String[] values = projectId.split("\\.");
        jsonResponse = util.deleteRequest(READER.getEndPoint(value), READER.getAuthorizationString(), localStore.get(values[0]).get(values[1]).toString());
    }

    @When("^I store the response \"(.*?)\"")
    public void iStoreResponse(String key) throws IOException {
        JSONObject body = new JSONObject(jsonResponse);
        localStore.put(key, body);
    }
}
