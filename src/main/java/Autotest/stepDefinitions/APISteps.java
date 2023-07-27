package Autotest.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APISteps {

    private static Response response;

    @Given("Check for API work by List of Manga")
    public void getMangaList() {
        response = given()
                .queryParam("limit", "50")
                .queryParam("order", "ranked")
                .get("manga")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    @Then("Should be presented with manga")
    public void shouldBePresentedWithManga() {
       String name = response
                .path("name.find { it.id == 2 }");
        System.out.println(name);
    }


}
