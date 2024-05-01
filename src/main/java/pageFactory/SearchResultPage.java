package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonUtilis;
import utilities.ElementsUtilies;

public class SearchResultPage {
   WebDriver driver;
   private ElementsUtilies elementsUtilies;
	
	
	@FindBy(xpath = "//div[@class='caption']//a[1]")
	private WebElement validProduct;
	
	@FindBy(xpath = "//p[.='There is no product that matches the search criteria.']")
	private WebElement messageText;
	

	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementsUtilies=new ElementsUtilies(driver);
	}
	
	public boolean displayedvalidProduct() {
		return elementsUtilies.elementDispalyed(validProduct,CommonUtilis.EXPLICITY_WAIT);
	}
	
	public String getmessageText() {
		return elementsUtilies.getTextFromElement(messageText,CommonUtilis.EXPLICITY_WAIT);
	}
	
}
