@AutomaticLunchApply
Feature: Automatic Lunch Apply

  Scenario: Applying for Lunch
    Given The user opens the application and logs in
    When The user selects to apply for lunch
    And The user selects lunch dates and location
    And The user clicks the add button
    Then Lunch should be successfully applied
