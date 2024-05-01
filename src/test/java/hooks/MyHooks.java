package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.configReader;

public class MyHooks {
	WebDriver driver;
	
	@Before()
	public void setup(){	
    Properties prop = configReader.initializeProperties();    //
	driver=DriverFactory.initialization(prop.getProperty("browserName"));
//	driver=DriverFactory.getDriver();
	driver.get(prop.getProperty("url"));
	}
	
	@After()
	public void teardown(Scenario scenario){
		
		if(scenario.isFailed()){
			String screnshotName=scenario.getName().replace(" ", "_");
			byte[] screenShort = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShort,"image/png", screnshotName);
		}
		
	driver.quit();

	}
	
}
