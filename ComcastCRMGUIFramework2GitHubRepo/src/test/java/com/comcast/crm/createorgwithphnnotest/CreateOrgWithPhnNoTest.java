package com.comcast.crm.createorgwithphnnotest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.Base1;
import com.comcast.crm.baseutility.BaseMainTest;
import com.comcast.crm.createorgwithPhnoObjrepository.CreateNewOrgWithPhNo;
import com.comcast.crm.createorgwithPhnoObjrepository.OrgPhnNoInfoPage;
import com.comcast.crm.createorgwithdropdownobjectrepository.HomePage;
import com.comcast.crm.createorgwithdropdownobjectrepository.OrganisationPage;

public class CreateOrgWithPhnNoTest  extends Base1{
	@Test
	public void createOrgWithPhnNoTest() throws Exception
	{
	   
	   HomePage hp = new HomePage(d);
	   hp.getOrgLnk().click();
	   
	   String orgName=eLib.readDataFromExcel("Sheet1", 1, 2)+jLib.getRandomNumber();
	   
	   OrganisationPage op = new OrganisationPage(d);
	   op.getCreateNewOrgImg().click();
	   String phnNo = eLib.readDataFromExcel("Sheet1", 1, 4);
	   
	   CreateNewOrgWithPhNo cop= new CreateNewOrgWithPhNo(d);
	   cop.createOrgWithPhn(orgName, phnNo);
	   cop.getSaveBtn().click();
	   
	   OrgPhnNoInfoPage oip= new OrgPhnNoInfoPage(d);
	   
	   String actOrgName=oip.getOrgHeaderInfo().getText();
	   if(actOrgName.contains(orgName))
	   {
		   System.out.println(orgName+ " is verified successfully");
	   }else
	   {
		   System.err.println(orgName+ " mismatching");
		   Assert.fail();
	   }
	   
	   String actPhnNo=oip.getPhnCheckInfo().getText();
	   if(actPhnNo.trim().equals(phnNo))
	   {
		   System.out.println(phnNo+ " is verified successfully");  
	   }else
	   {
		   System.err.println(phnNo+ " mismatching");
		   Assert.fail();
	   }
	   
	  
	   }

}
