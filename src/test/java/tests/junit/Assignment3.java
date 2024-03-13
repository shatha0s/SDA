package tests.junit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
public class Assignment3 extends TestBase {
    WebDriver driver = new ChromeDriver();

    @Test
    public void dragDrop() throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Actions actions = new Actions(driver);

       //Drag and drop the BANK button to the Account section in DEBIT SIDE
        actions.dragAndDrop(driver.findElement(By.xpath("//a[contains(.,'BANK')]")), driver.findElement(By.id("bank"))).perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        actions.dragAndDrop(driver.findElement(By.xpath("//a[contains(text(),'SALES')]")), driver.findElement(By.id("loan"))).perform();

        //  Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        actions.dragAndDrop(driver.findElement( By.id("fourth")), driver.findElement( By.id("amt7"))).perform();
        actions.dragAndDrop(driver.findElement( By.id("fourth")), driver.findElement( By.id("amt8"))).perform();

        // Verify the visibility of the "Perfect" text
        WebElement perfectText = driver.findElement(By.xpath("(//a[contains(@class,'button-green')])[1]"));
        Assertions.assertEquals("Perfect!",perfectText.getText() );
        System.out.println("Perfect text is visible.");
    }
}
