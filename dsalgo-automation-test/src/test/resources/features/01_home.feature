@home-page
Feature: Automate the introduction page

	@TC_Home_01
  Scenario: Browser
    Given The user should be open the browser
    When The user enter the DS_Algo Portal <URL>
    Then The user should landed on the DS_Algo Get Started page with message "You are at the right place"
  
  @TC_Home_02  
  Scenario: DS Algo Get Started page
    Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the "Get Started" button
    Then The user should land in Data Structure Introduction Page with "Register" and "Sign in" links

	@TC_Home_03
  Scenario: DS Introduction page
    Given The user should open the DS Algo Portal URL in any supported browser
    When The user clicks the data structure"dropdown  arrow"
    Then The user should able to see 6 options Arrays "Linked,List,Stack,Queue,Tree,Graph" in dropdown menu
  
  @TC_Home_04  
  Scenario: DS Introduction page
    Given The user is on the DS Introduction page
    When The user selects any data structures item from the drop down without Sign in.
    Then The user should able to see an warning message "You are not logged in"  
    
  @TC_Home_05
  Scenario: DS Introduction page
    Given The user is on the DS Introduction page
    When The user clicks any "Get Started" buttons of data structures  on the DS Introduction page
    Then The user should able to see an warning message "You are not logged in"

	@TC_Home_06
  Scenario: DS Introduction page
    Given The user is on the DS Introduction page
    When The user clicks "Register" link on the DS Introduction page
    Then The user should be redirected to Register form	
    And The user should able see message "Login"at the bottom of the page
	 				
   