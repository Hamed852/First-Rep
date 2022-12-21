package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Getunit extends CreateUnit {

	@Test(dependsOnMethods = "CreateUnitTest")
	static public void GetUnitTest() {
		
		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/product_unit_types";

	 
		int unitid = CreateUnit.unit_id;
	
		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.get("/" + unitid);
	    ResponseBody body = res.getBody();
	    System.out.println(res.getStatusLine());
	    System.out.println(body.asString());
	     
		String name = res.then().extract().path("product_unit_type.unit_name");

		System.out.println(" my unit name is "+ name  );

	Assert.assertEquals(name, CreateUnit.unitname);
		
		String unitRepr =res.then().extract().path("product_unit_type.unit_representation");
		
		System.out.println(unitRepr);
		
		Assert.assertEquals(unitRepr, CreateUnit.unitRepresentation);
				
		System.out.println("my status code is " + res.getStatusCode());

		Assert.assertEquals(res.getStatusCode(), 200);

		System.out.println("my Get method is OK ");

		
		
	}
}
