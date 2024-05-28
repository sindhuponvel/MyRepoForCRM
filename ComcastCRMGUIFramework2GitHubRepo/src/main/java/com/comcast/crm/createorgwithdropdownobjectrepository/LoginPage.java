package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver d;
	public LoginPage(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userNameEdt;
	
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordEdt;
	
	@FindBy(xpath="//input[@id='submitButton']")
	private WebElement loginBtn;
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	

	public void loginToApp(String url,String username, String password)
	{
		d.manage().window().maximize();
		d.get(url);
		userNameEdt.sendKeys(username);
		
	}

}
