package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class billcreationBase {

	date d = new date();
	Faker fake = new Faker();
	
	String BilReff = "Bill-" + fake.number().numberBetween(1, 99) ; 
	
	String billdes = fake.name().name();
	
	
public void BillFormNavigation()

{
	WebElement PurchasesLink=	homepageBase.driver.findElement(By.xpath("/html/body/div[2]/div/aside/section/ul/li[3]/a/span"));
	
			PurchasesLink.click();
		
	WebElement BillsLink=	homepageBase.driver.findElement(By.partialLinkText("Bills"));
	
			BillsLink.click();
		
	WebElement NewBillBtn =	homepageBase.driver.findElement(By.partialLinkText("New Bill"));

				NewBillBtn.click();
				
}

public void usercancreateabill() 
{
	
	WebElement BillRef =homepageBase.driver.findElement(By.id("bill_reference"));
	
			BillRef.clear();
			
			homepageBase.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			
			BillRef.sendKeys(BilReff);

	WebElement BillDes=	homepageBase.driver.findElement(By.id("bill_description"));
	
				BillDes.sendKeys(billdes);
	
	WebElement Biissdate =	homepageBase.driver.findElement(By.id("bill_issue_date"));	
	
	Biissdate.clear();
	
	homepageBase.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	
	Biissdate.sendKeys(homepageBase.date1);
	
	Biissdate.sendKeys();
	
//			.clear();
//			
//	homepageBase.driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//	
//	Biissdate.sendKeys(homepageBase.date1);
//	
//	Biissdate.sendKeys(Keys.ESCAPE);
/*
	WebElement BillVend =homepageBase.driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/section[2]/div/div/div/form/div/div[1]/div[3]/div/div[2]/span/span[1]/span"));

	Select selectoptions= new Select(BillVend);

		Assert.assertFalse(selectoptions.isMultiple());

           selectoptions.selectByVisibleText("Olin");






	/*WebElement Vsecondemail =	homepageBase.driver.findElement(By.id("contact_secondary_email"));

		Vsecondemail.sendKeys(VsecEmail);


WebElement Vorgname =	homepageBase.driver.findElement(By.id("contact_organization_name"));

	Vorgname.sendKeys(Vorgnam);

WebElement Vsite =	homepageBase.driver.findElement(By.id("contact_website"));

	Vsite.sendKeys(Vorgnwebsite);

WebElement Vtaxno =	homepageBase.driver.findElement(By.id("contact_tax_number"));

	Vtaxno.sendKeys(taxno);


WebElement Vstatuslist =homepageBase.driver.findElement(By.id("contact_status"));

	Select selectoption= new Select(Vstatuslist);

		Assert.assertFalse(selectoption.isMultiple());

			Assert.assertEquals(2, selectoptions.getOptions().size());

				selectoptions.selectByVisibleText("Active");
		
WebElement SubmitBtn =homepageBase.driver.findElement(By.id("product_submit"));

	SubmitBtn.click();
*/
}	
}
