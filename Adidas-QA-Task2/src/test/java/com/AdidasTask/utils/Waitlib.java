package com.AdidasTask.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Waitlib{

		WebDriver driver;
		

	public Waitlib(WebDriver driver)
		{
		this.driver = driver;
		}



	public void ExplicitWait(String Locater, String path){
		WebDriverWait wait = new WebDriverWait(driver, 4);
		if(Locater.equalsIgnoreCase("xpath")){
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(path))));
		}
		else if(Locater.equalsIgnoreCase("linktext"))
		{	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(path)));	
		}
		
		else if(Locater.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(path))));
		}
		
		else if(Locater.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(path)));
		}
	}
	
		public void ImplicitWait() {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	}