package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadMultipleRowData {

    public static String[][] getData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\satyam goswami\\Downloads\\V_Tiger Test Data.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");

        int rowNum = sh.getLastRowNum();
        int colNum = sh.getRow(0).getLastCellNum();

        String[][] str = new String[rowNum + 1][colNum];

        for (int i = 0; i <= rowNum; i++) {
            Row row = sh.getRow(i);
            if (row != null) {
                int cellNum = row.getLastCellNum();
                for (int j = 0; j < cellNum; j++) {
                    if (row.getCell(j) != null) {
                        String data = row.getCell(j).getStringCellValue();
                        str[i][j] = data;
                    }
                }
            }
        }
        fis.close();
        return str;
    }

    public static void main(String[] args) throws IOException {
        String[][] str = getData();

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                System.out.print(str[i][j] + " ");
            }
            System.out.println();
        }
    }
}
