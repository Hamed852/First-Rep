package Product;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import RestQydApiTest.CreateProduct;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Getproduct extends CreateProduct{

	
	
@Test(dependsOnMethods = "createproducttest")
	
	void getsingleproduct()
{

	String sku = "1472021";
	
	baseURI ="https://qaland.qoyod.com/api/2.0" ;
	basePath = "/products";


Response res =given().accept(ContentType.JSON).
		header("API-KEY","6d88aec7992f29fc715df835c").get("/1");
		
		

res.then().body("product.sku[0]", equalTo(sku));

String arname = res.then().extract().path("product.name_ar[0]");

System.out.println("my product name is " + arname);


}
}
