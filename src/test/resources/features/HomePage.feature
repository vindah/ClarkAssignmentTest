@test
Feature: Home Page feature
  In order to confirm the details of an item
  As a user


    # Clark home - Checking page loads properly
  @smoke
  Scenario: Verify home page will load properly
    Given The user is on the home page
    Then The Clark Logo should be displayed
    Then The side profile icon should be displayed

    # Clark home - Navigating to Bedarf tab
  @acceptance @regression
  Scenario: Verify user can navigate to Recommendations tab successfully
    Given The user is on the home page
    When The user clicks on 'Bedarf' in view
    Then The user should be navigated to the recommendations page successfully
