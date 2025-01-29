package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BankUserPage;

public class BankUserSteps {
    BankUserPage bankUserPage;

    @Given("I am on the BugBank registration page")
    public void i_am_on_the_bug_bank_registration_page() {
        Hooks.driver.get("https://bugbank.netlify.app/");
        bankUserPage = new BankUserPage(Hooks.driver);
        bankUserPage.waitAndSelectRegistrarButton();
    }

    @Given("I fill in the {string} field with {string}")
    public void i_fill_in_the_field_with(String string, String string2) {
        bankUserPage.searchAndInputData(string, string2);
    }

    @Given("I should see a message saying {string}")
    public void i_should_see_a_message_saying(String message) {
        bankUserPage.checkMessage(message);
    }

    @Given("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page() {
        bankUserPage.checkIfTheUserIsRedirectedToTheLoginPage();
    }

    @Then("I should be redirected to the home page with message {string}")
    public void i_should_be_redirected_to_the_home_page(String message) {
        bankUserPage.checkMessage(message);
    }

    @Given("I can access the {string} page with message {string}")
    public void i_can_access_the_payment_page(String page, String message) {
       bankUserPage.selectAndVisitPage(page, message);
    }


}
