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
import org.openqa.selenium.support.ui.Select;

public class BuyProduct {
	
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
		public static void buyProduct() {
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.name("email")).sendKeys("vinay.vinni.223@gmail.com");
		driver.findElement(By.name("passwd")).sendKeys("vinay123456");
		
		driver.findElement(By.id("SubmitLogin")).click();
		
		Actions action= new Actions(driver);
		WebElement element  = driver.findElement(By.xpath("//a[text()='Women']"));
		action.moveToElement(element).build().perform();
		//Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Dresses']")).click();
		
		
		Actions action1= new Actions(driver);
		WebElement element1  = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]	"));
		action1.moveToElement(element1).build().perform();
		
		driver.findElement(By.linkText("More")).click();
		
		driver.findElement(By.xpath("//*[@class='icon-plus']	")).click();
		
		WebElement size = driver.findElement(By.xpath("//select[@name='group_1']	"));
		
		Select select = new Select(size);
		select.selectByIndex(3);
		
		driver.findElement(By.xpath("//span[text()='Add to cart']	")).click();
		
		driver.findElement(By.xpath("//text()[contains(.,'Proceed to checkout')]/ancestor::span[1]	")).click();
		driver.findElement(By.xpath("//text()[.='Proceed to checkout']/ancestor::span[1]	")).click();
		driver.findElement(By.xpath("//text()[.='Proceed to checkout']/ancestor::span[1]	")).click();
		
		WebElement element2 = driver.findElement(By.xpath("//input[@type='checkbox'][@name='cgv']	"));
		element2.click();
		
		driver.findElement(By.xpath("//text()[contains(.,'Proceed to checkout')]/ancestor::span[1]	")).click();
		}
		
		
		@AfterClass
		public static void tearDown()
		{
			driver.close();
			driver.quit();
		}	
		
	}


