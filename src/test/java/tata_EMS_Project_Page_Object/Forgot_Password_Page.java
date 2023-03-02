package tata_EMS_Project_Page_Object;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tata_EMS_Project_Base_Class.Base_Class;

public class Forgot_Password_Page extends Base_Class {

	WebDriver ldriver;

	public Forgot_Password_Page(WebDriver rdriver) {
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement email;

	@FindBy(tagName = "button")
	WebElement recoverBtn;

	@FindBy(linkText = "Login")
	WebElement loginBtn;

	@FindBy(tagName = "strong")
	WebElement validationText;

	@FindBy(tagName = "img")
	WebElement logoImg;
	
	@FindBy(xpath="//span[@class='text-danger']")
	WebElement validationForBlankValue;

	// Enter User Email
	public void enter_userEmail(String Email) {
		email.sendKeys(Email);
	}

	// Click on Recover Button
	public void clickOn_RecoverBtn() {
		recoverBtn.click();
	}

	// Click on Login Tab
	public void clickon_LoginBtn() {
		loginBtn.click();
	}

	// Get the validation Text
	public String get_validationText() {
		return validationText.getText();
	}
	
	// Get the validation Text For Blank Value
		public String get_validationTextforBlankValue() {
			return validationForBlankValue.getText();
		}

	//Verifying logo on Login Page
	public Boolean logodisplayed() {
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoImg);
		return ImagePresent;
	}
}
