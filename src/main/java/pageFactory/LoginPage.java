package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class LoginPage {
	
	
	WebDriver driver;
	private ElementsUtilies elementUtilies;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementUtilies=new ElementsUtilies(driver);
	}
	
	//objects
	
	@FindBy(id = "input-email")
	private WebElement emailfied;
	
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	
	
	// actions
	public void enterEmailAddress(String emailText) {
		elementUtilies.typeTextIntoElement(emailfied,emailText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void enterPassword(String passwordText) {
		elementUtilies.typeTextIntoElement(passwordfield,passwordText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public AccountPage clickOnLogin() {
		elementUtilies.clickOnElement(loginButton,CommonUtilis.EXPLICITY_WAIT);
		return new AccountPage(driver);
	}
	
	public boolean displayWarningStatus() {
		return elementUtilies.elementDispalyed(warningMessage,CommonUtilis.EXPLICITY_WAIT);
	}
	
	

}
