package stepDefinitions;

import hooks.Hooks;
import pages.GoogleHomePage;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

public class GoogleSearchSteps {
    GoogleHomePage googleHomePage;

    @Given("I open the Google homepage")
    public void i_open_the_google_homepage() {
        Hooks.driver.get("https://www.google.com");
        googleHomePage = new GoogleHomePage(Hooks.driver);
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        googleHomePage.search(query);
    }

    @Then("I should see results related to {string}")
    public void i_should_see_results_related_to(String query) {
        String pageSource = Hooks.driver.getPageSource();
        assertTrue(pageSource.contains(query));
    }
}