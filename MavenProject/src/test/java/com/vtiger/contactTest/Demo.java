package com.vtiger.contactTest;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Demo {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(800,200));
	}
}
