@find_transaction
Feature: Find Transactions in Account Activity

  Background:
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Account Activity" page
    Given the user accesses the Find Transactions tab

  @find_transaction_1
  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06"
    And clicks search
    Then results should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the result should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06"
    And clicks search
    Then results should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the result table should only not contain transaction dated "2012-09-01"

  Scenario: Search description
    When the user enters description "ONLINE"
    And clicks search
    Then the result table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE"
    And clicks search
    Then the result table should only show descriptions containing "OFFICE"
    But result table should not show description containing "ONLINE"

  Scenario: Search description case insensitive
    When the user enters description "ONLINE"
    And clicks search
    Then the result table should only show descriptions containing "ONLINE"
    When the user enters description "online"
    And clicks search
    Then the result table should only show descriptions containing "ONLINE"

  Scenario: Type
    When clicks search
    Then result table should show at least one result under "Deposit"
    Then result table should show at least one result under "Withdrawal"
    When user selects type"Deposit"
    When clicks search
    Then result table should show at least one result under "Deposit"
    But result table should not show result under Withdrawal
    When user selects type"Withdrawal"
    When clicks search
    Then result table should show at least one result under "Withdrawal"
    But result table should not show result under Deposit

