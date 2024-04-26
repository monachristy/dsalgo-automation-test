Feature: feature to test navigation for Queue
 Background:
      Given The user is on Home page after logged in
   
 @TC_Queue_01
 Scenario: Navigate to queue page after login/home page
     When The user clicks the Getting Started button in Queue page
     Then The user should be directed to Queue page
 
 @TC_Queue_02 
 Scenario: Navigation to Implementaion of Queue in Python page
     Given user is on Queue page
     When user clicks on Implementation of Queue in Python link
     Then user should navigate to Implimentaion of Queue in Python page
   
 @TC_Queue_03
 Scenario: Navigation to Editor page from Queue in Python page
     Given user is on Implementaion of Queue in Python page
     When user clicks on button Try here 
     Then user is navigated to a page having TryEditor with a Run button
             
 @TC_Queue_04         
 Scenario Outline: The user is able run code in tryEditor for Implementation of Queue in Python page
	  Given The user clicks "Try here>>>" button on Implementation of Queue in Python page
		When The user is enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
	  Then The user clicks on run button and should be presented with Run result
	  Examples: 
	  	| Sheetname  | RowNumber |
	  	| PythonCode |         1|
    
 @TC_Queue_05
 Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Implementation of Queue in Python page
    Given The user clicks "Try here>>>" button on Implementation of Queue in Python page
    When The user is enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber>
    Then The user clicks on run button and should be presented with error result
    
 Examples: 
    | Sheetname  | RowNumber |
    | PythonCode |         5|
      
 @TC_Queue_06
 Scenario: Navigation to Implementation using collections.deque page
	   Given user is on Queue page
	   When user clicks on Implementation using collections.deque link
	   Then user should navigate to Implementation using collections.deque page
   
 @TC_Queue_07
 Scenario Outline: Navigation to Editor page from Implementation using collections.deque page
    Given The user clicks "Try here>>>" button on collections.deque page
		When The user is enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
	  Then The user clicks on run button and should be presented with Run result
	  Examples: 
	  	| Sheetname  | RowNumber |
	  	| PythonCode |         1|
                         
 @TC_Queue_08        
 Scenario: Navigation to Implementation using array page
    Given user is on Queue page
    And user clicks on Implementation using array link
    Then user should navigate to Implementation using array page
   
 @TC_Queue_09
 Scenario Outline: Navigation to Editor page from Implementation using array page
    Given The user clicks "Try here>>>" button on Implementation using array page
		When The user is enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
	  Then The user clicks on run button and should be presented with Run result
	  Examples: 
	  	| Sheetname  | RowNumber |
	  	| PythonCode |         1|
 
 @TC_Queue_10        
 Scenario: Navigation to Queue Operations page
     Given user is on Queue page
     And user clicks on Queue Operations link
     Then user should navigate to Queue Operations page

 @TC_Queue_11   
 Scenario Outline: Navigation to Editor page from Queue Operations page
     Given The user clicks "Try here>>>" button on Queue Operations page
		When The user is enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
	  Then The user clicks on run button and should be presented with Run result
	  Examples: 
	  	| Sheetname  | RowNumber |
	  	| PythonCode |         1|
 
      
 @TC_Queue_12
 Scenario: Navigation to Practice Questions page
     Given user is on Queue Operations page
     And user clicks on Practice Questions link
     Then user should navigate to Practice Questions page 
