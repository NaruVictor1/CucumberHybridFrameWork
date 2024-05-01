package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pageFactory.AccountPage;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utilities.CommonUtilis;

public class Login {

	
	WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private AccountPage accountpage;
	
	@Given("^User navigates to home page$")
	public void user_navigates_to_home_page(){
		
		driver=DriverFactory.getDriver();
		home=new HomePage(driver);
		home.clickOnAccountButton();
		login=home.clickOnLoginButton();
		
	}
	
	
	
	@When("^User enters vaild email address (.+) into email field$")
	public void User_enters_vaild_email_address_into_email_field(String emailAddress){
		login.enterEmailAddress(emailAddress);
	}
	
	@And("^Enter vaild password (.*) into password field$")
	public void Enter_vaild_password_into_password_field(String password) {
		login.enterPassword(password);
	}
	
	@When("^Clicks on Login button$")
	public void clicks_on_login_button(){
		accountpage=login.clickOnLogin();
	}

	@Then("^User should get successfully$")
	public void user_should_get_successfully(){
		Assert.assertTrue(accountpage.displayStatus());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field(){
//		login =new LoginPage(driver);  //again creating login page instance 2
		login.enterEmailAddress(CommonUtilis.getTimeStamp());
	}

	@When("Enter invaild password {string} into password field")
	public void enter_invaild_password_into_email_field(String invaildpassword){
		login.enterPassword(invaildpassword);
	}


	@When("^User dont enter any credentails$")
	public void user_dont_enter_any_credentails(){
		login.enterEmailAddress("");
	}
	
	@Then("^User should get a proper warning message$")
	public void user_should_get_a_proper_warning_message(){
		login.displayWarningStatus();
	}
	
}
