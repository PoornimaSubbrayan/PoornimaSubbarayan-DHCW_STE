package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.ContactsPageFunctions;

import java.time.Duration;

import static hooks.Hooks.driver;
import static hooks.Hooks.reader;

public class ContactPageSteps {

    ContactsPageFunctions contactsPageFunctions = new ContactsPageFunctions();

    @Given("I am on the Automation Panda homepage")
    public void navigateToPandaHomePage() {
        //driver.get("https://automationpanda.com/");
        driver.get(reader.get("application_url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("User is on Automation Panda home page");
    }

    @When("I select the {string} button from the navigation menu")
    public void contactPageNavigation(String page) {
        contactsPageFunctions.navigateToContactPage(page);
    }

    @When("I enter {string} into the name field")
    public void enterValueOnNameField(String name) {
        contactsPageFunctions.enterName(name);
    }


    @And("I enter {string} into the email field")
    public void enterValueOnEmailField(String email) {
        contactsPageFunctions.enterEmail(email);
    }

    @And("I enter {string} into the message field")
    public void enterValueOnMessageField(String message) {
        contactsPageFunctions.enterMessage(message);
    }

    @And("I submit the contact form")
    public void contactFormSubmission() {
        contactsPageFunctions.submitContactForm();
    }


    @And("the submitted name is {string}")
    public void submittedNameVerification(String expectedName) {
        contactsPageFunctions.verifySubmittedName(expectedName);
    }

    @And("the submitted email is {string}")
    public void submittedEmailVerification(String expectedEmail) {
        contactsPageFunctions.verifySubmittedEmail(expectedEmail);
    }

    @And("the submitted message is {string}")
    public void submittedMessageVerification(String expectedMessage) {
        contactsPageFunctions.verifySubmittedMessage(expectedMessage);
    }

    @Then("the contact page is displayed")
    public void verifyContactPageDisplayed() {
        contactsPageFunctions.verifyContactPageDisplayed();
    }

    @Then("a submission confirmation is displayed")
    public void submissionConfirmation() {
        contactsPageFunctions.verifySubmissionConfirmation();
    }
}
