package configure;

import Autotest.MyConfigWithoutXML;
import Autotest.driver.ConfigurationReader;
import Autotest.driver.DriverFactory;
import Autotest.hibernate.entity.ConnectionTest;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestWithoutXML {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfigWithoutXML.class);

//        ConnectionTest connectionTest = context.getBean("test",
//                ConnectionTest.class);
//
//        System.out.println(connectionTest);

        ConfigurationReader reader = context.getBean("configReader",
                ConfigurationReader.class);
        DriverFactory driverFactory = context.getBean("driverFactory",
                DriverFactory.class);
        System.out.println(reader.getBrowserType());

        WebDriver driver = DriverFactory.getDriver();
        context.close();
    }
}
