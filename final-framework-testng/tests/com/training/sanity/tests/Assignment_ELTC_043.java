package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AssignmentPOM;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.ForumPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Assignment_ELTC_043 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private MyCoursesPOM myCoursesPOM;
	private AssignmentPOM assignmentPOM;
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
		assignmentPOM = new AssignmentPOM(driver);
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
		loginPOM.sendUserName("shama");//enterUser id 
		loginPOM.sendPassword("shama@123");// enter password
		loginPOM.clickLoginBtn(); //click on login button 
		screenShot.captureScreenShot("LoginELTC_043");// capture login screenshot
	
	}
	
	@Test (priority =1)
	public void validAssignmentUploadTest()  {
		
		
		homePagePOM.clickMyCourses();//Click on My courses
		myCoursesPOM.clickSubscribedCourse();// Click on Subscribed Course
		myCoursesPOM.clickAssignmentsIcon();// Click on Assignment Icon
		screenShot.captureScreenShot("Assignment_ELTC_043");//Capture assignment screenshot
		assignmentPOM.clickAssignmentlink();// click on assignment link
		assignmentPOM.clickUploadMyAssignmentBtn();// click on UploadMyAssignmentBtn
		assignmentPOM.clickUploadSimpleTab();// click on UploadSimpleTab
		assignmentPOM.sendTitleText("Title");//Enter Title
		assignmentPOM.sendFilePath("C:\\Users\\SHAMATAYAL\\git\\LPB3-E-Learning\\final-framework-testng\\Upload\\Assignment2.docx");// Provide File Path
		assignmentPOM.clickUploadBtn();// Click on Upload button 
		screenShot.captureScreenShot("AssignmentUploded_ELTC_043");//Capture  uploaded assignment screenshot
		String UploadedAssignmentname = assignmentPOM.uploadedAssignmentName();// get the name of the uploaded document 
		Assert.assertTrue(UploadedAssignmentname.contains("Assignment2.docx"));// verify the name of the uploaded document
	
	}
	
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();// click on user dropdown
	homePagePOM.clicklogoutBtn();//click on logout button 
		screenShot.captureScreenShot("LogoutELTC_043");// capture loggout screenshot
	}
}
