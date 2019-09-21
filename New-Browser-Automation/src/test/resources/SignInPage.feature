@SanitySI
Feature: SignInPage

Background:

    When I launches a browser and enter the ProView URL in browser's address bar
    
Scenario: SignIn_ProView_OnePass_Sign_In_page_object_validation

 	Then I verify all element on sign-in Page
 					#All below elements are covered in above steps
 	             	#Link - Sign in With IP Access is displayed
 					#Link - Forgot username  is displayed
   					#Link - Forgot password  is displayed
    				#Link - Add registration key  is displayed
				    #Link - Create One Pass profile  is displayed
 				    # Link - Update One Pass profile is displayed
 				    #Text box Username, password are displayed
 				    # all four checkboxes: Show, Save username, Save username and password, Remember me displayed
                    #sign-in button displayed
                    # language drop down is displayed with all supported language
                    #country contact support link
                    #Link - Privacy is displayed
                    #Link - Terms and Conditions  is displayed
    Then I sign-in on ProView using username and password
    And I verify Proview home page is displayed
    
Scenario: SignIn_using_blank_username_and_password
    
    Then I click on signIn button
    And I verify error message Enter a username
    And I verify error message Enter a password
    
Scenario: SignIn_error_message_Validation

    Then I enter invalid username
    And I enter invalid password name
    And I click on signIn button
    Then I verify error message We don't recognize that username and/or password
    
Scenario: SignIn_verify_once_logged_in_Clicking_back_button_doesnot_logout_the_user

	Then I sign-in on ProView using username and password
	And  I click on Browser Back button
	And  I click on Browser Refresh button
	And  I click on  Browser Forward button
	Then I Click any Proview Logo on home page
	
Scenario: SignIn_Forgot_UserName_PasswordLinkValidation
    
    When I click on Forgot username link
    Then I should navigate to the forgot username recovery page
    Then I click browser back button
    Then I click on Forgot password link
    Then I should navigate to the forgot password recovery page
        
    
    