package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdministrationPOM {


	private WebDriver driver;

	public AdministrationPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	/* Courses categories */
	@FindBy(xpath="//div[@id = 'tabs-2']//ul[@class ='list-items-admin']//li[5]/a")
	private WebElement coursesCategories; 

/* Create a course */
@FindBy(xpath="//div[@id = 'tabs-2']//ul[@class ='list-items-admin']//li[2]/a")
private WebElement createCourse; 



/*Method to click courses Categories link  */
public void clickCoursesCategories() {
 this.coursesCategories.click();
	}
/*Method to click Create a course link  */
public void createACourse() {
this.createCourse.click();
}
}
