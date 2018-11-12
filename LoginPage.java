package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.TestBase;

public class LoginPage extends TestBase {
	
	//Object Repository or OR
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
    @FindBy(xpath="//input[@class='btn btn-small']")
    WebElement loginbtn;
	
//	@FindBy(xpath="//input[@type='submit' and @value='Login']")
//	WebElement loginbtn;
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[2]/a/font")
	WebElement signupbtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;

	public LoginPage()throws Exception{
		PageFactory.initElements(driver,this);

}
	//Actions
	
	public String validatetitle() {
		return driver.getTitle();
	}
	public boolean validateimg() {
		return crmlogo.isDisplayed();
	}
	public HomePage login(String un,String pwd) throws Exception {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
	    return new HomePage();
		
		
		
	}
	
	
	
	
	
	
	
	
}