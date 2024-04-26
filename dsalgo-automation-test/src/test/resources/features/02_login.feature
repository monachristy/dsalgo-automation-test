@signin-page
Feature: DS Algo Sign in Page

	@TC_Login_01
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after leaving the "<username>" textbox and "<password>" textbox blank
    Then The error message "Please fill out this field." appears below Username textbox
  
  @TC_Login_02  
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering the "<username>" and leaves "<password>" textbox blank
    Then The error message "Please fill out this field." appears below Pwd textbox

	@TC_Login_03
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering the "<password>" only
    Then The error message "Please fill out this field." appears below Username textbox
    
  @TC_Login_04
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering invalid username and invalid password
    Then The user should able to see an error message "Invalid Username and Password".
    
  @TC_Login_05
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid username and invalid password
    Then The user should able to see an error message "Invalid Username and Password".
    
  @TC_Login_06
  Scenario: DS Algo Sign in Page validation
    Given The user is on the DS Algo Sign in Page
    When The user clicks login button after entering valid username and valid password
    Then The user should land in Data Structure Home Page
  
