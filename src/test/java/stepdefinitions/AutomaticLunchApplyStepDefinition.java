package stepdefinitions;

import implementations.AutomaticLunchApplyImplementation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AutomaticLunchApplyStepDefinition {

    @Given("The user opens the application and logs in")
    public void openApplicationAndLogIn() {
        AutomaticLunchApplyImplementation.openApplicationAndLogIn();
    }

    @When("The user selects to apply for lunch")
    public void selectToApplyForLunch() {
        AutomaticLunchApplyImplementation.selectToApplyForLunch();
    }

    @And("The user selects lunch dates and location")
    public void selectLunchDatesAndLocation() {
        AutomaticLunchApplyImplementation.selectLunchDatesAndLocation();
    }

    @And("The user clicks the add button")
    public void clickAddButton() {
        AutomaticLunchApplyImplementation.clickAddButton();
    }

    @Then("Lunch should be successfully applied")
    public void verifyLunchAppliedSuccessfully() {
        AutomaticLunchApplyImplementation.verifyLunchAppliedSuccessfully();
    }
}
