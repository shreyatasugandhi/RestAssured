package authenticationtechniques;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.authentication.FormAuthConfig;

public class FormAuth {
	

	@Test
	public void formAuthTest() {
		given().auth()
		  .form(
		    "user1",
		    "user1Pass",
		    new FormAuthConfig("/perform_login", "username", "password"))
		  //given() .auth().form("your username", "your password").post("your end point URL")
		.when()
			.get("url")				
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}


}
