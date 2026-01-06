@contactspage
Feature: Navigate to Automation Panda site and view the Contacts page
Given I am on the Automation Panda homepage
When I select the "Contact" button from the navigation menu
Then the contact page is displayed
When I enter "Jane Doe" into the name field
And I enter "jane.doe@example.com" into the email field
And I enter "Test123!@#" into the message field
And I submit the contact form
Then a submission confirmation is displayed
And the submitted name is "Jane Doe"
And the submitted email is "jane.doe@example.com"
And the submitted message is "Test123!@#"


  @contacts
  Scenario Outline: User lands on Automation Panda home page and navigates to Contacts page
    Given I am on the Automation Panda homepage
    When I select the "Contact" button from the navigation menu
    Then the contact page is displayed
    When I enter "<name>" into the name field
    And I enter "<email>" into the email field
    And I enter "<message>" into the message field
    And I submit the contact form
    Then a submission confirmation is displayed
    And the submitted name is "<name>"
    And the submitted email is "<email>"
    And the submitted message is "<message>"

    Examples:
      | name              | email              | message              |
      | contact_form_name | contact_form_email | contact_form_message |
