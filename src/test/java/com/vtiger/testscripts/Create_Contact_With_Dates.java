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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class Create_Contact_With_Dates {
    public static void main(String[] args) throws IOException {
        // Load the properties file data into the code
        FileInputStream fisproperty = new FileInputStream("./src/main/resources/vtiger_common_data/vtiger_test_data.properties");
        Properties pObj = new Properties();
        pObj.load(fisproperty);
        String browser=pObj.getProperty("browser");
        String url=pObj.getProperty("url");
        String username=pObj.getProperty("username");
        String password=pObj.getProperty("password");
        // generate random number
        Random random = new Random();
        int randomnum= random.nextInt(555);
        // Load data from Excel
        FileInputStream fisexcel = new FileInputStream("./src/test/resources/vtiger_testdata_xlsx/V_Tiger_Test_Data.xlsx");
        Workbook wb = WorkbookFactory.create(fisexcel);
        Sheet sh = wb.getSheet("Sheet1");
        Row row = sh.getRow(3);
        Cell cell = row.getCell(2);
        String lastname = cell.getStringCellValue()+randomnum;
        wb.close();
        // generate the current date
        Date dateObj = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startdate = sdf.format(dateObj);
        // generate date for further days
        Calendar cal = sdf.getCalendar();
        cal.add(Calendar.DAY_OF_YEAR,1);
        String enddate = sdf.format(cal.getTime());
        // initialize the WebDriver
        WebDriver driver;
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--diasble-notifications");
            driver=new ChromeDriver(option);
        }
        else {
            FirefoxOptions option = new FirefoxOptions();
            option.addArguments("--diasble-notifications");
            driver = new FirefoxDriver(option);
        }
        // implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        // maximizing the window
        driver.manage().window().maximize();
        // Action class object
        Actions action = new Actions(driver);
        // Enter the url
        driver.get(url);
        //verifying the Login page
        String loginpagelogo = driver.findElement(By.linkText("vtiger")).getText();
        if (loginpagelogo.contains("vtiger"))
            System.out.println("Vtiger Login Page is Displayed ");
        else
            System.out.println("Login Page is Not Displayed");
        // Enter the Username
        driver.findElement(By.name("user_name")).sendKeys(username);
        // Enter the Password
        driver.findElement(By.name("user_password")).sendKeys(password);
        // Click on the Login Button
        driver.findElement(By.id("submitButton")).click();
        // Verifying the Home Page
        String homepagelogo = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
        if (homepagelogo.contains("home"))
            System.out.println("Home Page is Displayed");
        else
            System.out.println("Login Failed");
        // click on contacts major tab
        driver.findElement(By.linkText("Contacts")).click();
        // Verifying the Contacts page
        String contactspagelogo =driver.findElement(By.xpath("//a[@class=\"hdrLink\"]")).getText();
        if (contactspagelogo.contains("contacts"))
            System.out.println("Contacts page is displayed");
        else
            System.out.println("Contacts page is not displayed");
        //click on create new contact link
        driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
        String createnewcontactlogo =driver.findElement(By.xpath("//span[text()='Creating New Contact']")).getText();
        if (createnewcontactlogo.contains("Creating New Contact"))
            System.out.println("Create new contact page is displayed");
        else
            System.out.println("Create new contact page is not displayed");
        // Enter lastname in lastname txtfld
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        //Enter startdate in startdate txtfld
        WebElement startdatetxtfld=driver.findElement(By.name("support_start_date"));
        startdatetxtfld.clear();
        startdatetxtfld.sendKeys(startdate);
        // Enter enddate in enddate txtfld
        WebElement enddatetxtfld = driver.findElement(By.name("support_end_date"));
        enddatetxtfld.clear();
        enddatetxtfld.sendKeys(enddate);
        // click on save btn
        driver.findElement(By.name("button")).click();
        // verifying the contact creation
        String contactcreatedlogo = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
        if (contactcreatedlogo.contains(lastname))
            System.out.println("Contact Created Successfully");
        else
            System.out.println("Contact creation failed");
        // Logout process
        WebElement profileicon = driver.findElement(RelativeLocator.with(By.tagName("img"))
                .toRightOf(By.xpath("//span[text()='Admin123@ Administrator1']")));
        action.moveToElement(profileicon).perform();

        WebElement signoutoption = driver.findElement(By.linkText("Sign Out"));
        action.moveToElement(signoutoption).click().perform();

        // Verifying Logout
        if (driver.getTitle().contains("vtiger"))
            System.out.println("Sign Out Successfully");
        else
            System.out.println("Log out is failed");
        // closing the browser
        driver.quit();
    }
}
