package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateProduct extends GetProduct {

	static String updated_Pr_name_en ;


	
	@Test(dependsOnMethods = "getproductTest")
	public static void updatefield() 
{	
			JSONObject request = new JSONObject();

			JSONObject product = new JSONObject();
			
			String PRname  =fk.name().name();
			
			product.put("name_en", PRname);

			updated_Pr_name_en = PRname;
			
			request.put("product", product);
			
			
			baseURI = "https://qaland.qoyod.com/api/2.0/";
			basePath = "products";

	int product_id  = CreateProduct.ProductID;
	
			System.out.println(product_id);
			
			Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
					.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).log().all().when()
					.put("/" +product_id);
			
		
			String name = res.then().extract().path("product.name_en");
			
			System.out.println(name);
			
			System.out.println("the new product name is " + name );
			
			System.out.println(updated_Pr_name_en);

			Assert.assertEquals(res.then().extract().path("product.name_en"),updated_Pr_name_en);
			

	}
	
}
