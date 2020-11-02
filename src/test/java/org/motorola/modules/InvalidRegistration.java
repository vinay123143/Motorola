package org.motorola.modules;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InvalidRegistration {
	
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
		public static void invalidRegistration() throws InterruptedException {
		driver.findElement(By.linkText("Sign in")).click();
		
		driver.findElement(By.name("email_create")).sendKeys("vinay.kumar@gmail.com");
		
		driver.findElement(By.xpath("//text()[contains(.,'Create an account')]/ancestor::span[1]")).click();
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//input[@type='radio'][@name='id_gender']"));
		element.click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("bsabk123");
		driver.findElement(By.id("customer_lastname")).sendKeys("hqoho55");
		driver.findElement(By.name("passwd")).sendKeys("khsbdiq");
		
		
		WebElement day = driver.findElement(By.id("days"));
		Select selectDay = new Select(day);
		selectDay.selectByIndex(5);
		
		WebElement month = driver.findElement(By.id("months"));
		Select selectMonth = new Select(month);
		selectMonth.selectByIndex(5);
		
		WebElement year = driver.findElement(By.id("years"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2000");
		
		driver.findElement(By.name("address1")).sendKeys("jsabkaj");
		
		driver.findElement(By.name("city")).sendKeys("Bell");
		
		WebElement state =  driver.findElement(By.name("id_state"));
		Select selectState = new Select(state);
		selectState.selectByIndex(5);
		
		driver.findElement(By.name("postcode")).sendKeys("9897");
		
		driver.findElement(By.name("phone_mobile")).sendKeys("9999999999");
		
		WebElement adress = driver.findElement(By.name("alias"));
		adress.clear();
		adress.sendKeys("kadapa");
		
		driver.findElement(By.xpath("//text()[.='Register']/ancestor::span[1]")).click();
		
		
		String actual_msg=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]	")).getText();
	    
		
		String expect="plz enter valid details";
		                
		
		Assert.assertEquals(actual_msg, expect);
		}
		
		@AfterClass
		public static void tearDown()
		{
			driver.close();
			driver.quit();
		}	
	}


