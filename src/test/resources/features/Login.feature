
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  Scenario: Login with valid credentials
    When the user enters the valid username and password
    Then Account summary page should be displayed

  Scenario: Login with invalid username
    When the user enters the invalid username and valid password
    Then message "Login and/or password are wrong." should be displayed
    And the user should not be able to login


  Scenario: Login with invalid password
    When the user enters the valid username and invalid password
    Then message "Login and/or password are wrong." should be displayed
    And the user should not be able to login

  @wip
  Scenario: Login with blank username and password
    When the user does not enter username and password
    Then message "Login and/or password are wrong." should be displayed
    And the user should not be able to login
