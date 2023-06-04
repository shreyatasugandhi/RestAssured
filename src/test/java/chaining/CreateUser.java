package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class CreateUser {
	
	@SuppressWarnings("unchecked")
	@Parameters({ "appBaseURI", "token" })
	@Test
	public void createUserTest(String appUrl, String bearerToken, ITestContext context) {

		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		System.out.println(data);
		
		
		baseURI = appUrl;
		int id = given()
			.headers("Authorization", "Bearer " + bearerToken)
			.contentType("application/json")
			.body(data.toJSONString())
		.when()
			.post("/public/v2/users")
			.jsonPath().getInt("id");
//		.then()
//			 .statusCode(201)
//			 .log()
//			 .all()
//			 .extract().jsonPath().getInt("id");
		
		System.out.println("Generated user id is - " + id);
		
		context.setAttribute("user_id", id);
		//context.getSuite().setAttribute("user_id", id);
		
	}
	
	
	
}
