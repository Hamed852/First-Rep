package RestQydApiTest;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetProduct extends CreateProduct {

@Test(dependsOnMethods = "createproducttest") 
	static public void getproductTest() 
	
{
		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/products";

	 
		int prodcutid = CreateProduct.ProductID;
	
		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.get("/" + prodcutid);
	    ResponseBody body = res.getBody();
	    System.out.println(res.getStatusLine());
	    System.out.println(body.asString());
	     
		String name = res.then().extract().path("product.name_en[0]");

		System.out.println(" my En product name is "+ name  );

		String sku =res.then().extract().path("product.sku[0]");
		
		System.out.println(sku);
		
		Assert.assertEquals(sku, CreateProduct.Product_sku);
				
		System.out.println("my status code is " + res.getStatusCode());

		Assert.assertEquals(res.getStatusCode(), 200);

		System.out.println("my Get method is OK ");

		
}
}


