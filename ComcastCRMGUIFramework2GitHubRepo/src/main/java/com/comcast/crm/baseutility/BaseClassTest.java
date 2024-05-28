package com.comcast.crm.baseutility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("====Connect to DB, Report config====");
	}
	@BeforeClass
	public void configBC()
	{
		System.out.println("====Launch browser=====");
	}
	@BeforeMethod
	public void configBM()
	{
		System.out.println("=======Login======");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("====Logout======");
	}
	@AfterClass
	public void configAC()
	{
		System.out.println("====close the browser=====");
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("=====Close DB,Report backup========");
	}

}
