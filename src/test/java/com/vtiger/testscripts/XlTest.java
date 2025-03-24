package com.vtiger.testscripts;

import com.vtiger.datautility.VtigerExcelUtility;

import java.io.IOException;

public class XlTest {
    public static void main(String[] args) throws IOException {
        VtigerExcelUtility veu = new VtigerExcelUtility();
        String data = veu.getVtigerXlData("Sheet1",1,2);
        System.out.println(data);
    }
}
