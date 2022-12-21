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
import io.restassured.response.ResponseBody;

public class CreateVendor extends GetCustomer {

static GetCustomer cb = new GetCustomer();
	
	static int VendorID ; 
	static String VendorCreationdate ;
	static String Vendorname ; 
	static String VendorEmail ; 
	static String VendorPhoNo ; 
	
	@Test(dependsOnMethods = "getcustomertest")
	public static void CreateVendorTest() {

		JSONObject CRReq = new JSONObject();
		JSONObject contact = new JSONObject();

		 contact.put("name", cb.custName);
		 contact.put("organization", cb.OrgName);
		 contact.put("email", cb.custEmail);
		 contact.put("phone_number", cb.PhoneNo);
		 contact.put("tax_number", cb.Taxno);
		 
		CRReq.put("contact", contact);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "vendors";

		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRReq.toJSONString()).log().all().when()
				.post();
	
		int Venndorid = res.then().extract().path("contact.id");
		System.out.println(Venndorid);
		VendorID = Venndorid;
			
		ResponseBody body =res.getBody();
		
		String createdate = res.then().extract().path("contact.created_at");
		System.out.println(createdate);
		VendorCreationdate = createdate;
		
		String vendname = res.then().extract().path("contact.name");
		
		System.out.println(vendname);
		
		Vendorname = vendname;
		
		System.out.println(Vendorname);
		
		String vendorEmail = res.then().extract().path("contact.email");
		System.out.println(vendorEmail);
		VendorEmail = vendorEmail;
		
		String vendorPhone = res.then().extract().path("contact.phone_number");
		System.out.println(vendorEmail);
		VendorPhoNo = vendorPhone;
		
		
		
		
		int statuscode = res.statusCode();
		Assert.assertEquals(201, statuscode);
		
		System.out.println("my vendor id is "+ Venndorid);
	
	}
	
	}
