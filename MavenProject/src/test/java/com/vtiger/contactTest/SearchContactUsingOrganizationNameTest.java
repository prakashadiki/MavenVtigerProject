package com.vtiger.contactTest;

import java.util.Iterator;
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
import com.vtiger.objectRepoLib.CreatingNewOrganization;
import com.vtiger.objectRepoLib.Home;
import com.vtiger.objectRepoLib.Organizations;

public class SearchContactUsingOrganizationNameTest extends BaseClass{

	@Test
	public void searchContactUsingOrganizationNameTest() throws Throwable {
		
		Home homePage = PageFactory.initElements(driver, Home.class);
		homePage.getOrganizationsLnk().click();
		
		Organizations orgPage = PageFactory.initElements(driver, Organizations.class);
		orgPage.getCreateOrganizationImg().click();
		
		String organizationName = fLib.getExcelData("Sheet1", 19, 3)+utils.randomNum();
		CreatingNewOrganization newOrgPage = PageFactory.initElements(driver, CreatingNewOrganization.class);
		newOrgPage.getOrgNameEdt().sendKeys(organizationName);
		newOrgPage.getSaveBtn().click();
		
		int count = 0;
		while(count < 20) {
			try {
				homePage.getContactsLnk().click();
				break;
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
		
		/*navigate to Create New Contact Page*/
		Contacts contactPage = PageFactory.initElements(driver, Contacts.class);
		contactPage.getCreateContactImg().click();
		
		/*crate a Contact*/
		String lastName = fLib.getExcelData("Sheet1", 19, 2)+utils.randomNum();
		CreatingNewContact createNewContPage = PageFactory.initElements(driver, CreatingNewContact.class);
		createNewContPage.getLastNameEdt().sendKeys(lastName);
		createNewContPage.getOrgSelectImg().click();
		Iterator<String> iterator = driver.getWindowHandles().iterator();
		String PID = iterator.next();
		String CID = iterator.next();
		driver.switchTo().window(CID);
		createNewContPage.getSearchOrgFromChildWindowEdt().sendKeys(organizationName);
		createNewContPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		createNewContPage.getSelectOrgfromChildWindow().click();
		driver.switchTo().window(PID);
		createNewContPage.getSaveBtn().click();
		
		ContactInformation conInfoPage = PageFactory.initElements(driver, ContactInformation.class);
		conInfoPage.getContactsLnk().click();
		
		contactPage.getSearchEdt().sendKeys(organizationName);
		utils.selectByValue(contactPage.getSearchDropDownMenu(), "account_id");
		contactPage.getSearchNowBtn().click();
		Thread.sleep(2000);
		
		List<WebElement> listOrgs = contactPage.getListOrgs();
		
		boolean flag = false;
		for (WebElement element : listOrgs) {
			if(element.getText().contains(organizationName)) {
				flag = true;
			}else {
				flag = false;
				break;
			}
		}
		
		Assert.assertTrue(flag);
		Reporter.log("SearchContactUsingOrganizationName sucessfully Validated === PASS", true);
		
	}
}
