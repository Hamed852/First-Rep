package RestQydApiTest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xwpf.usermodel.BodyElementType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateCust {
	
	Customerbase cb = new Customerbase();


		@Test	 
void addcusttest() 
{
		
			Customerbase.addcust();
}
}
	
	
	
	