package authenticationtechniques;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class APIKeyAuth {
	
	@Test
	public void apiKeyAuth() {
		
		given()
			.queryParam("appid", "58b381cec85ccd2e763e8e97ed7d06de")
		.when()
			.get("http://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")				
		.then()
			.statusCode(200)
			.log().all();
	}

}
