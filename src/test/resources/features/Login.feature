
Feature: Users should be able to login

  Background:
    Given the user is on the login page
  @wip
  Scenario: Login with valid credentials
    When the user enters the valid username and password
    Then Account summary page should be displayed
