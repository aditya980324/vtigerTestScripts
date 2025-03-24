package com.vtiger.webdriver_java_listener_utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vtiger.datautility.VtigerExcelUtility;
import com.vtiger.datautility.VtigerPropertyUtility;
import com.vtiger.objectutility.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class VtigerBaseClass {
    public VtigerBaseClass() throws IOException {
    }
    public ExtentReports report;
    // initialize the driver
    public WebDriver driver=null;
    public static WebDriver sdriver;
    // utility classes
    public VtigerExcelUtility veu = new VtigerExcelUtility();
    public VtigerPropertyUtility vpu = new VtigerPropertyUtility();
    public JavaUtility ju = new JavaUtility();
    public WebDriverUtility wdu =new WebDriverUtility();
    // storing data in variables
    String browser=vpu.getVtigerPropData("browser");
    String url=vpu.getVtigerPropData("url");
    String username=vpu.getVtigerPropData("username");
    String password=vpu.getVtigerPropData("password");
    // object repository
    public ContactsPage cp;
    public CreateNewContactPage cncp ;
    public CreateNewOrgPage cnop ;
    public HomePage hp ;
    public LoginPage lp ;
    public OrganizationsPage op ;
    public WebDriverUtility wd;

    // connect to db
    @BeforeSuite
    public void connectVtigerDB () {
        String time=ju.currentDateTime();
        ExtentSparkReporter spark =new ExtentSparkReporter("./AdvanceReports/report-"+time+".html");
        spark.config().setDocumentTitle("Vtiger Test Results");
        spark.config().setReportName("Vtiger Report");
        spark.config().setTheme(Theme.STANDARD);
        //
        report=new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("os","windows-11");
        report.setSystemInfo("browser","chrome 13");
    }
    @AfterSuite
    public void disconnectVtigerDB () {

    }
    //@Parameters("BROWSER")
    @BeforeClass
    //public void openBrowser (String BROWSER) {
    public void openBrowser () {
        // initialize the browser
        //driver= wdu.getDriver(BROWSER);
        driver= wdu.getDriver(browser);
        sdriver=driver;
        // object repository initiation
        lp=new LoginPage(driver);
        hp=new HomePage(driver);
        op=new OrganizationsPage(driver);
        cp=new ContactsPage(driver);
        cnop=new CreateNewOrgPage(driver);
        cncp=new CreateNewContactPage(driver);
        // open the url
        wdu.openUrl(url);
        // maximize the window
        wdu.windowMaximize();
        // synchronization
        wdu.sync();
    }
    @AfterClass
    public void closeBrowser () {
        wdu.closeBrowser();
    }
    @BeforeMethod
    public void login () {
        // enter username
        lp.getUsernametxtfld().sendKeys(username);
        // enter password
        lp.getPasswordtxtfld().sendKeys(password);
        // click on login btn
        lp.getLoginbtn().click();
    }
    @AfterMethod
    public void logout () {
        // move the cursor to the profile icon
        wdu.moveCursorTo(hp.getProfileIcon());
        // click on signout btn
        hp.getSignOutBtn().click();
    }
}

































