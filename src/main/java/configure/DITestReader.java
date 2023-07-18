package configure;

import Autotest.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITestReader {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        ConfigurationReader reader = context.getBean("browserType",
//                ConfigurationReader.class);
//
//        System.out.println(reader.getBrowserType());
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml");

        WebDriver driver = DriverFactory.getDriver();
        System.out.println();
//        ConfigurationReader reader = context.getBean("configReader",
//                ConfigurationReader.class);
//
//        System.out.println(reader.getBrowserType());
    }
}
