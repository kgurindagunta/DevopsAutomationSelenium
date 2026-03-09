package com.tests;

import org.testng.annotations.Test;

import com.pages.LoginPage;

public class OrangeHRMLogin extends BaseTest  {
	
	@Test
	public void loginTest() throws InterruptedException {
		
		LoginPage login = new LoginPage();
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickSubmitBtn();
		Thread.sleep(5000);
	}

}
