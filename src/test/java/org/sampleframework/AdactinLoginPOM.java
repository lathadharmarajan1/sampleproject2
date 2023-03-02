package org.sampleframework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinLoginPOM extends Baseclass{
	public AdactinLoginPOM() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement Username;
	@FindBy(name="password")
	private WebElement Password;
	@FindBy(name="login")
	private WebElement Login;
	
	
	public WebElement getUsername() {
		return Username;
	}
	
	public WebElement getPassword() {
		return Password;
	}
	
	public WebElement getLogin() {
		return Login;
	}
	
	
	

}
