package tests.testng.Assignments;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.testng.Tests;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class Assignment2 extends Tests {

    /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */

    @Test(dataProvider = "data-provider")
    public void addNoteTest(String noteTitle, String noteContent) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleInput = By.id("note-title-input");
        By contentInput = By.id("note-details-input");
        By addButton = By.id("add-note");
        By listLocator = By.className("note-in-list");

        bot.type(titleInput, noteTitle);
        bot.type(contentInput, noteContent);
        bot.click(addButton);

        boolean check = driver.findElement(listLocator).isDisplayed();
        System.out.println("The list notes is displayed: " + check);
        Assert.assertTrue(check);
    }

        @DataProvider(name = "data-provider")
    public Object[][] getData() throws IOException {
        Object[][] data = new Object[10][2];
//        String path ="C://Users//Admin//IdeaProjects//test//src//test//resources//testData//exel homework.xlsx";
        String path = "src/test/resources/testData/exel homework.xlsx";
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i < 10; i++) {
            data[i][0] = sheet.getRow(i).getCell(0).toString();
            data[i][1] = sheet.getRow(i).getCell(1).toString();
        }
        return data;
    }

}

