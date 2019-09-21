package Pages;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Framework.Helpers;
import Framework.UtilityHelper;

public class WebPages{
	    private static ThreadLocal<WebPages> webages = new ThreadLocal<WebPages>();
		public static void set(WebPages helper)
		{
			webages.set(helper);
		 
		}
		public static WebPages get()
		{
		 return webages.get();
		}
	public	Signin signin = new Signin();
	public class Signin{
				
		public By userName_name = By.name("Username");
		public By password_name = By.name("Password");
		public By signin_name = By.name("SignIn");
		public By forgotUsername = By.linkText("Forgot username?");
		public By forgotPassword = By.linkText("Forgot password?");
		public By saveUsername = By.xpath("//*[@for='SaveUsername']");
		public By saveUsernamePassword = By.xpath("//*[@for='SaveUsernamePassword']");
		public By remenberMe = By.xpath("//*[@for='SuperRememberMe']");
		public By updateOnePassProfile = By.linkText("Update OnePass profile");
		public By createOnePassProfile = By.linkText("Create OnePass profile");
		public By addRegistrationKey = By.linkText("Add registration key");
		public By proviewTechnicalSupportbyCountryLink = By.linkText("ProView Technical Support by Country");
		public By privacy = By.linkText("Privacy");
		public By termAndCondition = By.linkText("Terms and Conditions");
		public By showPassword = By.xpath("//*[@id='form0']/div/ul[2]/li[2]/div[1]/div/div/span/label");
		public By cookies_AcceptButtom_xpath = By.xpath("*//app-cookie-policy/div/div/div/div/button");
		public By homePage = By.xpath("//*[@aria-label='Account settings and sign out']");
		public By userNameError = By.id("Username-error");
		public By passWordError = By.id("Password-error");
		public By signinError_WeDont_recognize = By.xpath("//*[@id='form0']/div/div/span/span[2]");
		public By proViewLogo = By.xpath("//*[@aria-label='Thomson Reuters ProView'][1]");
		public By forgotusernamePasswordPage = By.name("EmailAddress");
		
			  
			  public void sign_in() throws IOException, Exception{
				  Helpers.get().enterText(userName_name, UtilityHelper.get().ConfigReader("Username"));
				  Helpers.get().enterText(password_name, UtilityHelper.get().ConfigReader("Password"));
				  Helpers.get().clickOnElement(signin_name);
				  Helpers.get().clickOnElement(cookies_AcceptButtom_xpath);
				  Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().libraryHeader.library), true);
			}
			  
			  public void sign_out() throws IOException, Exception{
				  Helpers.get().clickOnElement(WebPages.get().signin.homePage);
				  Helpers.get().clickOnElement(WebPages.get().libraryHeader.accountSignOut);
				  Assert.assertEquals(Helpers.get().ValidateExistenceOfElement(WebPages.get().signin.userName_name), true);
			}
			
}	
	public LibraryHeader libraryHeader= new LibraryHeader();
	public class LibraryHeader{
		public By proviewLogoImg = By.xpath("//*[@id='libraryHeader']/header/a/span/xav-global-header-logo/img");
		public By skipToMainContent = By.id("skipLink-0");
		public By skipToFilter = By.id("skipLink-1");
		public By history = By.xpath("//*[@aria-label='History']");
		public By historyPanel = By.xpath("//*[@id='recentActivity']/div[2]/div[1]//img");
		public By notifications = By.xpath("//*[@mattooltip='Notifications']");
		public By elooseleaf = By.id("elooseleaf");
		public By library = By.id("library");
		public By logo = By.linkText("//*[@aria-label='Thomson Reuters ProView']");
		public By librarytext = By.xpath("//*[@id='gridViewLayoutContainer']/div[1]/div[2]/span");
		public By search = By.xpath("//*[@aria-label='Search']");
		public By titleShown = By.xpath("//*[@id='titlesContainer']/mat-label/span");
		public By accountMenupopover = By.id("menu-title");
		public By accountLanguage = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[1]/span[1]");
		public By accountLanguageSelected = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[1]/span[2]");
		public By accountRefreshLibrary = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[2]");
		public By accountExportListOfTitles = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[3]");
		public By accountClearCookies = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[4]");
		public By accountPrivacy = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[5]");
		public By accountSendUsFeedBack = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[6]");
		public By accountContactUs = By.xpath("//*[@id='libraryAccountMenu']/div[2]/ul/li[7]");
		public By accountSignOut = By.xpath("//*[@id='libraryAccountMenu']/div[2]/div[2]/button/span");
		public By footerLogo = By.xpath("//*[@id='footerContainer']/app-footer/footer/div/span[1]");
		public By default_Sort_Library = By.xpath("//*[@id='mat-select-0']/div/div[1]/span/span");
		public By Sort_Library = By.xpath("//*[@id='cdk-overlay-0']/div/div");
		public By Sort_Library_jurisdiction = By.xpath("//*[@id='mat-option-5']");
		
		
	}
	
	public TitleHeader titleHeader= new TitleHeader();
	public class TitleHeader{
		public By titleName = By.className("title-name");
		public By returnToLibraryButton = By.xpath("//*[@aria-label='Return to library']");
		public By searchTitleByTitle = By.id("Title Name Filter");
		public By searchTitleByAuthor = By.id("Author Filter");
		public By searchTitleByContent = By.id("Title Content Search");
		
		public By tocIcon = By.xpath("//*[@id='openTocButton']/span/img[2]");
		public By iconDivider = By.id("iconDivider");
		public By openSearchInTitleIcon = By.xpath("//*[@id='openSearchButton']/span/img[1]");
		public By viewAnnotationIcon = By.xpath("//*[@id='viewAnnotationsButton']/span/img[1]");
		public By downloadTitleIcon = By.xpath("//*[@id='fileDownloadButton']/span/img[1]");
		public By createLinkIcon = By.xpath("//*[@id='createLinkButton']/span/img[1]");
		public By recentActivityIcon = By.xpath("//*[@id='openRecentActivityButton']/span/img[1]");
		public By settingsMenuIcon = By.xpath("//*[@id='openSettingsButton']/span/img[1]");
	}
}