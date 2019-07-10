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

	/* Subscribed course by User*/
	@FindBy(xpath="//a[@data-title = 'manzoor mehadi']//ancestor::div[@class  = 'col-md-10']//preceding-sibling::div[@class ='col-md-2']//a//img")
	private WebElement subscribedCourse; 
	
	
	/* Subscribed course 'Manipal' by User*/
	@FindBy(xpath="//a[@data-title = 'manipal demo']//ancestor::div[@class  = 'col-md-10']//preceding-sibling::div[@class ='col-md-2']//a//img")
	private WebElement subscribedManipalCourse;
	
	
	//a[@href='http://elearningm1.upskills.in/courses/0003/index.php?id_session=0']
	
	/*Course Description link of Subscribed course by User*/
	@FindBy(id="istooldesc_919")
	private WebElement courseDesclink; 
	
	
	/*Course Description Text of Subscribed course by User*/
	@FindBy(xpath="//ul[@class = 'breadcrumb']//li[3]")
	private WebElement courseDescText;
	
	/*Forum icon of Subscribed course by User*/
	@FindBy(id="istooldesc_926")
	private WebElement forumIcon;
	
	/*Group icon of Subscribed course by User*/
	@FindBy(id="istooldesc_1533")
	private WebElement groupIcon;

	
	
	/*Assignments icon of Subscribed course by User*/
	@FindBy(id="istooldesc_931")
	private WebElement assignmentsIcon;
	
	/*Method to click on Subscribed course by User*/
	public void clickSubscribedCourse() {
		this.subscribedCourse.click();
		}
	
	/*Method to click on Manipal Subscribed course by User*/
	public void clickManipalSubscribedCourse() {
		this.subscribedManipalCourse.click();
		}
	/*Method to click on Course description of subscribed course by User*/
	public void clickCourseDesc() {
		this.courseDesclink.click();
		}
	/*Method to verify the text of Course description of subscribed course by User*/
	public String verifyCourseDescText() {
		return this.courseDescText.getText();
		}
	
	/*Method to click on Forum icon of subscribed course by User*/
	public void clickForumIcon() {
		this.forumIcon.click();
		}
	
	/*Method to click on Group icon of subscribed course by User*/
	public void clickGroupIcon() {
		this.groupIcon.click();
		}
	
	/*Method to click on Assignments icon of subscribed course by User*/
	public void clickAssignmentsIcon() {
		this.assignmentsIcon.click();
		}
	
}
