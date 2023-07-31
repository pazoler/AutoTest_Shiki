package Autotest.stepDefinitions.base;

import Autotest.MyConfigWithoutXML;
import Autotest.hibernate.entity.AnimesTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static Autotest.driver.DriverFactory.getDriver;

public class DBHooks {
    public static SessionFactory factory;

    @Before("@DB")
    public void setup() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AnimesTable.class)
                .buildSessionFactory();
    }

    @After("@DB")
    public void tearDown() {
        factory.close();
    }
}
