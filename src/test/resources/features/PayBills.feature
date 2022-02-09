Feature: Pay Bills page's tabs

  Background:
    Given the user is logged in
    When the user clicks on Pay Bills Page
  @wip
  Scenario: Get page title
    Then Pay Bills page should be displayed and have the title "Zero - Pay Bills"