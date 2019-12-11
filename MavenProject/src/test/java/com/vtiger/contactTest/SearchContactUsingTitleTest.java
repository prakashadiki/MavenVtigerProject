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

public class SearchContactUsingTitleTest extends BaseClass{

	@Test
	public void searchContactUsingTitleTest() throws Throwable {
		
		/*navigate to CONTACTS Page*/
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getContactsLnk().click();
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 16, 2)+utils.randomNum();
		String title = fLib.getExcelData("Sheet1", 16, 3)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getTitle().sendKeys(title);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		conInfoPage.getContactsLnk().click();
		
		contactPage.getSearchEdt().sendKeys(title);
		
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "title");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listTitle = contactPage.getListTitle();
		
		boolean flag = false;
		for (WebElement element : listTitle) {
			if(element.getText().contains(title)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		Reporter.log("SearchContactUsingTitle sucessfully Validated === PASS", true);
	}
}
