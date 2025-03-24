package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Vtiger_Property_File {
    public static void main(String[] args) throws IOException {
        // path of the property file
        String propertypath="C:\\Users\\satyam goswami\\OneDrive\\Documents\\vtiger_test_data.properties";
        // storing property file in java
        FileInputStream fis=new FileInputStream(propertypath);
        // loading the property file attributes
        Properties pObj=new Properties();
        pObj.load(fis);
        // creating the object of random class
        Random no=new Random();
        int ranno=no.nextInt(55);
        // fetching the data from the property file one by one
        String browser=pObj.getProperty("browser");
        String url=pObj.getProperty("url");
        String username=pObj.getProperty("username");
        String password=pObj.getProperty("password");
        String orgname=pObj.getProperty("orgname")+ranno;
        // setting up driver for cross browser
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome"))
            driver=new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver=new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge"))
            driver=new EdgeDriver();
        else if (browser.equalsIgnoreCase("safari"))
            driver=new SafariDriver();
        else
            driver=new ChromeDriver();
        // maximize the window
        driver.manage().window().maximize();
        // setting up implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        // entering the url
        driver.get(url);
        // enter username in username txtfld
        driver.findElement(By.name("user_name")).sendKeys(username);
        // enter password in password txtfld
        driver.findElement(By.name("user_password")).sendKeys(password);
        // click on submit button
        driver.findElement(By.id("submitButton")).click();
        // click on organizations link
        driver.findElement(By.linkText("Organizations")).click();
        // click on plus icon
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
        // enter organization name
        driver.findElement(By.name("accountname")).sendKeys(orgname);
        // click on save button
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


    }
}
