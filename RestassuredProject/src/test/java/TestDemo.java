import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestDemo {

	String api_url = "https://reqres.in/api/users?page=2";

	String api_key = "6d88aec7992f29fc715df835c";

@Test

	void GetDemo() {


Response response = get(api_url);

System.out.println(response.getStatusLine());

System.out.println(response.getStatusCode());

System.out.println(response.getTime());

System.out.println(response.getHeader("Content_Type"));

System.out.println(response.getBody().asString());

System.out.println(response.asString());

	int statuscode = response.getStatusCode();

	Assert.assertEquals(statuscode, 202);
}

@Test

void newtest() {

	given().header("API-KEY" , api_key)
	.accept(ContentType.JSON).
	contentType(ContentType.JSON).
		get("https://qaland.qoyod.com/api/2.0/customers/175").
			then().
					statusCode(200).log().all();
	/*.
		body("data.id[0]",equalTo(7))*/
	}
}
