package com.vtiger.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.vtiger.objectRepoLib.Home;
import com.vtiger.objectRepoLib.Login;
/**
 * This class contains all configure methods
 * @author Prakash Adiki
 *
 */
public class BaseClass {

	/*Global Objects*/
	public static WebDriver driver = null;
	public FileLib fLib = new FileLib();
	public WebdriverCommonUtils utils = new WebdriverCommonUtils();

	/**
	 * This TestNg configuration method is used to open browser
	 * @throws Throwable
	 */
	
	/*@Parameters("browser")
	@BeforeTest
	public void configBT(String browserName) {
		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
	}*/
	
	@BeforeClass
	public void configBC() throws Throwable {

		System.out.println("launch the Browser");

		/*read browser name from properties File*/
		String browserName = fLib.getPropertyKeyValue("browser");

		if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}else if (browserName.equalsIgnoreCase("opera")) {
			driver = new OperaDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
	}


	/**
	 * This TestNg configuration method is used to LOGIN to the application
	 * @throws Throwable
	 */
	@BeforeMethod
	public void configBM() throws Throwable {

		System.out.println("Login to application");

		/*read URL , username , password  from properties File*/
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		utils.waitForPageToLoad();
		utils.maximizeBrowser();
		driver.get(URL);
		/*create an object LOGIN POM class*/
		Login lp = PageFactory.initElements(driver, Login.class);
		lp.loginToApp(USERNAME, PASSWORD);

	}

	
	/**
	 * This TestNg configuration method is used to LOGOUT from the application
	 */
	@AfterMethod
	public void configAM(){
		System.out.println("Logout");
		/*create an object HOME POM class*/
		Home hp = PageFactory.initElements(driver, Home.class);
		hp.logout();
	}
	

	
	/*@AfterTest
	public void configAT(){
		System.out.println("========close browser======");
		driver.close();
	}*/
	
	
	/**
	 * This TestNg configuration method used to close the Browser
	 */
	@AfterClass
	public void configAC(){
		System.out.println("========close browser======");
		driver.close();
	}

}
