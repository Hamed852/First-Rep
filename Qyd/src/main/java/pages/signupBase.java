package pages;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class signupBase 

{
	
homepageBase hb = new homepageBase();

Faker fk = new Faker();

String FakeEmail = fk.internet().emailAddress();


public void Navigationsignup()

{
		hb.signupform();
}



public void usercanregister()
{

WebElement fname= homepageBase.driver.findElement(By.id("user_first_name"));

		fname.sendKeys("salma");
	
WebElement lname= homepageBase.driver.findElement(By.id("user_last_name"));

		lname.sendKeys("Salama");	

WebElement email= homepageBase.driver.findElement(By.id("user_email"));

		email.sendKeys(FakeEmail);

WebElement phone= homepageBase.driver.findElement(By.id("phone"));
 
        phone.sendKeys("123456789");

WebElement Orgname= homepageBase.driver.findElement(By.id("organization_name"));

		Orgname.sendKeys("Salma 88 ");

WebElement TermsCheckbox = homepageBase.driver.findElement(By.id("tc-pp"));

homepageBase.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		TermsCheckbox.click();



 WebElement submit = homepageBase.driver.findElement(By.id("login-submit"));

 submit.click();

}

}