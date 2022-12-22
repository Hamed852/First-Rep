package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetVendor extends CreateVendor  {
	
static	CreateVendor cv = new CreateVendor();
	

	@Test(dependsOnMethods = "CreateVendorTest") 
	public static void getVendorTest() {
		
	
					baseURI = "https://qaland.qoyod.com/api/2.0";
					basePath = "/vendors";

				 
					int vendID = CreateVendor.VendorID;
				
					Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
							.get("/" + vendID);
					
					System.out.println(" my vendor mail is " + VendorEmail  );
					System.out.println(" my phone nu. is "+ VendorPhoNo  );
					
					res.then().body("contact.email", equalTo(cv.VendorEmail));
					res.then().body("contact.phone_number", equalTo(cv.VendorPhoNo));
					 
					System.out.println("my Get method is OK ");

			}
	}


