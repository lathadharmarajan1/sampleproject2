package org.sampleframework;

import org.openqa.selenium.WebElement;

public class AdactinHotel extends Baseclass{
public static void main(String[] args) throws InterruptedException {
	LaunchBrowser("chrome");
	LaunchUrl("https://adactinhotelapp.com/");
	WebElement username = locators("id","username");
	sendkeys(username,"lathadharmarajan");
	WebElement password = locators("id", "password");
	sendkeys(password, "237JM1");
	WebElement loginbutton = locators("id", "login");
	click(loginbutton);
	WebElement location = locators("name", "location");
	select(location, "value", "Brisbane");
	WebElement hotels = locators("name", "hotels");
	select(hotels,"text", "Hotel Hervey");
	WebElement roomtype = locators("id", "room_type");
	select(roomtype, "value", "Double");
	WebElement roomno = locators("id", "room_nos");
	select(roomno, "value", "6");
	WebElement checkIn = locators("id", "datepick_in");
	sendkeys(checkIn, "23/2/2023");
	WebElement checkout = locators("id","datepick_out");
	sendkeys(checkout,"25/2/2023");
	WebElement adultperroom= locators("id","adult_room");
	select(adultperroom, "value", "2");
	WebElement childperroom = locators("id", "child_room");
	select(childperroom, "value", "2");
	WebElement submitbutton = locators("id", "Submit");
	click(submitbutton);
	WebElement selecthotel = locators("id","radiobutton_0");
	click(selecthotel);
	WebElement continuebutton = locators("id", "continue");
	click(continuebutton);
	WebElement firstname = locators("id","first_name");
	sendkeys(firstname,"Latha");
	WebElement lastname = locators("id","last_name");
	sendkeys(lastname,"Dharmarajan");
	WebElement address = locators("id","address");
	sendkeys(address, "23, sriram nagar, Trichy");
	WebElement creditcardnum = locators("id", "cc_num");
	sendkeys(creditcardnum, "1234545632765482");
	WebElement credittype = locators("id", "cc_type");
	select(credittype, "value", "AMEX");
	WebElement expirymonth = locators("id", "cc_exp_month");
	select(expirymonth, "value", "4");
	WebElement expiryyear = locators("id", "cc_exp_year");
	select(expiryyear, "value", "2012");
	WebElement ccv = locators("id", "cc_cvv");
	sendkeys(ccv, "123");
	WebElement booknowbutton = locators("id","book_now");
	click(booknowbutton);
	Thread.sleep(10000);
	WebElement orederno = locators("id", "order_no");
	System.out.printf("your order no is:  " );
	getAttribute(orederno);
	
//	
	}
}
