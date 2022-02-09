
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters the valid username and password
    Then Account summary page should be displayed
  @wip
  Scenario: Login with invalid username
    When the user enters the invalid username and valid password
    Then message "Login and/or password are wrong." should be displayed