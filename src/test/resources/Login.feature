Feature: Login
  Scenario: User logs in with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks on login button
    Then User should be redirected to the products page

  Scenario: User cannot log in with invalid credentials
    Given User is on the login page
    When User enters invalid username and password
    And User clicks on login button
    Then User should see an error message

  Scenario: User cannot log in with invalid password
    Given User is on the login page
    When User enters username and invalid password
    And User clicks on login button
    Then User should see an error message

    Scenario: User Logout
      Given User is on the login page
      When User enters valid username and password
      And User clicks on login button
      And User on dashboard
      And User Logout
      Then User success logout