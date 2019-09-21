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
public class Library_Header {
   
	@Given("^I launch the browser and Login to the application$")
	public void i_launch_the_browser_and_Login_to_the_application() throws Throwable {
		Helpers.get().launchNewProview();
	    Loggers.get().INFO("Signing-IN");
	    WebPages.get().signin.sign_in();
	    //Helpers.get().ScroolToDown(WebPages.get().libraryHeader.footerLogo);
	   // Helpers.get().clickOnElement(WebPages.get().signin.cookies_AcceptButtom_xpath);

	}

	@Given("^I verify the contents of the Library Header is displayed$")
	public void i_verify_the_contents_of_the_Library_Header_is_displayed() throws Throwable {
		 Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.history),true);
         Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.proViewLogo),true);
         Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.notifications),true);
         Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.search),true);
         Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.elooseleaf),true);
         /**
     	 * Click on Library button to test , the text is display for Library
     	 */
         Helpers.get().clickOnElement(WebPages.get().libraryHeader.library);
         Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.librarytext);
         Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"Library");
         
         /**
      	 * Click on elooseleaf button to verify , the text is display for elooseleaf
      	 */
         Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
         Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.librarytext);
         Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"eLooseleaf");

	}

	@Given("^I verify that with mouse hover on library icons,button and link gets highlighted$")
	public void i_verify_that_with_mouse_hover_on_library_icons_button_and_link_gets_highlighted() throws Throwable {
		
	}

	@Given("^I verify the tool tip for Library header icons,Recent activity,Notifications,Account menu$")
	public void i_verify_the_tool_tip_for_Library_header_icons_Recent_activity_Notifications_Account_menu() throws Throwable {
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().libraryHeader.history,"mattooltip","History"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().libraryHeader.notifications,"mattooltip","Notifications"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().signin.homePage,"mattooltip","Account settings and sign out"),true);
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().libraryHeader.proviewLogoImg,"mattooltip","Thomson Reuters ProView"),true);

	}

	@Given("^I am on URL of browser$")
	public void i_am_on_URL_of_browser() throws Throwable {
	}

	@Then("^I verify Skip to main content- and and Skip to filter option displayed\\.$")
	public void i_verify_Skip_to_main_content_and_and_Skip_to_filter_option_displayed() throws Throwable {
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.skipToMainContent), true);
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.skipToFilter), true);
	}

	@Then("^I verify Skip to filter content highlighted$")
	public void i_verify_Skip_to_filter_content_highlighted() throws Throwable {


	}

	@When("^I click on TR logo$")
	public void i_click_on_TR_logo() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.proviewLogoImg);
	}

	@Then("^I verify i navigated to library page and page should be refreshed$")
	public void i_verify_i_navigated_to_library_page_and_page_should_be_refreshed() throws Throwable {
		Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.homePage), true);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.titleShown).contains("Titles shown"),true);
	}

	@Then("^I clicked library tab and click on Thomson Reuters Logo$")
	public void i_clicked_library_tab_and_click_on_Thomson_Reuters_Logo() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.library);
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.proviewLogoImg);
	}

	@Then("^I verify  library tab is selected$")
	public void i_verify_library_tab_is_selected() throws Throwable {
        Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.librarytext);
        Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"Library");
	}

	@Then("^I clicked eLooseleaf tab and click on Thomson Reuters Logo$")
	public void i_clicked_eLooseleaf_tab_and_click_on_Thomson_Reuters_Logo() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.proviewLogoImg);
	}

	@Then("^I verify  eLooseleaf tab is selected$")
	public void i_verify_eLooseleaf_tab_is_selected() throws Throwable {
		Thread.sleep(10000);
        Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"eLooseleaf");

	}

	@Then("^I clicked on eLooseleaf tab$")
	public void i_clicked_on_eLooseleaf_tab() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
	}

	@Then("^I verify library containing only eLooseleaf titles$")
	public void i_verify_library_containing_only_eLooseleaf_titles() throws Throwable {
        Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
        Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.librarytext);
        Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"eLooseleaf");
	}

	@When("^I click the Account menu icon$")
	public void i_click_the_Account_menu_icon() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().signin.homePage);
	}

	@Then("^I see Account menu panel displayed$")
	public void i_see_Account_menu_panel_displayed() throws Throwable {
		Assert.assertEquals(Driver.get().findElement(WebPages.get().libraryHeader.accountLanguage).isDisplayed(),true);
	}

	@Then("^I click on outside of Account menu,account menu is closed$")
	public void i_click_on_outside_of_Account_menu_account_menu_is_closed() throws Throwable {
		Helpers.get().clickElementByJS(WebPages.get().libraryHeader.search);
		Helpers.get().clickOnElementUsingMouse(WebPages.get().libraryHeader.search);
		Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.accountLanguage);
	}

	@When("^I click on Notification icon on header, account menu is closed$")
	public void i_click_on_Notification_icon_on_header_account_menu_is_closed() throws Throwable {
		Helpers.get().clickOnElementUsingMouse(WebPages.get().libraryHeader.notifications);
		Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.accountLanguage);
	}

	@When("^I click the history menu icon$")
	public void i_click_the_history_menu_icon() throws Throwable {
		Helpers.get().clickOnElementUsingMouse(WebPages.get().libraryHeader.history);
	}

	@Then("^I see history menu panel displayed$")
	public void i_see_history_menu_panel_displayed() throws Throwable {
		Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.historyPanel);
	}

	@Then("^I see history menu panel hides$")
	public void i_see_history_menu_panel_hides() throws Throwable {
		Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.historyPanel);	
	}

	@When("^I click the Notification icon$")
	public void i_click_the_Notification_icon() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.notifications);
	}

	@When("^I click on outside of Notification icon\\.$")
	public void i_click_on_outside_of_Notification_icon() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.history);
	}

	@Then("^I see Notification icon panel hides$")
	public void i_see_Notification_icon_panel_hides() throws Throwable {


	}

	@When("^I press (\\d+) times Tab key$")
	public void i_press_times_Tab_key(int arg1) throws Throwable {
		Helpers.get().clickOnTabKeyUsingSel(arg1);
	}
	@When("^I press enter key$")
	public void i_press_enter_key() throws Throwable {
		Helpers.get().clickOnEnterKeyUsingSel(1);

	}
	@Then("^I see eLooseleaf getting highlighted$")
	public void i_see_eLooseleaf_getting_highlighted() throws Throwable {
		Thread.sleep(10000);
        Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.librarytext);
        Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.librarytext),"eLooseleaf");

	}

	@When("^Each time I press Tab key and other content getting in focused state$")
	public void each_time_i_press_Tab_key_and_other_content_getting_in_focused_state() throws Throwable {
		Helpers.get().clickOnTabKeyUsingSel(1);
		Helpers.get().clickOnEnterKeyUsingSel(1);
		Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.historyPanel);
		Helpers.get().clickOnEnterKeyUsingSel(1);
		Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.historyPanel);
		Helpers.get().clickOnTabKeyUsingSel(2);
		Helpers.get().clickOnEnterKeyUsingSel(1);
		Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.accountLanguage);
		Helpers.get().clickOnEnterKeyUsingSel(1);
		Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.accountLanguage);
	}

	@When("^I clicked on Language item$")
	public void i_clicked_on_Language_item() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.accountLanguage);
	}


	@Then("^I verify all the supported languages list on language panel$")
	public void i_verify_all_the_supported_languages_list_on_language_panel() throws Throwable {
		String[] expected = {"English - UK", "English - US", "Français", "Español", "Português", "한국어", "Русский","Türk"};
		List<WebElement> allOptions = Driver.get().findElements(By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li"));
		Loggers.get().INFO("Expected Language length: "+ expected.length);
		Loggers.get().INFO("Actual Language length: "+ allOptions.size());
		if (expected.length != allOptions.size()) {
		    System.out.println("fail, wrong number of elements found");
		}
		for (int i = 0; i < expected.length; i++) {
			System.out.println(allOptions.get(i).getText());
		    String optionValue = allOptions.get(i).getText();
		    if (optionValue.trim().equals(expected[i])) {
		        System.out.println("passed on: " + optionValue);
		    } else {
		        System.out.println("failed on: " + optionValue);
		        Assert.assertFalse(true);
		    }
		}

	}
	
	@Then("^I Verify the eLooseleaf library is sorted by default by subject$")
	public void i_Verify_the_eLooseleaf_library_is_sorted_by_default_by_subject() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library), "Subject");
	    System.out.println(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library));
	}
	@Then("^I Verify the titles shown is populated in secondary header for elooseleaf$")
	public void i_Verify_the_titles_shown_is_populated_in_secondary_header_for_elooseleaf() throws Throwable {
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.titleShown),"Titles shown: ");
	}
	
	@Then("^I Verify sort functionality on eLooseleaf$")
	public void i_Verify_sort_functionality_on_eLooseleaf() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
		System.out.println(WebPages.get().libraryHeader.elooseleaf);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library), "Subject");
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.library);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library), "Title");
		
	}
	@Then("^I Verify persistent behavior of sort functionality on eLooseleaf$")
	public void i_Verify_persistent_behavior_of_sort_functionality_on_eLooseleaf() throws Throwable {
		System.out.println("I Verify persistent behavior of sort functionality on eLooseleaf");
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.default_Sort_Library);
		System.out.println("click on drop down");
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.Sort_Library_jurisdiction);
		System.out.println(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library));
		Thread.sleep(6000);
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.library);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library), "Title");
		Helpers.get().clickOnElement(WebPages.get().libraryHeader.elooseleaf);
		Assert.assertEquals(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library), "Jurisdiction");
		System.out.println(Helpers.get().getText(WebPages.get().libraryHeader.default_Sort_Library));
	}
    
	@Then("^I should not see eLooseleaf option$")
	public void i_should_not_see_eLooseleaf_option() throws Throwable {
	   Helpers.get().ValidateNonExistenceOfElement(WebPages.get().libraryHeader.elooseleaf);
	}

}