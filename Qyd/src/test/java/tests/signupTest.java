package tests;

import org.testng.annotations.Test;

import pages.homepageBase;
import pages.signupBase;

public class signupTest {


	
	
	
	@Test
	
	public void UserRegesteration ()
	{
		
		homepageBase.Journeystarts();
	
     	signupBase SB = new signupBase();	
         
     	   SB.Navigationsignup();
		 
     	   SB.usercanregister();
	
		
	}
	
	
}
