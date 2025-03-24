package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Screenshot {
    public static void main(String[] args) {
        // WebDriverManager handles driver setup automatically
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a webpage
        driver.get("https://www.google.com");

        // Take screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define destination file
        File destFile = new File("screenshot.png");

        // Copy the file to the desired location
        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved successfully!");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}

