import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ApiSteps {
    Response response;

    @When("we send API request")
    public void weSendAPIRequest() {
        Response response = given().baseUri("https://superhero.qa-test.csssr.com/")
                .contentType("application/json")
                .when().get("superheroes")
                .then().extract().response();
        System.out.println(response.statusCode());
        System.out.println(response.asPrettyString());
        this.response = response;
    }

    @Then("api request successful")
    public void apiRequestSuccessful() {
        Assertions.assertEquals(response.statusCode(), 200);
    }

    @Then("api request {int}")
    public void apiRequestSuccessful(int statusCode) {
        Assertions.assertEquals(response.statusCode(), statusCode);
    }
}
