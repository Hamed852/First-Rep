package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.Future;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateBill extends CreateVendor {

	
	
	static Faker fk = new Faker();

	static int vendID = VendorID;
	static String Bill_ReferenceID;
	static String bill_status ;
	static String bill_issueDate ;
	static String bill_DueDate ;
	static String Pr_des = "Created by Rest assured Req";
	static String Creationdate = "";
	static int Bill_ID;

	@SuppressWarnings("unchecked")
	@Test
	
	public static void CreateBillTest() {

	JSONObject CRBillReq = new JSONObject();
		JSONObject bill = new JSONObject();

		bill.put("contact_id", "151");
		String Billstatus= "Draft";
		bill.put("status", Billstatus);
		bill.put("issue_date", "2022-12-28");
		bill.put("due_date", "2023-03-28");
		String BillReff = "Bill-"  + fk.number().randomNumber();
		bill.put("reference", BillReff);
		bill.put("inventory_id","7" );
		
		JSONObject line_items = new JSONObject();
		line_items.put("product_id","1" );
		line_items.put("description","First Rest Bill " );
		line_items.put("quantity","3" );
		line_items.put("unit_price","10" );
		line_items.put("discount", "20");
		line_items.put("tax_percent","10" );
		bill.put("line_items", line_items);
		
		JSONObject custom_fields = new JSONObject();
		custom_fields.put("customfield1", "mody");
		custom_fields.put("customfield2", "mody");
		bill.put("custom_fields", custom_fields);
		
		CRBillReq.put("bill", bill);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "bills";

		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRBillReq.toJSONString()).log().all().when()
				.post();
		
		System.out.println(res.then().extract().path("bill.created_at"));
		
		

		
		int bill_id =	res.then().extract().path("bill.id");
		
		System.out.println(bill_id);
		Bill_ID = bill_id;
	
		
		int statuscode = res.statusCode();
		Assert.assertEquals(201, statuscode);
		
	}

}
