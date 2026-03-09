package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.drivers.DriverSetup;

public final class LoginPage {

	

	private final static By input_username = By.xpath("//input[@name='username']");

	private final static By input_password = By.xpath("//input[@name='password']");

	private final static By btn_submit = By.xpath("//button");

	WebDriverWait wait = new WebDriverWait(DriverSetup.getDriver(), Duration.ofSeconds(30));

	public LoginPage enterUsername(String value) {
		
		WebElement uname =wait.until(ExpectedConditions.visibilityOfElementLocated(input_username));
        uname.sendKeys(value);
		//enterInput(input_username, value,"Username");
		return new LoginPage();
	}

	public LoginPage enterPassword(String value) {
		
		WebElement upass =wait.until(ExpectedConditions.visibilityOfElementLocated(input_password));
		upass.sendKeys(value);
		
		//DriverSetup.getDriver().findElement(input_password).sendKeys(value);

		//enterInput(input_password, value,"Password");
		return new LoginPage();
	}
	
	public  void clickSubmitBtn() {
		WebElement btnSubmit =wait.until(ExpectedConditions.visibilityOfElementLocated(btn_submit));
		btnSubmit.click();
			}







}
