package Tests;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutTest 
{
	Response response;
	JSONObject request;
	public void update_user()
	{
		baseURI="http://localhost:3000/";

		request = new JSONObject();
		request.put("firstName", "Binu");
		request.put("lastName", "Sally");
		request.put("subjectID", 8);
	}
	public void put_request(String url, String Query)
	{
		response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put(url+Query)
		.then()
		.extract().response();
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
	public void validate_put_response(String firstName, int status_code)
	{
		Assert.assertEquals(status_code, response.getStatusCode());
		
		String id =response.jsonPath().getString("id");
		System.out.println(response.jsonPath().getString("id"));
		getRequest("/users/",id);
		System.out.println("Get Response" +response.asString());
		
		Assert.assertEquals(firstName, response.jsonPath().getString("firstName"));	
	}
}
