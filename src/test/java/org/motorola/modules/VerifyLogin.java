package org.motorola.modules;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class VerifyLogin {
	
	static WebDriver driver;
	static WebElement element;
		
		@BeforeClass
		public static void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "../Motorola/Browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		@Test
		public static void verifyLogin() {
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.name("email_create")).sendKeys("vinay");
		
		driver.findElement(By.xpath("//text()[contains(.,'Create an account')]/ancestor::span[1]")).click();
		
		
		  String actual_msg=driver.findElement(By.xpath("//li[text()='Invalid email address.']")).getText();
		  
		  
		  String expect="Invalid email address";
		  
		  
		  Assert.assertEquals(actual_msg, expect);
		 
		}
		
		@AfterClass
		public static void tearDown()
		{
			driver.close();
			driver.quit();
		}		
	}	
	


