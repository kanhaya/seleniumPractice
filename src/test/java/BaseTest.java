import com.driver.Browser;
import com.driver.DriverManager;
import com.driver.Url;
import com.pagefactory.PageFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.driver.Url.BASE_URL;

public class BaseTest {
    protected WebDriver driver;
    protected PageFactory pageFactory;
    protected Properties properties;
    protected InputStream inputStream;

    // UI mode
    @BeforeSuite
    @Parameters("browser")
    public void browserSetup(Browser browser) throws IOException {
        try {
            System.out.println(System.getProperty("env"));
            properties=new Properties();
            inputStream  =this.getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
            Url.BASE_URL.setValue(properties.getProperty("baseUrl"));
            System.out.println(BASE_URL.getValue());
            driver= DriverManager.getInstance(browser).getDriver();
            this.pageFactory=new PageFactory(driver);
            driver.get(Url.BASE_URL.getValue());
            driver.manage().window().maximize();
            inputStream.close();
        }catch (Exception e){
            inputStream.close();
            e.printStackTrace();

        }


    }

    @AfterSuite
    public void tearDown(){
        DriverManager.quitDriver();
    }

    //HeadLess mode
//    @BeforeSuite
//    public void headLessBrowser(){
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options= new ChromeOptions();
//        options.addArguments("--headless");
//        driver=new ChromeDriver(options);
//        driver.get("https://www.saucedemo.com/");
//        pageFactory=new PageFactory(driver);
//    }
}
