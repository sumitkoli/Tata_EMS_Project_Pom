package tata_EMS_Project_Base_Class;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.io.File;

import Utilities.Extent_ListnerClass;
import Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import tata_EMS_Project_Page_Object.Login_Page;

@Listeners(Extent_ListnerClass.class)
public class Base_Class {

	public Login_Page loginpage;
	public ReadConfig readconfig;
	public static WebDriver driver;
	public String browser;

	@BeforeMethod
	public void applicationSetup() throws IOException {
		readconfig = new ReadConfig();

		browser = readconfig.getbrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			break;

		}
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String url=readconfig.geturl();

		driver.get(url);

		loginpage = new Login_Page(driver);
	
	}

	@AfterMethod
	public void applicationClose() {
		driver.quit();

	}
	
	public static String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {
		  TakesScreenshot ts=(TakesScreenshot)driver;
	  
	  File source=ts.getScreenshotAs(OutputType.FILE);
	  
	 // String destPath=System.getProperty("user.dir")+"\\Reports1\\"+TestCaseName+".png";
	  
	  String destPath=".//Reports//Screenshots//"+TestCaseName+".png"; 
	  
	  File file=new File(destPath); 
	  
	  FileUtils.copyFile(source, file); 
	  
	  return destPath;
	  
	  }

}

