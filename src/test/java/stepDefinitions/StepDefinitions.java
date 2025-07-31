package stepDefinitions;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinitions extends Utils{

    RequestSpecification Request;
    Response Response;
    TestDataBuild testDataBuild = new TestDataBuild();
    static String place_id;

    @Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String name, String language, String address ) throws IOException {

        Request = given().spec(requestSpecification())
        .body(testDataBuild.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_post_http_request(String resource, String method) {

        // Converts string 'resource' to enum constant of APIResources type
        APIResources apiResources = APIResources.valueOf(resource); 
        if(method.equalsIgnoreCase("POST"))
        Response= Request.when().post(apiResources.getResource())
        .then().spec(responseSpecification()).extract().response();
        else if(method.equalsIgnoreCase("GET"))
        Response= Request.when().get(apiResources.getResource())
        .then().spec(responseSpecification()).extract().response();
    }

    @Then("the API call is success with status code 200")
    public void the_api_call_is_success_with_status_code() {

        assertEquals(Response.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String expectedKey, String expectedvalue) {

        assertEquals(getJsonPath(Response,expectedKey), expectedvalue);
    }

    @Then("verify place_id created to {string} using {string}")
    public void verify_place_id_created_to_using(String expectedName, String resource) throws IOException {

    place_id = getJsonPath(Response, "place_id");
    Request = given().spec(requestSpecification()).queryParam("place_id", place_id);
    user_calls_with_post_http_request(resource, "GET");
    String actualName = getJsonPath(Response, "name");

    assertEquals(actualName, expectedName);

    System.out.println(actualName);

    }

    @Given("DeletePlace Payload")
    public void delete_place_payload() throws IOException {

       Request = given().spec(requestSpecification()).body(testDataBuild.deletePlacePayload(place_id));
    }


}
