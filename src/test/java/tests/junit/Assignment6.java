package tests.junit;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Store the path of the file as string and open the file.
//Open the workbook.
//Open the first worksheet.
//Go to the first row.
//Create a cell on the 3rd column (2nd index) on the first row.
//Write “POPULATION” on that cell.
//Create a cell on the 2nd row 3rd cell(index2), and write data.
//Create a cell on the 3rd row 3rd cell(index2), and write data.
//Create a cell on the 4th row 3rd cell(index2), and write data.
//Write and save the workbook.
//Close the file.
//Close the workbook.
//The 3rd column on excel file must be empty before running.
// Otherwise, new data will be written on the old data


public class Assignment6 {
    @Test
    public void ApachiPoi() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:/Users/Admin/IdeaProjects/test/src/test/resources/testData/exel homework.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet Fisrtsheet = workbook.getSheetAt(0); //Open the first worksheet.
        Row Firstrow = Fisrtsheet.getRow(0);  //Go to the first row.
        Cell row1cell3 = Firstrow.createCell(2); //Create a cell on the 3rd column (2nd index) on the first row.
        row1cell3.setCellValue("POPULATION"); //Write “POPULATION” on that cell.

        Fisrtsheet.getRow(1).createCell(2).setCellValue("A11110000"); //Create a cell on the 2nd row 3rd cell(index2), and write data.
        Fisrtsheet.getRow(2).createCell(2).setCellValue("A22220000"); //Create a cell on the 3rd row 3rd cell(index2), and write data.
        Fisrtsheet.getRow(3).createCell(2).setCellValue("A33330000"); //Create a cell on the 4th row 3rd cell(index2), and write data.

        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Admin/IdeaProjects/test/src/test/resources/testData/exel homework.xlsx");
        workbook.write(fileOutputStream); //Write and save the workbook.

        fileInputStream.close(); //Close the file. //Close the workbook.

    }
}
