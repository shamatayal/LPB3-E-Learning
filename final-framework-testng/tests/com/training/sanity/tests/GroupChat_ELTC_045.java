package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.GroupChatPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class GroupChat_ELTC_045 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private MyCoursesPOM myCoursesPOM;
	private GroupChatPOM groupChatPOM;
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
		groupChatPOM = new GroupChatPOM(driver);
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
		//Thread.sleep(1000);
		driver.quit();
	}
	@Test (priority =0)
	public void validLoginTest() {
		loginPOM.sendUserName("shama");
		loginPOM.sendPassword("shama@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginELTC_045");
	
	}
	
	@Test (priority =1)
	public void groupChatTest() throws InterruptedException {
		
		
		homePagePOM.clickMyCourses();//Click on My courses
		myCoursesPOM.clickManipalSubscribedCourse();// Click on Subscribed Course
		myCoursesPOM.clickGroupIcon();// Click on Group Icon
		screenShot.captureScreenShot("Group forums pageELTC_045");// capture Group forums screenshot
		groupChatPOM.clickGroupName();//Click on testing Group name 
		groupChatPOM.clickChatIcon();//Click on Chat Icon
		groupChatPOM.clickLeaveMessageIcon();// click on leave message Icon
		groupChatPOM.WriteMessage("Hello");// Write message in write message field
		groupChatPOM.sendMessageBtn();// click on send message button 
		screenShot.captureScreenShot("ChatpageELTC_045");// capture Chat screenshot
		String MessageText = groupChatPOM.verifyMessageText();// get the sent message
		Assert.assertTrue(MessageText.contains("Hello"));// verify the sent message 
		driver.close();//close the chat window
		groupChatPOM.returnElearingWindow();//Switch control to Main Window
	}
	
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();// click on user dropdown
	homePagePOM.clicklogoutBtn();//click on logout button
	screenShot.captureScreenShot("LogoutELTC_045");// capture loggout screenshot
	}
}
