package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateInventory {

		static Faker fk = new Faker();
	
		static String inv_acc_ID = "10" ;
		static String inv_EN_name= fk.company().name();
		static String inv_AR_name  = fk.company().name(); 
		static String inv_ship_address ;
		static String inv_ship_city ;
		static String inv_ship_state ;
		static String inv_ship_zipcode ;
		static String inv_ship_country ;
		static int	Inv_ID ;
		
	
			@Test
		
		public static void createLocationtest() 
			{

			JSONObject CRReq = new JSONObject();
			JSONObject inventory = new JSONObject();
			
			inventory.put("name", inv_EN_name);
			inventory.put("ar_name",inv_AR_name );
			inventory.put("account_id", inv_acc_ID);

			JSONObject address = new JSONObject();
				
			
			address.put("shipping_address", "");
			address.put("shipping_city", "");
			address.put("shipping_state", "");
			address.put("shipping_zip", "");
			address.put("shipping_country", "");
			
			inventory.put("address", address);

			
			CRReq.put("inventory", inventory);
			

	
			baseURI = "https://qaland.qoyod.com/api/2.0/";
			basePath = "inventories";

	Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRReq.toJSONString()).log().all().when()
					.post();
					
			int statuscode = res.statusCode();
			System.out.println(statuscode);
		Assert.assertEquals(200, statuscode);
	
			int inv_id = res.then().extract().path("id");
			System.out.println(inv_id);
			
			Inv_ID = inv_id;
			
	}

}
