package com.fb.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.qa.utils.TestUtil;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import basepackage.TestBase;


public class ContactPageTest extends TestBase {
	//private static final String getCrmTestData = null;
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactPage contactpage;
	String sheetName="Contacts";

	public ContactPageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setup() throws Exception{
		intialisation();
		 loginpage = new LoginPage();
		 testutil =new TestUtil();
		 contactpage = new ContactPage();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		 contactpage = homepage.clickOnContactsLinks();
		
	}
//	@Test(priority=1)
//	public void verifyContactLableTest() {
//		 boolean flag=contactpage.verifyContactLable();
//		 Assert.assertTrue(flag);
//	}
//	@Test(priority=2)
//	public void clickOnAdvancedButtonTest() throws Exception {
//		contactpage.clickOnAdvanceButton();
//	}
	@DataProvider
	public Object[][] getCrmTestData() {
	 Object[][] data=TestUtil.getTestData(sheetName);
	 return data;		
	}
	@Test(dataProvider="getCrmTestData")
	public void validateNewContactTest(String title,String firstname,String lastname,String nickname,String comp) {
	//public void validateNewContactTest() {
	homepage.clickOnNewContact();
		contactpage.createNewContact(title, firstname, lastname, nickname, comp);
		//contactpage.createNewContact("Mr.","firstname","lastname","nickname","comp");
	}	
    @AfterMethod
     public void tearDown() {
	 driver.quit();
}
}
