package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.TestBase;

public class ContactPage extends TestBase {
	
        @FindBy(xpath="//input[@id='btn_cs_search']")
        WebElement advancebutton;
	
		@FindBy(xpath="//td[contains(text(),'Contacts')]")
		WebElement contactLable;
		
		@FindBy(id="first_name")
		WebElement firstName;
		
		@FindBy(id="surname")
		WebElement lastName;
		
		@FindBy(name="nickname")
		WebElement nickName;
		
		@FindBy(name="client_lookup")
		WebElement company;
		
		@FindBy(xpath="//input[@class='button' and @value='Save']")
		WebElement saveBtn;
		
	
   public ContactPage() throws Exception {
	    PageFactory.initElements(driver,this);
}
   
   public boolean verifyContactLable() {
	  return contactLable.isDisplayed();
   }
   public void clickOnAdvanceButton() {
	   advancebutton.click();
   }
   public void createNewContact(String title,String ftname,String ltname,String nkname,String comp) {
	   Select select = new Select(driver.findElement(By.name("title")));
	   select.selectByVisibleText(title);
	   firstName.sendKeys(ftname);
	   lastName.sendKeys(ltname);
	   nickName.sendKeys(nkname);
	   company.sendKeys(comp);
	   saveBtn.click();
	   
	   
   }
}


