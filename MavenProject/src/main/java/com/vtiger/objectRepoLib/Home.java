package com.vtiger.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.BaseClass;

public class Home {

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLnk;
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationsLnk;

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public void logout() {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
	}
}
