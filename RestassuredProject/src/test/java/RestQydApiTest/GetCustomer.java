package RestQydApiTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetCustomer extends Customerbase  {
	
	Customerbase cb = new Customerbase();
		@Test(dependsOnMethods = "addcust")
void getcustomertest() {
	cb.getcust();
}
	
}