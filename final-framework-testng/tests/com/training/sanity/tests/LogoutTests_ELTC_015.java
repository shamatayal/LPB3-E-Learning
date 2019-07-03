package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LogoutTests_ELTC_015 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		homePagePOM = new HomePagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@BeforeMethod
	public void setUp() throws Exception {

	}
	
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test (priority =0)
	public void validLoginTest() {
		loginPOM.sendUserName("divij1");
		loginPOM.sendPassword("divij@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginELTC_015");
	
	}
	
	@Test (priority =1)
	public void validLogoutTest() {
		/* To verify the Welcome text available or not but commented as this text wont be displayed if any courses subscribed by User 
		String WelcomeText =homePagePOM.getWelcomeText();
		Assert.assertTrue(WelcomeText.contains("Hello divij1 gupta and welcome"));
		 */
		 		homePagePOM.clickUserDropdown();
		homePagePOM.clicklogoutBtn();
		screenShot.captureScreenShot("LogoutELTC_015");
	}
}
