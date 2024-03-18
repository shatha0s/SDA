package tests.testng.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
public class DependsOn {
    private WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void testFacebook() {
        driver.navigate().to("https://www.facebook.com");
    }

    // Test for Google, depends on the Facebook test
    @Test(dependsOnMethods = "testFacebook")
    public void testGoogle() {
        driver.get("https://www.google.com");
    }

    // Test for Amazon, depends on the Google test
    @Test(dependsOnMethods = "testGoogle")
    public void testAmazon() {
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
