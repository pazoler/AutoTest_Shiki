package Autotest;

import Autotest.driver.ConfigurationReader;
import Autotest.driver.DriverFactory;
import Autotest.hibernate.entity.ConnectionTest;
import org.springframework.context.annotation.*;

//Конфигурационный файл без XML
@Configuration
@ComponentScan("Autotest")
@PropertySource("application.properties")
public class MyConfigWithoutXML {

    @Bean
    public ConfigurationReader configReader() {
        return new ConfigurationReader();
    }

    @Bean
    @Scope("prototype")
    public ConnectionTest connectionTest() {
        return new ConnectionTest();
    }

    @Bean
    @Scope("singleton")
    public DriverFactory driverFactory() {
        return new DriverFactory(configReader());
    }
}
