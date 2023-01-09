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

public class GetBill extends CreateBill {



@Test(dependsOnMethods = "CreateBillTest") 
static public void getbillTest() 

{
	baseURI = "https://qaland.qoyod.com/api/2.0";
	basePath = "/bills";


	Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
			.get("/" +Bill_ID );

	ResponseBody body = res.getBody();
    System.out.println(res.getStatusLine());
    System.out.println(body.asString());
     

	res.then().body("reference", equalTo(Bill_ReferenceID));
	
	res.then().body("issue_date", equalTo(bill_issueDate));
			
	System.out.println("TC status code is " + res.getStatusCode());

	Assert.assertEquals(res.getStatusCode(), 200);

	System.out.println("my Get Bill Method is OK ");

}}
