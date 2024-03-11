package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class  AlertTest extends TestBase{

    @Test
    public void Alert(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        By JsConfirm = By.cssSelector("button[onclick='jsConfirm()'");
        driver.findElement(JsConfirm ).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        By result= By.id("result");
        String ResultText= driver.findElement(result).getText();
        Assertions.assertEquals("You clicked: Ok",ResultText);
    }

    @Test
    public void iFrame(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var headerText = driver.findElement(By.tagName("h1")).getText();
        driver.switchTo().defaultContent();
        Assertions.assertEquals("Testing Clicks",headerText);
    }

}
