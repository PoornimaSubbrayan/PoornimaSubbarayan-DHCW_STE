package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.ScreenshotUtil;
import utility.UiInteractables;

import static org.openqa.selenium.Keys.ENTER;

public class SearchResultsPageFunctions extends UiInteractables {

    public void enterSearchCriteria(String searchCriteria) {
        UiInteractables.sendKeysByXpath(driver, elementReader.get("searchLocator"), reader.get(searchCriteria));
        System.out.println("User entered the search criteria: " + reader.get(searchCriteria));
        ScreenshotUtil.attachScreenshot(driver, "Search criteria entered");
        Actions actions = new Actions(driver);
        actions.sendKeys(ENTER).build().perform();
    }

    public void verifySearchResults() {
        System.out.println("Current Page title after search results shown is: " + UiInteractables.getTitle(driver));
        Assert.assertTrue("User is not on search results page based on the search criteria entered", UiInteractables.getTitle(driver).contains("Search"));
    }

    public void verifySearchResultsContent(String searchResult) {
        System.out.println("Verifying the search results content for the search criteria: " + reader.get(searchResult));
        Assert.assertFalse("Search results not found", UiInteractables.findByXpathElements(driver, elementReader.get("searchResultPageHeading")).isEmpty());
        ScreenshotUtil.attachScreenshot(driver, "Search results page content");

        boolean isExpectedTitlePresent = UiInteractables.findByXpathElements(driver, elementReader.get("searchResultItem"))
                .stream().anyMatch(e -> e.getText().trim().equals(reader.get(searchResult)));
        System.out.println("Is expected title present in search results: " + isExpectedTitlePresent);
        Assert.assertTrue("Search results do not contain the expected title", isExpectedTitlePresent);
    }

}

