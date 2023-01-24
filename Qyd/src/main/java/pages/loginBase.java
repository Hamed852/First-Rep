package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class loginBase {


private static final String[] String = null;
homepageBase hb = new homepageBase();




public void Navigationlogin()

{
		hb.Loginform();
		hb.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/*@Parameters({"Username","Password"})
*/
public void usercanlogin()
{
	

	WebElement usrname = homepageBase.driver.findElement(By.id("user_email"));

		usrname.sendKeys("m.hamed@qoyod.com");

WebElement Pass = homepageBase.driver.findElement(By.id("user_password"));

	Pass.sendKeys("AAaa@123456789");

WebElement LognBtn = homepageBase.driver.findElement(By.id("login-submit"));

    LognBtn.click();

	
}

}
