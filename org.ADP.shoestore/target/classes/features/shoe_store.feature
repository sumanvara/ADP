Feature: Submit Email for reminder


Scenario: To be reminded of upcoming shoe releases, User should be able to submit email address  

Given The User is on the Home Page of the application
And There should be an area to submit email address
When The user enters the email address 
|nick.pitroda@gmail.com|
And clicks on submit button
Then The user is displayed with a confirmation message. 