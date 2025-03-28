package com.vtiger.threadutility;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class UtilityClassObject {

    // Use ThreadLocal properly
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Getter for ExtentTest
    public static ExtentTest getTest() {
        return test.get();
    }

    // Setter for ExtentTest
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);   // ✅ Use .set() method
    }

    // Getter for WebDriver
    public static WebDriver getDriver() {
        return driver.get();
    }

    // Setter for WebDriver
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);   // ✅ Use .set() method
    }

    // Clean up to avoid memory leaks
    public static void unload() {
        test.remove();
        driver.remove();
    }
}
