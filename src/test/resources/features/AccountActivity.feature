Feature: Account activity page's tabs

  Background:
    Given the user is logged in
    When the user clicks on Account Activity Page

  Scenario: Get page title
    Then Account activity page should be displayed and have the title "Zero - Account Activity"

  Scenario: Verify Account dropdown default option
    Then Account activity page should be displayed and have the title "Zero - Account Activity"
    And Account	drop down should have "Savings" selected

  Scenario: Verify Account dropdown options
    Then Account activity page should be displayed and have the title "Zero - Account Activity"
    And Account dropdown should have following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Verify Transaction table's column names
    Then Account activity page should be displayed and have the title "Zero - Account Activity"
    And Transactions table should have following columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
