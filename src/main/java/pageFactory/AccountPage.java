package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class AccountPage{
WebDriver driver;
private ElementsUtilies elementsUtilies;
	 
@FindBy(linkText = "Edit your account information")
private WebElement editYourAccountInformationOption;


public AccountPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementsUtilies=new ElementsUtilies(driver);
}


   public boolean displayStatus() {
	   
	return elementsUtilies.elementDispalyed(editYourAccountInformationOption,CommonUtilis.EXPLICITY_WAIT);
   }
	
}
