package com.djose.automation.pom.extranetaccounting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.djose.selenium.automation.lib.ExcelReader;

public class LoginPageObject {

	public LoginPageObject(WebDriver driver, String url) {
		PageFactory.initElements(driver, this);
		driver.navigate().to(url);
	}

	@FindBy(name = "j_username")
	public WebElement txtlogin;

	@FindBy(name = "j_password")
	public WebElement txtPassword;

	@FindBy(name = "x")
	public WebElement btnLogin;

	public void loginExtranetAccounting(String userId, String password) {
		txtlogin.sendKeys(userId);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
	}

	public void read(ExcelReader e) {
		// TODO Auto-generated method stub

	}



}
