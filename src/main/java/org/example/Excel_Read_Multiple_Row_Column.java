package org.example;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class Excel_Read_Multiple_Row_Column {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\satyam goswami\\Downloads\\VTIGER_Testcases.xlsx";
        Workbook wb = null;
        int rownum = 0;

        try (FileInputStream fis = new FileInputStream(path)) {
            wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet("VTIGER_Testcases");

            rownum = sh.getLastRowNum();  // Get the last row index

            // Finding the maximum number of columns for formatting
            int maxCols = 0;
            for (int i = 0; i <= rownum; i++) {
                Row row = sh.getRow(i);
                if (row != null && row.getLastCellNum() > maxCols) {
                    maxCols = row.getLastCellNum();
                }
            }

            // Print the top border of the table
            printBorder(maxCols);

            for (int i = 0; i <= rownum; i++) {
                Row row = sh.getRow(i);
                if (row == null) continue;  // Skip null rows

                System.out.print("|"); // Left border
                for (int j = 0; j < maxCols; j++) {
                    Cell cell = (row.getCell(j) != null) ? row.getCell(j) : null;
                    String cellData = getCellData(cell);
                    System.out.printf(" %-15s |", cellData); // Format cells with width
                }
                System.out.println(); // Move to the next line after reading a row

                // Print a row separator
                printBorder(maxCols);
            }
        } finally {
            if (wb != null) {
                wb.close();
                System.out.println("Workbook closed");
            }
            System.out.println("Total Rows: " + rownum);
        }
    }

    // Helper function to get cell data as String
    private static String getCellData(Cell cell) {
        if (cell == null) return "EMPTY";
        CellType cellType = cell.getCellType();
        if (Objects.requireNonNull(cellType) == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cellType == CellType.NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else if (cellType == CellType.BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cellType == CellType.FORMULA) {
            return cell.getCellFormula();
        }
        return "UNKNOWN";
    }

    // Helper function to print table border
    private static void printBorder(int cols) {
        System.out.print("+");
        for (int i = 0; i < cols; i++) {
            System.out.print("-----------------+");
        }
        System.out.println();
    }
}
