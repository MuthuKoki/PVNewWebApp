@SanityRL
Feature: RerturnToLibrary

Background: 
	Given I launch the browser and Login to the application
    
Scenario: ReturnToLibraryFunctionalAndNavigationValidation

	Then I open a title "Automated PITA" on ProView
	And I verify alt tag and tool tip for Return to Library button
	And I click on Return to library button
	And I verify Proview home page is displayed
	Then I open a title "Automated PITA" on ProView
	When I press 3 times Tab key
	Then I press enter key
	And I verify Proview home page is displayed
	