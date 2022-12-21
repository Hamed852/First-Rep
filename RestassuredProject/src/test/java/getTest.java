import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getTest {

	static String url = "https://reqres.in/api/users/" ;
	Response response ;

	@Test
	void get(){

	response= RestAssured.get(url+10);

	System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			System.out.println(response.getHeader("Content-type"));

			int statcode = response.getStatusCode();
			Assert.assertEquals(statcode, 200);
	}

	@Test
	void get2(){

		given().get(url)
		.then()
		.body("data.id", equalTo(10))
		.and()
		.log().all()
		.body("data.first_name" , equalTo("Byron"));

}}
