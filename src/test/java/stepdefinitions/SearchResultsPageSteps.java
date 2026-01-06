package stepdefinitions;

import io.cucumber.java.en.And;
import pages.SearchResultsPageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

import static hooks.Hooks.driver;
import static hooks.Hooks.reader;

public class SearchResultsPageSteps {
    SearchResultsPageFunctions searchResultPageFunctions = new SearchResultsPageFunctions();

    @Given("the user is on the Automation Panda home page")
    public void navigateToPandaHomePage() {
        driver.get(reader.get("application_url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("User is on Automation Panda home page");
    }

    @When("the user clicks Search icon and enters {string} as search criteria and user submits the search")
    public void searchCriteria(String searchCriteria) {
        searchResultPageFunctions.enterSearchCriteria(searchCriteria);
    }

    @And("the user should see the search results containing {string}")
    public void verifySearchResultsContentStep(String searchResult) {
        searchResultPageFunctions.verifySearchResultsContent(searchResult);
    }

    @Then("the user should see the results page with title as Search")
    public void verifySearchResultsPageTitle() {
        searchResultPageFunctions.verifySearchResults();
    }

}