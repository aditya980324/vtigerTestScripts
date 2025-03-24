package com.vtigerpom.tests;

import com.vtiger.datautility.VtigerExcelUtility;
import com.vtiger.datautility.VtigerPropertyUtility;
import com.vtiger.objectutility.CreateNewOrgPage;
import com.vtiger.objectutility.HomePage;
import com.vtiger.objectutility.LoginPage;
import com.vtiger.objectutility.OrganizationsPage;
import com.vtiger.webdriver_java_listener_utility.JavaUtility;
import com.vtiger.webdriver_java_listener_utility.WebDriverUtility;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class IndustryDrpdwnTest {
    public static void main(String[] args) throws IOException {
        // utility object creation
        VtigerPropertyUtility vpu = new VtigerPropertyUtility();
        VtigerExcelUtility veu = new VtigerExcelUtility();
        WebDriverUtility wdu = new WebDriverUtility();
        JavaUtility ju = new JavaUtility();
        // importing common data
        String browser=vpu.getVtigerPropData("browser");
        String url=vpu.getVtigerPropData("url");
        String username=vpu.getVtigerPropData("username");
        String password=vpu.getVtigerPropData("password");
        // open the browser
        WebDriver driver=wdu.getDriver(browser);
        // object repository
        LoginPage lp = new LoginPage(driver);
        HomePage hp = new HomePage(driver);
        OrganizationsPage op = new OrganizationsPage(driver);
        CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
        // maximize the window
        wdu.windowMaximize();
        // synchronization
        wdu.sync();
        // enter the url
        wdu.openUrl(url);
        // verifying the login page
        wdu.screenShotPage();
        if (lp.getLoginpagelogo().contains("vtiger"))
            System.out.println("Login Page is Displayed.");
        else System.out.println("Login page is not displayed");
        // enter username
        lp.getUsernametxtfld().sendKeys(username);
        wdu.screenShotElement(lp.getUsernametxtfld());
        // enter password
        lp.getPasswordtxtfld().sendKeys(password);
        wdu.screenShotElement(lp.getPasswordtxtfld());
        // click on login btn
        lp.getLoginbtn().click();
        // verifying the home page
        wdu.screenShotPage();
        if (hp.getHomeLogo().contains("home"))
            System.out.println("Home page is displayed");
        else System.out.println("Home page is not displayed");
        // click on the organization link
        wdu.screenShotElement(hp.getOrganizationsMajorTab());
        hp.getOrganizationsMajorTab().click();
        // verifying the organizations page
        wdu.screenShotPage();
        if (op.getOrganizationlogo().contains("organization"))
            System.out.println("Organization page is displayed");
        else System.out.println("Organization page is not displayed");
        // click on create new organization btn
        op.getCreateneworgbtn().click();
        // verifying create new organization page
        if (cnop.getCreateNewOrgLogo().contains("Creating New Organization"))
            System.out.println("Create new organization page is displayed");
        else System.out.println(" Create new organization page is not displayed");
        // verifying industry drpdwn
        wdu.handleDrpdwn(cnop.getIndustryDrpdwn());
        // move the cursor on the profile icon
        wdu.moveCursorTo(hp.getProfileIcon());
        // click on the signout btn
        hp.getSignOutBtn().click();
        // closing the browser
        wdu.closeBrowser();
    }
}
