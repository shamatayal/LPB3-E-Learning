package com.training.pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupChatPOM {


	private WebDriver driver;

	public GroupChatPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}

	/* group name */
	@FindBy(xpath="//span[@class='label label-success']/preceding-sibling::a")
	private WebElement groupName; 
	
	/*Chat icon in Testing group page  */
	@FindBy(xpath="	//img[@title = 'Chat']")
	private WebElement chatIcon; 
	/*Leave Message icon on chat window  */
	@FindBy(xpath="//i[@class = 'fa fa-comments text-muted']")
	private WebElement leaveMessageIcon; 

	/*Write message on chat window  */
	@FindBy(xpath="//div[@class = 'emoji-wysiwyg-editor']")
	private WebElement writeMessage; 
	
	
	/*Send message on chat window  */
	@FindBy(xpath="//button[@id = 'chat-send-message']")
	private WebElement sendMessageBtn; 
	
	/*Verify messaged text on chat window  */
	@FindBy(xpath="(//div[@class ='chat-message-block-content'])[last()]")
	private WebElement messageText;
			
	/*Method to click on Group name on Groups page */
	public void clickGroupName() {
		this.groupName.click();
		}
	/*Method to click on Chat icon in Testing group page*/
	public void clickChatIcon() {
		this.chatIcon.click();
		}
	
	/*Method to click on Leave Message icon on chat window*/
	public void clickLeaveMessageIcon() throws InterruptedException {
		driver.manage().window().maximize();
		Set<String> st = driver.getWindowHandles();
		Iterator<String> is = st.iterator();
		String Elearning = is.next();
		String chat = is.next();
	driver.switchTo().window(chat);
		this.leaveMessageIcon.click();
	
				}
	
	/*Method to write the write Message field on chat window*/
	public void WriteMessage(String Message) throws InterruptedException {
		driver.manage().window().maximize();
		Set<String> st = driver.getWindowHandles();
		Iterator<String> is = st.iterator();
		String Elearning = is.next();
		String chat = is.next();
		driver.switchTo().window(chat);
		this.writeMessage.sendKeys(Message);
	
				}
	/*Method to click on send Message button on chat window*/
	public void sendMessageBtn()  {
			this.sendMessageBtn.click();
		
				}
	/*Method to verify the message text on  chat window*/
	public  String verifyMessageText() {
		// TODO Auto-generated method stub
		return this.messageText.getText(); 
	}
	/*Method to Return control back to Parent window*/
	public  void returnElearingWindow() {
		Set<String> st = driver.getWindowHandles();
		Iterator<String> is = st.iterator();
		String Elearning = is.next();
		driver.switchTo().window(Elearning);
	}
	
}
