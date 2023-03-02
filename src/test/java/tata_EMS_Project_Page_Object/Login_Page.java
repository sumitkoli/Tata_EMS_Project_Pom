package tata_EMS_Project_Page_Object;

import org.openqa.selenium.JavascriptExecutor;
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

	@FindBy(tagName = "strong")
	WebElement validationText;

	@FindBy(tagName = "img")
	WebElement logoImg;

	@FindBy(linkText = "Forget Password?")
	WebElement forgotPassword;
	
	// Enter Email Address
	public void enterUser_Email(String useremail) {
		userEmail.sendKeys(useremail);
	}

	// Enter Password
	public void enterUser_password(String password) {
		userPassword.sendKeys(password);
	}

	// Click on Sign In Button
	public void clickon_Signin_Btn() {
		signInBtn.click();
	}
	
	public Forgot_Password_Page clickon_forgotPasswordLink() {
		forgotPassword.click();
		return new Forgot_Password_Page(ldriver);
	}

	// Get the validation Text
	public String get_validationText() {
		return validationText.getText();
	}

	// Login Process in Single step
	public void login(String useremail, String password) {
		userEmail.sendKeys(useremail);
		userPassword.sendKeys(password);
		signInBtn.click();
	}
	
	//Verifying logo on Login Page
	public Boolean logodisplayed() {
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoImg);
		return ImagePresent;
	}
}
