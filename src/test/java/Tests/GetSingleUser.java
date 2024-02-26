package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.response.Response;

public class GetSingleUser 
{
	static Response response;

	public void fetch_user()
	{
		baseURI = "https://reqres.in/";
	}
	public void request_single_user()
	{
		response = given()
				.when()
				.get("api/users/2");
	}
	public void validate_response_single_user(String first_name, String email, int status_code)
	{
		String firstName = response.path("data.first_name");

		Assert.assertEquals(firstName, first_name);

		String emailId = response.path("data.email");
		Assert.assertEquals(emailId, email);

		Assert.assertEquals(status_code, response.getStatusCode());
	}

}
