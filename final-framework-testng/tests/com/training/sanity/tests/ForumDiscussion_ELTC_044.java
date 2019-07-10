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
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		loginPOM = new LoginPOM(driver); 
		homePagePOM = new HomePagePOM(driver);
		myCoursesPOM = new MyCoursesPOM(driver);
		forumPOM = new ForumPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

		
	@AfterClass
	public void tearDown() throws Exception {
		
		driver.quit();
	}
	@Test (priority =0)
	public void validLoginTest() {
		loginPOM.sendUserName("divij1");
		loginPOM.sendPassword("divij@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("LoginELTC_044");
	
	}
	
	@Test (priority =1)
	public void validCourseSubscribeTest() throws InterruptedException {
		
		
		homePagePOM.clickMyCourses();//Click on My courses
		myCoursesPOM.clickSubscribedCourse();// Click on Subscribed Course
		myCoursesPOM.clickForumIcon();// Click on Forum Icon
		screenShot.captureScreenShot("Group forums pageELTC_044");
		forumPOM.clickGroupName();//click on Group name
		forumPOM.clickCreateThread();// click on Create Thread button
		forumPOM.sendTitleText("text");//Enter title
		forumPOM.switchiframe();//switch to text iframe
		forumPOM.sendTextField("Need Help");// Enter text in text field (Relative path is not working only absolute path is working)
		forumPOM.createThreadBtn();// click on Create thread button
		screenShot.captureScreenShot("CreateThreadELTC_044");
		forumPOM.replyToThisMsgBtn();//Click on Reply to this message button
		forumPOM.switchiframe();//switch to text iframe
		forumPOM.sendReplyTextField("Take google help");//Enter reply text (Relative path is not working only absolute path is working)
		forumPOM.clickReplyBtn();//click on reply to this message button
		screenShot.captureScreenShot("ReplyELTC_044");
		String replyAddedText = forumPOM.replyAddedText();// get the successful reply message
		Assert.assertTrue(replyAddedText.contains("The reply has been added"));// verify the reply has been Added
	}
	
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();// click on user drop down
	homePagePOM.clicklogoutBtn();//click on logout button 
		screenShot.captureScreenShot("LogoutELTC_044");// capture logout screenshot
	}
}
