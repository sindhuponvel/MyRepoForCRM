package com.comcast.crm.createcontactobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.objectrepositoryutility1.HomePage;


public class CreateNewContactPage{
	WebDriver d;
	public void CreateNewContactPage(WebDriver d)
	{
		this.d= d;
		PageFactory.initElements(d,this);
	}
	
	


}
