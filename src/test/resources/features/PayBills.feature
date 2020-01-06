Feature: Pay bills
  As a user I should be able to pay bills with valid credentials under the Pay Bills sub-module
  @pay_bills
  Scenario: Verify page title
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Pay Bills" page
    Then user verifies that page title is "Zero - Pay Bills"
  @pay_bills
    Scenario: user verifies successful payment message
      Given User is on the login page
      Then user logs in with valid credentials
      And user navigates to "Pay Bills" page
      And user enter payment amount"12" dollars and date:"2020-01-02" and clicks pay button
    Then user verifies that "The payment was successfully submitted." message is displayed

  @pay_bills
  Scenario: user verifies fill fields alert
    Given User is on the login page
    Then user logs in with valid credentials
    And user navigates to "Pay Bills" page
    And user enter payment amount"" dollars and date:"" and clicks pay button
    Then user verifies "Please fill out this field." alert is displayed