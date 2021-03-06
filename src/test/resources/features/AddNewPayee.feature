Feature: Add new payee under pay bills

  Scenario: Add a new page
    Given the user is logged in
    And the user accesses Pay Bills page
    And Add New Payee tab
    When creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed
