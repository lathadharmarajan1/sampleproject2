package org.sampleframework;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Testcase1 extends Baseclass {
public static void main(String[] args) throws IOException {
	LaunchBrowser("chrome");
	LaunchUrl("https://www.facebook.com/");
	maximize();
	WebElement username = locators("id", "email");
	sendkeys(username, "lathadharmarajan@gmail.com");
	getAttribute(username);
	WebElement password = locators("xpath", "//input[@placeholder='Password'] ");
	sendkeys(password, "1265463");
	getAttribute(password);
	WebElement locators2 = locators("name", "login");
	click(locators2);
	screenshot("E:\\screenshot\\1.png");
}
}

