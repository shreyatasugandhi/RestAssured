package requeststype;

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
	public void postTest() {
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Roger");
//		map.put("job", "teacher");
//		System.out.println("Before :- " + map);
		
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
			.post("/api/users")
		.then()
			.statusCode(201)
			.log().all();
		
		
	}

}
