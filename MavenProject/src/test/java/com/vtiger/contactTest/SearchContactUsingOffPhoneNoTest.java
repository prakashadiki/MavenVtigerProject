package com.vtiger.contactTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepoLib.ContactInformation;
import com.vtiger.objectRepoLib.Contacts;
import com.vtiger.objectRepoLib.CreatingNewContact;
import com.vtiger.objectRepoLib.Home;

public class SearchContactUsingOffPhoneNoTest extends BaseClass{

	@Test
	public void searchContactUsingOffPhoneNoTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 25, 2)+utils.randomNum();
		String offPhoneNo = fLib.getExcelData("Sheet1", 25, 3);
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getOffPhoneEdt().sendKeys(offPhoneNo);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		utils.waitForElemnetPresent(conInfoPage.getContactsLnk());
		conInfoPage.getContactsLnk().click();
		
		contactPage.getSearchEdt().sendKeys(offPhoneNo);
		
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "phone");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listOffPhone = contactPage.getListOffPhone();
		boolean flag = false;
		for (WebElement element : listOffPhone) {
			if(element.getText().contains(offPhoneNo)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		
		Reporter.log("SearchContactUsingOffPhoneNo sucessfully Validated === PASS", true);
		
	}
}
