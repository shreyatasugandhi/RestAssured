package mocking;

//
//import java.util.HashMap;
//import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class PostTest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void mockedPostTest() {
		
	
		JSONObject req = new JSONObject();
		req.put("name", "Roger");
		req.put("job", "Tester");
		
		System.out.println(req.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(req.toJSONString())
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
		
	}

}
