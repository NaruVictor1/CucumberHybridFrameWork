package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class AccountSuccessPage {
WebDriver driver;
private ElementsUtilies elementsUtilies;

//objects
@FindBy(xpath = "//h1[.='Your Account Has Been Created!']")
private WebElement pageHeding;

//contructor
public AccountSuccessPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementsUtilies=new ElementsUtilies(driver);
}

//actons
public String getPageHeding() {
	return elementsUtilies.getTextFromElement(pageHeding,CommonUtilis.EXPLICITY_WAIT);
}

}
