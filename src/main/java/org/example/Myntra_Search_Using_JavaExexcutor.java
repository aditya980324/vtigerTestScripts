package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Myntra_Search_Using_JavaExexcutor {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.navigate().to("https://www.myntra.com/");
        //js.executeScript("document.getElementByTagName('input').value='jeans';");

    }
}
