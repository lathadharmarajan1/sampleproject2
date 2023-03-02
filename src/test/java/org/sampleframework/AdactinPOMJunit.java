package org.sampleframework;

import java.io.IOException;

import javax.swing.border.TitledBorder;

import org.apache.poi.sl.usermodel.Sheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AdactinPOMJunit extends Baseclass{
	static String name;
	static AdactinLoginPOM pom;
	@BeforeClass
public static void browserlaunch() {
		LaunchBrowser("chrome");
		LaunchUrl("https://adactinhotelapp.com/");
		maximize();
		pom= new  AdactinLoginPOM();
	}
	@Test
	//valid logincredentials
	public void TC1() throws InterruptedException {
		name="testcase1.png";
		WebElement username = pom.getUsername();
		sendkeys(username, "LATHADHARMARAJAN");
		WebElement password = pom.getPassword();
		sendkeys(password, "237JM1");
		WebElement login = pom.getLogin();
		click(login);
		}
	@Test
	//Invalid logincredentials
		public void TC2() throws InterruptedException   {
		name="testcase2.png";
		backward();
		WebElement username = pom.getUsername();
		sendkeys(username, "LATHADHARARAJAN");
		WebElement password = pom.getPassword();
		sendkeys(password, "237JM1");
		WebElement login = pom.getLogin();
		click(login);
		}
	
	@Test
	//Invalid logincredentials
	public void TC3(){
		name="testcase3.png";
		refresh();
		WebElement username = pom.getUsername();
		sendkeys(username, "LATHADHARMARAJAN");
		WebElement password = pom.getPassword();
		sendkeys(password, "27JM1");
		WebElement login = pom.getLogin();
		click(login);
		}

	@After
	public void screenshot() throws IOException {
		screenshot("C:\\Users\\latha\\eclipse-workspace\\sampleProjectFramework\\target\\ "+name);
			}
	@AfterClass
	public static void teardown() {
		driver.quit();
		
	}
	
	
}
