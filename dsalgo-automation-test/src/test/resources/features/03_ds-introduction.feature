@ds-introduction-page
Feature: Data Structures- Introduction Page
	
	Background:
           Given The user is on Home page after logged in
  
  @TC_DSIntro_01
  Scenario: Data Structures- Introduction Page navigation
    Given The user is on the DS Algo Home Page
    When The user clicks  Get Started button below the Data structures-Introduction
    Then The user should land in "Data Structures-Introduction" page
    
  @TC_DSIntro_02
  Scenario: Data Structure Home page
    Given The user is on the Data Structure Introduction Page
    When The user clicks Time Complexity link
    Then The user should be redirected to "Time Complexity"TC page
    
  @TC_DSIntro_03
  Scenario: Time Complexity Page
    Given The user is on the Time Complexity Page
    When The user clicks Try Here  button of Time Complexity page
    Then The user should be redirected to a page having an Python Editor with a url "https://dsportalapp.herokuapp.com/tryEditor"
    
  @TC_DSIntro_04
  Scenario:Python Editor
    Given The user is on the Python Editor
    When The user clicks the Run Button without entring the code in the Editor
    Then Nothing happens to the page and no error message is displayed
    
  @TC_DSIntro_05
  Scenario:Python Editor
    Given The user is on the Python Editor
    When The user write the invalid code in Editor and Click the Run Button
    Then The user should able to see an error message in alert window
    
 @TC_DSIntro_06
 Scenario:Python Editor
    Given The user is on the Python Editor
    When The user write the valid code in Editor and Click the Run Button
    Then The user should able to see output in the console
    
 @TC_DSIntro_07
 Scenario:Time Complexity Page
    Given The user is on the Time Complexity Page
    When The user clicks Practice Questions link	
    Then The user doesn't find any practice problems and the page is blank