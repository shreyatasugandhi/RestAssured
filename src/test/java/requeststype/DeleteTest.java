package requeststype;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class DeleteTest {
	
	@Test
	public void deleteTest() {
		
		baseURI = "https://reqres.in";
	
		when()
			.delete("/api/users/2")
		.then()
			.statusCode(204)
			.log().all();
		
		
	}

}
