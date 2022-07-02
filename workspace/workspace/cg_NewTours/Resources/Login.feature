Feature: Login
Description: To check login functionality of NewTours page.

Scenario: To check login page has 2 text boxes as userName and Password and 2 buttons- Ok and Cancel.

Given: Login page is loaded
And user has valid credentials.
But user is not already logged in.

When the user validates visibility of userName and Password textboxes and OK and Cancel buttons

Then userName and Password textboxes and Ok and Cancel buttons are there on the login page




Scenario Outline: To validate successful login with valid values
Given: user has valid set of credentials.
When user enters <uName> and <password>
And clicks on Ok button.
Then user should be successfully logged in
And userName should be displayed on the page.


Examples:
|uName|password|
|mars|mars|
|mercury|mercury|
|asdfg12345|GLBajaj|
|earth|earth|


Scenario Outline: to validate login denied with invalid userName and valid password
Given: user has an invalid userNameand valid password.
When user enters <usrName> and <password>
And clicks on ok button.
Then user should be denied login
And login page should be reloaded.
 
 Expmles:
 |usrName|password|
 |qw23|GLBajaj|
 |asdfgh12345|GLBajaj|
 |   |GLBajaj|
 
