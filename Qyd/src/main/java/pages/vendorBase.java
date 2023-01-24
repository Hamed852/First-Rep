package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import com.github.javafaker.Faker;

public class vendorBase {

	
	homepageBase hb = new homepageBase();
  
	static Faker Fk = new Faker();
	
	String Vname = Fk.name().firstName();

	String VprEmail = Fk.internet().emailAddress();
	
	String VsecEmail = Fk.internet().emailAddress();
	
	String Vprimeno = Fk.phoneNumber().subscriberNumber(11);
	
	String Vsecondaryno = Fk.phoneNumber().subscriberNumber(11);
	
	String taxno = Fk.number().digits(20);
	
	String Vorgnam = Fk.name().title();
	
	
	String Vorgnwebsite = Fk.internet().url();
	
	
	public void VendorFormNavigation()

{
			
	WebElement PurchasesLink=	hb.driver.findElement(By.xpath("/html/body/div[2]/div/aside/section/ul/li[3]/a/span"));
	
			PurchasesLink.click();
		
	WebElement VendorsLink=	hb.driver.findElement(By.partialLinkText("Vendors"));
	
	        VendorsLink.click();
		
	WebElement NewVendorBtn =	hb.driver.findElement(By.partialLinkText("New Vendor"));

				NewVendorBtn.click();
		
}
	

	public void CreateVendor()
{
				
		WebElement VendorName =	hb.driver.findElement(By.id("contact_contact_name"));
		
			VendorName.sendKeys(Vname);
	
		WebElement VprimaryNo=	hb.driver.findElement(By.id("contact_primary_contact_number"));

			VprimaryNo.sendKeys(Vprimeno);
	
		WebElement VsecondaryNo =	hb.driver.findElement(By.id("contact_secondary_contact_number"));

			VsecondaryNo.sendKeys(Vsecondaryno);
		
		WebElement Vemail =	hb.driver.findElement(By.id("contact_primary_email"));

			Vemail.sendKeys(VprEmail);
		
     	WebElement Vsecondemail =	hb.driver.findElement(By.id("contact_secondary_email"));

     		Vsecondemail.sendKeys(VsecEmail);
		
		
		WebElement Vorgname =	hb.driver.findElement(By.id("contact_organization_name"));

			Vorgname.sendKeys(Vorgnam);
		
		WebElement Vsite =	hb.driver.findElement(By.id("contact_website"));

			Vsite.sendKeys(Vorgnwebsite);
		
		WebElement Vtaxno =	hb.driver.findElement(By.id("contact_tax_number"));

			Vtaxno.sendKeys(taxno);
		

		WebElement Vstatuslist =hb.driver.findElement(By.id("contact_status"));
		
			Select selectoptions= new Select(Vstatuslist);
		
				Assert.assertFalse(selectoptions.isMultiple());
		
					Assert.assertEquals(2, selectoptions.getOptions().size());
		
						selectoptions.selectByVisibleText("Active");
				
		WebElement SubmitBtn =hb.driver.findElement(By.id("product_submit"));
		
			SubmitBtn.click();
		
}
	
}
