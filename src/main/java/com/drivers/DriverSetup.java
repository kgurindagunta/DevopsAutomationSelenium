package com.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetup {
	
	private static WebDriver  driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static void  initDriver()  {
		
		String isHeadless = System.getProperty("headless", "no");
		String isRemoteDriver = System.getProperty("remoteDriver","no");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");   // REQUIRED
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");
		if(isHeadless.equals("yes") && isRemoteDriver.equalsIgnoreCase("no")) {
		 driver = new ChromeDriver(options);	
		}
		else if(isRemoteDriver.equalsIgnoreCase("yes") && isRemoteDriver.equalsIgnoreCase("yes")) {
			try {
				driver = new RemoteWebDriver(new URL("http://selenium-hub:4444/wd/hub"), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			driver = new ChromeDriver();	
		}
		
		driver.manage().window().maximize();
	}
	
	public static void quitDriver() {
		driver.quit();
	}

}
