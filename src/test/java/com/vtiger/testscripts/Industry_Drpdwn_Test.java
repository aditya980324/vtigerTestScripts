package com.vtiger.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class Industry_Drpdwn_Test {
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
        if (neworglogo.contains("create new organization"))
            System.out.println("Create New Organization Page is Displayed");

        // Verifying the visibility of the Dropdown
        WebElement indusdrpdwn=driver.findElement(By.name("industry"));
        if (indusdrpdwn.isDisplayed())
            System.out.println("Industry DropDown is Visible");

        // Verifying the status of the Dropdown
        if (indusdrpdwn.isEnabled())
            System.out.println("Industry DropDown is Enabled");

        Select sel = new Select(indusdrpdwn);
        // Verifying the nature of the Dropdown
        if (sel.isMultiple())
            System.out.println("Industry DropDown is Multi-Select");
        else
            System.out.println("Industry DropDown is Single-Select");

        // Verifying the Functionality of Industry Dropdown
        List<WebElement> indusdrpdwnoptions=sel.getOptions();
        for (int i=0;i<=indusdrpdwnoptions.size()-1;i++){
            String text=indusdrpdwnoptions.get(i).getText();
            sel.selectByIndex(i);
            if (sel.getFirstSelectedOption().getText().equals(text))
                System.out.println(text+" is getting selected");
            else
                System.out.println(text+" is not getting selected");
        }

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
