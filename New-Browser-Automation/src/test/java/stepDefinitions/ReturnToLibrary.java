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
public class ReturnToLibrary {
   
	@Then("^I open a title \"([^\"]*)\" on ProView$")
	public void i_open_a_title_on_ProView(String arg1) throws Throwable {
	    Helpers.get().enterText((WebPages.get().libraryHeader.search),arg1);
	    Helpers.get().clickOnElement(WebPages.get().titleHeader.searchTitleByTitle);
	    Helpers.get().clickOnElement(WebPages.get().titleHeader.titleName);
        Assert.assertEquals(Helpers.get().getText(WebPages.get().titleHeader.titleName),arg1);
	}

	@Then("^I verify alt tag and tool tip for Return to Library button$")
	public void i_verify_alt_tag_and_tool_tip_for_Return_to_Library_button() throws Throwable {
		Assert.assertEquals(Helpers.get().getTextByAttribute(WebPages.get().titleHeader.returnToLibraryButton,"alt"),"Return to library");
		Assert.assertEquals(Helpers.get().verifyToolTip(WebPages.get().titleHeader.returnToLibraryButton,"mattooltip","Return to library"),true);
	}

	@Then("^I click on Return to library button$")
	public void i_click_on_Return_to_library_button() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().titleHeader.returnToLibraryButton);
	}
}