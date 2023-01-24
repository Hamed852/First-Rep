package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.homepageBase;
import pages.vendorBase;

public class vendorTest {

homepageBase Hc = new homepageBase() ;
	
	@Test
	public static void VendorCreation  ()
	{
		
		
		loginTest.UserLogin();
		homepageBase Hc = new homepageBase() ;
		
     	vendorBase VB = new vendorBase();	
         
     	   VB.VendorFormNavigation();
     	   VB.CreateVendor();
     	   Hc.closingdriver();
		
    	}



}