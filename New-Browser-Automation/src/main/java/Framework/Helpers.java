package Framework;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import Pages.WebPages;
import cucumber.api.Scenario;

public class Helpers {
	    public Scenario sc;
		public static int minimumWait = 10;
		public static int maximumWait = 20;
		public static Screen screen = new Screen();
		private static ThreadLocal<Helpers> HelpersThread = new ThreadLocal<Helpers>();
		public static void set(Helpers helper)
		{
			HelpersThread.set(helper);
		 
		}
		public static Helpers get()
		{
		 return HelpersThread.get();
		}
	
	public void launchNewProview() throws IOException
	{
	
		Proxy proxy = new Proxy();
		proxy.setProxyType(ProxyType.AUTODETECT);
		//CHROME DESKTOP
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--ignore-certificate-errors", "--disable-extensions", "--dns-prefetch-disable", "lang=en_US.UTF-8", "--new-window");
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", prefs);
		Loggers.get().INFO("Starting Webdriver settings");
		if (!System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\WIN\\chromedriver.exe");
			Driver.set(new ChromeDriver());
		}
		else {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/Mac");
		}	
		Driver.get().manage().deleteAllCookies();
		Driver.get().manage().window().maximize();
		Driver.get().get(UtilityHelper.get().ConfigReader("URL"));
    }   
	
	
	/**
	 * Method to Validate Existence Of Element
	 * 
	 * @param locator
	 * @param locatorString
	 * @throws Exception
	 */
	
	public boolean ValidateExistenceOfElement(By element) throws Exception {
	if (element != null) {
		try {   
				WebDriverWait wait1 = new WebDriverWait(Driver.get(), maximumWait);
				wait1.until(ExpectedConditions.visibilityOfElementLocated(element));
				return true;
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
			throw new WebDriverException("Element Not Found: " + element);
		}
		
	  }
	return false;
	}
	
	
	/**
	 * Method to Validate NonExistence Of Element
	 * 
	 * @param Webelement
	 * @throws Exception
	 */
	public boolean ValidateNonExistenceOfElement(By element) throws Exception {
		
		try {
				WebDriverWait wait = new WebDriverWait(Driver.get(), maximumWait);
				wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
			throw new WebDriverException("Element Found: " + element);
		}
		return false;
	  }

	/**
	 * Method to send a data to the textbox
	 * 
	 * @param txt
	 * @throws Exception
	 */
	public void enterText(By element, String txt) throws Exception {
		try {
				if(ValidateExistenceOfElement(element)) {
					Driver.get().findElement(element).clear();
					Driver.get().findElement(element).sendKeys(txt);
					Thread.sleep(2000);
				}
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	  }
 
	/**
	 * Method to click on element
	 * 
	 * @param WebElementt
	 * @param txt
	 * @throws Exception
	 */
	public void clickOnElement(By element) throws Exception {
		try {
			
			if(ValidateExistenceOfElement(element)) {
				Driver.get().findElement(element).click();
			}
	}
		catch(NoSuchElementException e) {
			e.printStackTrace();
	}
	}
	
	/**
	 * Method to click on element using mouse over
	 * 
	 * @param By
	 */
	public void clickOnElementUsingMouse(By element) throws Exception {
		try {
			
			 WebElement el = Driver.get().findElement(element);
		     Actions builder = new Actions(Driver.get());
		     builder.moveToElement( el ).click( el );
		     builder.perform();
			
	        }
		catch(NoSuchElementException e) {
			e.printStackTrace();
	}
	}
	
	/**
	 * Method to press Tab key
	 * 
	 * @param By
	 */
	public void clickOnTabKeyUsingSel(int n) throws Exception {
		try {
			
			for(int i=0;i<n;i++) {
			
			Actions action = new Actions(Driver.get());
			action.sendKeys(Keys.TAB).build().perform();
			Thread.sleep(1000);
			}
	        }
		catch(NoSuchElementException e) {
			e.printStackTrace();
	}
	}
	
	/**
	 * Method to press enter key
	 * 
	 * @param By
	 */
	public void clickOnEnterKeyUsingSel(int n) throws Exception {
		try {
			
			for(int i=0;i<n;i++) {
			
			Actions action = new Actions(Driver.get());
			action.sendKeys(Keys.ENTER).build().perform();
			System.out.println("Clicked Enter key");
			Thread.sleep(1000);
			}
	        }
		catch(NoSuchElementException e) {
			e.printStackTrace();
	}
	}
	/**
	 * Method to click on element with JS
	 * 
	 * @param WebElementt
	 * @throws Exception
	 */
	public void clickElementByJS(By element) {
        try {
        	WebElement element1 = Driver.get().findElement(element);
            ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element1);
        } catch (NoSuchElementException e) {
            Assert.fail(((Throwable) e).getMessage());
        }
    }
	/**
	 * To select an element from the dropdown using text
	 * 
	 * @param element
	 * @param innerText
	 */
	public void dropDownSelectorByInnerText(By element, String innerText) {
		try {
			Select select = new Select(Driver.get().findElement(element));
			select.selectByVisibleText(innerText);
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not visible in dropdown: " + innerText);
		}
	}

	/**
	 * To select an element from the dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void dropDownSelectorByIndex(By element, int index) {
		try {
			Select select = new Select(Driver.get().findElement(element));
			select.selectByIndex(index);
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not visible in dropdown: " + index);
		}

	}

	/**
	 * To select an element from dropdown using value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownSelectorByValue(By element, String value) {
		try {
			Select select = new Select(Driver.get().findElement(element));
			select.selectByValue(value);
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not visible in dropdown: " + value + ex);
		}
	}
    
	/** To select an element from dropdown using visible text
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDownSelectorByVisibleText(By element, String value) {
		try {
			Select select = new Select(Driver.get().findElement(element));
			select.selectByVisibleText(value);
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not visible in dropdown: " + value + ex);
		}
	}
	
	/** To select an element from dropdown if select class is not there in html code
	 * 
	 * @param element
	 * * @param element
	 * @param value
	 */
	public void dropDownSelector(By elementTop,By linkTextOfElement, String value) {
		try {
			Actions drpdwn = new Actions(Driver.get());
			Driver.get(). findElement(elementTop).click();
			drpdwn.moveToElement(Driver.get().findElement(linkTextOfElement)).build().perform();
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not visible in dropdown: " + value + ex);
		}
	}

	/**
	 * To accept an alert
	 * 
	 */
	public void acceptAlert() {
		try {
			Driver.get().switchTo().alert().accept();
		} catch (WebDriverException ex) {
			throw new WebDriverException("Alert Not Present" + ex);
		}
	}
	
	/**
	 * To get text message from an alert
	 * 
	 */
	public String getAlertMessage() {
		try {
			String txt =Driver.get().switchTo().alert().getText();
			return txt;
		} catch (WebDriverException ex) {
			throw new WebDriverException("Message Not Present" + ex);
		}
	}
	
	/**
	 * To get text from element 
	 * @throws Exception 
	 * 
	 */
	public String getText(By element) throws Exception {
		try {
			ValidateExistenceOfElement(element);
			String txt =Driver.get().findElement(element).getText();
			return txt;
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not Present" + ex);
		}
	}
	
	/**
	 * To get text with attribute from element 
	 * @param By element
	 * @param attribute like class,id,name
	 * @throws Exception 
	 * 
	 */
	public String getTextByAttribute(By element,String attribute) throws Exception {
		try {
			ValidateExistenceOfElement(element);
			String txt =Driver.get().findElement(element).getAttribute(attribute);
			System.out.println("Displayed Attribute: "+txt);
			return txt;
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element Not Present" + ex);
		}
	}
	
	
	/**
	 * To wait for alert to display
	 * 
	 */
	public void waitAlert(int duration) {
        new WebDriverWait(Driver.get(), duration).until(ExpectedConditions.alertIsPresent());
    }
	/**
	 * To decline an alert
	 * 
	 * @param driver
	 */
	public void declineAlert() {
		try {
			Driver.get().switchTo().alert().dismiss();
		} catch (WebDriverException ex) {
			throw new WebDriverException("Alert Not Present" + ex);
		}
	}

	/**
	 * To switch to the iFrame
	 * 
	 * @param element
	 */
	public void iframeSwitcher(By element) {
		try {
			Driver.get().switchTo().frame(Driver.get().findElement(element));
		} catch (WebDriverException ex) {
			throw new WebDriverException("IFrame Not Present" + element + ex);
		}
	}

	public void ScroolToElement(By element){

		try
		{
		WebElement element1 = Driver.get().findElement(element);
		Thread.sleep(5000);
		String scrollElementIntoMiddle = 
				"var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) Driver.get()).executeScript("window.scrollTo(0, document.body.scrollHeight)",element1);
		
		Thread.sleep(5000);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		}
	public void ScroolToDown(By element){
 
		try
		{
			Thread.sleep(5000);
		//WebElement element1 = Driver.get().findElement(element);
		((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(false);");
		Thread.sleep(5000);
		//element1.click();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		}
	/**
	 * To mousehover on element
	 * 
	 * @param element
	 * @param driver
	 */
	public void mouseHoverAndClickAnElement(By element) {
		try {
			Actions action = new Actions(Driver.get());
			action.moveToElement(Driver.get().findElement(element)).click().build().perform();
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element is not found or clickable" + element + ex);
		}
	}

	/**
	 * To double click on the element
	 * 
	 * @param element
	 */
	public void doubleClickAnElement(By element) {
		try {
			Actions action = new Actions(Driver.get());
			action.moveToElement(Driver.get().findElement(element)).doubleClick().build().perform();
		} catch (WebDriverException ex) {
			throw new WebDriverException("Element is not found or clickable for double click" + element + ex);
		}
	}

	/**
	 * @param image
	 */
	public static void doubleClickOnImage(String image) {
		Pattern textToNote = new Pattern(image);
		try {
			screen.doubleClick(textToNote);
		} catch (FindFailed e) {
			e.printStackTrace();
			System.err.println("Waiting for text to be appear");
		}
	}

	/**
	 * @param image
	 */
	public static void verifyTheElement(String image) {
		Pattern textToNote = new Pattern(image);
		screen.exists(textToNote);

	}
	/**
	 * Wait to page load completely
	 */
	public void waitForJQueryDocumentReady() {
        new WebDriverWait(Driver.get(), minimumWait).until((ExpectedCondition<Boolean>) d -> {
            JavascriptExecutor js = (JavascriptExecutor) d;
            return (Boolean) js.executeScript("return document.readyState").toString().equals("complete");
        });
    }
	/**
	 * To find text on page source
	 */
	public boolean findInPageSource(String text) {
        return Driver.get().getPageSource().contains(text);
    }
	
	public enum ElementStatus{
        VISIBLE,
        NOTVISIBLE,
        ENABLED,
        NOTENABLED,
        PRESENT,
        NOTPRESENT
    }
	public ElementStatus isElementVisible(By element,ElementStatus getStatus){
        try{
            if(getStatus.equals(ElementStatus.ENABLED)){
                if(Driver.get().findElement(element).isEnabled())
                    return ElementStatus.ENABLED;
                return ElementStatus.NOTENABLED; 
            }
            if(getStatus.equals(ElementStatus.VISIBLE)){
                if(Driver.get().findElement(element).isDisplayed())
                    return ElementStatus.VISIBLE;
                return ElementStatus.NOTVISIBLE;
            }
            return ElementStatus.PRESENT;
        }catch(org.openqa.selenium.NoSuchElementException nse){
            return ElementStatus.NOTPRESENT;
        }
    }
 

	public boolean isElementPresentUsingJS(By element) throws FileNotFoundException {
	    JavascriptExecutor jse=(JavascriptExecutor) Driver.get();
	    try {
	    	WebElement element1 = Driver.get().findElement(element);
	        Object obj = jse.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;",
	            element);
			    if (obj.toString().contains("true")) {
			    	Loggers.get().INFO("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS");  
			    	Loggers.get().INFO("Element displayed is: "+element1.getText());  
			        return true;
			    } else {
			    	Loggers.get().INFO(element1 +": Not found");  
			    }
	
	    } catch (NoSuchElementException e) {
	    			Loggers.get().INFO(Driver.get().findElement(element) +": Not found");  
	    }
	    return false;
	}
	/**
	 * verifyToolTip using mattooltip attribute 
	 * Note: please write different memthod 
	 * @throws Exception 
	 */
	public boolean verifyToolTip(By element,String tooltipAttribute,String expectedMessage) throws Exception {
		try {
			@SuppressWarnings("unused")
			boolean xyz =ValidateExistenceOfElement(element);
			WebElement element1 = Driver.get().findElement(element);   
			String toolTipActual = element1.getAttribute(tooltipAttribute);
			Loggers.get().INFO("The tool top message display is: "+toolTipActual);
			if(toolTipActual.equals(expectedMessage)) {
				return true;	
			}
			else {
				return false;
			}
		} catch (WebDriverException ex) {
			throw new WebDriverException("Tool tip Message Not Present" + ex);
		}
	}
	
	public WebElement getAndVerifyElement(String locatorname,String locator) throws Exception {
		 WebDriverWait wait = new WebDriverWait(Driver.get(), 30);
		  try {
		 
			  if(locatorname.equalsIgnoreCase("id")) {
				  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
				  		  WebElement element = Driver.get().findElement(By.id(locator));
				  		  Loggers.get().INFO("The element display on the page is   :"+element);
				  		  return element;
			  }
			  else if(locatorname.equalsIgnoreCase("className")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			  		  WebElement element = Driver.get().findElement(By.className(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
		      }
			  else if(locatorname.equalsIgnoreCase("name")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locator)));
			  		  WebElement element = Driver.get().findElement(By.name(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
			  }
			  else if(locatorname.equalsIgnoreCase("linkText")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locator)));
			  		  WebElement element = Driver.get().findElement(By.linkText(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
			  }
			  else if(locatorname.equalsIgnoreCase("linkText")) {
		  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locator)));
		  		  WebElement element = Driver.get().findElement(By.partialLinkText(locator));
		  		  Loggers.get().INFO("The element display on the page is   :"+element);
		  		  return element;
		      }
			  else if(locatorname.equalsIgnoreCase("xpath")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			  		  WebElement element = Driver.get().findElement(By.xpath(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
			  }
			   else if(locatorname.equalsIgnoreCase("cssSelector")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
			  		  WebElement element = Driver.get().findElement(By.cssSelector(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
				    	    
			   }
			   else if(locatorname.equalsIgnoreCase("tagName")) {
			  		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locator)));
			  		  WebElement element = Driver.get().findElement(By.tagName(locator));
			  		  Loggers.get().INFO("The element display on the page is   :"+element);
			  		  return element;
	  	       } //end if
			   else {
				   Loggers.get().INFO("Please provide valid locator name");
				   return null;
			   }
		   }//end try
		 catch(NoSuchElementException e){
			 Loggers.get().INFO("Please provide valid locator name");
			 throw new Exception("Element Not Found: " + locator);
		  } //end catch
		
		  }
	
	
	
}