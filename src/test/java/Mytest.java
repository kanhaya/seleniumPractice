import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Mytest {

    WebDriver driver;
    @Test(dataProvider = "loginData")
    public void mytest(String userName,String pasword) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys(pasword);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void mySecrodTest(){
        System.out.println("my second test");
    }

    @Test
    public void myThirdTest(){
        System.out.println("my third test");
    }

    public boolean isElementVisible(WebDriver driver,WebElement element){

    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
      return wait.until(ExpectedConditions.invisibilityOf(element));

    }

    @DataProvider(name="loginData")
    public Object[][] data(){
        return new Object[][]{
                { "standard_user","secret_sauce"},
                {"standard_user2","secret_sauce"},
                {"standard_user3","secret_sauce"}
        };
    }
    @AfterSuite
    public void quiteBrowsr(){
        System.out.println("Closing windows");
        driver.quit();
    }
}
