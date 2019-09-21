package BaseClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.cucumber.listener.Reporter;
import Framework.Driver;
import Framework.Loggers;
import Framework.UtilityHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {
	@Before
	public void intialize(Scenario sc) throws Exception {
		try {
			Reporter.loadXMLConfig("config/extent-config.xml");
			Reporter.setSystemInfo("Automation", "Proview New Browser");
			Reporter.setSystemInfo("Environment", UtilityHelper.get().ConfigReader("URL"));
			Reporter.setSystemInfo("User Name", "Parmeshwar");
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
			Logger logger = Logger.getLogger("");
			logger.setLevel(Level.SEVERE);
			System.out.println("Executing Scenario is : " + sc.getName());
			String featureName = "Feature ";
			String rawFeatureName = sc.getId().split(";")[0].replace("-", " ");
			featureName = featureName + ":" + rawFeatureName.substring(0, 1).toUpperCase()
					+ rawFeatureName.substring(1);
			System.out.println("Executing feature name is : " + rawFeatureName);
		 }
		    catch (Exception ex) {
		    	ex.printStackTrace();
		}
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		    String name = scenario.getName();
			Loggers.get().INFO("Scenario : " + name);
			File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + name +"_"+new SimpleDateFormat("MM.dd_HH.mm").format(new Date())+ ".png");
			File src = (File) ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.FILE);
			byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
				try {
					FileUtils.copyFile(src, dest);
					scenario.embed(screenshot, "image/png");
				} catch (IOException e) {
					e.printStackTrace();
		 }
		Reporter.addScreenCaptureFromPath(dest.toString());
        Reporter.addScenarioLog(scenario.getName());
        Driver.get().quit();
	
	}}
