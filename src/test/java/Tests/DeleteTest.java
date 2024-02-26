package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteTest 
{
	Response response;
	public void delete_user()
	{
		baseURI = "http://localhost:3000";
	}
	public void request_delete(String url, String Query)
	{
		response = given()
				.when()
				.delete(url+Query);
	}
	public void getRequest(String url,String Query)
	{ 
		response = 
				given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.get(url+Query)
				.then()
				.extract().response();
	}
	public void validate_delete_response(int status_code)
	{
		getRequest("/users/","721a");
		System.out.println("Get Response: " +response.asString());

		Assert.assertEquals(status_code, response.getStatusCode());
	}
}
