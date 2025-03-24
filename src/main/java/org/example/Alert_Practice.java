package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert_Practice {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.name("cusid")).sendKeys("3");
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        //driver.quit();
    }
}
