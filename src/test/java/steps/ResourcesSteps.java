package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import utils.CommonUtils;
import java.util.List;

public class ResourcesSteps {
    private String jsonResponse;
    private CommonUtils util = new CommonUtils();

    public String getJsonResponse() {
        return jsonResponse;
    }

    @When("^I did a post request:$")
    public void iDidPostRequest(DataTable table) throws
            Throwable {
       List<List<String>> data =table.raw();
       JSONObject project = new JSONObject();
        for ( int index = 0; index < data.size(); index ++ ) {
            project.put(data.get(index).get(0), data.get(index).get(1));
        }
        jsonResponse = util.postRequest(util.readProperty("rest.projects.url"),
                util.readProperty("rest.projects.authorization"), project.toString());
    }

    @When("^I did a get all request")
    public void iDidGetAllRequest() throws
            Throwable {
        jsonResponse = util.getRequest(util.readProperty("rest.projects.url"),
                util.readProperty("rest.projects.authorization"));
    }

    @When("^I did a get request with the id \"(.*?)\"")
    public void iDidGetRequest(String id) throws
            Throwable {
        jsonResponse = util.getRequestId(util.readProperty("rest.projects.url"),
                util.readProperty("rest.projects.authorization"),id);
    }

    @When("^I did a put request with the id \"(.*?)\" and the values \"(.*?)\": \"(.*?)\" : \"(.*?)\": (\\d+)$")
    public void iDidPutRequest(String id,String tagContent, String contentValue, String tagIcon, int iconValue) throws
            Throwable {
        JSONObject project = new JSONObject();
        project.put(tagContent, contentValue);
        project.put(tagIcon, iconValue);

        jsonResponse = util.putRequest(util.readProperty("rest.projects.url"),
                util.readProperty("rest.projects.authorization"), id, project.toString());
    }

    @When("^I did a delete request with the id \"(.*?)\"")
    public void iDidDeleteRequest(String id) throws
            Throwable {
        jsonResponse = util.deleteRequest(util.readProperty("rest.projects.url"),
                util.readProperty("rest.projects.authorization"),id);
    }


}
