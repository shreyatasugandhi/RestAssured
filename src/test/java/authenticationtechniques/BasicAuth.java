package authenticationtechniques;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;


public class BasicAuth {
	
	@Test
	public void basicAuthTest() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")				
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}

}
