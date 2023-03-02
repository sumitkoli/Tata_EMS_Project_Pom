package tata_EMS_Project_Test_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import tata_EMS_Project_Base_Class.Base_Class;
import tata_EMS_Project_Page_Object.Forgot_Password_Page;

public class Forgot_Password_Test extends Base_Class {

	@Test(priority = 0)
	public void Test07_Verifying_Forgot_Password_with_ValidEmail() {

		loginpage.clickon_forgotPasswordLink();
		log.info("User is Redirected to Forgot Password Page");
		forgotpasspage.enter_userEmail("admin@gmail.com");
		log.info("User Email ID is entered");
		forgotpasspage.clickOn_RecoverBtn();
		log.info("Recover Button is Clicked");
	}

	@Test(priority = 1)
	public void Test07_Verifying_Forgot_Password_with_InvalidEmail() {

		loginpage.clickon_forgotPasswordLink();
		log.info("User is Redirected to Forgot Password Page");
		forgotpasspage.enter_userEmail("dmin@gmail.com");
		log.info("User Email ID is entered");
		forgotpasspage.clickOn_RecoverBtn();
		log.info("Recover Button is Clicked");
		String expected = "Email does not exist.";

		String actual = forgotpasspage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");

	}
	
	@Test(priority = 2)
	public void Test07_Verifying_Forgot_Password_with_BlankDetails() {

		loginpage.clickon_forgotPasswordLink();
		log.info("User is Redirected to Forgot Password Page");
		forgotpasspage.enter_userEmail("");
		log.info("User Email ID is entered");
		forgotpasspage.clickOn_RecoverBtn();
		log.info("Recover Button is Clicked");
		String expected = "The Email field is required.";

		String actual = forgotpasspage.get_validationTextforBlankValue();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");

	}

	@Test(priority = 3)
	public void Test09_Verifying_ForgotPassword_Page_Logo() {

		loginpage.clickon_forgotPasswordLink();
		log.info("User is Redirected to Forgot Password Page");
		Assert.assertTrue(forgotpasspage.logodisplayed());
		log.info("Logo is displayed on Login Page");
		
	}
}
