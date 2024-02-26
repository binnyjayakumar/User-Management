package Tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchTest 
{
	JSONObject request;
	Response response;
	public void update_user_patch()
	{
		baseURI="http://localhost:3000/";
	
		request = new JSONObject();
		request.put("lastName", "Joe");
	}
	public void patch_request(String url, String Query)
	{
		response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
	    .body(request.toJSONString())
	    .when()
	    .patch(url+Query);
	}
	public void getRequest(String url,String Query)
	{ 
		response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.body(request.toJSONString())
				.when()
				.get(url+Query)
				.then()
				.extract().response();
	}
	public void validate_patch_response(String lastName, int status_code)
	{
Assert.assertEquals(status_code, response.getStatusCode());
		
		String id =response.jsonPath().getString("id");
		System.out.println(response.jsonPath().getString("id"));
		getRequest("/users/",id);
		System.out.println("Get Response" +response.asString());
		
		Assert.assertEquals(lastName, response.jsonPath().getString("lastName"));	
	}
}
