package com.vtiger.contactTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepoLib.Contacts;
import com.vtiger.objectRepoLib.CreatingNewContact;
import com.vtiger.objectRepoLib.Home;

@Listeners(com.vtiger.genericLib.ListenerImpClass.class)
public class CreateContactWithoutMandatoryDetailsTest extends BaseClass{

	@Test
	public void createContactWithoutMandatoryDetailsTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*creating contact without details*/
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getSaveBtn().click();
		
		/*capture alert popup message*/
		String actAlertMsg  = utils.alertPopUpMsg();
		String expAlertMsg = fLib.getExcelData("Sheet1", 4, 3);
		
		/*Validation*/
		Assert.assertEquals(actAlertMsg, expAlertMsg);
		Reporter.log("CreateContactWithoutMandatoryDetails successfully Validated === PASS", true);
		
	}
}
