Feature: Pay Bills page's tabs

  Background:
    Given the user is logged in
    When the user clicks on Pay Bills Page

  Scenario: Get page title
    Then Pay Bills page should be displayed and have the title "Zero - Pay Bills"

  @wip
  Scenario: Verify Pay Saved Payee function is working
    When the user select payee and accounts and enters value for amount, date, and description
    And clicks on pay button
    Then warning message "The payment was successfully submitted." should be displayed