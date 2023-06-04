package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetUser {
	
	@Parameters({ "appBaseURI", "token" })
	@Test
	public void getUserByIdTest(String appUrl, String bearerToken, ITestContext context) {
		
		int id = (int) context.getAttribute("user_id"); // This will come from createUserTest at test level
		//int id = (int) context.getSuite().getAttribute("user_id"); // This will come from createUserTest at suite level
		
		baseURI = appUrl;
		
		given()
			.headers("Authorization", "Bearer " + bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
		.when()
			.get("/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
