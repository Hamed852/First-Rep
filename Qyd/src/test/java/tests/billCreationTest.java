package tests;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.billcreationBase;
import pages.homepageBase;

public class billCreationTest 

{

	@Test
public void Billcreation() {
	
		homepageBase.Getdate();
		loginTest.UserLogin();
	
 	billcreationBase BB = new billcreationBase();	
 	BB.BillFormNavigation();
 	BB.usercancreateabill();
}}
