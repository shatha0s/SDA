package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends TestBase{
    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */

    @Test
    public void Upload(){
        driver.get("https://the-internet.herokuapp.com/upload");
        String url = "https://the-internet.herokuapp.com/upload";
        logger.info("URL navigation : " + url);

        By fileUploadInput = By.xpath("(//input[@type='file'])");
        String filepath = "C:/Users/Admin/OneDrive/الصور/smart.jpg";
        logger.info("File upload"+filepath);
        driver.findElement(fileUploadInput).sendKeys("C:/Users/Admin/OneDrive/الصور/smart.jpg");

        driver.findElement(fileUploadInput).submit();
// hi


        By uploadSuccessfullyLabel = By.tagName("h3");
        Assertions.assertEquals("File Uploaded!", driver.findElement(uploadSuccessfullyLabel).getText());
    }

}
