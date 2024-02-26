package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.response.Response;

public class GetSingleUserNotFound 
{
	Response response;
	public void find_user()
	{
		baseURI = "https://reqres.in/";
	}
	public void request_user_not_found()
	{
		response = given()
				.when()
				.get("api/users/23");
	}
	public void validate_response(int status_code)
	{
		Assert.assertEquals(status_code, response.getStatusCode());
	}
}
