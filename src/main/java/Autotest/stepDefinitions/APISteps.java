package Autotest.stepDefinitions;

import Autotest.API.BaseAPI;
import Autotest.POJOclasses.AnimeIdClass;
import Autotest.utils.GlobalVariables;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APISteps {

    public static Response response;
    public static String JSON_local;



    @Given("Site Shiki is working")
    public void siteShikiIsWorking() {
       Assert.assertTrue(BaseAPI.isHostReachable(GlobalVariables.SHIKI_SITE_HOME_PAGE_URL));
    }

    @When("Check for API work by List of Manga")
    public void getMangaList() {
        response = given()
                .queryParam("limit", "50")
                .queryParam("order", "ranked")
                .get("mangas")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    @Then("Should be presented with manga")
    public void shouldBePresentedWithManga() {
       String name = response
                .path("name.find { id == 2 }");
        System.out.println(name);
    }

    @Then("Should be presented with manga {}")
    public void shouldBePresentedWithBerserk(String animeName) {
        ArrayList<String> allTopMangaNames = response.path("name");
        System.out.println(allTopMangaNames.get(0));

        Assert.assertTrue(BaseAPI.titleSearchInArrayList(allTopMangaNames, animeName));

        }


    @When("I looking for manga with id {}")
    public void iLookingForMangaWithId(int mangaId) {
        response = given().
                pathParam("mangaId", mangaId)
                .when()
                .get(GlobalVariables.SHIKI_SINGLE_MANGA).then().extract().response();
    }


    @Then("Manga should be named {}")
    public void mangaShouldBeNamedMonster(String mangaName) {
        response.then().body("name", equalTo(mangaName));
    }



    @When("I looking for Anime with id {int}")
    public void iLookingForAnimeWithId(int animeId) {
        response = given().
                pathParam("animeId", animeId)
                .when()
                .get(GlobalVariables.SHIKI_SINGLE_ANIME).then().extract().response();

    }





}
