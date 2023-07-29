package Autotest.stepDefinitions.base;

import Autotest.utils.GlobalVariables;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

public class APIHooks {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    @Before("@API")
    public static void setup() {
        //уточнить, как пройти ssl верификацию на фиддлере
        //RestAssured.proxy("localhost", 8080);

        requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(GlobalVariables.SHIKI_SITE_HOME_PAGE_URL)
                        .setBasePath(GlobalVariables.SHIKI_SITE_API_PATH)
                        .addHeader("Context-Type", "application/json")
                        .addHeader("Accept", "application/json")
                        //       .addHeader("X-Auth-Token", "abc")
                        .addHeader("X-Response-Control", "minified")
                        .addFilter(new RequestLoggingFilter())
                        .addFilter(new ResponseLoggingFilter())
                        .build();
        RestAssured.requestSpecification = requestSpecification;

        responseSpecification = new ResponseSpecBuilder()
                //.expectStatusCode(200)
                //.expectResponseTime(lessThan(300L))
                .build();

        RestAssured.responseSpecification = responseSpecification;
    }
}
