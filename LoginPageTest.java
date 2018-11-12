package com.fb.qa.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import basepackage.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() throws Exception {
		super();
	}
	@BeforeMethod
	public void setup() throws Exception{
		intialisation();
		 loginpage = new LoginPage();
		
     }
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validatetitle();
		Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void validateImgTest() {
		boolean flag = loginpage.validateimg();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginPageTest() throws Exception {
		homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
