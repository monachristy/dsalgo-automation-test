@Graph
Feature: Testing Graph page
		Background:
			Given The user is on Home page after logged in
			
		@TC_Graph_01
  	Scenario: The user is able to navigate to Graph page
	    Given The user is on home page
	    When The user clicks the "Get Started" button in Graph Panel
	    Then The user should be redirected to Graph page

		@TC_Graph_02
		Scenario: The user is able to test all links in Graph page
			Given User enters the Graph page by clicking get started
			When User clicks the list of Graph links 
			And checking the try editor box