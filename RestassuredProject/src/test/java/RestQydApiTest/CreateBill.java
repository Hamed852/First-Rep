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
/*
	static Faker fk = new Faker();

	static int vendID = VendorID;
	static String Bill_ReferenceID;
	static String bill_status ;
	static String bill_issueDate ;
	static String bill_DueDate ;
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

	@SuppressWarnings("unchecked")
	@Test(dependsOnMethods = "CreateVendorTest") /* Also must Depend on create location test */
	public static void CreateBillTest() {
/*

        "issue_date": "{{iss_date}}",
        "due_date": "{{Due_date}}",
        "reference": "{{Reference}}",
        "inventory_id": "{{inven_id}}",
        "line_items": [
            {
                "product_id": "{{pr_id}}",
                "description": "{{desc}}",
                "quantity": "{{quan}}",
                "unit_price": "{{unit_pric}}",
                "discount": "{{disc}}",
                "tax_percent": "{{tax_perc}}"
            }
        ],
        "custom_fields": {
            "customfield1": "{{custom_field1}}",
            "customfield2": "{{custom_field2}}"
        }
    }

loc
	*/
	/*tttt	LocalDate myObj = LocalDate.now(); 
		
		JSONObject CRBillReq = new JSONObject();
		JSONObject bill = new JSONObject();
		bill.put("contact_id", vendID);
		String Billstatus= "Draft";
		bill.put("status", Billstatus);
		String issuedate = fk.date().toString();
		
		product.put("name_ar", issuedate);
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
		basePath = "bills";

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
*/	}

}
