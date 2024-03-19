package tests.testng.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class Assignment5 extends Tests {


    @Test
    public void testToDoApp() {
        bot.navigate("http://crossbrowsertesting.github.io/");
        By toDoLinkLocator = By.xpath("//a[@href='todo-app.html']");
        bot.click(toDoLinkLocator);
        By todo4Checkbox = By.name("todo-4");
        bot.click(todo4Checkbox);
        By todo5Checkbox = By.name("todo-5");
        bot.click(todo5Checkbox);

        By todoList = By.className("done-true");
        Assert.assertEquals(driver.findElements(todoList).size(),2);


        By textInputLocator = By.id("todotext");
        By addButtonLocator = By.id("addbutton");
        bot.type(textInputLocator,"we added is present in the list");
        bot.click(addButtonLocator);
        By checkText = By.xpath("//span[text()='we added is present in the list']");
        Assert.assertTrue(driver.findElement(checkText).isDisplayed());
        By archiveButtonLocator = By.tagName("a");
        bot.click(archiveButtonLocator);


        By doneFalseListLocator = By.className("done-false");
        Assert.assertEquals(driver.findElements(doneFalseListLocator).size(),4);


    }
}
