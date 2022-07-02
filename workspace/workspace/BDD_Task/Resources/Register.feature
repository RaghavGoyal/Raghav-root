Feature: Login Page
Description: On enetering the valid data in the input fields the user should be logged in

Scenario: Successful User registeration with valid mandatory values
Given User Registartion page is open
When User enters username,password and other details 
And User clicks on Submit button
Then User is registered