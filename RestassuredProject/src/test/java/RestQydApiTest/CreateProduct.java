package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Code;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateProduct {

	static Faker fk = new Faker();


	
	static String Product_sku;
	static String Pr_name_ar = fk.food().fruit();
	static Code Pr_barcode = fk.code() ;
	static String Pr_name_en = fk.food().fruit();
	static String Pr_des = "Created by Rest assured Req";
	static int Pr_unit_type_id = 1;
	static int Pr_category_id = 1;
	static String Pr_track_quantity = "10";
	static boolean is_purchase_item = true;
	static int Pr_buying_price = 10;
	static boolean is_sale_item = true;
	static int Pr_selling_price = 30;
	static int exp_acc_id = 1;
	static int sales_account_id = 17;
	static int tax_id = 1;
	static String Creationdate = "";
	static int ProductID;
static String Productname;
static String Producdesc;	
	@Test
	public static void createproducttest() {

		JSONObject CRReq = new JSONObject();
		JSONObject product = new JSONObject();
		String Pr_sku = "sku-" + fk.number().numberBetween(10000, 100000);
		product.put("sku", Pr_sku);
		Product_sku = Pr_sku;
		product.put("barcode", Pr_barcode);
		product.put("name_ar", Pr_name_ar);
		product.put("name_en", Pr_name_en);
		product.put("description", Pr_des);
		product.put("product_unit_type_id", Pr_unit_type_id);
		product.put("category_id", Pr_category_id);
		product.put("track_quantity", Pr_track_quantity);
		product.put("purchase_item", is_purchase_item);
		product.put("buying_price", Pr_buying_price);
		product.put("expense_account_id", exp_acc_id);
		product.put("sale_item", is_sale_item);
		product.put("selling_price", Pr_selling_price);
		product.put("sales_account_id", sales_account_id);
		product.put("tax_id", tax_id);

		CRReq.put("product", product);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "products";

		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRReq.toJSONString()).log().all().when()
				.post();
		
		int prodid = res.then().extract().path("product.id");
		System.out.println(prodid);
		ProductID = prodid;
		
		String createdate = res.then().extract().path("product.created_at");
		System.out.println(createdate);
		Creationdate = createdate;
		
		int statuscode = res.statusCode();
		Assert.assertEquals(201, statuscode);
		
		System.out.println(Product_sku);
	}
}
