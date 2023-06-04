package requeststype;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTest {
	
	//@Test
	public void getTest() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.jsonPath().getString("data[5].first_name"), "Rachel");
		Assert.assertNotEquals(res.jsonPath().getString("data[5].first_name"), "Shreyata");
		
	}
	
	@Test
	public void BDDgetTest () {
		
		baseURI = "https://reqres.in";
		given()
			.queryParam("page", "2")
		.when()
			.get("/api/users")
		.then()
			.statusCode(200)
			.body("data[1].id", equalTo(8))
			.body("data[5].first_name", equalTo("Rachel"))
			.body("data.first_name", hasItems("Michael", "George"))
			.log().all();
		
	}

}
