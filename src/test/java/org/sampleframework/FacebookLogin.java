package org.sampleframework;

import java.io.IOException;
import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookLogin extends Baseclass {
	static String name;
	static WebElement username;
	@BeforeClass
	public static void launchBrowser() {
		LaunchBrowser("chrome");
		LaunchUrl("https://www.facebook.com/");
		maximize();
		
		 
		
	}
	@Before
	public void refreshpage() {
		refresh();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		username = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			}
	@Test
	public void TC01() {
		name="TEST1.png";
		sendkeys(username, "lathadharmarajan@gmail.com");
		}
	@Test
	public void TC02() {
		name=".TEST2.png";
		sendkeys(username, "krishna@gmail.com");
	}
	@Test
	public void TC03() {
		name=".TEST3.png";
		sendkeys(username, "kanushika@gmail.com");
	}
	@Test
	public void TC04() {
		name=".TEST4.png";
		sendkeys(username, "vimal@gmail.com");
	}
	@After
	public void Screenshot() throws IOException {
	screenshot("C:\\Users\\latha\\eclipse-workspace\\sampleProjectFramework\\target\\ "+name);
   	}
	@AfterClass
	public static void closebrowser() {
		System.out.println("Test completed");
		driver.quit();
	}
}
