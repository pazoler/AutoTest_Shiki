package Autotest.stepDefinitions;


import Autotest.pageObjects.BasePageObject;
import Autotest.pageObjects.ShikiLoginPO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ShikiLogInSteps extends BasePageObject {
    private ShikiLoginPO shikiLoginPO;

    public ShikiLogInSteps(ShikiLoginPO shikiLoginPO) {
        this.shikiLoginPO = shikiLoginPO;
    }


    @Given("I access the Shikimori login page")
    public void openShikiLoginPage() {
        shikiLoginPO.navigateToLoginPage();
    }


    @When("I enter a login {}")
    public void enterUserName(String username) {
        shikiLoginPO.setUsernameTextField(username);
    }

    @And("I enter a shiki password {}")
    public void enterShikiPassword(String password) {

        shikiLoginPO.setPasswordTextField(password);
    }

    @And("I click on the entry button")
    public void clickEntryButton() {

        shikiLoginPO.clickLogInButton();
    }

    @Then("I should be presented with the successful entry message")
    public void shouldBeSuccessEntryMessage() {
        shikiLoginPO.validateSuccessLoginMessage();
    }

    @And("I click checkbox button")
    public void clickCheckboxButton() {
        shikiLoginPO.clickCheckBoxButton();
    }

//    @Then("I should be presented with the unsuccessful login message")
//    public void i_should_be_presented_with_the_unsuccessful_login_message() {
//        shikiLoginPO.validateUnSuccessLoginMessage();
//    }
//
//    @Then("I should be presented with the following login validation message {}")
//    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
//        getTextFromAlert(expectedMessage);
//    }
}
