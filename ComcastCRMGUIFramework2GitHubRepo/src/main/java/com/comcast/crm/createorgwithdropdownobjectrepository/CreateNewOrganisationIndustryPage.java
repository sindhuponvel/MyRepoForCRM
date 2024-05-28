package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganisationIndustryPage {

	WebDriver d;

	public CreateNewOrganisationIndustryPage(WebDriver d) {
		this.d = d;
		PageFactory.initElements(d, this);

	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement valueDropDown;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getValueDropDown() {
		return valueDropDown;
	}
	
	
	public void selectIndustryDropDown()
	{
		WebDriverUtility wLib= new WebDriverUtility();
		wLib.select(industryDropDown, "Banking");
				
			
	}
	

}
