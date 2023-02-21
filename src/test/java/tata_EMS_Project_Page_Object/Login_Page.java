package tata_EMS_Project_Page_Object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tata_EMS_Project_Base_Class.Base_Class;

public class Login_Page extends Base_Class {

	WebDriver ldriver;

	public Login_Page(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "email")
	WebElement userEmail;

	@FindBy(name = "password")
	WebElement userPassword;

	@FindBy(xpath = "//button[contains(text(),'SIGN IN')]")
	WebElement signInBtn;

	public void enterUser_Email(String useremail) {
		userEmail.sendKeys(useremail);
	}

	public void enterUser_password(String password) {
		userPassword.sendKeys(password);
	}

	public void clickon_Signin_Btn() {
		signInBtn.click();
	}

}
