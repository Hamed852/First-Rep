package RestQydApiTest;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import java.util.List;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import static com.github.javafaker.Faker.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

 public  class Customerbase {
	 
	 static	Faker fk = new Faker() ;
		
	 	static int customerID; 	
		static String custName;
		static String custEmail;	
		static String Taxno;
		static String OrgName;
		static String PhoneNo;
		static String Status;
		
		
		@SuppressWarnings("unchecked")
		@Test(alwaysRun = true)
public static void addcust() {

	JSONObject requ = new JSONObject();
	JSONObject contact = new JSONObject();
	
		String tanumber = fk.random().hex(10);
		contact.put("tax_number",tanumber );
		System.out.println(tanumber);
		Taxno = tanumber ;
		
		String CustomerrName = fk.name().fullName();
		contact.put("contact_name",CustomerrName );
		System.out.println( "My Cutsomer name is "+ CustomerrName);
		custName = CustomerrName ;
		
		String CustORgName = fk.name().nameWithMiddle();
		contact.put("organization",CustORgName );
		System.out.println( "My Cutsomer org is "+ CustORgName);
		
		String MailForinput = fk.internet().emailAddress();
		contact.put("email",MailForinput );
		System.out.println( "My Cutsomer mail is "+ MailForinput);
		custEmail=MailForinput;
		
		String phoneNoinput = fk.phoneNumber().phoneNumber();
		contact.put("phone_number",phoneNoinput );
		System.out.println( "My Cutsomer PhNo. is "+ phoneNoinput);
		PhoneNo = phoneNoinput;
		
		String Statusinput = "Active";
		contact.put("status",Statusinput );
		System.out.println( "My Cutsomer status is "+ Statusinput);
		Status = Statusinput;

		requ.put("contact", contact);
		baseURI = "https://qaland.qoyod.com/api/2.0/";
		basePath = "customers";

		Response res = given().header("API-KEY", "6d88aec7992f29fc715df835c").header("Content Type", "application/json")
				.contentType(ContentType.JSON).accept(ContentType.JSON).body(requ.toJSONString()).log().all().when()
				.post();

		int custID = res.then().extract().path("contact.id");

		System.out.println(custID);

		customerID = custID;

		String customerName = res.then().extract().path("contact.name");

		System.out.println(customerName);

		custName = customerName;


		String phoneNum = res.then().extract().path("contact.phone_number");

		PhoneNo =phoneNum;		
		
		
		String taxnum = res.then().extract().path("contact.tax_number");
		
        Taxno= taxnum ;
		
        
        
        String organization = res.then().extract().path("contact.organization");
		OrgName = organization;
		
		
		String Email = res.then().extract().path("contact.email");

		System.out.println(Email);

		custEmail = Email;

		int statuscode = res.statusCode();

		Assert.assertEquals(201, statuscode);

		System.out.println("my customer Name is " + customerName);

		System.out.println("mycustomer id is " + customerID);

		System.out.println("status code is " + statuscode);

		System.out.println("Customer Email is " + Email);
		

		System.out.println(Taxno);
	}

@Test()
	public void getcust() {

		baseURI = "https://qaland.qoyod.com/api/2.0";
		basePath = "/customers";

		Response res = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all()
				.get("/" + 241);
	    ResponseBody body = res.getBody();
	    System.out.println(res.getStatusLine());
	    System.out.println(body.asString());
	     
		String customerEmail = given().accept(ContentType.JSON).header("API-KEY", "6d88aec7992f29fc715df835c").log().all().get()
				.then().extract().path("contact.name");

		
		int statuscode = res.getStatusCode();

		System.out.println(customerID);

		System.out.println("my status code is " + statuscode);

		Assert.assertEquals(200, statuscode);

	}
}
