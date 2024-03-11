package tests.junit;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestClassStructured {
WebDriver driver;
    @Test
    public void checkPageTitle() {
        var title = driver.getTitle();
        Assertions.assertEquals("Electronics, Cars, Fashion, Collectibles & More | eBay", title);

        // initial navigation


        // test steps

    }

        @Test
                public void checkPageUrl(){
            var currentUrl = driver.getCurrentUrl();
            Assertions.assertEquals("https://www.ebay.com/", currentUrl);

        }
        @Test
        public void webFromManipulation(){
            driver.get("https://www.selenium.dev/selenium/web/web-form.html");

            // writing text
            By textInput = By.id("my-text-id");
            driver.findElement(textInput).sendKeys("Selenium is Great!");

            // reading text
            By pageHeader = By.tagName("h1");
            var textValue = driver.findElement(pageHeader).getText();
            Assertions.assertEquals("Web form", textValue);

    }

@BeforeEach
        public void beforeEach() {
             driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
            driver.get("https://www.ebay.com/");
        }
        @AfterEach
                public void afterEach(){
        //terminating the session
        driver.quit();
    }
}