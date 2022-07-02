Feature: User registration

Scenario: Successful user registration with valid  mandatory values
Given User Registartion page is open
When User enters username,password and other details 
And User clicks on Submit button
Then User is registered