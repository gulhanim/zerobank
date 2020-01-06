@account_navigation
Feature: Navigation to specific accounts in Accounts Activity


  Background:
    Given User is on the login page
    Then user logs in with valid credentials


  Scenario: Savings account redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account dropdown should have "Savings" selected

  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account dropdown should have "Brokerage" selected

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account dropdown should have "Checking" selected

  Scenario: Credit Card account redirect
    When the user clicks on "Credit card" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account dropdown should have "Credit Card" selected

  Scenario: Loan account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account dropdown should have "Loan" selected