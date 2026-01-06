@searchresults
Feature: Login to Automation Panda site and view the search results page based on search term
Given I am on the Automation Panda home page
When I click Search icon and enter testing as search criteria
And submit the search
Then I am taken to the Search Results page with title as Search
And I see search result with the title "7 MAJOR TRENDS IN FRONT END WEB TESTING"


  @search
  Scenario Outline: User lands on Automation Panda home page and view the search results based on the search criteria
    Given the user is on the Automation Panda home page
    When the user clicks Search icon and enters "<searchTerm>" as search criteria and user submits the search
    Then the user should see the results page with title as Search
    And the user should see the search results containing "<searchResult>"
    Examples:
      | searchTerm  | searchResult          |
      | search_term | search_result_to_find |

