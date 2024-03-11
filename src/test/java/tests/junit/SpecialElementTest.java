package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SpecialElementTest {
    WebDriver driver;

    @Test
    public void checkBox(){
        By checkbox= By.id("my-check-2");
        driver.findElement(checkbox).click();
        boolean isChecked=driver.findElement(checkbox).isSelected();
        Assertions.assertTrue(isChecked);
    }

    @Test
    public void radioButton(){
        By radioButton = By.id("my-radio-2");
        driver.findElement(radioButton).click();
        boolean isSelected = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isSelected);
    }

    @Test
public void DropDownSelect(){
        By selectEl=By.name("my-select");
        Select Select = new Select(driver.findElement(selectEl));
        Select.selectByValue("1");
        String actualText=Select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("One",actualText);
    }
    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver=new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
