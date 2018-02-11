package com.djose.automation.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomPageObject {

	public GoogleHomPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "q")
	public WebElement txtSearch;

	@FindBy(name = "btnG")
	public WebElement btnSearch;

	public void searchGoogle(String text) {
		txtSearch.sendKeys("Selenium");
		btnSearch.click();
	}

}
