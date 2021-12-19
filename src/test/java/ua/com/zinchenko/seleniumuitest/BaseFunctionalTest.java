package ua.com.zinchenko.seleniumuitest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseFunctionalTest {

    protected final static String MAIN_PAGE_URL = "https://protonmail.com/";
    protected final static String CORRECT_USERNAME = "artem.zinchenko";
    protected final static String CORRECT_PASSWORD = "testpassword";
    protected final static String NO_EXIST_SEARCH_QUERY = UUID.randomUUID().toString();
    protected static WebDriver driver;

    @BeforeAll
    static void initialize() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterEach
    void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
