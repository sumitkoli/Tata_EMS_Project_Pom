package tata_EMS_Project_Base_Class;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.File;

import Utilities.Extent_ListnerClass;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import tata_EMS_Project_Page_Object.Forgot_Password_Page;
import tata_EMS_Project_Page_Object.Login_Page;

@Listeners(Extent_ListnerClass.class)
public class Base_Class {

	public Login_Page loginpage;
	public Forgot_Password_Page forgotpasspage;
	public ReadConfig readconfig;
	public static WebDriver driver;
	public String browser;
	public Logger log;

	@BeforeMethod
	public void applicationSetup() throws IOException {
		readconfig = new ReadConfig();
		log= LogManager.getLogger("Logs");

		browser = readconfig.getbrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome Browser Started Successfully");
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("FireFox Browser Started Successfully");
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Edge Browser Started Successfully");
			break;

		default:
			driver = null;
			break;

		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url=readconfig.geturl();
		
		driver.get(url);
		
		log.info("URL Opened Successfully");

		loginpage = new Login_Page(driver);
		forgotpasspage= new Forgot_Password_Page(driver);
	
	}

	@AfterMethod
	public void applicationClose() {
		driver.quit();
		log.info("Browser Closed Successfully");

	}
	
	
	
}

