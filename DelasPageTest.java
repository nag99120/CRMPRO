package com.fb.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.utils.TestUtil;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import basepackage.TestBase;

public class DelasPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	DealsPage dealspage;
	String sheetName="Deals";

	public DelasPageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setup() throws Exception {
		intialisation();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil =new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		dealspage = homepage.clickOnDealslink();
		
		
	}
	@Test(priority=1)
	public void verifydelasLabelTest() throws Exception {
              boolean flag= dealspage.valiadteDealslabel();	
              Assert.assertTrue(flag,"The Deals Label not displayed");
	}
	@DataProvider
	public Object[][] getCrmTestData() {
		 Object[][] data=TestUtil.getTestData(sheetName);
		 return data;	
	}
	@Test(priority=2,dataProvider="getCrmTestData")
	public void validateNewDealsTest(String Title,String Comp,String primecontact,String Amount ) {
		homepage.clickOnNewDeal();
		dealspage.clickOnNewDealsLink(Title, Comp, primecontact, Amount);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
