@LoginPage
Feature: Login Feature
	@validCredentials
 	Scenario: Login Feature with valid credentials
 	Given I am in the Orange HRM Login Page
 	When User provides the valid User name
 	And User provides the valid password
 	And User clicks the login button
 	Then I should see a dashboard