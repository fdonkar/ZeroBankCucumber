Feature: Pay Bills page's tabs

  Background:
    Given the user is logged in
    When the user clicks on Pay Bills Page

  Scenario: Get page title
    Then Pay Bills page should be displayed and have the title "Zero - Pay Bills"

  Scenario: Verify Pay Saved Payee function is working
    When the user select payee and accounts and enters value for amount, date, and description
    And clicks on pay button
    Then warning message "The payment was successfully submitted." should be displayed


  Scenario: Verify the user should not be able to pay without entering amount
    When the user select payee and accounts and enters value for date and description only
    And clicks on pay button
    Then the user should not be able to pay and "Please fill out this field." should be displayed for amount

  @wip
  Scenario: Verify the user should not be able to pay without entering date
    When the user select payee and accounts and enters value for amount and description only
    And clicks on pay button
    Then the user should not be able to pay and "Please fill out this field." should be displayed for date