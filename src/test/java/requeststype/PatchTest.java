package requeststype;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PatchTest {
	

	@SuppressWarnings("unchecked")
	@Test
	public void patchTest() {
		
		JSONObject req = new JSONObject();
		req.put("name", "Roger");
		req.put("job", "teacher");
		
		System.out.println(req.toJSONString());
		
		baseURI = "https://reqres.in";
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.patch("/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
		
	}

}
