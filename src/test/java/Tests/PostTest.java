package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostTest 
{
	JSONObject request;
	Response response;

	public void create_user()
	{
		baseURI = "http://localhost:3000";

		request = new JSONObject();
		request.put("firstName", "Shanni");
		request.put("lastName", "Rose");
		request.put("studentId", 4);
	}
	public void postRequest(String url, String query)
	{
		response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.body(request.toJSONString())
				.when()
				.post(url+query)
				.then().contentType(ContentType.JSON)
				.extract().response();
		System.out.println(response.jsonPath().getString("firstName"));
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
	public void validate_new_user(String firstName, int status_code) throws IOException
	{
		//		String key = "id";
		//		String complete = response.asString();
		//	    JsonPath js = new JsonPath(complete);
		//	    String id = js.get(key).toString();
		Assert.assertEquals(response.getStatusCode(), status_code);
		String id =response.jsonPath().getString("id");
		System.out.println(response.jsonPath().getString("id"));

		getRequest("/users/",id);
		System.out.println("Get Response" +response.asString());

		Assert.assertEquals(response.getStatusCode(), 200);

		Assert.assertEquals(firstName, response.jsonPath().getString("firstName"));		
	}
}
