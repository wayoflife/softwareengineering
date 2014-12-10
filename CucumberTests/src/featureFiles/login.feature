Feature: login
  
  As a registered user
  I want to log in to my account
  so that I can use the website

  Scenario: enter correct details and login
    Given I am not logged in
    And I am on the "Login" page
    When I enter "dbetsche@gmail.com" in the field "Email"
    And I enter "daniel" in the field "Password"
    And I press the "Anmelden" button
    Then I am on the "Main" page

  Scenario: enter correct details and login
    Given I am not logged in
    And I am on the "Login" page
    When I enter "dbetsche@gmail.com" in the field "Email"
    And I enter "falsch" in the field "Password"
    And I press the "Anmelden" button
    And I receive a "error" message
