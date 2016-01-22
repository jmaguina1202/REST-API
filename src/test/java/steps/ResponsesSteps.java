package steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import utils.LocalStore;

public class ResponsesSteps {

    private ResourcesSteps projectSteps;

    public ResponsesSteps(ResourcesSteps projectSteps) {
        this.projectSteps = projectSteps;
    }

    @Then("^The response should have a \"(.*?)\" attribute with value: \"(.*?)\"$")
    public void theResponseShouldContainSentData(String attr, String attrValue) {
        if (attrValue.contains(".")) {
            Assert.assertTrue(projectSteps.getJsonResponse().contains(attr) &&
                    projectSteps.getJsonResponse().contains(LocalStore.getId(attrValue)));
        } else {
            Assert.assertTrue(projectSteps.getJsonResponse().contains(attr) &&
                    projectSteps.getJsonResponse().contains(attrValue));
        }
    }

    @Then("^Response is not empty")
    public void responseIsNotEmpty() {
        Assert.assertFalse(projectSteps.getJsonResponse().isEmpty());
    }
}
