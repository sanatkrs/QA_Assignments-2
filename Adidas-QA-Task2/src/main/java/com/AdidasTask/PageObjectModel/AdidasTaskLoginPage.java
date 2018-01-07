package com.AdidasTask.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.AdidasTask.utils.Waitlib;


public class AdidasTaskLoginPage {
	public WebDriver driver;
	Waitlib wait;
	
	public AdidasTaskLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//input[@id='dwfrm_login_username']")
	WebElement EnterEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@id='dwfrm_login_password']")
	WebElement EnterPassword;
	
	@FindBy(how = How.XPATH, using = "//*[@name='dwfrm_login_login']")
	WebElement LoginButton; 
	
	@FindBy(how =How.XPATH, using = "//div[text()='Incorrect user name or password']")
	WebElement ErrorMessage;

	
	public String credentials(String Email, String Password){
		wait = new Waitlib(driver);
		wait.ImplicitWait();
		EnterEmail.sendKeys(Email);
		EnterPassword.sendKeys(Password);
		LoginButton.click();
		return ErrorMessage.getText();
		
	}
	
	
	
	
}
