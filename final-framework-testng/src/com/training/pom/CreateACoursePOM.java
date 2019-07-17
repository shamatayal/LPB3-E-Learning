package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateACoursePOM {


	private WebDriver driver;

	public CreateACoursePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	/*  Title */
	@FindBy(xpath="//input[@id = 'update_course_title']")
	private WebElement title; 


/*code */
@FindBy(xpath="//input[@id = 'visual_code']")
private WebElement code; 
/* Teacher */
@FindBy(xpath="//ul[@class ='select2-selection__rendered']//li/input[@type = 'search']")
private WebElement teacher; 
/* Teacher 'manzoor' */
@FindBy(xpath="//ul[@class ='select2-selection__rendered']//li[text() = 'manzoor mehadi (manzoor)']")
private WebElement teacherName; 


/*Method to Add text to title field  */
public void enterTitle(String title) {
this.title.sendKeys(title);
}

/*Method to add text to code field  */
public void enterCode(String code) {
this.code.sendKeys(code);
}
/*Method to add Teacher name  to Teacher field  */
public void enterTeacher(String Teacher) throws InterruptedException {
this.teacher.sendKeys(Teacher);
Actions act = new Actions(driver);
act.sendKeys(Keys.ENTER).click().build().perform();
}
}
