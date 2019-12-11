package com.vtiger.contactTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepoLib.ContactInformation;
import com.vtiger.objectRepoLib.Contacts;
import com.vtiger.objectRepoLib.CreatingNewContact;
import com.vtiger.objectRepoLib.Home;

@Listeners(com.vtiger.genericLib.ListenerImpClass.class)
public class CreateContactWithValidDataTest extends BaseClass{

	@Test
	public void createContactWithValidDataTest() throws Throwable {
		
		String[] date = utils.currentDateArr();
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 1, 2)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		String conID = conInfoPage.getContactID().getText().replace(" ", "");
		
		String expPageInfo = "[ "+conID+" ] "+lastName+fLib.getExcelData("Sheet1", 1, 4)+date[2]+" "+date[1]+" "+date[5]+fLib.getExcelData("Sheet1", 1, 5);
		String actPageInfo = conInfoPage.getActInfo1().getText()+" "+conInfoPage.getActInfo2().getText();
		
		/*Validating the Created Contact PAGE*/
		Assert.assertEquals(actPageInfo, expPageInfo);
		Reporter.log("CreateContactWithValidData Validated successfully", true);
		
	}
}
