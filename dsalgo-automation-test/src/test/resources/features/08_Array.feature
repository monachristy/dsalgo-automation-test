@Array
Feature: Testing Array page
		Background:
			Given The user is on Home page after logged in
			
		@TC_Array_01
  	Scenario: The user is able to navigate to Array page
	    Given The user is on home page
	    When The user clicks the "Get Started" button in Array Panel
	    Then The user should be redirected to Array page

		Scenario: Arrays in Python
			Given user is on the array page
			When User clicks on the link Arrays in Python 
			Then user will see try here editor box

		Scenario: Arrays Using List
			Given User should be on the array page 
			When User clicks on the link Arrays Using List
			Then user will see try here editor box and click on it

		Scenario: Basic Operations in List
			Given The array page on the app
			When User clicks on the link Basic Operations in List
			Then User will click on try here box

		Scenario: Applications of Array 
			Given User should be landing on array page 
			When User clicks on the link Applications of Array
			Then User will click on try here editor box 

		Scenario: Practice questions 
			Given User is at array page 
			When User clicks on the link Practice questions
			Then User click on try here editor box 