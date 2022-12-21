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

public class CreateUnit {

	Faker fk = new Faker();
static	 String unitname ; 
static	 String unitRepresentation ;
	static int unit_id ; 
	@SuppressWarnings("unchecked")
	@Test
	public void CreateUnitTest() 
	
	{

		JSONObject CRReq = new JSONObject();
		JSONObject product_unit_type = new JSONObject();
		
		String unitnam = fk.name().name();		
		
		product_unit_type.put("unit_name", unitnam);	
		
		unitname =unitnam ;
		
		String unitRep = fk.harryPotter().book();		
		
		product_unit_type.put("unit_representation", unitRep);
		
		unitRepresentation =unitRep ;
		
		CRReq.put("product_unit_type", product_unit_type);
		
		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/product_unit_types";

		
		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
					.contentType(ContentType.JSON).accept(ContentType.JSON).body(CRReq.toJSONString()).log().all().when()
					.post();
			
		    ResponseBody body = res.getBody();
		    System.out.println(res.getStatusLine());
		   
		    System.out.println(body.asString());
		     
			int unitid =res.then().extract().path("product_unit_type.id");
			
			System.out.println( "my unit id is " + unitid);
			
			unit_id = unitid ;
		}
	}
