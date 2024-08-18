package com.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import static com.driver.Browser.*;

public class BrowserFactory {

    public static WebDriver createWebDriverInstance(Browser browser){
        WebDriver driver=null;
        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver=new SafariDriver();
                break;
            default:
                System.out.println("No driver found");
        }
        return driver;
    }

}
