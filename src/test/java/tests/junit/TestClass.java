package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//navigate to https://www.selenium.dev/selenium/web/droppableItems.html
//drag the draggable, onto the droppable
//check that the text now shows "Dropped!"

//navigate to: https://rangeslider.js.org/
//scroll to the right until you reach 700
//        assert that the number says 700

public class TestClass  extends TestBase{

    @Test
    public void Action() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

         new Actions(driver).dragAndDrop(draggable , droppable).perform();

         String textAfterDrop = droppable.getText();
        Assertions.assertEquals("Dropped!",textAfterDrop);


    }

//    @Test
//    public void scrollTask(){
//        driver.navigate().to("https://rangeslider.js.org");
//        WebElement scroll= driver.findElement(By.xpath(("//div[@class='rangeslider__handle'])"));
//
//
//    }


}







