package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement dealsLabel;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(name="client_lookup")
	WebElement comp;
	
	@FindBy(name="contact_lookup")
	WebElement primeCotact;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(xpath="//td[@colspan='2']/input[@type='submit']")
	WebElement saveBtn;

	public DealsPage() throws Exception {
		PageFactory.initElements(driver,this);
	}
	//Actions
	
	public boolean valiadteDealslabel() {
		return dealsLabel.isDisplayed();
	}
	public void clickOnNewDealsLink(String Title,String Comp,String primecontact,String Amount) {
		title.sendKeys(Title);
		comp.sendKeys(Comp);
		primeCotact.sendKeys(primecontact);
		amount.sendKeys(Amount);
		saveBtn.click();
	}

}
