package com.vtiger.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInformation {

	@FindBy(xpath="//td[text()='Contact Id']/following-sibling::td")
	private WebElement contactID;
	
	@FindBy(xpath="//span[contains(text(),'Contact Information')]")
	private WebElement cusInfo1;
	
	@FindBy(xpath="//span[contains(text(),'Contact Information')]/following-sibling::span[@class='small']")
	private WebElement cusInfo2;
	
	@FindBy(xpath="//td[@class='moduleName']/a[text()='Contacts']")
	private WebElement contactsLnk;
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getActInfo1() {
		return cusInfo1;
	}

	public WebElement getActInfo2() {
		return cusInfo2;
	}

	public WebElement getContactID() {
		return contactID;
	}
}
