package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.TestBase;

public class HomePage extends TestBase {
	
	//Objecr Repository
	
	@FindBy(xpath="//td[contains(text(),'User: nag reddy')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'Cases')")
	WebElement casesLink;
	
	@FindBy(xpath="//a[contains(text(),'Forms')")
	WebElement formsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Deals Related
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newdealLink;


	public HomePage() throws Exception {
	PageFactory.initElements(driver,this);
	}
	
	public String vefiryhomepageTitle() {
		 return driver.getTitle();
	}
	public boolean validateUserNameLable() {
		 return userNameLabel.isDisplayed();
	}
	public ContactPage clickOnContactsLinks() throws Exception {
		 contactsLink.click();
		 return new ContactPage();
	}
	public void clickOnNewContact() {
		Actions action =new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	public DealsPage clickOnDealslink() throws Exception {
		dealsLink.click();
		return new DealsPage();	
		}
	public void clickOnNewDeal(){
		Actions action = new Actions(driver);
		action.moveToElement(dealsLink).build().perform();
		newdealLink.click();
		
	}
}
