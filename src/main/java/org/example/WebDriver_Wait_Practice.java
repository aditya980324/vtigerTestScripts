package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriver_Wait_Practice {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(12));

    }
}
