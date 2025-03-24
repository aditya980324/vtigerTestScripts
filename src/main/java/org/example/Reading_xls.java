package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class Reading_xls {
    public static void main(String[] args) throws IOException {
        // storing the path of excel sheet
        String path="C:\\Users\\satyam goswami\\Downloads\\Untitled spreadsheet.xlsx";
        // converting excel sheet in java
        FileInputStream xlsht=new FileInputStream(path);
        // opening the excel sheet
        Workbook wb= WorkbookFactory.create(xlsht);
        // navigating to sheet
        Sheet sh= wb.getSheet("Sheet1");
        // navigating to row
        for (int i=1;i<= sh.getLastRowNum();i++){
            Row row= sh.getRow(i);
            String data1=row.getCell(0).toString();
            String data2=row.getCell(1).toString();
            System.out.println(data1+" "+data2);
        }
        wb.close();

    }
}
