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

public class Create_Org_Test {
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
        driver.findElement(By.id("submitButton")).click();

        // Verifying the Login
        String homelogo= driver.findElement(By.xpath("//a[contains(text(),'Home' )]")).getText();
        if (homelogo.contains("home"))
        System.out.println("Login Successful");

        // Navigate to Organizations
        driver.findElement(By.linkText("Organizations")).click();

        // Verifying Organization Page
        String orglogo=driver.findElement(By.xpath("//a[text()='Organizations' and @class='hdrLink']")).getText();
        if (orglogo.contains("Organizations"))
            System.out.println("Organization Page is Displayed");

        // Navigate to Create New Organizations Page
        driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

        // Verifying Create New Organizations Page
        String neworglogo=driver.findElement(By.xpath("//span[text()='Creating New Organization' ]")).getText();
        if (neworglogo.contains("Creating New Organization"))
            System.out.println("Create New Organization Page is Displayed");

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

        Row row = sh.getRow(1);

        // Check if the row exists
        if (row == null) {
            System.out.println("Error: Row 1 is empty or does not exist.");
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

        // Creating random organization name
        String orgname = cell.toString() + randomInt;
        System.out.println("Generated Organization Name: " + orgname);

        // Enter org name and click on save btn
        driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
        driver.findElement(By.xpath("//input[@accesskey='S']")).click();

        // Verify account creation
        String headertxt = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if (headertxt.contains(orgname)) {
            System.out.println("Organization Created Successfully!");
        }

        // Logout process
        WebElement profileicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        Actions action = new Actions(driver);
        action.moveToElement(profileicon).perform();

        WebElement signoutoption = driver.findElement(By.linkText("Sign Out"));
        //action.moveToElement(signoutoption).click().perform();
        signoutoption.click();

        // Verifying Logout
        if (driver.getTitle().contains("vtiger"))
        System.out.println("Sign Out Successfully");

        // Close browser
        driver.quit();
    }
}
