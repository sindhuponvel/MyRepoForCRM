package com.comcast.crm.createorgwithdropdownobjectrepository;

import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseMainTest;
import com.comcast.crm.objectrepositoryutility1.HomePage;
import com.comcast.crm.objectrepositoryutility1.LoginPage1;

public class CreateOrgWithDropDown extends BaseMainTest{
	@Test
	public void createOrgWithDropDown()
	{
		HomePage hp= new HomePage(d);
		hp.getOrgLink().click();
		
		
		
	}

}
