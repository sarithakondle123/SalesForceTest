package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FileConstants;

public class BaseTest {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();
	
	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ThreadLocal<ExtentTest> threadExtentTest = new ThreadLocal<ExtentTest>();
	 public static Logger logger = LogManager.getLogger("BaseTest");
	
	@BeforeSuite
	public void doConfiguration() {
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FileConstants.REPORT_PATH);		
		extent.attachReporter(sparkReporter);
		
		//threadExtentTest.set();

	}
	
	@AfterSuite
	public void tearDownConfig() {
		extent.flush();
	}
	
	public static void setDriver(String browserName,boolean headless)
	{
		
		driver = BaseTest.getWebDriver(browserName, headless);		
		threadLocal.set(driver);		 
	}
	
	public static WebDriver getDriver()
	{
		return threadLocal.get();
	}
	
	public static WebDriver getWebDriver(String browserName,boolean headless)
	
	{
		browserName = browserName.toLowerCase();
		
		switch(browserName)
		{
		case "chrome" : 
			if(headless)
				{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless","--diable--gpu");
				driver = new ChromeDriver(options);
				}			
			else 
				driver = new ChromeDriver();
			break;
			
		case "edge": 
			driver = new EdgeDriver();
			break;
			
		case "safari": 
			driver = new SafariDriver();
			break;
			
			default: 
				driver =null;
				logger.error("Driver Configuration failed");
			System.out.println("You are  allowed to use only chrome, safari and edge");
		}
		return driver;
	}

}
