package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateInventory extends GetInventory {

	static GetInventory GET_Inv = new GetInventory();

	static String Updated_LOC_name;
	
	static Response updateInventoryres ;


	@Test(dependsOnMethods = "getinventoryTest")
	public static void updateLocationDetails() {
		JSONObject request = new JSONObject();

		JSONObject inventory = new JSONObject();
		Faker fk = new Faker();
		
		String new_inv_name = fk.company().name();

		inventory.put("name", new_inv_name);

		Updated_LOC_name = new_inv_name;

		System.out.println("now the new name is " + new_inv_name);

		request.put("inventory", inventory);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "inventories";

		int inv_id = Inv_ID;

		String Old_loc_name = GET_Inv.inv_EN_name;

		System.out.println(inv_id);

		updateInventoryres = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).log().all().when()
				.patch("/" + inv_id);

		
		updateInventoryres.then().body("name", equalTo(new_inv_name));
		 
		updateInventoryres.then().body("ar_name", equalTo( GET_Inv.inv_AR_name));
		 
		System.out.println("the old Loc name is " + Old_loc_name);

		System.out.println("the new Loc name is " + Updated_LOC_name);


	
}}