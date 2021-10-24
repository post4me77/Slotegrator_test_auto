package com.slot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	private WebDriver driver;
	ReadPropertyFile readPropertyFile= new ReadPropertyFile();

	public DriverFactory() {
		System.setProperty("webdriver.chrome.driver", "jars/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--allowed-ips");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}

	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
}
