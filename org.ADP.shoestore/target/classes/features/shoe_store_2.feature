Feature: Monthly display of new releases
	

Scenario Outline: In order to view upcoming shoes being released every month
									As a user of the Shoe store I want to be able to visit a link for each month 
									and see the shoes being released
Given The User is on Home Page
When User clicks on "<Month>"
Then User should be navigated to Monthly display page
And Should display blurb of each shoe with price and image

Examples:
		|Month	 |
		|January |
    |February|
    |March	 |
    |April 	 |
    |May		 |
    |June		 |
    |July		 |
    |August	 |
    |September|
    |Octomber|
    |November|
    |December|
    
