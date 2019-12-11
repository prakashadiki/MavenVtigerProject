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

public class SearchContactUsingContactIDTest extends BaseClass{

	@Test
	public void searchContactUsingContactIDTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 13, 2)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		String conID = conInfoPage.getContactID().getText().replace(" ", "");
		conInfoPage.getContactsLnk().click();
		
		contactPage.getSearchEdt().sendKeys(conID);
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "contact_no");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listContactNo = contactPage.getListContactNo();
		
		boolean flag = false;
		for (WebElement element : listContactNo) {
			if(element.getText().contains(conID)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		Reporter.log("SearchContactUsingContactID sucessfully Validated === PASS", true);
	}
}
