package tests.junit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public abstract class TestBase {
    protected  WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    @BeforeAll
    public static void beforeAll(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(TestBase.class.getName());
    }

    @BeforeEach
    public void beforeEach(){

        logger.info("Configuring 5 second explicit wait");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver=new ChromeDriver(chromeOptions);
        wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void afterEach(){driver.quit();
    }

}
