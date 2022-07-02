#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@FunctionalTest
Feature: Email registeration
Email registeration can be done with password, confirm password and email values.


  @smokeTest
  Scenario: Successful email registeration with valid mandatory values
    Given Email registeration page is open
    When user enters valid password,confirm password and email
    And user clicks on submit button
    Then user's email is registered