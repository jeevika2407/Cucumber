Feature: Login functionality of SauceDemo

  Scenario: Successful login with valid credentials
    Given I am on the sauce demo Login Page
    When User provides valid credentials
    Then Swag Labs page is displayed
    And close the application

  Scenario: Login attempt with username but no password
    Given I am on the sauce demo Login Page
    When User provides username but no password
    Then Shows error message for missing password
    And close the application

  Scenario: Login attempt with password but no username
    Given I am on the sauce demo Login Page
    When User provides password but no username
    Then Shows error message for missing username
    And close the application

  Scenario: Login attempt with incorrect username and password
    Given I am on the sauce demo Login Page
    When User provides incorrect username and password
    Then Shows error message for invalid credentials
    And close the application
