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
Feature: Personal Details
  I want to add my Personal Details to the Web Browser

  
  Scenario: Personal Details
    Given Page is displaying the Details
    And Linker tag is shown
    When Fill all the details 
    And All the restrictions are there
    Then checking if next button is validating
    And All the fields get entered
And Going to the next page

  
  Scenario Outline: To validate Phone Number correct 
Given User has valid Phone Number
When User enters <PhoneC> and clicks on Next button
Then Popup not Occured

Examples: 
|PhoneC|
|7017460040|
|9810428816|
|9810459775|

Scenario Outline: To validate Phone Number Incorrect 
Given User has invalid Phone Number
When User enters <PhoneI> and clicks on Next button
Then Popup Occured

Examples: 
|PhoneI|
|2342412|
|34635234212412|
|6810459775|

Scenario Outline: To validate Email Correct
Given User has valid Email ID
When User enters <EmailC> and clicks on Next buttonC
Then Popup not Occured

Examples: 
|EmailC|
|abc@gmail.com|
|abc1@gmail.com|
|abc2@gmail.com|

Scenario Outline: To validate Email Incorrect
Given User has invalid Email ID
When User enters <EmailI> and clicks on Next button
Then Popup Occured

Examples: 
|EmailI|
|abcgmail.com|
|abc1@gmailcom|
|abc2gmailcom|