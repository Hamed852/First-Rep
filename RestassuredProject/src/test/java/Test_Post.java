import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo ;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matcher.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Post {
	@Test
	public void Postdemowithmap() {

	Map<String,Object > map = new HashMap<String, Object>();

	map.put("\"name\"","\"hamed\"");

	map.put("job", "Qc engineer");

		System.out.println(map);

		given().get().statusCode();
}

	@DataProvider(name ="dataFortest")
	public Object[][] datafortest(){

		Object [][] data = new Object[2][2];


		data [0][0] = "mohamed";
		data [0][1] = "QC";



		data [1][0] = "Hamedo-teacher";
		data [1][1] = "Teacher";
return data;
				}

	@Test(dataProvider = "dataFortest")
	
	public void PostdemowithjsonRequest(String fname , String job) {


		JSONObject request = new JSONObject();
		request.put("name",fname);
		request.put("job", job);
		/*System.out.println(request);
		*/

		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").then().statusCode(201).log().all();

	



	}
@Test
	void getuser() {
		given().get("/users")
		.then().
		statusCode(200).
		log().all();
		
		
	}


}
