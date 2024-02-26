package Reqres_StepDefinition;

import java.io.IOException;

import Tests.DeleteTest;
import Tests.PatchTest;
import Tests.PostTest;
import Tests.PutTest;
import io.cucumber.java.en.*;

public class PostPutPatchDelete_Stepdef
{
	PostTest pt = new PostTest();
	PutTest puttest = new PutTest();
	PatchTest ptest = new PatchTest();
	DeleteTest dt = new DeleteTest();
	
	@Given("the valid endpoint to create user")
	public void the_valid_endpoint_to_create_user() 
	{
	   pt.create_user();
	}

	@When("the request is send to the server")
	public void the_request_is_send_to_the_server() 
	{
	   pt.postRequest("/users","");
	}

	@Then("the new user will be created with name as {string} and validate reponse {int}")
	public void the_new_user_will_be_created_with_name_as_and_validate_reponse(String firstName, int status_code) throws IOException 
	{
	   pt.validate_new_user(firstName, status_code);
	}
	
	@Given("the valid endpoint to update user")
	public void the_valid_endpoint_to_update_user()
	{
		puttest.update_user();
	}

	@When("the put request is send to the server")
	public void the_put_request_is_send_to_the_server() 
	{
		puttest.put_request("/users/", "5b60");
	}

	@Then("the user gets details validated with name as {string} and validate reponse {int}")
	public void the_user_gets_details_validated_with_name_as_and_validate_reponse(String firstName, int status_code) 
	{
		puttest.validate_put_response(firstName, status_code);
	}
	
	@Given("the valid endpoint to update user using patch service")
	public void the_valid_endpoint_to_update_user_using_patch_service() 
	{
	   ptest.update_user_patch();
	}

	@When("the patch request is send to the server")
	public void the_patch_request_is_send_to_the_server() 
	{
	    ptest.patch_request("/users/", "2d7b");
	}

	@Then("the user details gets updated and validated with name as {string} and validate reponse {int}")
	public void the_user_details_gets_updated_and_validated_with_name_as_and_validate_reponse(String lastName, int status_code) 
	{
	   ptest.validate_patch_response(lastName, status_code);
	}
	
	@Given("the valid endpoint to delete user")
	public void the_valid_endpoint_to_delete_user() 
	{
	    dt.delete_user();
	}

	@When("the request is send to the server to delete data")
	public void the_request_is_send_to_the_server_to_delete_data() 
	{
	    dt.request_delete("/users/", "7313");
	}

	@Then("the user data will be deleted and validate reponse {int}")
	public void the_user_data_will_be_deleted_and_validate_reponse(int status_code)
	{
	   dt.validate_delete_response(status_code);
	}




}
