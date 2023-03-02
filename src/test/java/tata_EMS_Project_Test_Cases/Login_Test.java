package tata_EMS_Project_Test_Cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.RetryAnalyzer;
import tata_EMS_Project_Base_Class.Base_Class;
import tata_EMS_Project_Page_Object.Login_Page;

public class Login_Test extends Base_Class {

	@Test(priority = 0)
	public void Test01_Verifying_login_with_ValidEmail_ValidPassword() {

		loginpage.login("admin@gmail.com", "123456");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = driver.getCurrentUrl();
		String actual = "https://staging.netscribes.co/tata_ems_testing/admin/dashboard";
		Assert.assertEquals(actual, expected);
		log.info("Login successfull");

	}

	@Test(priority = 1)
	public void Test02_Verifying_login_with_ValidEmail_InvalidPassword() {

		loginpage.login("admin@gmail.com", "12345");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Wrong password";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");

	}

	@Test(priority = 2)
	public void Test03_Verifying_login_with_InvalidEmail_ValidPassword() {

		loginpage.login("admin@gmail", "123456");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Invalid email format";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");
	}

	@Test(priority = 3)
	public void Test04_Verifying_login_with_InvalidEmail_InvalidPassword() {

		loginpage.login("admin@gmail", "12345");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Invalid email format";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");
	}

	@Test(priority = 4)
	public void Test05_Verifying_login_with_BlankEmail_ValidPassword() {

		loginpage.login("", "123456");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Please fill all fields";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");
	}

	@Test(priority = 5)
	public void Test06_Verifying_login_with_ValidEmail_BlankPassword() {

		loginpage.login("admin@gmail", "");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Please fill all fields";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");
	}

	@Test(priority = 6)
	public void Test07_Verifying_login_with_BlankEmail_BlankPassword() {

		loginpage.login("", "");

		log.info("User Email ID is entered");
		log.info("User Password is entered");
		log.info("Sign In Button is clicked");

		String expected = "Please fill all fields";

		String actual = loginpage.get_validationText();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		log.info("Login Unsuccessfull");
	}

	@Test(priority = 7)
	public void Test08_Verifying_Forgot_PasswordLink() {

		loginpage.clickon_forgotPasswordLink();

		log.info("User Clicked on Forgot Password Link");

		String expected = "https://staging.netscribes.co/tata_ems_testing/admin/auth/forgot_password";
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
		log.info("User is on Forgot Password Page");
	}

	@Test(priority = 8)
	public void Test09_Verifying_loginPage_Logo() {

		Assert.assertTrue(loginpage.logodisplayed());
		log.info("Logo is displayed on Login Page");

	}

}
