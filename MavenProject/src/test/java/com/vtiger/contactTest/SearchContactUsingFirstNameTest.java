package com.vtiger.contactTest;

import java.util.List;

import org.openqa.selenium.WebElement;
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
public class SearchContactUsingFirstNameTest extends BaseClass{

	@Test
	public void searchContactUsingFirstNameTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		String lastName = fLib.getExcelData("Sheet1", 7, 2)+utils.randomNum();
		String firstName = fLib.getExcelData("Sheet1", 7, 3)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getFirstNameEdt().sendKeys(firstName);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		conInfoPage.getContactsLnk().click();
		contactPage.getSearchEdt().sendKeys(firstName);
		
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "firstname");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listFirstName = contactPage.getListFirstName();
		
		boolean flag = false;
		for (WebElement element : listFirstName) {
			if(element.getText().contains(firstName)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		Reporter.log("SearchContactUsingFirstName sucessfully Validated === PASS", true);
	}
}
