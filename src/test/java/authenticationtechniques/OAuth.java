package authenticationtechniques;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class OAuth {
	
	//@Test
	public void OAuth1Test() {
		
		given()
			.queryParam("oauth_consumer_key", "RKCGzna7bv9YD57c")
			.queryParam("oauth_nonce", "zPzMMw6SKaZ")
			.queryParam("oauth_signature", "zY4BYNEZQ2HK7ePE%2B4ULQLctbLk%3D")
			.queryParam("oauth_signature_method", "HMAC-SHA1")
			.queryParam("oauth_timestamp", "1685615808")
			.queryParam("oauth_version", "1.0")
			.cookie("some cookie")
			.auth().oauth("RKCGzna7bv9YD57c", "D+EdQ-gs$-%@2Nu7", "accessToken", "secretToken")
		.when()
			.get("https://postman-echo.com/oauth1")				
		.then()
			.statusCode(200)
			.body("status", equalTo("pass"))
			.body("message", equalTo("OAuth-1.0a signature verification was successful"))
			.log().all();
	}

	
	@Test
	public void OAuth2Test() {
		
		String apiToken = "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";
		baseURI = "https://api.github.com/";
		
		given()
			.auth().oauth2(apiToken)
		.when()
			.get("/user/repos")				
		.then()
			.statusCode(200)
			.log().all();
	}

}
