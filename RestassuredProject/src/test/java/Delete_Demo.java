import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class Delete_Demo extends Dataprovider {

	@Test(dataProvider ="delete")
	public void deleteRequest(int userID) {



		baseURI ="http://localhost:3000/";

		when().
		delete("/users/"+userID).then().log().all();


	}
}
