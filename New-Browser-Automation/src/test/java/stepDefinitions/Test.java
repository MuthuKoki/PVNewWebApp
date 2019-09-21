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
public class Test {
   
	
	
	@Then("^I failed the test cases$")
	public void i_open_a_title_on_ProView(String arg1) throws Throwable {
	    
        Assert.fail();;
	}
}