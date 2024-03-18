package tests.testng.Assignments;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testng.Tests;

public class Assignment4  extends Tests {
    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
    @Test(dataProvider = "searchQuery")
    public void searchProduct(String searchQuery) {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        By emailField = By.id("input-email");
       By passwordField = By.id("input-password");
        By loginButton = By.cssSelector("input[type='submit']");

        JSONObject testCaseData = (JSONObject) testData.get("Assignment4Data");
        bot.type(emailField, (String) testCaseData.get("input-email"));
        bot.type(passwordField, (String) testCaseData.get("input-password"));
        bot.click(loginButton);

       //Using the Search function do it with Data Provider for Mac, iPad and Samsung.
        By searchField = By.name("search");
        By searchButton = By.cssSelector("button[class='btn btn-default btn-lg']");
        bot.type(searchField, searchQuery);
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButtonElement.click();
    }
    @DataProvider(name = "searchQuery")
    public Object[][] searchQuery() {
        return new Object[][] {
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
