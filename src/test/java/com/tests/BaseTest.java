package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.drivers.DriverSetup;
public class BaseTest {
	
	@BeforeMethod
	protected void setUp() {
		
		
		DriverSetup.initDriver();
		DriverSetup.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@AfterMethod
	protected void tearDown() {
		
		DriverSetup.quitDriver();
	}

}
