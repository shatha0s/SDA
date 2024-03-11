package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;



public class Assignment1 {
    WebDriver driver = new ChromeDriver();
    @Test
    public void DoubleClick(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://api.jquery.com/dblclick/");

        // the blue square its inside iframe
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);

        //Double click on the blue square at the bottom of the page and then write the changed color.
        WebElement blueSquare = driver.findElement(By.cssSelector("div"));
        String colorBeforeDoubleClick = blueSquare.getCssValue("background-color");

        Actions actions = new Actions(driver);
        actions.doubleClick(blueSquare).perform();

        String colorAfterDoubleClick = blueSquare.getCssValue("background-color");
        Assertions.assertNotEquals(colorBeforeDoubleClick, colorAfterDoubleClick, "Color did not change after double click");

        System.out.println("Color before double click: " + colorBeforeDoubleClick);
        System.out.println("Color after double click: " + colorAfterDoubleClick);

    }
@Test
        public void javaScript(){
    driver.get("https://api.jquery.com/dblclick/");
    //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, 0)");
        WebElement textBox = driver.findElement(By.tagName("input"));
        textBox.sendKeys("Thanks to JavascriptExecutor");

//Go to the bottom of the page and click the book, name"jQuery in Action"
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    WebElement element = driver.findElement(By.cssSelector("a[href*='https://www.manning.com/books/jquery-in-action-third-edition']"));
    element.click();
}
    }



