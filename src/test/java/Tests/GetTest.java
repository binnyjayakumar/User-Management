package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;

import io.restassured.response.Response;

public class GetTest 
{
	static Response response;

	public void fetch_users()
	{
		baseURI = "https://reqres.in/";
	}

	public void get_request() 
	{
		response = given()
				.when()
				.get("/api/users?page=2");
	}

	public void response_of_the_list_of_users() throws IOException
	{

		File file = new File("/Users/binnyjayakumaremily/eclipse-workspace1/RestAssuredBDD/src/test/resources/schema/Schema.json");
		if (file.exists())
		{
			System.out.println("  > > File exists");
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

		Assert.assertEquals(response.getBody().asPrettyString(), requestBody);

		Assert.assertEquals(response.getStatusCode(), 200);	

		//		MatcherAssert.assertThat("Validate json schema", 
		//				response.getBody().asString(),
		//				JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"));	
	}

}
