Feature: Account activity
  As a user I should be able to navigate to account activity page and verify title and sub modules.
  @account_activity
  Scenario: Verify account title
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Account Activity" page
    And user verifies that page title is "Zero - Account Activity"

  @account_activitya
    Scenario: Verify dropdown menu's default value
      Given User is on the login page
      Then user logs in with valid credentials
    And user navigates to "Account Activity" page
      When Account dropdown should have "Savings" selected
  @account_activity
  Scenario: Verify dropdown menu's default value
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Account Activity" page
    Then user verifies that dropdown menu has the following options
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
  @account_activity
  Scenario: Verify column names
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Account Activity" page
    Then user verifies that transactions table column names are
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
