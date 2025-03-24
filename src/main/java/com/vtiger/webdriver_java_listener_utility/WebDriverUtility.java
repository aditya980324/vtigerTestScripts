package com.vtiger.webdriver_java_listener_utility;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WebDriverUtility {
    private WebDriver driver;

    public WebDriverUtility() {}
        public WebDriverUtility(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome"))
            driver=new ChromeDriver();
        else if (browser.equalsIgnoreCase("firefox"))
            driver=new FirefoxDriver();
        else if (browser.equalsIgnoreCase("edge"))
            driver=new EdgeDriver();
        return driver;
    }
    public void openUrl (String url) {
        driver.get(url);
    }
    public void windowMaximize () {
        driver.manage().window().maximize();
    }
    public void sync () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    public void moveCursorTo (WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
    public void closeBrowser () {
        driver.quit();
    }
    public void screenShotPage () {
            String page = driver.getWindowHandle();
            TakesScreenshot ts =(TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/"+page+".png");
            try{
                FileUtils.copyFile(src,dest);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }
    public void screenShotElement (WebElement element) {
        String ele = element.getAccessibleName();
        File src = element.getScreenshotAs(OutputType.FILE);
        File dest = new File("./screenshots/"+ele+".png");
        try{
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void switchToChildWindow() {
        String parwinid= driver.getWindowHandle();
        System.out.println("Parent Window ID "+parwinid);
        Set<String> windowids = new HashSet<>(driver.getWindowHandles());
        for (String win:windowids){
            if (win!=parwinid) {
                driver.switchTo().window(win);
                System.out.println("Child Window ID "+win);
                System.out.println("Successfully Switched to Child Window");
            }
        }
    }
    public void switchToOriginalWindow (String handle) {
        driver.switchTo().window(handle);
    }
    public void handleDrpdwn (WebElement element) {
        Select sel = new Select(element);
        List<WebElement> drpdwnoptions=sel.getOptions();
        for (int i=0;i<=drpdwnoptions.size()-1;i++) {
            String text = drpdwnoptions.get(i).getText();
            sel.selectByIndex(i);
            if (sel.getFirstSelectedOption().getText().equals(text))
                System.out.println(text + " is getting selected");
            else
                System.out.println(text + " is not getting selected");
        }
    }
}
