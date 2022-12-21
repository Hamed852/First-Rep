package Hamee;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramaterization {


	@Test
	@Parameters({"userid"})
	public void deleteRequest(int userid) {



		baseURI ="http://localhost:3000/";

		when().
		delete("/users/"+userid).then().log().all();


	}

}
