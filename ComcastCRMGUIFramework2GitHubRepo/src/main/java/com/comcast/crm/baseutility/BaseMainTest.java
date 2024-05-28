package com.comcast.crm.baseutility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility1.HomePage;
import com.comcast.crm.objectrepositoryutility1.LoginPage1;

public class BaseMainTest {

	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();

	public WebDriver d = null;

	@BeforeSuite(groups= {"Smoke Test","Regression Test"})
	public void configBS() throws Exception {
		System.out.println("Connect to Database");
		dLib.getDBConnection();

	}
    @Parameters//("myBrowser")
	@BeforeClass(groups= {"Smoke Test","Regression Test"})
	public void configBC() throws Exception {//String Browser)
		System.out.println("Launch the browser");
		//String BROWSER=Browser;
		String BROWSER = fLib.getDataFromProperties("Browser");
		String brow = BROWSER;

		if (brow.equals("Chrome")) {
			d = new ChromeDriver();
		} else if (brow.equals("Edge")) {
			d = new EdgeDriver();
		} else {
			d = new FirefoxDriver();
		}
	}

	@BeforeMethod(groups= {"Smoke Test","Regression Test"})
	public void configBM() throws Exception {

		System.out.println("Login to application");
		wLib.waitForPageToLoad(d);
		String URL = fLib.getDataFromProperties("Url");
		d.get(URL);
		LoginPage1 lp = new LoginPage1(d);
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
		lp.loginToApp(USERNAME, PASSWORD);

	}

	@AfterMethod(groups= {"Smoke Test","Regression Test"})
	public void configAM() {
		System.out.println("Logout application");
		HomePage hp = new HomePage(d);
		hp.signOut();
	}

	@AfterClass(groups= {"Smoke Test","Regression Test"})
	public void configAC() {
		System.out.println("Close the broswer");
		d.quit();
	}

	@AfterSuite(groups= {"Smoke Test","Regression Test"})
	public void configAS() throws Exception {
		System.out.println("Disconnect to Database");
		dLib.closeDbConnection();
	}

}
