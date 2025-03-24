package com.vtigerpom.tests;

import com.vtiger.datautility.VtigerExcelUtility;
import com.vtiger.datautility.VtigerPropertyUtility;
import com.vtiger.objectutility.ContactsPage;
import com.vtiger.objectutility.CreateNewContactPage;
import com.vtiger.objectutility.HomePage;
import com.vtiger.objectutility.LoginPage;
import com.vtiger.webdriver_java_listener_utility.JavaUtility;
import com.vtiger.webdriver_java_listener_utility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Create_ContactOrgTest {
    public static void main(String[] args) throws IOException {
        // utility object creation
        VtigerPropertyUtility vpu = new VtigerPropertyUtility();
        VtigerExcelUtility veu = new VtigerExcelUtility();
        WebDriverUtility wdu = new WebDriverUtility();
        JavaUtility ju = new JavaUtility();
        // importing common data
        String browser = vpu.getVtigerPropData("browser");
        String url = vpu.getVtigerPropData("url");
        String username = vpu.getVtigerPropData("username");
        String password = vpu.getVtigerPropData("password");
        // open the browser
        WebDriver driver =wdu.getDriver(browser);
        // maximizing the window
        wdu.windowMaximize();
        // synchronizing
        wdu.sync();
        // object repository
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        ContactsPage cp = new ContactsPage(driver);
        CreateNewContactPage cncp = new CreateNewContactPage(driver);
        // enter the url
        wdu.openUrl(url);
        //verifying login page
        if (lp.getLoginpagelogo().contains("vtiger"))
            System.out.println("Login Page is Displayed.");
        else System.out.println("Login page is not displayed");
        // enter username
        lp.getUsernametxtfld().sendKeys(username);
        // enter password
        lp.getPasswordtxtfld().sendKeys(password);
        // click on login btn
        lp.getLoginbtn().click();
        // verifying home page
        if (hp.getHomeLogo().contains("home"))
            System.out.println("Home page is displayed");
        else System.out.println("Home page is not displayed");
        // click on the contact major tab
        hp.getContactsMajorTab().click();
        // verifying the contacts page
        if (cp.getContactlogo().contains("Contacts"))
            System.out.println("Contacts page is displayed");
        else System.out.println("Contacts page is not displayed");
        // click on create new contacts btn
        cp.getCreatenewcontactbtn().click();
        //verifying create new contacts page
        if (cncp.getCreatenewcontactlogo().contains("Creating New Contact"))
            System.out.println("Create new contacts page is displayed");
        else System.out.println("create new contacts page is not displayed");
        // enter last name
        String lastname = veu.getVtigerXlData("Sheet1",3,2)+ju.getRandomNum(500);
        cncp.getLastnametxtfld().sendKeys(lastname);
        // save the parent window handle
        String parentHandle = driver.getWindowHandle();
        // click on org plus btn
        cncp.getOrgPlusBtn().click();
        // switch to child window
        wdu.switchToChildWindow();
        // maximize the current window
        wdu.windowMaximize();
        // entering previous orgname in the srch txtfld
        String porgname = veu.getVtigerXlData("Sheet1",3,2).toString();
        cncp.getOrgSrchTxtFld().sendKeys(porgname);
        // click on srch btn
        cncp.getSrchBtn().click();
        // Click on the previous orgname
        driver.findElement(By.linkText(porgname)).click();
        // switch back to parent window
        wdu.switchToOriginalWindow(parentHandle);
        // click on the save btn
        cncp.getSaveBtn().click();
        // move the cursor on the profile icon
        wdu.moveCursorTo(hp.getProfileIcon());
        // click on the signout btn
        hp.getSignOutBtn().click();
        // closing the browser
        wdu.closeBrowser();






















    }
}
