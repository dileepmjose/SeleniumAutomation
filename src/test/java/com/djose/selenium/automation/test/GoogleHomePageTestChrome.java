package com.djose.selenium.automation.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.djose.automation.listener.TestListener;
import com.djose.automation.pom.GoogleHomPageObject;
import com.djose.selenium.automation.lib.ExcelReader;
import com.djose.selenium.automation.lib.ProperyFileReader;
import com.djose.selenium.automation.lib.SeleniumWebDriver;

import jxl.read.biff.BiffException;

@Listeners(value=TestListener.class)
public class GoogleHomePageTestChrome  {

	
	@Test
	public void testGoogleSearch() throws IOException, BiffException {
		ExcelReader xlsReader = new ExcelReader("TestCase.xls", "TestCase");
		System.out.println("---" + xlsReader.rowCount());
		
		for (int row = 1; row < xlsReader.rowCount(); row++) {			
			System.out.println(xlsReader.ReadCell("Result", row));
			System.out.println(xlsReader.ReadCell("TestCase", row));
			
		}
		ProperyFileReader properyFile = new ProperyFileReader();
//		properyFile.getPropValues();
//		SeleniumWebDriver selDriver = new SeleniumWebDriver();
//		WebDriver driver = selDriver.loadDriver("Chrome");
//		driver.navigate().to("https://google.com");
//		GoogleHomPageObject homePage = new GoogleHomPageObject(driver);
//		homePage.searchGoogle("Selenium Test");
		
	
	}

}
