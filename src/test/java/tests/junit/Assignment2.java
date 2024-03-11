package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class Assignment2 {

    @Test
    public void window() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        //Verify the text: “Opening a new window”
        WebElement textElement = driver.findElement(By.tagName("h3"));
        String text = textElement.getText();
        assert text.equals("Opening a new window") : "Text verification failed.";

        // Verify the title of the page is "The Internet"
        String title = driver.getTitle();
        assert title.equals("The Internet") : "Page title verification failed.";

        // Click on the "Click Here" button
        WebElement button = driver.findElement(By.linkText("Click Here"));
        button.click();

        // Verify the new window title is "New Window"
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String newWindowTitle = driver.getTitle();
        Assertions.assertEquals("New Window", newWindowTitle, "New window title verification failed.");

    }
}

