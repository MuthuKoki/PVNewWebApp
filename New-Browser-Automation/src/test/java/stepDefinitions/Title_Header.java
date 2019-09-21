package stepDefinitions;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import Framework.Driver;
import Framework.Helpers;
import Framework.Loggers;
import Pages.WebPages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
@SuppressWarnings("unused")
public class Title_Header {
  

	@Then("^I verify all eight Title Header element present on the Title Header$")
	public void i_verify_all_eight_Title_Header_element_present_on_the_Title_Header() throws Throwable {
		
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.returnToLibraryButton),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.tocIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.viewAnnotationIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.downloadTitleIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.createLinkIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.recentActivityIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.settingsMenuIcon),true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.openSearchInTitleIcon),true);

	}

	@Then("^I verify the presence of horizontal bar between the ,return to library and the TOC icon$")
	public void i_verify_the_presence_of_horizontal_bar_between_the_return_to_library_and_the_TOC_icon() throws Throwable {
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().titleHeader.iconDivider),true);
	}

	@Then("^I verify all eight Title Header element tool tip message$")
	public void i_verify_all_eight_Title_Header_element_tool_tip_message() throws Throwable {
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.returnToLibraryButton,"mattooltip","Return to library"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.tocIcon,"mattooltip","Open table of contents"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.viewAnnotationIcon,"mattooltip","View annotations"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.downloadTitleIcon,"mattooltip","Download Title"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.createLinkIcon,"mattooltip","Create Link"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.recentActivityIcon,"mattooltip","Open Recent Activity"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.settingsMenuIcon,"mattooltip","Open Settings Menu"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.openSearchInTitleIcon,"mattooltip","Open search"),true);
		
	}

	@Then("^I verify all eight Title Header element have respective alt tag$")
	public void i_verify_all_eight_Title_Header_element_have_respective_alt_tag() throws Throwable {
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.returnToLibraryButton,"alt"),"Return to library");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.tocIcon,"alt"),"Open table of contents");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.viewAnnotationIcon,"alt"),"View annotations");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.downloadTitleIcon,"alt"),"Download Title");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.createLinkIcon,"alt"),"Create Link");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.recentActivityIcon,"alt"),"Open Recent Activity");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.settingsMenuIcon,"alt"),"Open Settings Menu");
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.openSearchInTitleIcon,"alt"),"Open search");
	}

	@Then("^I verify all eight Title Header element tool tip message and atl tag are same$")
	public void i_verify_all_eight_Title_Header_element_tool_tip_message_and_atl_tag_are_same() throws Throwable {
		By returnLibrary=WebPages.get().titleHeader.returnToLibraryButton;
		By toc=WebPages.get().titleHeader.tocIcon;
		By anno=WebPages.get().titleHeader.viewAnnotationIcon;
		By downloadT=WebPages.get().titleHeader.downloadTitleIcon;
		By cLink=WebPages.get().titleHeader.createLinkIcon;
		By history=WebPages.get().titleHeader.recentActivityIcon;
		By setting=WebPages.get().titleHeader.settingsMenuIcon;
		By search=WebPages.get().titleHeader.openSearchInTitleIcon;
		Assert.assertEquals(Helpers.get().getTextByAttribute(returnLibrary,"alt"),Helpers.get().getTextByAttribute(returnLibrary,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(toc,"alt"),Helpers.get().getTextByAttribute(toc,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(anno,"alt"),Helpers.get().getTextByAttribute(anno,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(cLink,"alt"),Helpers.get().getTextByAttribute(cLink,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(downloadT,"alt"),Helpers.get().getTextByAttribute(downloadT,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(history,"alt"),Helpers.get().getTextByAttribute(history,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(setting,"alt"),Helpers.get().getTextByAttribute(setting,"mattooltip"));
		Assert.assertEquals(Helpers.get().getTextByAttribute(search,"alt"),Helpers.get().getTextByAttribute(search,"mattooltip"));
	}

	@Then("^I verify the presence of Skip Links,skip to title content and Skip to TOC links$")
	public void i_verify_the_presence_of_Skip_Links_skip_to_title_content_and_Skip_to_TOC_links() throws Throwable {
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.skipToMainContent), true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.skipToFilter), true);
	}
}