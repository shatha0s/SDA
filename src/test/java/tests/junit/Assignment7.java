package tests.junit;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;

// Go to amazon.com
// Take Full Page Screenshot.
// Take any spesific WebElement ScreenShot

public class Assignment7  extends TestBase{
    @Test
            public void screenShot() throws IOException {
        driver.get("https://www.amazon.com/");
        // Take a full-page screenshot
        TakesScreenshot SS = (TakesScreenshot) driver;
        File Amazonpagefile = SS.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(Amazonpagefile, new File("target/sreenshot1" + System.currentTimeMillis() + ".png"));

       // Take any spesific WebElement ScreenShot
        WebElement AsosWebsite = driver.findElement(By.id("nav-logo"));
        File AmazonLOGOSS = AsosWebsite.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(AmazonLOGOSS, new File("target/sreenshot2"+System.currentTimeMillis()+".png"));
}}


