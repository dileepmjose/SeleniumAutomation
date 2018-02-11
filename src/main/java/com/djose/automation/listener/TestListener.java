package com.djose.automation.listener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	Logger logger = Logger.getLogger(TestListener.class);;

	public void onFinish(ITestContext context) {
	}

	public void onStart(ITestContext context) {
		BasicConfigurator.configure();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult context) {

	}

	public void onTestFailure(ITestResult context) {
		logger.error(printMeassage("FALIURE", context));
	}

	public void onTestSkipped(ITestResult context) {

	}

	public void onTestStart(ITestResult context) {
		
		System.out.println("Method--bgin");

	}

	public void onTestSuccess(ITestResult context) {
		logger.info(printMeassage("SUCESS", context));
	}

	private String printMeassage(String message, ITestResult context) {
		return message + " :   " + context.getMethod();
	}

}
