package com.fb.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.utils.TestUtil;
import com.qa.pages.ContactPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import basepackage.TestBase;


public class HomePageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactPage contactpage;

	public HomePageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setup() throws Exception{
		intialisation();
		 loginpage = new LoginPage();
		 testutil =new TestUtil();
		 contactpage = new ContactPage();
		 homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		 String title=homepage.vefiryhomepageTitle();
		 Assert.assertEquals(title,"CRMPRO","The Title Is Not Matched With Acuall Res");
	}
	@Test(priority=2)
	public void validateUserNameLableTest() {
		 testutil.switchToFrame();
		 boolean falg=homepage.validateUserNameLable();
		 Assert.assertTrue(falg);
	}
	@Test(priority=3)
	public void clickOnContactsLinkTest() throws Exception {
		 testutil.switchToFrame();
		 contactpage=homepage.clickOnContactsLinks();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
