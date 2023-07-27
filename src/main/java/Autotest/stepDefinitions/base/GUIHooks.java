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
public class GUIHooks {
    AnnotationConfigApplicationContext context;
    @Before("GUI")
    public void setup() {
        context = new AnnotationConfigApplicationContext(MyConfigWithoutXML.class);
        getDriver();
    }

    @AfterStep ("GUI")
    public void captureExceptionImage(Scenario scenario) {
        if (scenario.isFailed()) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", timeMilliseconds);
        }
    }

    @After ("GUI")
    public void tearDown() {
        cleanupDriver();
        context.close();
    }
}
