package com.AdidasTask.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.AdidasTask.utils.TestProperties;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.*;



public class TestBase {
	public WebDriver driver;
	public ExtentHtmlReporter reporter; 
	public ExtentReports extent;
	public ExtentTest test;
	
	
	@BeforeTest
	public void ExtentReportinit(){
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//src//test//resources//Report//AllReport.html");	
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("OS Version", System.getProperty("os.version"));
		extent.setSystemInfo("Browser Name",TestProperties.browser_type);
		extent.setSystemInfo("URL",TestProperties.base_url);
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		
		reporter.config().setDocumentTitle("Adidas QA Task-2");
		reporter.config().setReportName("Adidas UI Test Automation Report");
		reporter.config().setTheme(Theme.STANDARD);
	}
	
	
	
	
	@BeforeMethod
	public void BrowserFactory(){
		
		
	
		if (TestProperties.browser_type.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
			System.getProperty("user.dir") + "//src///test//resources//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(TestProperties.base_url);
			
			
		} else if (TestProperties.browser_type.equalsIgnoreCase("chrome")) {
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "//src//test//resources//Drivers//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
			driver.get(TestProperties.base_url);
		
	}
		
			
			
		
	
}

	
	
}