package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class homepageBase {
	
	

	static ChromeDriver  driver ; 
	
	static String QydUrl = "https://qaland.qoyod.com/en"; 
	
	
	static	String CHpath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" ; 
	
	static	String firepath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe" ; 
	
	
	static String date1;

	
	
	public static void Journeystarts() 
	
	{
	
		System.setProperty("webdriver.chrome.driver", CHpath);
		driver= new ChromeDriver();
		driver.navigate().to(QydUrl);
		 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		
	}
	
	
	public static void closingdriver() {
		
		driver.close();
		
	}
	@Test
	public static void Getdate()
	{
		 
	// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		  date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println("Current date and time is " +date1);

	}

	
	public void signupform () 
    {
		WebElement SignupBtn = driver.findElement(By.partialLinkText("FREE TRIAL"));
		SignupBtn.click();
		

				
	}

	public void Loginform()
	{
		WebElement lOGINBTN = driver.findElement(By.partialLinkText("Login"));
			lOGINBTN.click();

		
	
	}
	
	
	
	
	
	
}
