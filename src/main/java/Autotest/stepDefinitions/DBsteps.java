package Autotest.stepDefinitions;

import Autotest.POJOclasses.AnimeIdClass;
import Autotest.hibernate.entity.AnimesTable;
import Autotest.hibernate.entity.ConnectionTest;
import Autotest.stepDefinitions.base.DBHooks;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static Autotest.stepDefinitions.base.DBHooks.factory;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.requestSpecification;
import static java.lang.Float.parseFloat;

public class DBsteps {

    AnimeIdClass anime;

    @Then("Put fields of this object into DB")
    public void putFieldsIntoDB()
        {
            try {
                Session session = factory.getCurrentSession();
                AnimesTable animeToDB = new AnimesTable
                        (anime.name, anime.episodes, anime.russian, parseFloat(anime.score));
                //открытие транзакции отправка и закрытие сессии
                session.beginTransaction();
                session.save(animeToDB);
                session.getTransaction().commit();
            }
        catch (HibernateException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    @And("Transform JSON to Object")
    public void transformJSONToObject() throws JsonProcessingException {

        System.out.println("Success!");
        String responseBody = APISteps.response.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        anime = objectMapper.readValue(responseBody, AnimeIdClass.class);
        System.out.println(anime);
    }
}
