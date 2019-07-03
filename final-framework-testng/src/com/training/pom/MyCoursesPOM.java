package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCoursesPOM {


	private WebDriver driver;

	public MyCoursesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@href = 'http://elearningm1.upskills.in/courses/0003/index.php?id_session=0']")
	
	private WebElement subscribedCourse; 
	
	

	@FindBy(id="istooldesc_823")
	private WebElement courseDesclink; 
	
	

	@FindBy(xpath="//ul[@class = 'breadcrumb']//li[3]")
	private WebElement courseDescText;
	
	public void clickSubscribedCourse() {
		this.subscribedCourse.click();
		}
	
	public void clickCourseDesc() {
		this.courseDesclink.click();
		}
	
	public String verifyCourseDescText() {
		return this.courseDescText.getText();
		}
	
}
