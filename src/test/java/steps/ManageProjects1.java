package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.json.JSONObject;
import utils.CommonUtils;
import utils.PropertiesReader;

public class ManageProjects1 {
    private String jsonResponse;
    private static final PropertiesReader READER = PropertiesReader.instance();

    @When("^I did a post request \"(.*?)\": \"(.*?)\" : \"(.*?)\": (\\d+)$")
    public void iDidPostRequest(String tagContent, String contentValue, String tagIcon, int iconValue) throws
            Throwable {
        JSONObject project = new JSONObject();
        project.put(tagContent, contentValue);
        project.put(tagIcon, iconValue);

        CommonUtils util = new CommonUtils();
        jsonResponse = util.postRequest(READER.getEndPoint(), READER.getAuthorizationString(), project.toString());
    }

    @When("^I did a get all request")
    public void iDidGetAllRequest() throws
            Throwable {
        CommonUtils util = new CommonUtils();
        jsonResponse = util.getRequest(READER.getEndPoint(), READER.getAuthorizationString());
    }

    @When("^I did a get request with the id \"(.*?)\"")
    public void iDidGetRequest(String id) throws
            Throwable {
        CommonUtils util = new CommonUtils();
        jsonResponse = util.getRequestId(READER.getEndPoint(), READER.getAuthorizationString(), id);
    }

    @When("^I did a put request with the id \"(.*?)\" and the values \"(.*?)\": \"(.*?)\" : \"(.*?)\": (\\d+)$")
    public void iDidPutRequest(String id,String tagContent, String contentValue, String tagIcon, int iconValue) throws
            Throwable {
        JSONObject project = new JSONObject();
        project.put(tagContent, contentValue);
        project.put(tagIcon, iconValue);

        CommonUtils util = new CommonUtils();
        jsonResponse = util.putRequest(READER.getEndPoint(), READER.getAuthorizationString(), id, project.toString());
    }

    @When("^I did a delete request with the id \"(.*?)\"")
    public void iDidDeleteRequest(String id) throws
            Throwable {
        CommonUtils util = new CommonUtils();
        jsonResponse = util.deleteRequest(READER.getEndPoint(), READER.getAuthorizationString(), id);
    }

    @Then("^The response should contain the values \"(.*?)\" and (\\d+)$")
    public void theResponseShouldContainSentDataWithStringValue(String firstValue, String secondValue) throws Throwable {
        Assert.assertTrue(jsonResponse.contains("\"" + firstValue + "\",") && jsonResponse.contains("\"Icon\":" + secondValue + ","));
    }

    @Then("^The response should contain \"(.*?)\" and \"(.*?)\"$")
    public void theResponseShouldContainSentData(String tag, String tagValue) throws Throwable {
        Assert.assertTrue(jsonResponse.contains("\"" + tag + "\":" + tagValue ));
    }

    @Then("^Response is not empty")
    public void responseIsNotEmpty() throws Throwable {
        Assert.assertFalse(jsonResponse.isEmpty());
    }
}
