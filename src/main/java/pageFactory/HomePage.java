package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class HomePage {

	WebDriver driver;
	private ElementsUtilies elementsUtilies;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementsUtilies=new ElementsUtilies(driver);
	}
	
	@FindBy(xpath ="//span[text()='My Account']")
	private WebElement myAccountBottun;
	
	@FindBy(linkText ="Login")
	private WebElement loginOption;
	
	@FindBy(xpath ="//span[text()='Checkout']/following::input")                //search box
	private WebElement searchBoxField;
	
	
	@FindBy(linkText  ="Register")
	private WebElement registerOption;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-default')]")
	private WebElement searchButton;
	
	
	
	
	
	public void clickOnAccountButton(){
		elementsUtilies.clickOnElement(myAccountBottun,CommonUtilis.EXPLICITY_WAIT);		 
	}
	
	public LoginPage clickOnLoginButton() {
		elementsUtilies.clickOnElement(loginOption,CommonUtilis.EXPLICITY_WAIT);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		elementsUtilies.clickOnElement(registerOption,CommonUtilis.EXPLICITY_WAIT);
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBox(String productText){
		elementsUtilies.typeTextIntoElement(searchBoxField, productText,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public SearchResultPage clickOnSearchButton(){
		elementsUtilies.clickOnElement(searchButton,CommonUtilis.EXPLICITY_WAIT);
		return new SearchResultPage(driver);
	}
	
	
	
	
	
	
	
	
}
