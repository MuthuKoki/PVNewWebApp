package stepDefinitions;
import org.testng.Assert;
import Framework.Driver;
import Framework.Helpers;
import Framework.Loggers;
import Framework.UtilityHelper;
import Pages.WebPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
@SuppressWarnings("static-access")
public class SignIn{
	
	@When("^I launches a browser and enter the ProView URL in browser's address bar$")
    public void i_launches_a_browser_and_enter_the_ProView_URL_in_browser_s_address_bar() throws Throwable {
    	Helpers.get().launchNewProview();
		Loggers.get().INFO("Browser Launched with proview URL");
    }
	
	@Then("^I verify all element on sign-in Page$")
	public void i_verify_all_element_on_sign_in_Page() throws Throwable {

          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.signin_name));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.password_name));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.signin_name));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.saveUsername));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.saveUsernamePassword));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.forgotPassword));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.forgotUsername));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.addRegistrationKey));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.createOnePassProfile));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.updateOnePassProfile));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.privacy));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.remenberMe));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.showPassword));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.proviewTechnicalSupportbyCountryLink));
          Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.termAndCondition));

	}

	@Then("^I sign-in on ProView using username and password$")
	public void i_sign_in_on_ProView_using_username_and_password() throws Throwable {
		WebPages.get().signin.sign_in();
	}
	@Then("^I log-out from the proview app$")
	public void i_log_out_from_the_proview_app() throws Throwable {
		WebPages.get().signin.sign_out();
	}
	
	@Then("^I login just after logout with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_with_username_and_password(String arg1, String arg2) throws Throwable {
		  Helpers.get().enterText(WebPages.get().signin.userName_name, arg1);
		  Helpers.get().enterText(WebPages.get().signin.password_name, arg2);
		  Helpers.get().clickOnElement(WebPages.get().signin.signin_name);
		  Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.library), true);
	}
	
	@Then("^I verify Proview home page is displayed$")
	public void i_verify_Proview_home_page_is_displayed() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.homePage));
	}
	@Then("^I click on signIn button$")
	public void i_click_on_signIn_button() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().signin.signin_name);
	}

	@Then("^I verify error message Enter a username$")
	public void i_verify_error_message_Enter_a_username() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.userNameError));
	}

	@Then("^I verify error message Enter a password$")
	public void i_verify_error_message_Enter_a_password() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.passWordError));
	}

	@Then("^I enter invalid username$")
	public void i_enter_invalid_username() throws Throwable {
		Helpers.get().enterText((WebPages.get().signin.userName_name), "BrowserAutomation");
	}

	@Then("^I enter invalid password name$")
	public void i_enter_invalid_password_name() throws Throwable {
		Helpers.get().enterText((WebPages.get().signin.password_name), "Browser123we");
	}
	
	@Then("^I verify error message We don't recognize that username and/or password$")
	public void i_verify_error_message_We_don_t_recognize_that_username_and_or_password() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.signinError_WeDont_recognize));
	}

	@Then("^I click on Browser Back button$")
	public void i_click_on_Browser_Back_button() throws Throwable {
		Driver.get().navigate().back();
	}

	@Then("^I click on Browser Refresh button$")
	public void i_click_on_Browser_Refresh_button() throws Throwable {
		Driver.get().navigate().refresh();
	}

	@Then("^I click on  Browser Forward button$")
	public void i_click_on_Browser_Forward_button() throws Throwable {
		Driver.get().navigate().forward();
	}

	@Then("^I Click any Proview Logo on home page$")
	public void i_Click_any_Proview_Logo_on_home_page() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.proViewLogo));
	}

	@When("^I click on Forgot username link$")
	public void i_click_on_Forgot_username_link() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().signin.forgotUsername);
	}

	@Then("^I should navigate to the forgot username recovery page$")
	public void i_should_navigate_to_the_forgot_username_recovery_page() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.forgotusernamePasswordPage));
	}

	@Then("^I click browser back button$")
	public void i_click_browser_back_button() throws Throwable {
	   Driver.get().navigate().back();
	}

	@Then("^I click on Forgot password link$")
	public void i_click_on_Forgot_password_link() throws Throwable {
		Helpers.get().clickOnElement(WebPages.get().signin.forgotPassword);
	}

	@Then("^I should navigate to the forgot password recovery page$")
	public void i_should_navigate_to_the_forgot_password_recovery_page() throws Throwable {
		Assert.assertEquals(true, Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.forgotusernamePasswordPage));
	}
	
}
