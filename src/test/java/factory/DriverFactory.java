package factory;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.CommonUtilis;
import utilities.configReader;

public class DriverFactory {

	static WebDriver driver=null;

	public static WebDriver initialization(String browserName) {
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		default:
			System.out.println("invalid browser");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtilis.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(CommonUtilis.IMPLICITY_WAIT));
		return driver;
	}
	
	
	public static  WebDriver getDriver(){
		
		return driver;
	}
	
	
}
