package com.vtiger.genericLib;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverCommonUtils {

	public void waitForPageToLoad(){
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForElemnetPresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void selectByVisText(WebElement element , String text){
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element , String value){
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectByIndex(WebElement element , int index){
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void maximizeBrowser() {
		BaseClass.driver.manage().window().maximize();
	}
	
	public void dropDownMenu(WebElement wb, String value) {
		new Select(wb).selectByValue(value);
	}
	
	public String[] currentDateArr() {
		String[] date = new Date().toString().split(" ");
		return date;
	}
	
	public int randomNum() {
		Random random = new Random();
		int intData = random.nextInt(100000);
		return intData;
	}
	
	public String alertPopUpMsg() {
		Alert alert = BaseClass.driver.switchTo().alert();
		String alerMsg = alert.getText();
		alert.accept();
		return alerMsg;
	}
}
