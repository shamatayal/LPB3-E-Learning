package com.training.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForumPOM {


	private WebDriver driver;

	public ForumPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	/* Assigned Rock(group name) */
	@FindBy(xpath="//a[@title = 'Rock']")
	private WebElement groupName; 
	
	

	/* Create Thread icon */
	@FindBy(xpath="	//img[@title = 'Create thread']")
	private WebElement createThread; 
	/* Title on Create Thread Form */
	@FindBy(id="thread_post_title")
	private WebElement titleThread; 
	

	/* Text Iframe Create Thread Form */
	@FindBy(xpath="//iframe[@title='Rich Text Editor, post_text']")
	public WebElement textIframe; 
	
	/* Text Field on Create Thread Form */
	@FindBy(xpath="//body[@class ='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']/p")
	private WebElement textField; 
	
	
	/* Create Thread button on Create Thread Form */
	@FindBy(id ="thread_SubmitPost")
	private WebElement createThreadBtn; 
	
	
	/*Method to click on Assigned Rock(group name)*/
	public void clickGroupName() {
		this.groupName.click();
		}

	/*Method to click on Create Thread icon*/
	public void clickCreateThread() {
		this.createThread.click();
		}

	/*Method to send Text to Title Field  on Create Thread Form*/
	public void sendTitleText(String title) {
		this.titleThread.clear();
			this.titleThread.sendKeys(title);
		}

	/*Method to send Text to Text Field  on Create Thread Form*/
	public void sendTextField(String text) throws InterruptedException {
		Thread.sleep(6000);
		driver.switchTo().frame(textIframe);
		System.out.println("Frame Switvched");
		//this.textIframe.click();
		//this.textIframe.sendKeys(text);
		this.textField.click();
		System.out.println("clicked");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//head//title[@data-cke-title = 'Rich Text Editor, post_text']//parent::head//following-sibling::body/p")).sendKeys(text);
		//this.textField.sendKeys(text);
		}
	
	/*Method to click on create Thread Button  on Create Thread Form*/
	public void createThreadBtn() {
		this.createThreadBtn.click();
		}

	
}
