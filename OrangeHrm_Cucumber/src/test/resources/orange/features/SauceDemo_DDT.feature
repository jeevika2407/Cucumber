Feature: Login functionality for SauceDemo

  @SauceDemoInputs @chrome
  Scenario Outline: To test login features of Sauce Demo website
    Given the user is in Login page
    When the user provides username "<username>"
    And the user provides password "<password>"
    And the user clicks login button
    Then the user is able to see "<expected_result>"

    Examples: 
      | username        | password       | expected_result|
      | standard_user   | secret_sauce   |Products|
      |                 | secret_sauce   |Epic sadface: Username is required|
      | standard_user   |                |Epic sadface: Password is required|
      | invalid_user    | wrong_password |Username and password do not match any user in this service|