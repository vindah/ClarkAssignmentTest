@test
Feature: Recommendation Page feature
  In order to confirm the details of an item
  As a user


    # Clark home - Checking page loads properly
  @smoke
  Scenario: Verify that the user can fill recommendations form
    Given The user is on the recommendations page
    When The user clicks on the 'Start now' button
    Then The recommendations form should be displayed
    When The user clicks on the date field and enters a date
    And The user

    # Clark home - Navigating to Bedarf tab
  @acceptance @regression
  Scenario: Verify user can navigate to Bedarf tab successfully

