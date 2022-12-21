package RestQydApiTest;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static com.github.javafaker.Faker.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateVendor extends CreateVendor {
	static CreateVendor cv = new CreateVendor();
	static GetVendor gv = new GetVendor();

	static String UpdVendName;
	
	static Response updateVendorres ;


	@Test(dependsOnMethods = "CreateVendorTest")
	public static void updateVendorDetails() {
		JSONObject request = new JSONObject();

		JSONObject contact = new JSONObject();
Faker fk = new Faker();
		String vendname = fk.name().name();

		contact.put("contact.name", vendname);

		UpdVendName = vendname;

		System.out.println("now the new name is " + UpdVendName);

		request.put("contact", contact);

		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "vendors";

		int vendor_id = cv.VendorID;

		String Oldvendorname = cv.Vendorname;

		System.out.println(vendor_id);

		updateVendorres = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).log().all().when()
				.put("/" + vendor_id);

		System.out.println("the old Vendor name is " + Oldvendorname);

		System.out.println("the new Vendor name is " + UpdVendName);

		gv.getVendorTest();
		
		updateVendorres.then().body("contact.name", equalTo(UpdVendName ));
		 
		updateVendorres.then().body("contact.name", equalTo(gv.Vendorname ));
		
		UpdVendName = cv.Vendorname ;
	}
}
