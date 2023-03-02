package org.sampleframework;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.swing.border.TitledBorder;

import org.apache.poi.sl.usermodel.Sheet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import dev.failsafe.internal.util.Assert;

public class JunitBCDDAdactin extends Baseclass{
	static String name;
	@BeforeClass
public static void browserlaunch() {
		LaunchBrowser("chrome");
		LaunchUrl("https://adactinhotelapp.com/");
		maximize();
	}
	@Test 
	public  void TC0() throws IOException {
		readexcel("F:\\JAVA SELENIUM\\framework\\framework sathish sir\\adactin.xlsx", "Sheet1");
	}
	@Test
	public void TC1() throws InterruptedException {
		name="testcase1.png";
		WebElement username = locators("id", "username");
		username.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		WebElement password = locators("id", "password");
		password.sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		WebElement loginbutton = locators("id", "login");
		click(loginbutton);
		String title = title();
		junit.framework.Assert.assertEquals("Adactin.com - Search Hotel", title);
	}
	@Test
	public void TC2() {
		name="testcase2.png";
		WebElement location = locators("name", "location");
		select(location, "value", "Brisbane");
		WebElement hotels = locators("name", "hotels");
		select(hotels,"text", "Hotel Hervey");
		WebElement roomtype = locators("id", "room_type");
		select(roomtype, "value", "Double");
		WebElement roomno = locators("id", "room_nos");
		select(roomno, "value", "6");
		WebElement checkIn = locators("id", "datepick_in");
		checkIn.sendKeys(sheet.getRow(3).getCell(1).getStringCellValue());
		WebElement checkout = locators("id","datepick_out");
		checkout.sendKeys(sheet.getRow(4).getCell(1).getStringCellValue());
		WebElement adultperroom= locators("id","adult_room");
		select(adultperroom, "value", "2");
		WebElement childperroom = locators("id", "child_room");
		select(childperroom, "value", "2");
		WebElement submitbutton = locators("id", "Submit");
		click(submitbutton);
		String title2 = title();
		org.junit.Assert.assertEquals("Adactin.com - Select Hotel",title2);
	}
	@Test
	public void TC3() {
		name="testcase3.png";
		WebElement selecthotel = locators("id","radiobutton_0");
		click(selecthotel);
		WebElement continuebutton = locators("id", "continue");
		click(continuebutton);
		String title3 = title();
		org.junit.Assert.assertEquals("Adactin.com - Book A Hotel",title3);
	}

	@Test
	public void TC4() {
		name="testcase4.png";
		WebElement firstname = locators("id","first_name");
		firstname.sendKeys(sheet.getRow(5).getCell(1).getStringCellValue());
		WebElement lastname = locators("id","last_name");
		lastname.sendKeys(sheet.getRow(6).getCell(1).getStringCellValue());
		WebElement address = locators("id","address");
		address.sendKeys(sheet.getRow(7).getCell(1).getStringCellValue());
		WebElement creditcardnum = locators("id", "cc_num");
		creditcardnum.sendKeys(sheet.getRow(8).getCell(1).getStringCellValue());
		WebElement credittype = locators("id", "cc_type");
		select(credittype, "value", "AMEX");
		WebElement expirymonth = locators("id", "cc_exp_month");
		select(expirymonth, "value", "4");
		WebElement expiryyear = locators("id", "cc_exp_year");
		select(expiryyear, "value", "2012");
		WebElement ccv = locators("id", "cc_cvv");
		creditcardnum.sendKeys(sheet.getRow(9).getCell(1).getStringCellValue());
		WebElement booknowbutton = locators("id","book_now");
		click(booknowbutton);
		String title4 = title();
		org.junit.Assert.assertEquals("Adactin.com - Book A Hotel",title4);
		
	}
	@Test
	public void TC5() throws InterruptedException {
		name="testcase5.png";
		Thread.sleep(50000);
		WebElement orederno = locators("id", "order_no");
		System.out.printf("your order no is:  " );
		getAttribute(orederno);
		String title5 = title();
		org.junit.Assert.assertEquals("Adactin.com - Hotel Booking Confirmation",title5);
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
