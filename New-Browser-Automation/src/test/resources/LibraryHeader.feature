@SanityLH
Feature: Library_Header 

Background: 
	Given I launch the browser and Login to the application 
	
Scenario: LibraryHeader_FunctionalValidation
	And I verify the contents of the Library Header is displayed
	#TR logo, Library ,eLooseleaf, History icon ,Notification ,Account menu
    And I verify the tool tip for Library header icons,Recent activity,Notifications,Account menu

Scenario: LibraryHeader_SkipNavigationWith_TabKeys

	Given I am on URL of browser
	And I press 2 times Tab key
	Then I verify Skip to main content- and and Skip to filter option displayed.
	Then I press 1 times Tab key
	Then I verify Skip to filter content highlighted

Scenario: LibraryHeader_ThomsonreutersLogo_FunctionValidation

	When I click on TR logo
	Then I verify i navigated to library page and page should be refreshed
	And  I clicked library tab and click on Thomson Reuters Logo
	Then I verify  library tab is selected
	And I clicked eLooseleaf tab and click on Thomson Reuters Logo
 	Then I verify  eLooseleaf tab is selected
 	And I clicked on eLooseleaf tab
 	Then I verify library containing only eLooseleaf titles
    
Scenario: LibraryHeader_AccountMenu_FunctionalValidation

	When I click the Account menu icon
	Then I see Account menu panel displayed
	And I click on outside of Account menu,account menu is closed
	When I click the Account menu icon
	And I click on Notification icon on header, account menu is closed
    
Scenario: LibraryHeader_historyMenu_NotificationPanel_FunctionValidation

	When I click the history menu icon
 	Then I see history menu panel displayed
 	When I click the history menu icon
 	Then I see history menu panel hides
 	When I click the Notification icon
 	#Notification panel is not opening
 	#Then I see Notification icon panel displayed
 	#When I click on outside of Notification icon.
	#Then I see Notification icon panel hides

Scenario: LibraryHeader_AccountMenu_LocalizationForSupportedlanguage

	When I click the Account menu icon
	Then I see Account menu panel displayed
	When I clicked on Language item
	Then I verify all the supported languages list on language panel

Scenario: LibraryHeader_KeyboardNavigationValidation

	Given I am on URL of browser
	When I press 6 times Tab key
	Then I press enter key
	Then I see eLooseleaf getting highlighted
	When Each time I press Tab key and other content getting in focused state
	#like TR logo, Library ,eLooseleaf, History icon ,Notification ,Account menu
	
Scenario:  eLooseleaf_FunctionalValidation
	Then I Verify the eLooseleaf library is sorted by default by subject
  Then I Verify the titles shown is populated in secondary header for elooseleaf
  And I Verify sort functionality on eLooseleaf
  Then I Verify persistent behavior of sort functionality on eLooseleaf
Scenario:  eLooseleaf_option_doesn't_appear_for_the_user_with_no_ereference_type_titles
	Then I log-out from the proview app
	And I login just after logout with username "Uslegal_Titles" and password "Uslegal/All"
  Then I should not see eLooseleaf option

