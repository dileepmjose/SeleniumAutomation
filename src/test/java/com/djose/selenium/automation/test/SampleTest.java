package com.djose.selenium.automation.test;


import junit.framework.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.djose.automation.listener.TestListener;

@Listeners(value=TestListener.class)
public class SampleTest {
	

// test case 1

@Test
public void testCase1() {
System.out.println("Executing test case 1");
}



@Test
public void testCase2() {
System.out.println("Executing test case 2");
Assert.assertEquals("d", "d");

}

@BeforeMethod
public void beforeMethod() {
System.out.println("Executing beforeMethod");
}

@AfterMethod
public void afterMethod() {
System.out.println("Executing afterMethod");
}

@BeforeClass
public void beforeClass() {
System.out.println("Executing beforeClass");
}

@AfterClass
public void afterClass() {
System.out.println("Executing afterClass");
}

@BeforeTest
public void beforeTest() {
System.out.println("Executing beforeTest");
}

@AfterTest
public void afterTest() {
System.out.println("Executing afterTest");
}

@BeforeSuite
public void beforeSuite() {
System.out.println("Executing beforeSuite");
}

@AfterSuite
public void afterSuite() {
System.out.println("Executing afterSuite");
}
}