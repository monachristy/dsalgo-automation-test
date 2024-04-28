@LinkedList
Feature: Testing LinkedList page
		Background:
			Given The user is on Home page after logged in
			
		@TC_LinkedList_01
  	Scenario: The user is able to navigate to LinkedList page
		    Given The user is on home page
		    When The user clicks the "Get Started" button in LinkedList Panel
		    Then The user should be redirected to LinkedList page

		@TC_LinkedList_02
		Scenario: linked list
			 Given User is on linked list page 
			 When User clicks on the Introduction link  
			 Then User will see the Try here editor box
		
		@TC_LinkedList_03
		Scenario: Creating Linked List
			 Given User is now on linked list page 
			 When User clicks on the Creating Linked List 
			 Then User will see the Try here editor box and click
		
		@TC_LinkedList_04
		Scenario: Types of Linked List
			Given User is on the linked list page 
			When User clicks on the Types of Linked List
			Then User will click on Try here editor box 
		
		@TC_LinkedList_05
		Scenario: Implement Linked List in Python
			Given User is on the home page 
			When User clicks on the Linked List in Python
			Then User clicks on Try here editor box 
		
		@TC_LinkedList_06
		Scenario: Traversal
			Given User is on home page Linked list
			When User clicks on the Traversal link
			Then User will clicks on Try here editor box 
		
		@TC_LinkedList_07
		Scenario: Insertion 
			Given User is on Data structure Home page
			When User clicks on the Insertion link
			Then User click on Try here editor box 
		
		@TC_LinkedList_08  
		Scenario: Deletion
			 Given User is on home page 
			 When User clicks on the "Deletion" 
			 Then User click on Try here editor  
		
		@TC_LinkedList_09
		Scenario: Practice Questions
			 Given User is on home page of linked list
			 When User clicks on the Practice Questions 
			 Then User will see nothing on the page  
		
  