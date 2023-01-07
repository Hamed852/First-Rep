package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreatePurchaseOrder extends CreateVendor {

	static CreateVendor CV = new CreateVendor();

	static int Purchase_order_ID;
	static Faker fk = new Faker();
	static String orderReferenceNo;
	static String PurOrder_Creationdate;
	static Date PurOrder_expirydate;
	
	@Test(dependsOnMethods = "CreateVendorTest")
	public static void CreatePurchaseOrderTest() {

		JSONObject CRReq = new JSONObject();
		JSONObject order = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String orderRef = "Order-" + fk.number().randomNumber();
		orderReferenceNo = orderRef;
		String Exp_date = sdf.format(fk.date().future(50, TimeUnit.DAYS));
		String issue_date = sdf.format(fk.date().past(50, TimeUnit.DAYS));

		String orderStatus = "draft";

		String orderNotes = fk.funnyName().name();

		String orderTerms = fk.name().nameWithMiddle();

		order.put("contact_id", "270");

		order.put("reference", orderRef);
		order.put("issue_date", issue_date);
		order.put("expiry_date", Exp_date);
		order.put("status", orderStatus);
		order.put("inventory_id", "75");
		order.put("notes", orderNotes);
		order.put("terms_conditions", orderTerms);

		JSONArray arr = new JSONArray();

		JSONObject line_items = new JSONObject();

		line_items.put("product_id", "1");
		line_items.put("description", "First Rest Bill ");
		line_items.put("quantity", "3");
		line_items.put("unit_price", "10");
		line_items.put("discount", "20");
		line_items.put("tax_percent", "10");
		line_items.put("discount_type", "1");

		arr.add(line_items);

		order.put("line_items", arr);

		CRReq.put("order", order);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "orders";

		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRReq.toJSONString()).log().all().when()
				.post();

		int statuscode = res.statusCode();
		System.out.println(statuscode);
		Assert.assertEquals(201, statuscode);

		int PurChase_orid = res.then().extract().path("order.id");
		System.out.println(PurChase_orid);

		Purchase_order_ID = PurChase_orid;

		String Created_at = res.then().extract().path("order.created_at");

		PurOrder_Creationdate = Created_at;
		System.out.println(PurChase_orid);

	}

}
