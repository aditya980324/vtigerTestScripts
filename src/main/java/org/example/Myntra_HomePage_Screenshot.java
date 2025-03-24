package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Myntra_HomePage_Screenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://www.myntra.com/");
        TakesScreenshot ts=(TakesScreenshot) driver;
        File srcfile=ts.getScreenshotAs(OutputType.FILE);
        File destfile=new File("./screenshots/myntra_homepage_screenshot_1.png");
        FileHandler.copy(srcfile,destfile);
//        try {
//            FileUtils.copyFile(srcfile, destfile);
//            System.out.println("Screenshot saved successfully!");
//        } catch (IOException e) {
//            System.out.println("Failed to save screenshot: " + e.getMessage());
//        }
//        WebElement srchtxtfld= driver.findElement(By.tagName("input"));
//        srchtxtfld.sendKeys("jeans for men");
//        File srcfile1=srchtxtfld.getScreenshotAs(OutputType.FILE);
//        File destfile1=new File("srchtxtfld.png");
//        try {
//            FileUtils.copyFile(srcfile1, destfile1);
//            System.out.println("Screenshot saved successfully!");
//        } catch (IOException e) {
//            System.out.println("Failed to save screenshot: " + e.getMessage());
//        }
        driver.quit();
    }
}
