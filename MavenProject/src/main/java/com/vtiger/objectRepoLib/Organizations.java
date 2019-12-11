package com.vtiger.objectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Organizations {

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationImg;

	public WebElement getCreateOrganizationImg() {
		return createOrganizationImg;
	}
}
