package TestRunner;
import java.io.FileNotFoundException;
import org.junit.runner.RunWith;
import Framework.Helpers;
import Framework.Loggers;
import Framework.UtilityHelper;
import Pages.WebPages;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".",
		glue = {"stepDefinitions","BaseClass",},
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/ProView_NB_AutomationReport.html","rerun:target/rerun.txt"  }, monochrome = true,
		tags = {"@SanityLH,@FailedTestCases"}
		)

public class TestRunner extends AbstractTestNGCucumberTests{

	public TestRunner() throws FileNotFoundException {
		Helpers.set(new Helpers());
		Loggers.set(new Loggers());
		UtilityHelper.set(new UtilityHelper());
		WebPages.set(new WebPages());
	}
}
