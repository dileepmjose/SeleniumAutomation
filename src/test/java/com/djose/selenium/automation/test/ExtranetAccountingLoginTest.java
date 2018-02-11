package com.djose.selenium.automation.test;

import java.io.IOException;

import junit.framework.Assert;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.djose.automation.constants.AppConst;
import com.djose.automation.listener.TestListener;
import com.djose.automation.pom.extranetaccounting.LoginPageObject;
import com.djose.selenium.automation.lib.ExcelReader;
import com.djose.selenium.automation.lib.SeleniumWebDriver;

@Listeners(value = TestListener.class)
public class ExtranetAccountingLoginTest extends SeleniumWebDriver {

	@Test
	public void testLoginChrome() throws BiffException, IOException {
		ExcelReader xlsReader = new ExcelReader(AppConst.TC_NAME,
				AppConst.TS_NAME);
		for (int row = 1; row < xlsReader.rowCount(); row++) {
			WebDriver driver = loadDriver(BrowserType.CHROME);
			LoginPageObject login = new LoginPageObject(driver, applicationUrl);
			login.loginExtranetAccounting(
					xlsReader.ReadCell(AppConst.USER_NAME, row),
					xlsReader.ReadCell(AppConst.PASSWORD, row));
			Assert.assertEquals(driver.getTitle(),
					AppConst.EXTNET_HOMEPAGE_TITLE);
			driver.quit();
		}
	}

	@Test
	public void testLoginFirefox() throws BiffException, IOException {
		ExcelReader xlsReader = new ExcelReader(AppConst.TC_NAME,
				AppConst.TS_NAME);
		for (int row = 1; row < xlsReader.rowCount(); row++) {
			WebDriver driver = loadDriver(BrowserType.FIREFOX);
			LoginPageObject login = new LoginPageObject(driver, applicationUrl);
			login.loginExtranetAccounting(
					xlsReader.ReadCell(AppConst.USER_NAME, row),
					xlsReader.ReadCell(AppConst.PASSWORD, row));
			Assert.assertEquals(driver.getTitle(),
					AppConst.EXTNET_HOMEPAGE_TITLE);
			driver.quit();
		}
	}

}
