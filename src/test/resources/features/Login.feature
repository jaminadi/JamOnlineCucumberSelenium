Feature: Login
  As a user, I want to be able to login with username and password
  # Agile story

  # Test Method = Test Case = Scenario
  # Test + DataProvider = Scenario Outline = Examples Table

  Scenario: Login as a sales manager and verify that title is Dashboard
    Given user is on the landing page
    When user logs in as a sales manager
    Then user should verify that title is a Dashboard

  Scenario: Login as a store manager and verify that title is Dashboard
    Given user is on the landing page
    When user logs in as a store manager
    Then user should verify that title is a Dashboard