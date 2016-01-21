package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Jean Carlo Rodriguez on 1/21/2016.
 */
public class ProjectSteps {

    private String projectName;

    @Given("^I will use the user \"([^\"]*)\" to make the requests$")
    public void IWillUseTheUserToMakeTheRequests(String user) {
        //
        System.out.println("");
        System.out.println("Using the user: " + user + " for API");
    }

    @When("^I create a project \"([^\"]*)\" using the API$")
    public void ICreateAProjectUsingTheAPI(String projectName) {
        this.projectName = projectName;
        System.out.println("Creating a project with the name: " + projectName);
    }

    @Then("^the Project should be obtained with the correct values$")
    public void theProjectShouldBeObtainedWithTheCorrectValues() {
        System.out.println("Executing the asserts! for the project: " + this.projectName);
    }

    @After("@createProject")
    public void removeAProject() {
        //just for probe
        System.out.println("Removing the project: " + this.projectName);
    }
}