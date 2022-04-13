@login
Feature: Login
  As a user, I want to be able to login with username and password
  # Agile story

  # Test Method = Test Case = Scenario
  # Test + DataProvider = Scenario Outline = Examples Table

  Background: open login page
    Given user is on the login page

  @sales_manager
  Scenario: Login as a sales manager and verify that title is Dashboard
    When user logs in as a sales manager
    Then user should verify that title is a Dashboard

  @store_manager
  Scenario: Login as a store manager and verify that title is Dashboard
    When user logs in as a store manager
    Then user should verify that title is a Dashboard

  @driver @dashboard
  Scenario: Login as driver and verify that title is a Dashboard
    When user logs in as a driver
    Then user should verify that title is a Dashboard

  @login_with_params
  Scenario: Login with parameters
    When user enters "salesmanager115" username and "UserUser123" password
    Then user should verify that title is a Dashboard

  @scenario_outline
  Scenario Outline: User names test for user <name>
    When user enters "<username>" username and "<password>" password
    Then user name should be "<name>"

    Examples: credentials
      | username        | password    | name       |
      | user187         | UserUser123 | Alex Jones |
      | user200         | UserUser123 | Alex Jones |
      | storemanager52  | UserUser123 | John Doe   |
      | storemanager66  | UserUser123 | John Doe   |
      | salesmanager125 | UserUser123 | John Doe   |
      | salesmanager140 | UserUser123 | John Doe   |