Feature: Application up and running
  As a Play developer I want to see that I integrated Cucumber correctly

  Scenario: Seeing that the application is up and running
    Given my application is running
    When I go to the "start" page
    Then I should see "Hello world!"