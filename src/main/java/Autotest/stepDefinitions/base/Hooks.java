package Autotest.stepDefinitions.base;

import Autotest.MyConfigWithoutXML;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;

import static Autotest.driver.DriverFactory.cleanupDriver;
import static Autotest.driver.DriverFactory.getDriver;

//Fixture class
public class Hooks {
    AnnotationConfigApplicationContext context;
    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext(MyConfigWithoutXML.class);
        getDriver();
    }

    @AfterStep
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
        context.close();
    }
}
