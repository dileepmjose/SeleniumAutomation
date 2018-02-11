package com.djose.automation.pom.extranetaccounting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	
	public HomePageObject(WebDriver driver, String url) {
		PageFactory.initElements(driver, this);		
	}


}
