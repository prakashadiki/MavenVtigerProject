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

public class SearchContactUsingEmailIDTest extends BaseClass{

	@Test
	public void searchContactUsingEmailIDTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 22, 2)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		String emailID = fLib.getExcelData("Sheet1", 22, 3);
		createNewContPage.getEmailEdt().sendKeys(emailID);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		conInfoPage.getContactsLnk().click();
		
		contactPage.getSearchEdt().sendKeys(emailID);
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "email");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listEmail = contactPage.getListEmail();
		boolean flag = false;
		for (WebElement element : listEmail) {
			if(element.getText().contains(emailID)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		Reporter.log("SearchContactUsingEmailID sucessfully Validated === PASS");
	}
}
