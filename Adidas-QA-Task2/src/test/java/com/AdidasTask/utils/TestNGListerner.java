package com.AdidasTask.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListerner implements ITestListener {

	public void onFinish(ITestContext result) {
		
		System.out.println("TestCases finish and TestScript is " + result.getName());	
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("TestCases failed and TestScript is " + result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("TestCases Skipped and TestScript is " + result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("TestCases started and TestScript is " + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase success and TestScript is " + result.getName());
		
	}

}
