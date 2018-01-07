package com.AdidasTask.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.AdidasTask.utils.Waitlib;

public class AdidasTaskProductDetailsPage {
	
	public WebDriver driver;
	Waitlib wait;
	
	public AdidasTaskProductDetailsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//div[@class='custom-input   false label'][text()='Select size']")
	WebElement ProductSizeDropDown;
	@FindBy(how = How.XPATH, using = "//*[@title='M']" )
	WebElement Productsize;
	@FindBy(how = How.XPATH, using ="//*[@class='btn btn-bag  ']")
	WebElement AddtoBag;
	@FindBy(how=How.XPATH, using="//*[@data-auto-id='product-title']")
	WebElement ProductTitle;
	@FindBy(how=How.XPATH, using="//h6[text()='Successfully added to bag']")
	WebElement HeaderText;
	@FindBy(how=How.XPATH, using ="//a[text()='View Bag']")
	WebElement ViewBag;
	@FindBy(how=How.XPATH, using="//*[@id='shipment_wrapper_0_0']/div[2]/div[2]/a")
	WebElement ProductinCart;
	
	
	
	public String CartValueVerification() throws InterruptedException{
	wait = new Waitlib(driver);
	Actions action = new Actions(driver);	
	ProductSizeDropDown.click();
	Thread.sleep(2000);
	//wait.ExplicitWait("xpath", "//*[@title='M']");
	action.moveToElement(Productsize).click().build().perform();
	Thread.sleep(1000);
	AddtoBag.click();
	driver.switchTo().activeElement();
	wait.ExplicitWait("xpath", "//h6[text()='Successfully added to bag']");
	String Headername = HeaderText.getText();
	System.out.println(HeaderText.getText());
	Assert.assertEquals(Headername, "SUCCESSFULLY ADDED TO BAG");
	ViewBag.click();
	String ProductInCartName = ProductinCart.getText();
	System.out.println(ProductInCartName);
	return ProductInCartName;
	//Assert.assertEquals(ProductInCartName, Product_Name);
	}
}
