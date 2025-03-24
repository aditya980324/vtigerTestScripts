package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.xml.XmlTest;

public class GoogleTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openGoogle(XmlTest test) {
//        String url=System.getProperty("url");
//        driver.get(url);
//        driver.get("https://www.google.co.in/");
        String url=test.getParameter("url");
        driver.get(url);
        System.out.println("Page Title: " + driver.getTitle());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
