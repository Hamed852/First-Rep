package newselenium1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Introo1 {

	static ChromeDriver  driver ; 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\QOYOD\\Desktop\\Drivers\\chromedriver.exe");
		
		driver	 = new ChromeDriver();
		
driver.navigate().to("https://qaland.qoyod.com/users");



WebElement lOGINBTN = driver.findElement(By.partialLinkText("Login"));

lOGINBTN.click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

WebElement usrname = driver.findElement(By.id("user_email"));

usrname.sendKeys("m.hamed@qoyod.com");

WebElement Pass = driver.findElement(By.id("user_password"));

Pass.sendKeys("AAaa@123456789");

WebElement LognBtn = driver.findElement(By.id("login-submit"));

LognBtn.click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	

	WebElement products = driver.findElement(By.xpath("/html/body/div[2]/div/aside/section/ul/li[4]/a/span"));

	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	products.click();
	   
	
	WebElement Addnewprshortcut = driver.findElement(By.xpath("/html/body/div[2]/div/aside/section/ul/li[4]/ul/li[1]/a[2]"));
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	Addnewprshortcut.click();
	
	
	//	driver.close();
}}
