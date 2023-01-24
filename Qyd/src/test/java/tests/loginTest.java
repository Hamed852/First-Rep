package tests;

import org.testng.annotations.Test;

import pages.homepageBase;
import pages.loginBase;

public class loginTest {
	
	
	

	@Test
	
	public static void UserLogin ()
	{
		
		homepageBase.Journeystarts();
	
     	loginBase LB = new loginBase();	
         
     	   LB.Navigationlogin();
		 
     	   LB.usercanlogin();
	
		
	}

}
