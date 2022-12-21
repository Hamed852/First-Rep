import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class Put_Demo {


	@Test

	void putdemo() {



		JSONObject request = new JSONObject();
		request.put("name", "hamedo");
		request.put("job", "Teacher ");

		/*System.out.println(request);
		*/
		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").then().statusCode(200).log().all();



		
		


	}

	@Test
	void patchdemo() {



		JSONObject request = new JSONObject();
		request.put("name", "hamedo");
		request.put("job", "Teacher ");

		/*System.out.println(request);
		*/
		given().
		header("Content-type" , "application/json").
		contentType(ContentType.JSON)
		.accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();
}}
