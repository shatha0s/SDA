package tests.junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Alert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;

//Go to URL: http://demo.automationtesting.in/Alerts.html
//Click "Alert with OK" and click 'click the button to display an alert box:’
//Accept Alert(I am an alert box!) and print alert on console.
//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
//Cancel Alert (Press a Button !)
//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
//And then sendKeys «Bootcamp» (Please enter your name)
//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

public class AlertTask extends TestBase{

    @Test
    public void alertTest() {
        driver.get("https://demo.automationtesting.in/Alerts.html");

        // Click "Alert with OK" button
        WebElement alertWithOKButton = driver.findElement(By.cssSelector("button[onclick='alertbox()']"));
        alertWithOKButton.click();

        // Accept Alert and print alert message
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assertions.assertEquals("I am an alert box!",  alertText);

//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
        By alertWithOkAndCancelLink = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(alertWithOkAndCancelLink).click();
        By alertWithOkAndCancelButton = By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(alertWithOkAndCancelButton).click();

        //Cancel Alert (Press a Button !)
      alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
       By message = By.xpath("//p[@id='demo']");
       String actualMessage = driver.findElement(message).getText();
       System.out.println(actualMessage);

        //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box
        By alertWithTextBoxLink = By.xpath("//a[@href='#Textbox']");
        driver.findElement(alertWithTextBoxLink).click();
        By alertWithTextBoxButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(alertWithTextBoxButton).click();
        alert.sendKeys("Shatha Aziz ");
        alert.accept();

        //Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
        By message1 = By.xpath("//p[@id='demo1']");
        String actualMessage1 = driver.findElement(message1).getText();
        System.out.println(actualMessage1);
        Assertions.assertEquals("Hello Shatha Aziz How are you today",actualMessage1);
    }
    }










