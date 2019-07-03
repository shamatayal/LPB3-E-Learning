package com.training.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CourseCatalogPOM {


	private WebDriver driver;

	public CourseCatalogPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="search_term")
	private WebElement searchTextbox; 
	
	@FindBy(xpath="//button[@class = 'btn btn-default']")
	private WebElement searchBtn;
	

	
	
	@FindBy(xpath="//a[@class = 'btn btn-success btn-sm']")
	private WebElement subscribeBtn;
	@FindBy(xpath="//div[@class = 'alert alert-info']")
	private WebElement subscribedMsg;
	
	
	@FindBy (className = "title-courses")
		private WebElement courseCatalogText;
	

	public String getcourseCatalogText() {
		return this.courseCatalogText.getText(); 
	}
	
	public void clickSearchTextbox(String Course) {
		this.searchTextbox.sendKeys(Course);
		}
	

	public void clickSearchBtn() {
		this.searchBtn.click(); 
	}
	
	public void subscribeCourse() {
				
		this.subscribeBtn.click(); 
	}

	public  String verifySubscribedMsg() {
		// TODO Auto-generated method stub
		return this.subscribedMsg.getText(); 
	}
	
	
	
}
