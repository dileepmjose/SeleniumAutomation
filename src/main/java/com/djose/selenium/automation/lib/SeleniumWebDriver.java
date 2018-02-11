package com.djose.selenium.automation.lib;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.djose.automation.constants.AppConst;

public class SeleniumWebDriver {
	
	public String applicationUrl = "";
	
	
	public SeleniumWebDriver() {
		super();
		ProperyFileReader profileRead = new  ProperyFileReader();
		try {
			applicationUrl  =  profileRead.getPropValues("ApplicationUrl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
    * Return the WebDriver for browserName
    * 
    * @param browserName
    * 
    * @return WebDriver
    */
	public WebDriver loadDriver(String browserName) {
		if (browserName.equalsIgnoreCase(BrowserType.FIREFOX))
			return loadFireFoxDriver();
		else if (browserName.equalsIgnoreCase(BrowserType.CHROME))
			return loadChormeDriver();
		else if (browserName.equalsIgnoreCase(BrowserType.IE))
			return loadInternetExplorerDriver();
		return null;
	}
	
	
	

	/**
	 * Load the Firefox Webdriver
	 * 
	 * @return WebDriver
	 */
	private WebDriver loadFireFoxDriver() {
		System.setProperty(AppConst.FIREFOX_WEB_DRIVER_KEY,
				AppConst.FIREFOX_WEB_DRIVER_VALUE);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return new FirefoxDriver(capabilities);
	}

	/**
	 * Load the Chorme Webdriver
	 * 
	 * @return WebDriver
	 */
	private WebDriver loadChormeDriver() {
		System.setProperty(AppConst.CHORME_WEB_DRIVER_KEY,
				AppConst.CHORME_WEB_DRIVER_VALUE);
		ChromeOptions o = new ChromeOptions();
		o.addArguments(AppConst.DISABLE_EXTENSION_VALUE);
		o.addArguments(AppConst.START_MAXIMIED_VALUE);
		return new ChromeDriver(o);
	}

	/**
	 * Load the Internet Explorer Webdriver
	 * 
	 * @return WebDriver
	 */
	private WebDriver loadInternetExplorerDriver() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		System.setProperty(AppConst.IE_WEB_DRIVER_KEY,
				AppConst.IE_WEB_DRIVER_VALUE);
		return new InternetExplorerDriver();
	}
	
	

	

}
