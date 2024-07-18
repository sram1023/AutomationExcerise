package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import util.RestServiceActions;

public class RestApi extends RestServiceActions {


    @Given("^the rest api for (.+) is ready$")
    public void restApi(String action) {
        restActions(action);
    }

    @Then("^validate the (.+) response$")
    public void validateTheSuccessStatusOK(String action) {
        validateResponse(action);
    }
}
