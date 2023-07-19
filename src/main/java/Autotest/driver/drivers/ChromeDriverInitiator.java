package Autotest.driver.drivers;

import Autotest.driver.DriverFactory;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

public class ChromeDriverInitiator  {

    static WebDriver driver = null;

    public static WebDriver setChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}

//Установка кук вручную для обхода капчи
//    // Создаем cookie
//    private static final Cookie COOKIE = new Cookie("имя", "содержимое", "домен", "путь", new Date("дата"));
//    // Создаем браузер
//    WebDriver driver = new ChromeDriver(options);
//// Добавляем cookie в браузер
//driver.manage().addCookie(COOKIE);