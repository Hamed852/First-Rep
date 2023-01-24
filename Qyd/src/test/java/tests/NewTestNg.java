package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestNg
	{
  
	
  static ChromeDriver  driver ; 
	
	
	static	String CHpath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" ; 

	@Test
	public  void navigatetoQYD ()
{
	
		System.setProperty("webdriver.chrome.driver",CHpath);

		driver	 = new ChromeDriver();
		
driver.navigate().to("https://qaland.qoyod.com/users");




}
	}
