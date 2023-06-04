package requeststype;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDDTestFormat {
	
	@Test
	public void GetTest2 () {
		
		baseURI = "https://reqres.in";
		given()
			.header("key", "value")
			.param("key", "value")
			.body("{ \"key\": value}")
		.when()
			.get("/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data[1].id", equalTo(8))
			.body("data[5].first_name", equalTo("Rachel"))
			.body("data.first_name", hasItems("Michael", "George"))
			.log().all();
		
	}

}
