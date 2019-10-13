Feature: Free CRM Login Feature 


#without Examples Keyword
Scenario: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user enters "9000370275" and "Dinesh123@"
Then user clicks on login button
Then user is on home page
Then close the browser


		