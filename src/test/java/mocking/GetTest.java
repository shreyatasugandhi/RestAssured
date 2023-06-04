package mocking;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	@Test
	public void mockedGetTest () {
		
		baseURI = "http://localhost:3000";
		given()
			.queryParam("page", "2")
		.when()
			.get("/api/users")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
