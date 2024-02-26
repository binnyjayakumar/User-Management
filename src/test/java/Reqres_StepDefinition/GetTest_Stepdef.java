package Reqres_StepDefinition;

import java.io.IOException;

import Tests.GetSingleUser;
import Tests.GetSingleUserNotFound;
import Tests.GetTest;
import io.cucumber.java.en.*;



public class GetTest_Stepdef 
{
	GetTest gt = new GetTest();
	GetSingleUser gsu = new GetSingleUser();
	GetSingleUserNotFound gsunf = new GetSingleUserNotFound();

	@Given("the valid endpoint to fetch users")
	public void the_valid_endpoint_to_fetch_users()
	{
		gt.fetch_users();
	}

	@When("the request is send to server")
	public void the_request_is_send_to_server() 
	{
		gt.get_request();
	}

	@Then("validate the response of the list of users")
	public void validate_the_response_of_the_list_of_users() throws IOException
	{
		gt.response_of_the_list_of_users();
	}
	
	@Given("the valid endpoint to fetch user")
	public void the_valid_endpoint_to_fetch_user() 
	{
	   gsu.fetch_user();
	}

	@When("the request is send to get the single user")
	public void the_request_is_send_to_get_the_single_user() 
	{
	    gsu.request_single_user();
	}

	@Then("validate the response of single user by first_name as {string} email as {string} status_code as {int}")
	public void validate_the_response_of_single_user_by_first_name_email_statuscode(String first_name, String email, int status_code)
	{
	    gsu.validate_response_single_user(first_name, email, status_code);
	}
	@Given("the valid endpoint to find user")
	public void the_valid_endpoint_to_find_user() 
	{
		gsunf.find_user();
	}

	@When("the request of single user not Found is send to server")
	public void the_request_of_single_user_not_Found_is_send_to_server() 
	{
		gsunf.request_user_not_found();
	}

	@Then("validate the response by status_code as {int}")
	public void validate_the_response_by_status_code_as(int status_code)
	{
		gsunf.validate_response(status_code);
	}

}
