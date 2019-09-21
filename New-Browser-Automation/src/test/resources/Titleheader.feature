@SanityTH
Feature: TitleHeader

Background: 
	Given I launch the browser and Login to the application
    
Scenario: TitleheaderFunctionalAndNavigationValidation

	Then I open a title "Automated PITA" on ProView
	And I verify all eight Title Header element present on the Title Header
	#1.Skip links 2.Return to Library 2.TOC icon 3.Search icon 4.Post it icon 5.Download icon 6.Share icon 7.History icon 8.Gear icon
	And I verify the presence of horizontal bar between the ,return to library and the TOC icon 
	Then I verify all eight Title Header element tool tip message
	And I verify all eight Title Header element have respective alt tag
	Then I verify all eight Title Header element tool tip message and atl tag are same
	When I press 2 times Tab key
	And I verify the presence of Skip Links,skip to title content and Skip to TOC links
	And I click on Return to library button
	And I verify Proview home page is displayed

