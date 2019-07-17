package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {


	private WebDriver driver;

	public HomePagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@class='dropdown-toggle']//span[2]")
	private WebElement userDropdown; 
	
	@FindBy(id="logout_button")
	private WebElement logoutBtn;
	
	@FindBy(linkText="Course catalog")
	private WebElement courseCatalog;
	@FindBy(xpath="//a[@title= 'My courses']")
	private WebElement myCourses;
	
	
	@FindBy (xpath = "//div[@class = 'normal-message']//p[1]")
	
	private WebElement welcomeText;
	
	//Administration tab 
	@FindBy (xpath = "//a[@title = 'Administration']")
	
	private WebElement administration;
	
	
	public void clickUserDropdown() {
		this.userDropdown.click();
	
	}
	

	public void clicklogoutBtn() {
		this.logoutBtn.click(); 
	}
	
	public void clickCourseCatalog() {
		this.courseCatalog.click(); 
	}
	
	public void clickMyCourses() {
		this.myCourses.click(); 
	}
	
	public String getWelcomeText() {
		return this.welcomeText.getText(); 
	}
	//Method to click on Administration Tab 
	public void clickAdministration() {
		this.administration.click(); 
	}
	
}
