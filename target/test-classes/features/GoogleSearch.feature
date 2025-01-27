Feature: Google Search

  Scenario: Search for Selenium on Google
    Given I open the Google homepage
    When I search for "Selenium"
    Then I should see results related to "Selenium"
