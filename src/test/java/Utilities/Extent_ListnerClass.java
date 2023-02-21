package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.App;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tata_EMS_Project_Base_Class.Base_Class;

public class Extent_ListnerClass extends Base_Class implements ITestListener {

	String concatenate = ".";
	ExtentSparkReporter htmlReporter;
	static ExtentReports reports;
	static ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	//Extent Report
	public void configureReport() throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		String datename = formatter.format(date);

		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "./Reports/ExtentListnerReport" + datename + ".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add system information/ environment info to reports
		readconfig = new ReadConfig();
		String browser = readconfig.getbrowser();
		reports.setSystemInfo("Machine:", "Sumit's Laptop");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("Browser", browser);
		reports.setSystemInfo("User Name", "Sumit");

		// configuration to change the look and feel of report
		htmlReporter.config().setDocumentTitle("Tata EMS Project");
		htmlReporter.config().setReportName("Tata EMS Report");
		htmlReporter.config().setTheme(Theme.DARK);

	}
	//Capturing Screenshot
	public String screshot(String TestCaseName) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		String datename = formatter.format(date);
		String screenshotpath = ".//Reports//Screenshots//Screenshot" + TestCaseName + datename + ".jpeg";

		File file = new File(screenshotpath);

		try {
			FileUtils.copyFile(src, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Failure of test cases and its details are : " + TestCaseName);
		return screenshotpath;
	}

	//Attaching screenshot at Log level
	public static Object screencapture(String logDetails, String imagepath) {
		test.log(Status.INFO, logDetails, MediaEntityBuilder.createScreenCaptureFromPath(imagepath).build());
		return test;
	}

	//concatenating the screenshot path
	public void failscreenshot(String name) {
		String screenshotname = concatenate+screshot(name);
		screencapture("Defect", screenshotname);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Name of the Test Case Started : " + result.getName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Success of test cases and its details are : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the Pass test case is:" + result.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the Failed test case is:" + result.getName(), ExtentColor.RED));
		test.log(Status.FAIL, result.getThrowable());

		failscreenshot(result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skip of test cases and its details are : " + result.getName());
		test = reports.createTest(result.getName());
		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the Skip test case is:" + result.getName(), ExtentColor.YELLOW));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failure of test cases and its details are : " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Name of Test Started : " + context.getName());
		try {
			configureReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Name of Test Finish : " + context.getName());
		reports.flush();
	}
}
