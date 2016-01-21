package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;

public class ResponsesSteps {

    private ResourcesSteps projectSteps;

    public ResponsesSteps(ResourcesSteps projectSteps) {
       this.projectSteps = projectSteps;
    }

    @Then("^The response should have a \"(.*?)\" attribute with value: \"(.*?)\"$")
    public void theResponseShouldHaveAnAttributeWithValue(String attr, String attrValue){
        Assert.assertTrue(jsonResponse.contains(attr) && jsonResponse.contains(attrValue));
    }


    @Then("^Response is not empty")
    public void responseIsNotEmpty() throws Throwable {
        Assert.assertFalse(projectSteps.getJsonResponse().isEmpty());
    }
}
