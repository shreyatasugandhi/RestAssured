package authenticationtechniques;

import java.util.HashMap;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestDummy {
	
    String tokendetails;
    String url="https://10.2.0.183:9191/v1.0/ui/applicationType";
    @BeforeSuite()
    public void beforeexecution(){
        String loginurl = "https://10.2.0.183:9191/v1.0/ui/user/authenticate";
        Map<String, Object> jsonAsMap = new HashMap<String, Object>();
        jsonAsMap.put("userName", "admin");
        jsonAsMap.put("password", "KICekGmsle4brMVtBhVgZA==");
        jsonAsMap.put("initializationVector","73b6569f3e4b3f95");

        Response response2 = given().relaxedHTTPSValidation().contentType("application/json").
                body(jsonAsMap).
                when().
                post(loginurl).then().statusCode(200).extract().response();
        tokendetails = response2.getBody().jsonPath().getString("authToken");
        System.out.println("Result-------------" +tokendetails);
    }

    @Test
    public void responcecodevalidation(){


        Response response1 = given().relaxedHTTPSValidation().header("Authorization",tokendetails).contentType("application/json").
                body("{\n" +
                        "\"name\":\"TestApi\",\n" +
                        "\"description\":\"TestApi Description\",\n" +
                        "\"status\":1,\n" +
                        "\"componentVersionIds\" : [1,2]\n" +
                        "}").
                when().
                post(url);
        int responsecode =response1.getStatusCode();
        System.out.println(responsecode);
        Assert.assertEquals(200, responsecode);

    }

}
