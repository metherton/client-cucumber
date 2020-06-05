Feature: Home Page behaviour ?

  We can see and do stuff on the home page

  Scenario: Family tree links displayed
    Given I am on the ONS home page
    When A link to Search Etherton family trees is shown
    Then I click on Search Etherton family trees link
    Then A list of Etherton family trees is shown
