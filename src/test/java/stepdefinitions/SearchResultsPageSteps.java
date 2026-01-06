package stepdefinitions;

import io.cucumber.java.en.And;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.SearchResultsPageFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Duration;
import java.util.List;

import static hooks.Hooks.driver;
import static hooks.Hooks.reader;
import static org.openqa.selenium.Keys.ENTER;

public class SearchResultsPageSteps {
    SearchResultsPageFunctions searchResultPageFunctions = new SearchResultsPageFunctions();

    @Given("the user is on the Automation Panda home page")
    public void navigateToPandaHomePage() {
        //driver.get("https://automationpanda.com/");
        driver.get(reader.get("application_url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("User is on Automation Panda home page");
    }

    @When("the user clicks Search icon and enters {string} as search criteria and user submits the search")
    public void searchCriteria(String searchCriteria) {
        searchResultPageFunctions.enterSearchCriteria(searchCriteria);
    }

    @Then("the user should see the results page with title as Search")
    public void verifySearchResultsPageTitle() {
        searchResultPageFunctions.verifySearchResults();
    }

    @And("the user should see the search results containing {string}")
    public void verifySearchResultsContentStep(String searchResult) {
        searchResultPageFunctions.verifySearchResultsContent(searchResult);
    }

}