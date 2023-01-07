package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class GetPurchaseOrder extends CreatePurchaseOrder {

	@Test(dependsOnMethods = "CreatePurchaseOrderTest")
	static public void getPurchaseOrderTest() {
		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/orders";

		int purchase_order_id = Purchase_order_ID;

		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.get("/" + purchase_order_id);
		ResponseBody body = res.getBody();
		System.out.println(res.getStatusLine());
		System.out.println(body.asString());

		res.then().body("reference", equalTo(orderReferenceNo));

		res.then().body("created_at", equalTo(PurOrder_Creationdate));
		res.then().body("expiry_date", equalTo(PurOrder_expirydate));

		System.out.println("my status code is " + res.getStatusCode());

		Assert.assertEquals(res.getStatusCode(), 200);

		System.out.println("Get PurChase Order is OK ");

	}

}
