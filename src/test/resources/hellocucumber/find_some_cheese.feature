Feature: Can we find cheese ?
  Everybody wants to find cheese on google

  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"