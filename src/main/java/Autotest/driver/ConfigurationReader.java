package Autotest.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("configReader")
public class ConfigurationReader {

    @Value("${browser}")
    public String browserType;

    public String getBrowserType() {
        return browserType;
    }


    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    public ConfigurationReader() {
        System.out.println("Config obj have been created");;
    }
}
