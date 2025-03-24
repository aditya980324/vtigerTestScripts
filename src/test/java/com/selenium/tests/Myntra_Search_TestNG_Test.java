package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Myntra_Search_TestNG_Test {
    @Test
    public void getUrl() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://www.myntra.com/");
        driver.quit();
    }
}
