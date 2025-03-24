package com.vtiger.datautility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class VtigerPropertyUtility {
    private static final String property_path = "./src/main/resources/vtiger_common_data/vtiger_test_data.properties";
    public String getVtigerPropData (String key) throws IOException {
        String data="";
        try (FileInputStream fis = new FileInputStream(property_path)) {
            Properties pObj = new Properties();
            pObj.load(fis);
            data=pObj.getProperty(key);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
}
