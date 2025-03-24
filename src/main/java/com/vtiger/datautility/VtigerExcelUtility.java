package com.vtiger.datautility;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;

public class VtigerExcelUtility {
    private static final String XL_PATH = "./src/test/resources/vtiger_testdata_xlsx/V_Tiger Test Data.xlsx";

    public String getVtigerXlData(String sheetname, int rownum, int cellnum) {
        String data = "";
        try (FileInputStream fis = new FileInputStream(XL_PATH);
             Workbook wb = WorkbookFactory.create(fis)) {

            data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Invalid sheet/row/cell reference: " + e.getMessage());
        }
        return data;
    }
}
