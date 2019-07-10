package com.training.sanity.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Test {{

		WebDriver driver = new ChromeDriver();
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
	
		// open the browser 
		driver.get("http://elearningm1.upskills.in/main/forum/newthread.php?cidReq=SEL&id_session=0&gidReq=14&gradebook=0&origin=&forum=16");
		
		
	}}


