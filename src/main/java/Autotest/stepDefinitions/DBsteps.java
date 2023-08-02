package Autotest.stepDefinitions;

import Autotest.POJOclasses.AnimeIdClass;
import Autotest.hibernate.entity.AnimesTable;
import Autotest.hibernate.entity.BaseDBClass;
import Autotest.hibernate.entity.DBInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.get;
import static java.lang.Float.parseFloat;
import static org.hamcrest.Matchers.equalTo;

public class DBsteps {

    AnimeIdClass anime;
    AnimesTable animeTable;
    List<DBInterface> animeTables;

    @Then("Put fields of this object into DB")
    public void putFieldsIntoDB(){
    AnimesTable animeToDB = new AnimesTable
            (anime.name, anime.episodes, anime.russian, parseFloat(anime.score));
        Assert.assertTrue(BaseDBClass.putIntoDB(animeToDB));

}

    @And("Transform JSON to Object")
    public void transformJSONToObject() throws JsonProcessingException {

        System.out.println("Success!");
        String responseBody = APISteps.response.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        anime = objectMapper.readValue(responseBody, AnimeIdClass.class);
        System.out.println(anime);
    }

    @When("I looking for Anime with name {} in DB")
    public void iLookingForAnimeWithIdInDB(String name) {
        animeTable = (AnimesTable) BaseDBClass.getFromDB("Autotest.hibernate.entity.AnimesTable", Integer.parseInt(name));
        System.out.println("JOPA " + animeTable);
    }

//    @When("I looking for Anime with field {} and value {} in DB")
//    public void iLookingForAnimeWithNameInDB(String field, String value) {
//        animeTables = BaseDBClass.getFromDB("AnimesTable", field, value);
//        System.out.println("JOPA " + animeTables);
//    }
    @Then("Anime name should be equal in DB")
    public void animeNameShouldBeEqualInDB() {
        System.out.println("123");
        Assert.assertEquals(animeTable.getAnimeName(), APISteps.response.jsonPath().getString("name"));

    }
}
