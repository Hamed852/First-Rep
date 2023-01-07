package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetInventory extends CreateInventory {

	@Test(dependsOnMethods = "createLocationtest") 
	static public void getinventoryTest() 
	
{
		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/inventories";

	 
		int inventory_ID = CreateInventory.Inv_ID;
	
		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.get("/" + inventory_ID);
	    ResponseBody body = res.getBody();
	    System.out.println(res.getStatusLine());
	    System.out.println(body.asString());
	     

		
		res.then().body("ar_name", equalTo(inv_AR_name));
		
		res.then().body("name", equalTo(inv_EN_name));
				
		System.out.println("my status code is " + res.getStatusCode());

		Assert.assertEquals(res.getStatusCode(), 200);

		System.out.println("my Get method is OK ");

}

}
