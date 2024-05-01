package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class RegisterPage {

	WebDriver driver;
	private ElementsUtilies elementsUtilies;
	
	@FindBy(id = "input-firstname")
	private WebElement firstnameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastnameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement conformPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "(//input[@name='newsletter'])[1]")
	private WebElement newsletter;
	
	@FindBy(xpath = "//div[text()='Warning: E-Mail Address is already registered!']")
	private WebElement warningDuplicateMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]/i")
	private WebElement allFieldWarning;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementsUtilies=new ElementsUtilies(driver);
	}
	//actions
	public void enterFirstName(String firstname){
		elementsUtilies.typeTextIntoElement(firstnameField, firstname,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void enterLastName(String lastNameText) {
		elementsUtilies.typeTextIntoElement(lastnameField, lastNameText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void enterEmailAddress(String emailText) {
		elementsUtilies.typeTextIntoElement(emailField, emailText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void enterTelephone(String telephone) {
		elementsUtilies.typeTextIntoElement(telephoneField, telephone,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void enterPassword(String passwordText) {
		elementsUtilies.typeTextIntoElement(passwordField, passwordText,CommonUtilis.EXPLICITY_WAIT);
	}
	public void enterConfirmPassword(String confirmPasswordText) {
		elementsUtilies.typeTextIntoElement(conformPasswordField, confirmPasswordText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void clickOnNewsletter() {
		elementsUtilies.clickOnElement(newsletter,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public void clickonPrivacyPolicy() {
		elementsUtilies.clickOnElement(privacyPolicy,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		elementsUtilies.clickOnElement(continueButton,CommonUtilis.EXPLICITY_WAIT);
		return new AccountSuccessPage(driver); 
	}
	
	public String getDuplicateEmailwarningStatus() {
		return elementsUtilies.getTextFromElement(warningDuplicateMessage,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public boolean getWarningMessage(){
		return elementsUtilies.elementDispalyed(allFieldWarning,CommonUtilis.EXPLICITY_WAIT); //classname.methodname-pass parameters
	}
}
