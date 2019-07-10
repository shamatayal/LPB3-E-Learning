package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentPOM {


	private WebDriver driver;

	public AssignmentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	/* Assignment link */
	@FindBy(xpath="//tr[@id = '1']//td[@title ='assignment1']//a")
	private WebElement assignmentlink; 
	/* Upload my assignment button */
	@FindBy(xpath="//a[@class ='btn-toolbar']//img[@title='Upload my assignment']")
	private WebElement uploadMyAssignmentBtn;
	/* Upload (Simple) Tab */
	@FindBy(xpath="//a[@id= 'tabs2']")
	private WebElement uploadSimpleTab;
	
	/* Title on Upload a document page */
	@FindBy(xpath="	//input[@id ='file_upload']")
	private WebElement titleTextbox;
	
	/* ChooseFile on Upload a document page */
	@FindBy(xpath="//input[@id ='form-work_file']")
	private WebElement chooseFilebtn;
	
	/* Upload button Upload a document page */
	@FindBy(xpath="//button[@id = 'form-work_submitWork']")
	private WebElement uploadBtn;
	
	/* Uploaded assignment document name  */
	@FindBy(xpath="//tr[@id ='8']//td//div[@class ='work-title']")
	private WebElement uploadedAssignmentName;
	
	
	/*Method to click on Assignment link*/
	public void clickAssignmentlink() {
		this.assignmentlink.click();
		}
	
	/*Method to click on Upload my assignment button link*/
	public void clickUploadMyAssignmentBtn() {
		this.uploadMyAssignmentBtn.click();
		}
	/*Method to click on Upload my assignment button link*/
	public void clickUploadSimpleTab() {
		this.uploadSimpleTab.click();
		}
		/*Method to send Text to Title Field  on Upload a document page*/
	public void sendTitleText(String title) {
		this.titleTextbox.clear();
			this.titleTextbox.sendKeys(title);
		}
/*Method to send file path to choose file field on Upload a document page*/
public void sendFilePath(String FilePath) {
			this.chooseFilebtn.sendKeys(FilePath);
	}
/*Method to click on upload button Upload a document page*/
public void clickUploadBtn() {
	this.uploadBtn.click();
	}
/*Method to verify uploaded document name */
public String uploadedAssignmentName() {
	return this.uploadedAssignmentName.getText();
	}
}
