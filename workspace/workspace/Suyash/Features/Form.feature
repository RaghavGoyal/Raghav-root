@FunctionalTest
Feature: Email Registration 
 Email Registraion can be done with password and email values.
  

  @smokeTest
  Scenario: Successful email registration with valid mandatory values 
    Given Email Registration page open 
    When User enters valid password, confirm password and email 
    And User clicks on submit button
    Then User's email is registered 




