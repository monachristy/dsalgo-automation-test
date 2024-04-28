@Tree
Feature: Testing Tree page
		Background:
			Given The user is on Home page after logged in
			
		@TC_Tree_01
  	Scenario: The user is able to navigate to Tree page
	    Given The user is on home page
	    When The user clicks the "Get Started" button in Tree Panel
	    Then The user should be redirected to Tree page
			
		@TC_Tree_02
		Scenario: The user is able to test all links in Tree page
				Given The user is on tree page
				When User clicks the list of Tree links 
				And enters the list of Tree links and checking try editor box
				#Then User gives wrong code in try editor box





