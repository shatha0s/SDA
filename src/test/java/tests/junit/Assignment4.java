package tests.junit;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

//(Holding the SHIFT key type "s" and then continue to type "croll" then click
//space and again make the "m" capital and continue typing "ethods" then click enter.)
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
     public class Assignment4 extends TestBase {
      @Test
      public void Scrollmethod(){


        driver.navigate().to("https://www.google.com/");

          // search for "Scroll Methods" by using an Actions object
        new Actions(driver).scrollToElement(driver.findElement(By.id("APjFqb"))).click(driver.findElement(By.id("APjFqb")))
                .keyDown(Keys.SHIFT).sendKeys("s").keyDown(Keys.SHIFT).sendKeys("croll").keyDown(Keys.SPACE)
                .keyUp(Keys.SHIFT).sendKeys("m").keyUp(Keys.SHIFT).sendKeys("ethods").sendKeys(Keys.ENTER).perform();

    }
}
