package org.myntra.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Myntra_Register_Test {
    public static void main(String[] args) {
        // initialize driver instance
        WebDriver driver = new ChromeDriver();
        // object of action class
        Actions action = new Actions(driver);
        // declaring implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        // maximizing the window
        driver.manage().window().maximize();
        // open the web application
        driver.get("https://www.myntra.com/");
        // identifying the profile icon
        WebElement profileicon=driver.findElement(By.xpath(" //span[text()='Profile']"));
        // moving the cursor to the profile icon
        action.moveToElement(profileicon).perform();
        // identifying signup button in profile drpdwn
        WebElement signupbtn= driver.findElement(By.xpath("//a[text()='login / Signup']"));
        // moving the cursor to the signup / login button and click it
        action.moveToElement(signupbtn).click().build().perform();
        // enter a mobile number in textfield
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("5555555555");
        // click on continue button
        driver.findElement(By.className("submitBottomOption")).click();

    }
}
