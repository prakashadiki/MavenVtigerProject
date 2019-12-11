package com.vtiger.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vtiger.genericLib.FileLib;

public class CreatingNewContact {

	FileLib fLib = new FileLib();
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name="firstname")
	private WebElement firstNameEdt;
	
	@FindBy(name="salutationtype")
	private WebElement salutationType;
	
	@FindBy(id="title")
	private WebElement title;
	
	@FindBy(id="email")
	private WebElement emailEdt;
	
	public WebElement getEmailEdt() {
		return emailEdt;
	}

	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgSelectImg;
	
	/*Child Window*/
	@FindBy(xpath="//a[contains(text(),'Organization Name')]/../../following-sibling::tr//a")
	private WebElement selectOrgfromChildWindow;
	
	/*Child Window*/
	@FindBy(id="search_txt")
	private WebElement searchOrgFromChildWindow;
	
	/*Search Now Button*/
	@FindBy(name="search")
	private WebElement searchNowBtn;
	
	@FindBy(id="phone")
	private WebElement offPhoneEdt;
	
	public WebElement getOffPhoneEdt() {
		return offPhoneEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSearchOrgFromChildWindowEdt() {
		return searchOrgFromChildWindow;
	}

	public WebElement getSelectOrgfromChildWindow() {
		return selectOrgfromChildWindow;
	}

	public WebElement getOrgSelectImg() {
		return orgSelectImg;
	}

	public WebElement getTitle() {
		return title;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getFirstNameEdt() {
		return firstNameEdt;
	}

	public WebElement getSalutationType() {
		return salutationType;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createNewContact(String lName) {
		lastNameEdt.sendKeys(lName);
		saveBtn.click();
	}
	
	public void createNewContact(String lName, String fName) {
		lastNameEdt.sendKeys(lName);
		firstNameEdt.sendKeys(fName);
		saveBtn.click();
	}
}
