package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ResponsesSteps {

    private ResourcesSteps projectSteps;

    public ResponsesSteps(ResourcesSteps projectSteps) {
       this.projectSteps = projectSteps;
    }

    @Then("^The response should contain the data with the string value \"(.*?)\" and \"(.*?)\"$")
    public void theResponseShouldContainSentDataWithStringValue(String tag, String tagValue) throws Throwable {
        Assert.assertTrue(projectSteps.getJsonResponse().contains("\"" + tag + "\":" + "\"" + tagValue + "\""));
    }

    @Then("^The response should contain \"(.*?)\" and \"(.*?)\"$")
    public void theResponseShouldContainSentData(String tag, String tagValue) throws Throwable {
        Assert.assertTrue(projectSteps.getJsonResponse().contains("\"" + tag + "\":" + tagValue));
    }

    @Then("^Response is not empty")
    public void responseIsNotEmpty() throws Throwable {
        Assert.assertFalse(projectSteps.getJsonResponse().isEmpty());
    }
}
