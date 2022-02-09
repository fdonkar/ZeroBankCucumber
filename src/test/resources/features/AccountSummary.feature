Feature: Account summary page's tabs

  Background:
    Given the user is logged in

  Scenario: Get page title
    Then Account summary page should be displayed and have the title "Zero - Account Summary"


  Scenario: Verify account types
    Then Account summary page should be displayed and have the title "Zero - Account Summary"
    And Account summary page should have following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  @wip
  Scenario: Verify Credit Accounts table's columns
    Then Account summary page should be displayed and have the title "Zero - Account Summary"
    And Credit Accounts table should have following columns
      | Account     |
      | Credit Card |
      | Balance     |
