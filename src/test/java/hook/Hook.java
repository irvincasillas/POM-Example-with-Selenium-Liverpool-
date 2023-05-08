package hook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class Hook {
    public WebDriver driver;
    public HomePage HomePage;
    public Utility util;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.liverpool.com.mx/tienda/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        HomePage = new HomePage(driver);
        util = new Utility(driver);
    }

    @After
    public void close(){
        driver.close();
    }
}

