package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@SuppressWarnings("unchecked")
	@Parameters({ "appBaseURI", "token" })
	@Test
	public void createUserTest(String appUrl, String bearerToken, ITestContext context) {

		int id = (int) context.getAttribute("user_id"); // This will come from createUserTest at test level
		//int id = (int) context.getSuite().getAttribute("user_id"); // This will come from createUserTest at suite level
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		System.out.println(data);
				
		baseURI = appUrl;
		given()
			.headers("Authorization", "Bearer " + bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toJSONString())
		.when()
			.put("/public/v2/users/{id}")
		.then()
			 .statusCode(200)
			 .log()
			 .all();
				
		
	}
	

}
