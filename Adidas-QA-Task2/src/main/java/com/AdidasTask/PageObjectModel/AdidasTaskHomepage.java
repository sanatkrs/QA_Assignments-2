package com.AdidasTask.PageObjectModel;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.AdidasTask.utils.Waitlib;

public class AdidasTaskHomepage {
	
	
	public WebDriver driver;
	Waitlib wait;
	
	public AdidasTaskHomepage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = ".//a[@manual_cm_sp='customer_info-_-Sign in']")
	WebElement Signin_Link;
	@FindBy(how = How.XPATH, using = ".//a[@title='Login and Register']")
	WebElement SigninPage;
	@FindBy(how = How.XPATH,using = "//a[@manual_cm_sp ='header-_-Men']")
	WebElement Men;
	@FindBy(how= How.LINK_TEXT, using = "T-Shirts & Polos")
	WebElement Tshirts;
	@FindBy(how=How.XPATH, using = "//div[@id ='product-CE1820']")
	WebElement product;
	@FindBy(how=How.XPATH, using="//*[@data-auto-id='product-title']")
	WebElement ProductTitle;

	
	
	
	
	public void SignInPage_Redirect(){
		Signin_Link.click();
		String Text = SigninPage.getText();
		//Assert.assertEquals(actual, expected);
		System.out.println(Text);
	}
	
	
	
	public String Men_Menu() throws InterruptedException{
		Actions action = new Actions(driver);
		wait = new Waitlib(driver);
		action.moveToElement(Men).build().perform();
		wait.ExplicitWait("LinkText", "T-Shirts & Polos");
		Tshirts.click();
		product.click();
		String Product_Name = ProductTitle.getText();
		
		return Product_Name;

		
	}
	
}