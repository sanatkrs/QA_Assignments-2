package com.AdidasTask.utils;

import java.io.File;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName)
	{
	try
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String userDirector = System.getProperty("user.dir");
		String resultFile = userDirector
				+ "\\src\\test\\resources\\Screenshots\\"+screenshotName+".png";
		File destination = new File(resultFile);
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot Taken");
		return resultFile;
		
	}
	catch(Exception e)
	{
		System.out.println("Exception while taking screenshot" + e.getMessage());
		return e.getMessage();
		
	}	
	
	
	
	
	

	
}

	
}
