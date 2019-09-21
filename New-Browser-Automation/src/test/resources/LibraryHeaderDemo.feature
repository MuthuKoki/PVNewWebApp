@Demo_LH
Feature: Library_Header 

Background: 
	Given I launch the browser and Login to the application 
	


    
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


