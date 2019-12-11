package com.vtiger.objectRepoLib;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts {

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchDropDownMenu;
	
	@FindBy(xpath="//span[@vtfieldname='firstname']/..//a[@title='Contacts']")
	private List<WebElement> listFirstName;
	
	@FindBy(xpath="//span[@vtfieldname='lastname']/..//a[@title='Contacts']")
	private List<WebElement> listLastName;
	
	@FindBy(xpath="//span[@vtfieldname='contact_no']/..")
	private List<WebElement> listContactNo; 
	
	@FindBy(xpath="//span[@vtfieldname='title']/..")
	private List<WebElement> listTitle;
	
	@FindBy(xpath="//span[@vtfieldname='account_id']/..")
	private List<WebElement> listOrgs;
	
	@FindBy(xpath="//span[@vtfieldname='email']/preceding-sibling::a")
	private List<WebElement> listEmail;
	
	@FindBy(xpath="//span[@vtfieldname='phone']/..")
	private List<WebElement> listOffPhone;
	
	public List<WebElement> getListOffPhone() {
		return listOffPhone;
	}

	public List<WebElement> getListEmail() {
		return listEmail;
	}

	public List<WebElement> getListOrgs() {
		return listOrgs;
	}

	public List<WebElement> getListTitle() {
		return listTitle;
	}

	public List<WebElement> getListContactNo() {
		return listContactNo;
	}

	public List<WebElement> getListLastName() {
		return listLastName;
	}

	public List<WebElement> getListFirstName() {
		return listFirstName;
	}

	public WebElement getSearchDropDownMenu() {
		return searchDropDownMenu;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}
}
