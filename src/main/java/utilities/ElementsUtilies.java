package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtilies {

	WebDriver driver;
	public ElementsUtilies(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long duration){
		
		
		WebElement webElement = waitForElement(element,duration);//cm
		webElement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String text,long duration) {
		WebElement webElement = waitForElement(element,duration); //cm
		webElement.click();
		webElement.clear();
		webElement.sendKeys(text);
	}
	
	public WebElement waitForElement(WebElement element,Long duration) { // common method
		WebElement webElement=null;
		
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
	     webElement=wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
	}
	
	public void selectDropdownOption(WebElement element,String dropdownOptin,Long duration) {
		
		WebElement webElement=waitForElement(element,duration); //cm
		Select select =new Select(webElement);
		select.selectByVisibleText(dropdownOptin);
	}
	
	public void acceptAlter(Long duration) {
		Alert alter = waitForAlter(duration);
		alter.accept();
	}
	
	public Alert waitForAlter(Long duration) {
	    Alert alter=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
        alter= wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return alter;
	}
	
	public void alterForDissmis(Long duration) {
		Alert alter = waitForAlter(duration);
		alter.dismiss();
	}
	
	public void mouseOverAndClick(WebElement element,Long duration) {
		
		WebElement Webelement=waitForVisibilityOfElement(element,duration);       
        Actions action=new Actions(driver);
        action.moveToElement(element).build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,Long duration) {
		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
       webElement=wait.until(ExpectedConditions.visibilityOf(element));
		    }
		catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void javaScriptClick(WebElement element,Long duration) {
		WebElement webElement=waitForVisibilityOfElement(element,duration);
		JavascriptExecutor 	javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click();", webElement);
	}
	
	public void javaScriptTexttype(WebElement element,Long duration,String text) {
		WebElement webElement=waitForVisibilityOfElement(element,duration);
		JavascriptExecutor 	javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].value='"+text+"';", webElement);
	}
	
	
	public String getTextFromElement(WebElement element,long duration) {
		WebElement webElement = waitForElement(element,duration);//cm
		return webElement.getText();
	}
	public boolean elementDispalyed(WebElement element,long duration){
		WebElement webElement = waitForElement(element,duration);   //cm
		return webElement.isDisplayed();
	}
	
}
