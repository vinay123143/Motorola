package org.motorola.modules;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AddtoWishlist {
	
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
		public static void addtoWishlist() {
		Actions action= new Actions(driver);
		WebElement element  = driver.findElement(By.xpath("//a[text()='Women']"));
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.linkText("Summer Dresses")).click();
		

		Actions action1= new Actions(driver);
		WebElement element1  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]	"));
		action1.moveToElement(element1).build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Add to Wishlist')]	")).click();
		
		String actual_msg=driver.findElement(By.xpath("//p[text()='You must be logged in to manage your wishlist.']	")).getText();
		  
		  
		  String expect="You must be logged in to manage your wishlist";
		  
		  
		  Assert.assertEquals(actual_msg, expect);
		}
		
		@AfterClass
		public static void tearDown()
		{
			driver.close();
			driver.quit();
		}
		

	}


