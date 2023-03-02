package tata_EMS_Project_Test_Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import tata_EMS_Project_Base_Class.Base_Class;

public class login_testd extends Base_Class{

	@Test(priority = 0)
	public void Test01_Verifying_login_with_ValidEmail_ValidPasswords() {

loginpage.clickon_forgotPasswordLink();
		
		String expected ="https://staging.netscribes.co/tata_ems_testing/admin/auth/forgot_password";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);

	}
}
