package tata_EMS_Project_Test_Cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import tata_EMS_Project_Base_Class.Base_Class;
import tata_EMS_Project_Page_Object.Login_Page;

public class Login_Test extends Base_Class {

	@Test
	public void Test01_Verifying_login_with_ValidDetails() {

		loginpage.enterUser_Email("admin@gmail.com");
		log.info("User Email ID is entered");
		loginpage.enterUser_password("123456");
		log.info("User Password is entered");
		loginpage.clickon_Signin_Btn();
		log.info("Sign In Button is clicked");
		String expected = driver. getCurrentUrl();
		String actual="https://staging.netscribes.co/tata_ems_testing/admin/dashboard";
		Assert.assertEquals(actual, expected);
		log.info("Login successfull");
		
	}
	
	@Test
	public void Test01_Verifying_login_with_InValidDetails() {

		loginpage.enterUser_Email("admin@gmail.co");
		log.info("User Email ID is entered");
		loginpage.enterUser_password("12345");
		log.info("User Password is entered");
		loginpage.clickon_Signin_Btn();
		log.info("Sign In Button is clicked");
		String expected = driver. getCurrentUrl();
		String actual="https://staging.netscribes.co/tata_ems_testing/admin/dashboard";
		Assert.assertEquals(actual, expected);
		log.info("Login unsuccessfull");
	}
}
