package pages;

import org.junit.Assert;
import org.openqa.selenium.BuildInfo;
import org.openqa.selenium.By;
import utility.ScreenshotUtil;
import utility.UiInteractables;

import static hooks.Hooks.*;

public class ContactsPageFunctions {

    public void navigateToContactPage(String page) {
        driver.findElement(By.linkText(page)).click();
        System.out.println("User navigated to Contact page");
    }

    public void verifyContactPageDisplayed() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("User is not on Contact page", currentUrl.contains("/contact"));
        System.out.println("Contact page is displayed with URL: " + currentUrl);
    }

    public void enterName(String name) {
        UiInteractables.sendKeysByID(driver, elementReader.get("contactformname"), reader.get(name));
        System.out.println("Entered name: " + name);
    }

    public void enterEmail(String email) {
        UiInteractables.sendKeysByID(driver, elementReader.get("contactformemail"), reader.get(email));
        System.out.println("Entered email: " + email);
    }

    public void enterMessage(String message) {
        UiInteractables.sendKeysByID(driver, elementReader.get("contactformmessage"), reader.get(message));
        System.out.println("Entered message: " + message);
        ScreenshotUtil.attachScreenshot(driver, "Contact form details with the entered values");
    }

    public void submitContactForm() {
        UiInteractables.clickByXpath(driver, elementReader.get("contactformsubmitbutton"));
        System.out.println("Contact form submitted");
    }

    public void verifySubmissionConfirmation() {
        String confirmationMessage = UiInteractables.findByIDElement(driver, elementReader.get("contactformsuccessheader")).getText();

        Assert.assertTrue("Submission confirmation message is not displayed as expected.", confirmationMessage.contains("Your message has been sent"));
        ScreenshotUtil.attachScreenshot(driver, "Contact form submission confirmation");
        System.out.println("Submission confirmation verified: " + confirmationMessage);
    }

    public void verifySubmittedName(String expectedName) {
        String actualName = UiInteractables.findByXpathElement(driver, elementReader.get("expectedcontactformname")).getText().trim();
        Assert.assertEquals("Submitted name is incorrect. Expected name is: " + expectedName + " . But actual name is :" + actualName, reader.get(expectedName), actualName);
        ScreenshotUtil.attachScreenshot(driver, "Contact form submitted name verification");
        System.out.println("Submitted name verified: " + actualName);
    }

    public void verifySubmittedEmail(String expectedEmail) {
        String actualEmail = UiInteractables.findByXpathElement(driver, elementReader.get("expectedcontactformemail")).getText().trim();
        Assert.assertEquals("Submitted email is incorrect. Expected email is: " + expectedEmail + " . But actual email is :" + actualEmail, reader.get(expectedEmail), actualEmail);
        ScreenshotUtil.attachScreenshot(driver, "Contact form submitted email verification");
        System.out.println("Submitted email verified: " + actualEmail);
    }

    public void verifySubmittedMessage(String expectedMessage) {
        String actualMessage = UiInteractables.findByXpathElement(driver, elementReader.get("expectedcontactformmessage")).getText().trim();
        Assert.assertEquals("Submitted message is incorrect. Expected message is: " + expectedMessage + " . But actual message is :" + actualMessage, reader.get(expectedMessage), actualMessage);
        ScreenshotUtil.attachScreenshot(driver, "Contact form submitted message verification");
        System.out.println("Submitted message verified: " + actualMessage);
    }
}
