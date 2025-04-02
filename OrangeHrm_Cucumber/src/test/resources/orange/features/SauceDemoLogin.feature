Feature: Login functionality of SauceDemo

  Background:
    Given I am on the sauce demo Login Page

  @SmokeTest @ChromeBrowser
  Scenario: Successful login with valid credentials
    When User provides valid credentials
    Then Swag Labs page is displayed
    And close the application

  @RegressionTest @ChromeBrowser
  Scenario: Login attempt with username but no password
    When User provides username but no password
    Then Shows error message for missing password
    And close the application

  @RegressionTest @EdgeBrowser
  Scenario: Login attempt with password but no username
    When User provides password but no username
    Then Shows error message for missing username
    And close the application

  @RegressionTest @NegativeTest @ChromeBrowser
  Scenario: Login attempt with incorrect username and password
    When User provides incorrect username and password
    Then Shows error message for invalid credentials
    And close the application
