@account_summary
Feature: Account Summary
  As a user when I login, the zero bank page title should display and should display the sub-accounts

  Scenario: Verify page title
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Account Summary" page
    And user verifies that page title is "Zero - Account Summary"

  Scenario: Verify subAccounts are displayed
    Given User is on the login page
    Then user logs in with valid credentials
    And user verifies that SubAccounts Displayed


    Scenario: Verify credit accounts subAccounts
      Given User is on the login page
      Then user logs in with valid credentials
      And user verifies that Credit account's sub Accounts are displayed