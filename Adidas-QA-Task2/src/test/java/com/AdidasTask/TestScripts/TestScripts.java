package com.AdidasTask.TestScripts;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AdidasTask.PageObjectModel.AdidasTaskHomepage;
import com.AdidasTask.PageObjectModel.AdidasTaskLoginPage;
import com.AdidasTask.PageObjectModel.AdidasTaskProductDetailsPage;
import com.AdidasTask.testbase.TestBase;
import com.AdidasTask.utils.ExcelDataconfig;
import com.AdidasTask.utils.Screenshot;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


@Listeners(com.AdidasTask.utils.TestNGListerner.class)
public class TestScripts extends TestBase {
	
	
	@Test(priority=1)
	public void HomePage_Title_Verification(){
		test = extent.createTest("Verify the title for Homepage");
		String name = driver.getTitle();
		test.log(Status.INFO, "Title is ready for verifications");
		Assert.assertEquals(name, "adidas virallinen verkkosivusto | adidas Suomi");
		test.pass("Title Verified");
	}
	
	
	
	@Test(dataProvider= "Login_Credentials", priority=3)
	public void LoginCheck(String username, String password){
		test = extent.createTest("Verify the login functionality with invalid creadentials");
		AdidasTaskHomepage Signin = PageFactory.initElements(driver, AdidasTaskHomepage.class);
		AdidasTaskLoginPage Details = PageFactory.initElements(driver, AdidasTaskLoginPage.class);
		Signin.SignInPage_Redirect();
		String ErrorMessage = Details.credentials(username, password);
		test.log(Status.INFO, "Invalid credentials are entered");
		Assert.assertEquals(ErrorMessage, "INCORRECT USER NAME OR PASSWORD");
		test.pass("User is not able to login with invalid credentials");
		
	}
	
	
	@Test(priority=2)
	public void CartValueVerification() throws InterruptedException{
		
		test = extent.createTest("Verify When user is adding any product in the cart same product is visible in the cart");
		AdidasTaskHomepage Home = PageFactory.initElements(driver, AdidasTaskHomepage.class);
		String Productname = Home.Men_Menu();
		test.log(Status.INFO, "Product name has been taken from the product detail page");
		AdidasTaskProductDetailsPage Productdetail = PageFactory.initElements(driver, AdidasTaskProductDetailsPage.class);
		String Productnameincart = Productdetail.CartValueVerification();
		test.log(Status.INFO, "Product name has been taken from the cart");
		Assert.assertEquals(Productname, Productnameincart);
		test.pass("Product name verified: found same in product detail page and cart");
	}
	
	@AfterMethod
	public void TearDown(ITestResult result) throws IOException{
		if (result.getStatus()==ITestResult.FAILURE){
			String screenshot_path= Screenshot.captureScreenshot(driver, result.getName());
			ExtentTest image = test.addScreenCaptureFromPath(screenshot_path);
			test.log(Status.FAIL, "Test Script Failed and details are: "+ result.toString() );
			test.log(Status.FAIL, "screenshot Below" + image);
		}			
		extent.flush();
		driver.close();
		
	}
	
	@AfterTest
	public void report(){
		
		
		
	}
	
	@DataProvider(name="Login_Credentials")
	public Object[][] PassData(){
		
		ExcelDataconfig config = new ExcelDataconfig();
		
		int rows =config.GetRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0; i<rows; i++){
			
			data[i][0] = config.ExcelRead(0, i, 0);
			data[i][1] = config.ExcelRead(0, i, 1 );
		}
		
		
		
		return data;
		
		
		
	}
	
	
	
}
