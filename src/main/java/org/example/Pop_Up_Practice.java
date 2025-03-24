package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Pop_Up_Practice {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.easemytrip.com/");
        //driver.switchTo().alert().dismiss();
        //Thread.sleep(1000);

    }
}
