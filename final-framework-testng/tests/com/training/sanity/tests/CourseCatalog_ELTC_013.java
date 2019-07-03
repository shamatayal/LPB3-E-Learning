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
import com.training.pom.CourseCatalogPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CourseCatalog_ELTC_013 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private CourseCatalogPOM courseCatalogPOM;
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
		courseCatalogPOM = new CourseCatalogPOM(driver);
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
		screenShot.captureScreenShot("LoginELTC_013");
	
	}
	
	@Test (priority =1)
	public void validCourseSubscribeTest() {
		
		
		homePagePOM.clickCourseCatalog();
		String coursescatalog =courseCatalogPOM.getcourseCatalogText();
		Assert.assertTrue(coursescatalog.contains("Courses catalog"));
		courseCatalogPOM.clickSearchTextbox("selenium");
		courseCatalogPOM.clickSearchBtn();
		screenShot.captureScreenShot("CourseCatalogListELTC_013");
		courseCatalogPOM.subscribeCourse();
		screenShot.captureScreenShot("subscribeCourseELTC_013");
		String subscribedMsg =courseCatalogPOM.verifySubscribedMsg();
		Assert.assertTrue(subscribedMsg.contains("has been registered to course"));

	}
	
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();
	homePagePOM.clicklogoutBtn();
		screenShot.captureScreenShot("LogoutELTC_013");
	}
}
