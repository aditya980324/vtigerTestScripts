//package com.vtiger.threadutility;
//
//import com.aventstack.extentreports.ExtentTest;
//import org.openqa.selenium.WebDriver;
//
//public class UtilityClassObject {
//    public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
//    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//
//    public static ExtentTest getTest() {
//        return test.get();
//    }
//
//    public static void setTest(ExtentTest test) {
//        UtilityClassObject.test=test;
//    }
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void setDriver(WebDriver driver) {
//        UtilityClassObject.driver = driver;
//    }
//}
