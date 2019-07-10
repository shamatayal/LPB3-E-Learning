package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.ForumPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ForumDiscussion_ELTC_044 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private MyCoursesPOM myCoursesPOM;
	private ForumPOM forumPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver); 
		homePagePOM = new HomePagePOM(driver);
		myCoursesPOM = new MyCoursesPOM(driver);
		forumPOM = new ForumPOM(driver);
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
		loginPOM.sendUserName("shama");
		loginPOM.sendPassword("shama@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginELTC_044");
	
	}
	
	@Test (priority =1)
	public void validCourseSubscribeTest() throws InterruptedException {
		
		
		homePagePOM.clickMyCourses();//Click on My courses
		myCoursesPOM.clickSubscribedCourse();// Click on Subscribed Course
		myCoursesPOM.clickForumIcon();// Click on Forum Icon
		screenShot.captureScreenShot("Group forums pageELTC_044");
		forumPOM.clickGroupName();
		forumPOM.clickCreateThread();
		forumPOM.sendTitleText("123text");
		
		forumPOM.sendTextField("Need Help");// NOT WORKING AS THIS FIELD IS NOT INTERACTABLE
		/*Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		forumPOM.createThreadBtn();*/
	}
	/*
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();
	homePagePOM.clicklogoutBtn();
		screenShot.captureScreenShot("LogoutELTC_044");
	}*/
}
