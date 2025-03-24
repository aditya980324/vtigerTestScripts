package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Shadow_Root_Practice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
        SearchContext shadow_host=driver.findElement(By.xpath("//form/div"));
        shadow_host.findElement(By.cssSelector("input[type='text']")).sendKeys("aditya");
    }
}
