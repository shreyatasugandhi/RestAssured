package authenticationtechniques;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class BearerTokenAuth {
	
	@Test
	public void bearerTokenAuthTest() {
		
		String bearerToken = "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";
		given()
			.headers("Authorization", "Bearer " + bearerToken)
		.when()
			.get("https://api.github.com/user/repos")				
		.then()
			.statusCode(200)
			.log().all();
	}

}
