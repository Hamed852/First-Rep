import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class testPost {

	@Test
	void posttest ()

	{

	JSONObject req = new JSONObject();
	
	req.put("name", "Sayed ");

	req.put("job", "leader3");
	
	
	baseURI ="http://localhost:3000/users?name=HamedTest";

	given().header("Content Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
	body(req.toJSONString()).
when().
post().then().statusCode(201).and().log().all();

	
	
	
/*
	System.out.println(req);
	System.out.println(req.toJSONString());
	*/
	}
	
	
	
@Test
	void posttestUseMap ()

	{


		Map<String, Object>  mp = new HashMap<String, Object>();

	mp.put("name", "morpheus");

	mp.put("job", "leader");
	System.out.println(mp);
	JSONObject req = new JSONObject();
	
	req.put("name", "morpheus");

	req.put("job", "leader");

	System.out.println(req);
	System.out.println(req.toJSONString());




	}}