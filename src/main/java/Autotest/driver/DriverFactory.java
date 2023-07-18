package Autotest.driver;

import Autotest.driver.drivers.ChromeDriverInitiator;
import Autotest.driver.drivers.GeckoDriverInitiator;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//@Component - XML annotation
public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    private static String browserType;

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }


    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (browserType) {
            case "chrome" -> {
                System.out.println("Chrome!");
                driver = ChromeDriverInitiator.setChromeDriver();
                System.out.println("Chrome!");
                break;
            }
            case "firefox" -> {
                driver = GeckoDriverInitiator.setGeckoDriver();
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    //@Autowired - XML annotation
    public DriverFactory(ConfigurationReader reader) {
        browserType = reader.getBrowserType();
    }

    //    private static String getBrowserType() {
//        String browserType = null;
//
//        try {
//            Properties properties = new Properties();
//            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
//            properties.load(file);
//            browserType = properties.getProperty("browser").toLowerCase().trim();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return browserType;
//    }
}
