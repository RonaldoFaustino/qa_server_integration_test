package com.sitture.definitions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.sitture.utils.RestInstance;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PesquisarPessoas {

	private static final String BASE_PATH = "/pessoas";
	private static final String INCORRECT_BASE_PATH = "/usuario";

	@Given("^The endpoint is already configured$")
	public void the_endpoint_is_already_configured() {
		RestInstance.request().contentType(ContentType.JSON);
	}

	@When("^I set baseURI$")
	public void i_set_base_uri() {
		RestAssured.baseURI = "http://localhost:8080";
	}

	@When("^I input a valid userId \"([^\"]*)\" and phone \"([^\"]*)\"$")
	public void i_input_a_valid_userId(String ddd, String phone) {
		RestInstance.response = RestInstance.request().basePath(BASE_PATH).when().get("/" + ddd + "/" + phone);
		RestInstance.response.then().log().all();
	}

	@When("^I input a invalid userId \"([^\"]*)\" and phone \"([^\"]*)\"$")
	public void i_input_a_invalid_userId(String ddd, String phone) {
		RestInstance.response = RestInstance.request().basePath(BASE_PATH).when().get("/" + ddd + "/" + phone);
		RestInstance.response.then().log().all();
	}

	@When("^I input a invalid userId \"([^\"]*)\" and phone \"([^\"]*)\" and invalid basePath$")
	public void i_input_a_invalid_user_and_invalid_basePath(String ddd, String phone) {
		RestInstance.response = RestInstance.request().basePath(INCORRECT_BASE_PATH).when()
				.get("/" + ddd + "/" + phone);
		RestInstance.response.then().log().all();
	}

	@Then("^I should have the status code \"([^\"]*)\"$")
	public void i_should_have_the_status_code(String statusCode) {
		RestInstance.response.then().statusCode(Integer.parseInt(statusCode));
	}

	@Then("^content type should be in \"([^\"]*)\"$")
	public void content_type_should_be_in_format(String format) {

		if (format.equals("JSON")) {
			RestInstance.response.then().assertThat().contentType(ContentType.JSON).and()
					.body(matchesJsonSchemaInClasspath("user-schema.json"));
		}

	}

	@Then("^the body response content should be matched$")
	public void the_body_response_content_should_be_matched(DataTable table) {
		List<List<String>> data = table.raw();
		for (int i = 2; i < data.size(); i++) {
			RestInstance.response.then().assertThat().body(data.get(i).get(0), equalTo(data.get(i).get(1)));
		}

	}

}
