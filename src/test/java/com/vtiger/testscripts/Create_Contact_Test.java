package com.vtiger.testscripts;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

public class Create_Contact_Test {
    public static void main(String[] args) throws IOException {

        // Storing the path of property file
        String propertypath = "C:\\Users\\satyam goswami\\OneDrive\\Documents\\vtiger_test_data.properties";
        FileInputStream cd = new FileInputStream(propertypath);
        Properties pObj = new Properties();
        pObj.load(cd);

        // Storing data from properties file
        String browser = pObj.getProperty("browser");
        String url = pObj.getProperty("url");
        String username = pObj.getProperty("username");
        String password = pObj.getProperty("password");

        // Disable notifications
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            driver = new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }

        // Implicit wait declaration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        driver.get(url);

        // Verifying the Url
        if (driver.getTitle().contains("vtiger"))
            System.out.println("Vtiger HomePage is Displayed");

        // Login
        driver.findElement(By.name("user_name")).sendKeys(username);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.id("submitButton ")).click();

        // Verifying the Login
        String homelogo= driver.findElement(By.xpath("//a[contains(text(),'Home' )]")).getText();
        if (homelogo.contains("home"))
            System.out.println("Login Successful");

        // Navigate to Contacts
        driver.findElement(By.linkText("Contacts")).click();

        // Verifying Contacts Page
        String orglogo=driver.findElement(By.xpath("//a[text()='Contacts' and @class='hdrLink']")).getText();
        if (orglogo.contains("Contacts"))
            System.out.println("Contacts Page is Displayed");

        // Navigate to Create New Contacts Page
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

        // Verifying Create New Contacts Page
        String neworglogo=driver.findElement(By.xpath("//span[text()='Creating New Contact' ]")).getText();
        if (neworglogo.contains("Creating New Contact"))
            System.out.println("Create New Contact Page is Displayed");

        // Generate random number
        Random random = new Random();
        int randomInt = random.nextInt(555);

        // Read orgname from Excel
        String xlspath = "C:\\Users\\satyam goswami\\Downloads\\V_Tiger Test Data.xlsx";
        FileInputStream td = new FileInputStream(xlspath);
        Workbook wb = WorkbookFactory.create(td);
        Sheet sh = wb.getSheet("Sheet1");

        // Check if the sheet exists
        if (sh == null) {
            System.out.println("Error: Sheet 'Sheet1' not found in the Excel file.");
            driver.quit();
            return;
        }

        Row row = sh.getRow(3);

        // Check if the row exists
        if (row == null) {
            System.out.println("Error: Row 2 is empty or does not exist.");
            driver.quit();
            return;
        }

        Cell cell = row.getCell(2);

        // Check if the cell exists
        if (cell == null) {
            System.out.println("Error: Cell(2) is empty or does not exist.");
            driver.quit();
            return;
        }

        // Creating random lastname
        String lastname = cell.toString() + randomInt;
        System.out.println("Generated Organization Name: " + lastname);

        // Entering lastname in lastname txtfld
        driver.findElement(By.name("lastname")).sendKeys(lastname);

        // Click on save button
        driver.findElement(By.xpath("//input[@accesskey='S']")).click();

        // Verifying the Contact Creation
        String headertxt=driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]")).getText();
        if (headertxt.contains(lastname))
            System.out.println("Contact Created Successfully");
        else
            System.out.println("Contact Creation Failed");

        // Logout process
        WebElement profileicon = driver.findElement(RelativeLocator.with(By.tagName("img"))
                .toRightOf(By.xpath("//span[text()='Admin123@ Administrator1']")));
        Actions action = new Actions(driver);
        action.moveToElement(profileicon).perform();

        WebElement signoutoption = driver.findElement(By.linkText("Sign Out"));
        action.moveToElement(signoutoption).click().perform();

        // Verifying Logout
        if (driver.getTitle().contains("vtiger"))
            System.out.println("Sign Out Successfully");

        // Close browser
        driver.quit();
    }
}
