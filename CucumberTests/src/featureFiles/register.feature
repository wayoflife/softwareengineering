Feature: register
  
  As an unregistered user
  I want to register an account
  so that I can use the website

  @Runme
  Scenario: enter correct details and register
    Given I am not registered
    And I am on the "Registrieren" page
    When I enter my "email@web.de" in the field "Email"
    And I enter my "daniel" in the field "FirstName"
    And I enter my "betsche" in the field "SecondName"
    And I enter my "password" in the field "Password"
    And I enter my "password" in the field "Password2"
    And I enter my "22.05.1989" in the field "Geburtstag"
    And I accept the "Nutzungsbedingungen" by checking the checkbox
    And I press the "Registrieren" button
    Then my "userdata" will be created
    And I will receive and email
    And I will be logged into the website

  Scenario: enter correct details and register
    Given I am not registered
    And I am on the "Registrieren" page
    When I enter my "email@web.de" in the field "Email"
    And I enter my "daniel" in the field "FirstName"
    And I enter my "betsche" in the field "SecondName"
    And I enter my "password" in the field "Password"
    And I enter my "password" in the field "Password2"
    And I enter my "22.05.1989" in the field "Geburtstag"
    And I accept the "Nutzungsbedingungen" by checking the checkbox
    And I press the "Registrieren" button
    And one of them is wrong
    Then I will receive an error message to check my input
