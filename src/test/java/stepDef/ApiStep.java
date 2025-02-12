package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {
    ApiPage apiPage;
    public ApiStep() {
        apiPage = new ApiPage();
    }
    @Given("prepare url valid for {string}")
    public void prepareUrlValidFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit api get user by id")
    public void hitApiGetUserById() {
        apiPage.hitApiGetUserById();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
        apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get user by id")
    public void validationResponseBodyGetUserById() {
        apiPage.validationResponseBodyGetUserByid();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String filename) {
        apiPage.validationResponseJsonWithJSONSchema(filename);
    }

    @And("hit api post create new user")
    public void hitApiPostCreateNewUser() {
        apiPage.hitApiGetNewUser();
    }

    @Then("validation response body post create new user")
    public void validationResponseBodyPostCreateNewUser() {
        apiPage.validationResponseBodyCreteNewUser();
    }

    @And("hit api delete new")
    public void hitApiDeleteNew() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update data")
    public void hitApiUpdateData() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUser();
    }
}
