package com.training.regression.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.dataproviders.TestDataProvider;
import com.training.generics.ScreenShot;
import com.training.pom.AdministrationPOM;
import com.training.pom.AssignmentPOM;
import com.training.pom.CourseCatalogPOM;
import com.training.pom.CourseCategoryPOM;
import com.training.pom.CreateACoursePOM;
import com.training.pom.ForumPOM;
import com.training.pom.HomePagePOM;
import com.training.pom.LoginPOM;
import com.training.pom.MyCoursesPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CategoryAndCourse_ELTC_075 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePagePOM homePagePOM;
	private AdministrationPOM administrationPOM;
private CourseCategoryPOM courseCategoryPOM;
private CreateACoursePOM createACoursePOM;
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
		administrationPOM = new AdministrationPOM(driver);
		courseCategoryPOM = new CourseCategoryPOM(driver);
		createACoursePOM = new CreateACoursePOM(driver);
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
		loginPOM.sendUserName("admin");//enterUser id 
		loginPOM.sendPassword("admin@123");// enter password
		loginPOM.clickLoginBtn(); //click on login button 
		screenShot.captureScreenShot("LoginELTC_075");// capture login screenshot
	
	}
	
	@Test (priority =1, dataProvider = "excel-inputs", dataProviderClass = TestDataProvider.class)
	public void validCreateCategoryTest(String CategoryCode,String CategoryName,String Title,String code,String Teacher) throws InterruptedException  {
		System.out.println("class");
		
		homePagePOM.clickAdministration();//Click on Administration Link 
		administrationPOM.clickCoursesCategories();// click on courses Categories link
		courseCategoryPOM.clickAddCategory();
		courseCategoryPOM.categorycode(CategoryCode);
		courseCategoryPOM.categoryname(CategoryName);
		courseCategoryPOM.yesAllowRadioBtn();
		courseCategoryPOM.clickAddCategoryBtn();
		
		Thread.sleep(3000);
	
	}
	
	
	@Test (priority =2,enabled = false)
	public void validCreateCourseTest() throws InterruptedException  {
		
		
		
		homePagePOM.clickAdministration();//Click on Administration Link 
		administrationPOM.createACourse();// click on Create A course  link
		createACoursePOM.enterTitle("testing");
		createACoursePOM.enterCode("tes");
		createACoursePOM.enterTeacher("manzoor");
		Thread.sleep(6000);
	
	}
	@Test (priority =2)
	public void validLogoutTest() {
	homePagePOM.clickUserDropdown();// click on user dropdown
	homePagePOM.clicklogoutBtn();//click on logout button 
		screenShot.captureScreenShot("LogoutELTC_075");// capture logout screenshot
	}
}
