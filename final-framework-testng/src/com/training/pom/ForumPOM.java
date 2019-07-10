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
	@FindBy(xpath="//iframe[@class ='cke_wysiwyg_frame cke_reset']")
	public WebElement textIframe; 
	
	/* Text Field on Create Thread Form */
	@FindBy(xpath="/html/body")
	private WebElement textField; 
	
	
	/* Create Thread button on Create Thread Form */
	@FindBy(id ="thread_SubmitPost")
	private WebElement createThreadBtn; 
	
	
	/* Reply to this message button  on Thread page */
	@FindBy(xpath ="//a[@class='btn btn-primary']")
	private WebElement replyToThisMsgBtn; 

	/* Text Field on reply Thread Form */
	@FindBy(xpath="	/html/body[@class ='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	private WebElement replyTextField;
	
	
	/* Reply to this message button  on  reply Thread Form */
	@FindBy(xpath="//button[@id='thread_SubmitPost']")
	private WebElement replyMsgBtn;
	

	/* Successful reply text  on  reply Thread Form */
	@FindBy(xpath="	//div[@class ='alert alert-success']")
	private WebElement replytext;
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

	/*Method to switch to Text iframe  on Create Thread Form*/
	public void switchiframe() throws InterruptedException {
				driver.switchTo().frame(textIframe);
	}
	
	/*Method to send Text to Text Field  on Create Thread Form*/
	public void sendTextField(String text) {
			this.textField.sendKeys(text);
			}
	
	/*Method to click on create Thread Button  on Create Thread Form*/
	public void createThreadBtn() {
		driver.switchTo().parentFrame();
		this.createThreadBtn.click();
		}
	
	/*Method to click on Reply to this message Button  on Create Thread Form*/
	public void replyToThisMsgBtn() {
		this.replyToThisMsgBtn.click();
		}
	/*Method to send Text to Reply Text Field  on reply Thread Form*/
	public void sendReplyTextField(String text) {
		this.replyTextField.sendKeys(text);
			}
	
	/*Method to click on reply Button  on reply Form*/
	public void clickReplyBtn() {
		driver.switchTo().parentFrame();
		this.replyMsgBtn.click();
		}
	
		/*Method to verify reply has been added */
	public String replyAddedText() {
		return this.replytext.getText();
		}
}
