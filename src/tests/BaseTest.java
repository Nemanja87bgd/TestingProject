package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "D:\\Documents\\Desktop\\TestProjekat\\TestProject\\lib\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
