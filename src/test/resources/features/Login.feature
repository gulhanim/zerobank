Feature: Login
  Only authorized users	should be able to login	to the application
  ,When user logs-in with valid credentials, Account summary page should be displayed.
@login_page_valid
  Scenario: User logs in with valid credentials
    Given User is on the login page
    Then user logs in with valid credentials
    And user verifies that "Account Summary" page is displayed
  @login_page_valid
  Scenario: User should not be able to log in with invalid credentials
    Given User is on the login page
    Then user enters invalid "invalid" and "invalid" credentials and verifies "Login and/or password are wrong." message

  @login_page_valid
  Scenario: User should not be able to log in with empty credentials
    Given User is on the login page
    Then user enters invalid "username" and "" credentials and verifies "Login and/or password are wrong." message
