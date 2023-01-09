package RestQydApiTest;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.junit.After;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class DeleteBill extends GetBill {

	@SuppressWarnings("rawtypes")
	@Test(dependsOnMethods = { "getbillTest" })
	public static void DeletebillTest() {

		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/bills";

		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.delete("/" + Bill_ID);
		
		ResponseBody body = res.getBody();
		System.out.println(res.getStatusLine());
		System.out.println(body.asString());
	}
}
