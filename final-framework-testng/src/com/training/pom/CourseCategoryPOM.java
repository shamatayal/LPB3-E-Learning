package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseCategoryPOM {


	private WebDriver driver;

	public CourseCategoryPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	/* Add category */
	@FindBy(xpath="//img[@title = 'Add category']")
	private WebElement addCategory; 


/* Category code */
@FindBy(xpath="//input[@id ='course_category_code']")
private WebElement categorycode; 
/* Category name */
@FindBy(xpath="//input[@id ='course_category_name']")
private WebElement categoryname; 


/* yes radio button Allow adding courses in this category? */
@FindBy(xpath="//div[@class = 'radio']/label/input[1]")
private WebElement yesAllowRadioBtn; 



/* Add category button  */
@FindBy(xpath="//button[@id ='course_category_submit']")
private WebElement addCategoryBtn; 

/*Method to click add category image */
public void clickAddCategory() {
 this.addCategory.click();
	}

/*Method to enter category code in category code field  */
public void categorycode(String categorycode) {
this.categorycode.sendKeys(categorycode);
}

/*Method to enter category name in category name field  */
public void categoryname(String categoryname) {
this.categoryname.sendKeys(categoryname);
}


/*Method to yes radio button Allow adding courses in this category?  */
public void yesAllowRadioBtn() {
	
	if (!this.yesAllowRadioBtn.isSelected())
	
this.yesAllowRadioBtn.click();
}

/*Method to click add category button  */
public void clickAddCategoryBtn() {
 this.addCategoryBtn.click();
	}


}
